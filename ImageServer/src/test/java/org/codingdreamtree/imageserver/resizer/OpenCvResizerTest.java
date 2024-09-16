package org.codingdreamtree.imageserver.resizer;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.opencv.opencv_java;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OpenCvResizerTest {

    ImageResizer imageResizer = new OpenCvResizer();

    @BeforeAll
    static void init() {
        Loader.load(opencv_java.class);
    }

    @Test
    @DisplayName("이미지 리사이징에 대해서 테스트 코드를 짜보자")
    void resizeFile() throws IOException {
        final File file = new File("src/test/resources/images/image_3840x2400.png");
        final int resizeWith = 300;
        final int resizeHeight = 200;

        final File result = imageResizer.resizeFile(file, resizeWith, resizeHeight);
        final BufferedImage imageResult = ImageIO.read(result);

        assertThat(imageResult.getWidth()).isEqualTo(resizeWith);
        assertThat(imageResult.getHeight()).isEqualTo(resizeHeight);

        result.delete();
    }
}