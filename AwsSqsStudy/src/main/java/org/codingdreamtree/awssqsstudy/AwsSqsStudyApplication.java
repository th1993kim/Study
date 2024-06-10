package org.codingdreamtree.awssqsstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AwsSqsStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsSqsStudyApplication.class, args);
    }

}
