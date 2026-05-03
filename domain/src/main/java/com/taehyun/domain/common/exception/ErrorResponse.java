package com.taehyun.domain.common.exception;

public record ErrorResponse(
        String url,
        String errorMessage
) {
}
