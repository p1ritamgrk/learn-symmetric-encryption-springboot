package com.cryptography.learn.p1ritamgrk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ResponseDto {
    private String originalPlaintext;
    private String encryptedText;
    private String decryptedText;
}
