package org.icgc.dcc.sodalite.server.controller;

import static java.lang.String.format;
import static org.icgc.dcc.sodalite.server.utils.JsonUtils.jsonResponse;
import static org.icgc.dcc.sodalite.server.utils.JsonUtils.jsonStatus;

import org.icgc.dcc.sodalite.server.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.val;

@RestController
@RequestMapping(path = "/studies/{study_id}/func/")
@RequiredArgsConstructor
public class FunctionController {

  @Autowired
  private final FunctionService functionService;

  @PostMapping(value = "notify-upload/{upload_id}")
  @ResponseBody
  @PreAuthorize("@studySecurity.authorize(authentication, #studyId)")
  public String notifyUpload(@PathVariable("study_id") String studyId, @PathVariable("upload_id") String uploadId) {
    val status = functionService.notifyUpload(studyId, uploadId);
    return jsonStatus(status, "status", "ok: " + uploadId, "failed: " + uploadId);
  }

  @PostMapping(value = "publish")
  @ResponseBody
  @PreAuthorize("@studySecurity.authorize(authentication, #studyId)")
  public String publish(@PathVariable("study_id") String id) {
    val numPublished = functionService.publish(id);
    if (numPublished == 0) {
      return jsonResponse("status", "No new uploads were left to publish");
    }
    return jsonResponse("status", format("Successfully published %d uploads.", numPublished));
  }

  @PostMapping(value = "publish/{upload_id}")
  @ResponseBody
  @PreAuthorize("@studySecurity.authorize(authentication, #studyId)")
  public String publishByUploadId(@PathVariable("study_id") String studyId,
      @PathVariable("upload_id") String uploadId) {
    val status = functionService.publishId(studyId, uploadId);
    return jsonStatus(status, "status", "Successfully published " + uploadId, "Publish of " + uploadId + " failed");
  }

}