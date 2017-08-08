package org.icgc.dcc.song.client.errors;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.icgc.dcc.song.core.exceptions.ServerException;
import org.icgc.dcc.song.core.exceptions.SongError;
import org.icgc.dcc.song.core.utils.JsonUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Objects.isNull;
import static org.icgc.dcc.common.core.util.Joiners.NEWLINE;
import static org.icgc.dcc.song.core.exceptions.ServerErrors.UNAUTHORIZED_TOKEN;
import static org.icgc.dcc.song.core.exceptions.SongError.createSongError;
import static org.icgc.dcc.song.core.exceptions.SongError.parseErrorResponse;

@Slf4j
public class ServerResponseErrorHandler extends DefaultResponseErrorHandler{

  private static final String ERROR = "error";
  private static final String INVALID_TOKEN = "invalid_token";

  @SneakyThrows
  private static boolean isInvalidToken(String error){
    val response = JsonUtils.readTree(error);
    if (response.has(ERROR)) {
      val errorValue = response.path(ERROR).textValue();
      return errorValue.equals(INVALID_TOKEN);
    }
    return false;
  }

  @Override
  public void handleError(ClientHttpResponse clientHttpResponse) throws IOException, ServerException {
    val httpStatusCode = clientHttpResponse.getStatusCode();
    val br = new BufferedReader(new InputStreamReader(clientHttpResponse.getBody()));
    val body = NEWLINE.join(br.lines().iterator());
    SongError songError = parseErrorResponse(httpStatusCode,body);
    if (isNull(songError.getErrorId()) && isInvalidToken(body)){
      songError = createSongError(UNAUTHORIZED_TOKEN,"Invalid token");
    }
    throw new ServerException(songError);
  }

}
