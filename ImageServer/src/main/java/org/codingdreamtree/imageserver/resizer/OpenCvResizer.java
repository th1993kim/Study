package org.codingdreamtree.imageserver.resizer;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class OpenCvResizer implements ImageResizer {

    @Override
    public File resizeFile(File file, int resizeWith, int resizeHeight) {

        new File("\\images").mkdirs();

        String absolutePath = file.getAbsolutePath();
        Mat src = Imgcodecs.imread(absolutePath);

        Size size = new Size(resizeWith, resizeHeight);
        Mat det = new Mat(size, src.type());

        Imgproc.resize(src, det, size, 0, 0, Imgproc.INTER_AREA);
        Imgcodecs.imwrite(getFilename(file.getName()), det);

        return new File(getFilename(file.getName()));
    }

    private String getFilename(String name) {
        return "\\images\\" + name;
    }
}
