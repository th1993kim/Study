package org.codingdreamtree.imageserver.controller;

import lombok.RequiredArgsConstructor;
import org.codingdreamtree.imageserver.common.MultipartFileUtils;
import org.codingdreamtree.imageserver.common.aws.s3.S3UploadService;
import org.codingdreamtree.imageserver.resizer.ImageResizer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageResizeController {

    private final ImageResizer imageResizer;
    private final S3UploadService s3UploadService;

    @PostMapping(value = "/resize", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> resize(@ModelAttribute FileResizeRequest2 request) throws IOException {
//        File beforeFile = MultipartFileUtils.toFile(request.file());
//        File resizedFile = imageResizer.resizeFile(beforeFile, request.resizeWith(), request.resizeHeight());
//        s3UploadService.uploadFile(resizedFile, request.bucket(),request.filePath());

        File beforeFile = MultipartFileUtils.toFile(request.getFile());
        File resizedFile = imageResizer.resizeFile(beforeFile, request.getResizeWith(), request.getResizeHeight());
        s3UploadService.uploadFile(resizedFile, request.getBucket(),request.getFilePath());
        beforeFile.delete();
        resizedFile.delete();

        return ResponseEntity.ok(resizedFile.getName());
    }

}
