package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.common.ApiResponseCode;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.ISecurityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The service implementation for security operations
 *
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 * @since 0.0.1
 */
@Service
public class SecurityService implements ISecurityService {

    /**
     * Value for security password generation
     */
    @Value("saltForPassword")
    private String salt;

    /**
     * Encrypt data with secure method
     * @param data the data to encrypt
     * @return the encrypted data
     * @throws StoreApiException
     */
    public String encryptData(String data) throws StoreApiException {

        try {
            StringBuilder sb = new StringBuilder();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(data.getBytes());

            for(int i=0; i< bytes.length ;i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new StoreApiException(ApiResponseCode.ERROR_ON_ENCRYPT_PASSWORD);
        }
    }
}
