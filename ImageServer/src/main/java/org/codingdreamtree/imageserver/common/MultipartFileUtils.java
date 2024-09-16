package org.codingdreamtree.imageserver.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MultipartFileUtils {

    public static File toFile(MultipartFile multipartFile) throws IOException {
        File file = new File("C:\\ImageServer\\temp\\" + Objects.requireNonNull(multipartFile.getOriginalFilename()));
        file.getParentFile().mkdirs();
        multipartFile.transferTo(file);
        return file;
    }


}
