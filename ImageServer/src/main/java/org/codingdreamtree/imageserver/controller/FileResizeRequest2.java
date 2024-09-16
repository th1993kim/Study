package org.codingdreamtree.imageserver.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.codingdreamtree.imageserver.common.Bucket;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FileResizeRequest2 {
        @NotBlank(message = "이미지 경로는 필수로 입력해야합니다.")
        private String filePath;
        @NotNull(message = "버켓은 필수로 입력해야합니다.")
        private Bucket bucket;
        @Min(value = 100 , message = "변환하려는 이미지 파일의 폭은 최소 100px 이상이어야합니다.")
        @Max(value = 1000, message = "변환하려는 이미지 파일의 폭은 최대 1000px 이하이어야합니다.")
        private int resizeWith;
        @Min(value = 100 , message = "변환하려는 이미지 파일의 높이는 최소 100px 이상이어야합니다.")
        @Max(value = 1000, message = "변환하려는 이미지 파일의 높이는 최대 1000px 이하이어야합니다.")
        private int resizeHeight;
        private MultipartFile file;
}