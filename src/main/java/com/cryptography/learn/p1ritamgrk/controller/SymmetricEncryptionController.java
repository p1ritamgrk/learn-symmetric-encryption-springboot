package com.cryptography.learn.p1ritamgrk.controller;

import com.cryptography.learn.p1ritamgrk.dto.RequestDto;
import com.cryptography.learn.p1ritamgrk.dto.ResponseDto;
import com.cryptography.learn.p1ritamgrk.service.SymmetricEncryptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SymmetricEncryptionController {
    private final SymmetricEncryptionService symmetricEncryptionService;

    @PostMapping()
    public ResponseEntity<ResponseDto> getSymmetricEncryption(@RequestBody RequestDto requestDto)
            throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return new ResponseEntity<>(symmetricEncryptionService.getSymmetricEncryption(requestDto),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ResponseDto> getEncryption() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
