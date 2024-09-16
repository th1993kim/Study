package org.codingdreamtree.imageserver.common.aws.s3;

import lombok.RequiredArgsConstructor;
import org.codingdreamtree.imageserver.common.Bucket;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.s3.S3Client;

import java.io.File;
import java.nio.file.Path;

@Component
@RequiredArgsConstructor
public class S3UploadService {

    private final S3Client s3Client;


    public void uploadFile(File file, Bucket bucket, String filePath) {

        s3Client.putObject(builder -> builder.bucket(bucket.name()).key(file.getName()).build(), Path.of(filePath));
    }

}
