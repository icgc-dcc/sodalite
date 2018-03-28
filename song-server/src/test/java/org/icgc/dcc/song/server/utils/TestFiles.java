/*
 * Copyright (c) 2018. Ontario Institute for Cancer Research
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.icgc.dcc.song.server.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.icgc.dcc.common.core.util.Joiners;
import org.icgc.dcc.song.server.model.Metadata;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.icgc.dcc.song.core.utils.JsonUtils.readTree;
import static org.icgc.dcc.song.core.utils.JsonUtils.toJson;

@Slf4j
public class TestFiles {

  public static final String SEARCH_TEST_DIR = "documents/search";
  private static final String NAME = "name";

  @SneakyThrows
  public static String getJsonStringFromClasspath(String name) {
    return toJson(getJsonNodeFromClasspath(name));
  }

  private static URL getTestResourceUrl(){
    return TestFiles.class.getClassLoader().getResource("./");
  }

  public static Path getTestResourceFilePath(String filename){
    return Paths.get(
        Joiners.PATH.join(getTestResourceUrl().getPath(), filename));
  }

  @SneakyThrows
  public static JsonNode getJsonNodeFromClasspath(String pathname) {
    InputStream is1 = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathname);
    checkNotNull(is1, "null reference. Path '%s' could be incorrect", pathname);
    return readTree(is1);
  }

  public static boolean isTestFileExist(String filename){
    return getTestResourceFilePath(filename).toFile().exists();
  }

  public static String getInfoName(Metadata metadata){
    val info = metadata.getInfo();
    assertThat(info.has(NAME)).isTrue();
    return metadata.getInfo().get(NAME).textValue();
  }

  public static String getInfoValue(@NonNull Metadata metadata, @NonNull String key) {
    assertThat(metadata.getInfo().has(key)).isTrue();
    return metadata.getInfo().path(key).textValue();
  }

  public static <T> void assertSetsMatch(@NonNull Set<T> left, @NonNull Set<T> right){
    assertThat(left).isSubsetOf(right);
    assertThat(right).isSubsetOf(left);
  }

  public static void assertInfoKVPair(@NonNull Metadata metadata, @NonNull String key, @NonNull Object expectedValue){
      assertThat(metadata.getInfo().has(key)).as("The input metadata does not have the key '%s'", key).isTrue();
      val actualValue  = metadata.getInfo().path(key).textValue();
      assertThat(actualValue)
          .as("Failed since field '%s' has actual=%s and expected=%s", key, actualValue, expectedValue)
          .isEqualTo (expectedValue);
  }

}
