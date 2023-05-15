package com.java.core.crypt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class CryptoController {

    public static void main(String[] args) {
        CryptoVo icji = CryptoVo.builder().userId(1).username("icji").num(123)
                .build();

        System.out.println("icji = " + encryptObjectByAES(icji));
    }
//    public String test() {
//        CryptoVo icji = CryptoVo.builder().userId(1).username("icji").num(123)
//                .build();
//
//        return encryptObjectByAES(icji);
//    }
    private static final String IV_PARAM 	= "gwJj1WIZGuBAF5J7";
    private static final String SECRET_KEY 	= "Mb62BZkWbS6ZIKcusV3Zf28bR2Z7haRF";

    /**
     * Encrypt by AES-256
     * @param str
     * @return
     */
    public static String encryptObjectByAES(Object str) {
        try {
            Cipher cipherObj = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipherObj.init(Cipher.ENCRYPT_MODE, getEncKey(), new IvParameterSpec(IV_PARAM.getBytes()));

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = new ObjectOutputStream(bos);
            out.writeObject(str);
            byte[] encrypt = cipherObj.doFinal(bos.toByteArray());
            return new String(Base64.getEncoder().encode(encrypt));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Encrypt by AES-256
     * @param str
     * @return
     */
    public static String encryptByAES(String str) {
        try {
            Cipher cipherObj = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipherObj.init(Cipher.ENCRYPT_MODE, getEncKey(), new IvParameterSpec(IV_PARAM.getBytes()));

            byte[] encrypt = cipherObj.doFinal(str.getBytes("UTF-8"));

            return new String(Base64.getEncoder().encode(encrypt));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Decode by AES-256
     * @param str
     * @return
     */
    public static Object decodeObjectByAES(String str) {
        try {
            Cipher cipherObj = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipherObj.init(Cipher.DECRYPT_MODE, getEncKey(), new IvParameterSpec(IV_PARAM.getBytes()));

            byte[] encrypt = cipherObj.doFinal(Base64.getDecoder().decode(str));
            ByteArrayInputStream bis = new ByteArrayInputStream(encrypt);
            ObjectInput in = new ObjectInputStream(bis);
            return in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Decode by AES-256
     * @param str
     * @return
     */
    public static String decodeByAES(String str) {
        try {
            Cipher cipherObj = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipherObj.init(Cipher.DECRYPT_MODE, getEncKey(), new IvParameterSpec(IV_PARAM.getBytes()));

            byte[] encrypt = cipherObj.doFinal(Base64.getDecoder().decode(str));

            return new String(encrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Encrypt by SHA-256
     * @param str
     * @return
     */
    public static String encryptBySHA(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            byte[] bytes = str.getBytes();

            messageDigest.reset();

            byte[] digested = messageDigest.digest(bytes);

            StringBuilder sb = new StringBuilder();

            for (byte b : digested) {
                sb.append(Integer.toHexString(0xff & b));
            }

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Secret Key 암호화
     * @return
     */
    private static SecretKey getEncKey() {
        MessageDigest sha = null;

        try {
            byte[] resultKey = SECRET_KEY.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");

            resultKey = sha.digest(resultKey);
            resultKey = Arrays.copyOf(resultKey, 16);

            return new SecretKeySpec(resultKey, "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
