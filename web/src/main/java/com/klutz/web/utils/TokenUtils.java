package com.klutz.web.utils;

import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * 生成 token
 * created on 2021/11/24
 * @author klutz
 */
public class TokenUtils {

    /**
     * 生成token
     * @return
     */
    public static String generateToken(  String userId ){
        if( userId== null){
            userId = "";
        }
        String nonce = UUID.randomUUID().toString();
        String value = userId +":" + nonce + ":" +System.currentTimeMillis();
        try {
            return CryptUtils.encodeHexString(CryptUtils.SHA256Crypt(value),true);
        }catch (NoSuchAlgorithmException ex){
            return nonce;
        }
    }

}
