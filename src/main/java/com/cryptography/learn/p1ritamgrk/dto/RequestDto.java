package com.cryptography.learn.p1ritamgrk.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestDto {
    private String originalPlaintext;
    private String secretKey;
}
