package org.codingdreamtree.imageserver.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.core.retry.RetryPolicy;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.time.Duration;

@Profile("prod")
@Configuration
public class AwsS3Config {

    @Bean
    public S3Client s3Client() {
        ClientOverrideConfiguration clientOverrideConfiguration =
                ClientOverrideConfiguration.builder()
                        .apiCallAttemptTimeout(Duration.ofSeconds(1))
                        .retryPolicy(RetryPolicy.builder().numRetries(10).build())
                        .build();

        Region region = Region.AP_NORTHEAST_2;
        return S3Client.builder()
                .region(region)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .overrideConfiguration(clientOverrideConfiguration)
                .build();
    }
}
