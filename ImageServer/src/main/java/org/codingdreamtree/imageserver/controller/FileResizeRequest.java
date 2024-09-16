package org.codingdreamtree.imageserver.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.codingdreamtree.imageserver.common.Bucket;
import org.springframework.web.multipart.MultipartFile;

public record FileResizeRequest(
        @NotBlank(message = "이미지 경로는 필수로 입력해야합니다.")
        String filePath,
        @NotNull(message = "버켓은 필수로 입력해야합니다.")
        Bucket bucket,
        @Min(value = 100 , message = "변환하려는 이미지 파일의 폭은 최소 100px 이상이어야합니다.")
        @Max(value = 1000, message = "변환하려는 이미지 파일의 폭은 최대 1000px 이하이어야합니다.")
        int resizeWith,
        @Min(value = 100 , message = "변환하려는 이미지 파일의 높이는 최소 100px 이상이어야합니다.")
        @Max(value = 1000, message = "변환하려는 이미지 파일의 높이는 최대 1000px 이하이어야합니다.")
        int resizeHeight,
        @NotNull(message = "파일첨부가 비어있어서는 안됩니다.")
        MultipartFile file
) {
}
