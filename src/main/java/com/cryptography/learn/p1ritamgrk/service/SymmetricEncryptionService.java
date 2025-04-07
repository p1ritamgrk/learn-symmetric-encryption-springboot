package com.cryptography.learn.p1ritamgrk.service;

import com.cryptography.learn.p1ritamgrk.dto.RequestDto;
import com.cryptography.learn.p1ritamgrk.dto.ResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface SymmetricEncryptionService {
    ResponseDto getSymmetricEncryption(RequestDto requestDto) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException;
}
