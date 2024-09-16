package org.codingdreamtree.imageserver;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.opencv.opencv_java;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageServerApplication {

    public static void main(String[] args) {
        Loader.load(opencv_java.class);
        SpringApplication.run(ImageServerApplication.class, args);
    }

}
