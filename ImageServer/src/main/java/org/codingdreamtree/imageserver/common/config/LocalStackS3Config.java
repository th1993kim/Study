package org.codingdreamtree.imageserver.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.core.retry.RetryPolicy;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;
import java.time.Duration;

@Profile("local")
@Configuration
public class LocalStackS3Config {

    @Value("${cloud.aws.endpoint.s3}")
    private String s3Endpoint;
    @Value("${cloud.aws.region.static}")
    private String region;
    @Value("${cloud.aws.credentials.accessKey}")
    private String accessKey;
    @Value("${cloud.aws.credentials.secretKey}")
    private String secretKey;

    @Bean
    public S3Client s3Client() {
        ClientOverrideConfiguration clientOverrideConfiguration =
                ClientOverrideConfiguration.builder()
                        .apiCallAttemptTimeout(Duration.ofSeconds(1))
                        .retryPolicy(RetryPolicy.builder().numRetries(10).build())
                        .build();

        return S3Client.builder()
                .region(Region.of(region))
                .forcePathStyle(true)
                .endpointOverride(URI.create(s3Endpoint))
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
                .overrideConfiguration(clientOverrideConfiguration)
                .build();
    }
}
