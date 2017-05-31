package com.collection.project.utils;
import com.test.project.po.gen.UserDetail;

import org.apache.shiro.codec.Base64; 
import org.apache.shiro.codec.Hex; 
import org.apache.shiro.crypto.AesCipherService; 
import org.apache.shiro.crypto.SecureRandomNumberGenerator; 
import org.apache.shiro.crypto.hash.Md5Hash; 
import org.springframework.util.StringUtils;

import java.security.Key; 
/** 
* ��ע�� shiro���м��ܽ��ܵĹ������װ 
*/ 
public final class EndecryptUtils { 
    /** 
     * base64���Ƽ��� 
     * 
     * @param password 
     * @return 
     */ 
    public static void encrytBase64(String password) { 
        byte[] bytes = password.getBytes(); 
        password = Base64.encodeToString(bytes); 
    } 
    /** 
     * base64���ƽ��� 
     * @param cipherText 
     * @return 
     */ 
    public static void decryptBase64(String cipherText) { 
        cipherText = Base64.decodeToString(cipherText); 
    } 
    /** 
     * 16���Ƽ��� 
     * 
     * @param password 
     * @return 
     */ 
    public static void encrytHex(String password) { 
        byte[] bytes = password.getBytes(); 
        password = Hex.encodeToString(bytes); 
    } 
    /** 
     * 16���ƽ��� 
     * @param cipherText 
     * @return 
     */ 
    public static void  decryptHex(String cipherText) { 
        cipherText = new String(Hex.decode(cipherText)); 
    } 
    public static String generateKey() 
    { 
        AesCipherService aesCipherService=new AesCipherService(); 
        Key key=aesCipherService.generateNewKey(); 
        return Base64.encodeToString(key.getEncoded()); 
    } 
    /** 
     * ���������md5����,���������ĺ�salt��������User������ 
     * @param username �û��� 
     * @param password ���� 
     * @return ���ĺ�salt 
     */ 
    public static void md5Password(UserDetail userDetail){ 
        SecureRandomNumberGenerator secureRandomNumberGenerator=new SecureRandomNumberGenerator(); 
        String salt= secureRandomNumberGenerator.nextBytes().toHex(); 
        //���username,���ε�������������м��� 
        String password_cipherText= new Md5Hash(StringUtils.trimAllWhitespace(userDetail.getPassword()),StringUtils.trimAllWhitespace(userDetail.getLoginName())+salt,2).toBase64(); 
        userDetail.setPassword(password_cipherText); 
        userDetail.setSalt(salt); 
    } 
   
}