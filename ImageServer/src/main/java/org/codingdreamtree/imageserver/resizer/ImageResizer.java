package org.codingdreamtree.imageserver.resizer;

import java.io.File;

public interface ImageResizer {

    File resizeFile(File file, int resizeWith, int resizeHeight);
}

