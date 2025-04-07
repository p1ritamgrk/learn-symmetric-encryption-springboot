package com.cryptography.learn.p1ritamgrk.service.impl;

import com.cryptography.learn.p1ritamgrk.dto.RequestDto;
import com.cryptography.learn.p1ritamgrk.dto.ResponseDto;
import com.cryptography.learn.p1ritamgrk.service.SymmetricEncryptionService;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class SymmetricEncryptionServiceImpl implements SymmetricEncryptionService {
    @Override
    public ResponseDto getSymmetricEncryption(RequestDto requestDto) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String originalMessage = requestDto.getOriginalPlaintext();

        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedMessage = cipher.doFinal(originalMessage.getBytes(StandardCharsets.UTF_8));

        String encodedMessage = Base64.getEncoder().encodeToString(encryptedMessage);


        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedMsg = cipher.doFinal(Base64.getDecoder().decode(encodedMessage));
        String decryptedMessage = new String(decryptedMsg, StandardCharsets.UTF_8);

        return ResponseDto.builder()
                .originalPlaintext(originalMessage)
                .encryptedText(encodedMessage)
                .decryptedText(decryptedMessage)
                .build();
    }
}