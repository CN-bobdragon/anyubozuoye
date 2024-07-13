package com.util;


import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;

import java.security.KeyPair;

public class encode {
    public static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIWH2fbbhEIFRiuR1a90P+AA2DOccM7HEQcCp47/vOal6ppJasaZ8LyMEkTkvr2CTcLVv88fiyllJcm5klQq8OamQu7FFvhwryUQKuIRiK4n1j9kIcJZ0a+w63CUmjtghr97QAlItgoIwDIyJIDIULUEjOgRk7/s7ynZ14Z7sBAlAgMBAAECgYA5uEyeqasVAsSfRs3QpvaJdLQAM0qMB36zwhD9/kwAg43SnZO7P4XRatbm0t4kevP0GYNtG9yCy0c3WLEJEvrIhW1xpip+2QxBSriBzJWJbObZdb7cCNCNpYj8sXhaUympuW7OyPH61f+HgJmKfj5mVp3152sqf2EmWiaGMnZAwQJBAOTcXElA6GTq4kR/X48478FHRgnag2TKbBshPkONHqVhp2WMN5uJNKJCL4LenDlx9m2EJ7dGjwpt8RtwXEFA8nECQQCVXYH6LTim4VjPJFEBWudqBF3A99xXxE6eO7/V+vWbSmz01Mq6wBaVBM5aI1qR6pq5J2rKQZtQVvf1BZMimar1AkBeSUrcAxm7OemuPqun3dUo06xPMu8e/yY6px93xRPzHqBQfcwLECPXFV1tlTjXkdPsmp2iLDeSHGlQ3KGlYJSBAkEAjbZJEnaDMHnPS8C2BmYb908rMGE5sh+zQ5eGu9s92Vc0ptmZerOy+TG1Ino2fQisQY0vWbQDSqco3FSss4A+XQJAacfF6xfhkL0SYN7IeeL+C7WsF1fhhVeo76SKEvAT4tkYL9US2t0cpdBDNlc9mg/M5zk9qgbrD5N4qE+kgTHs6w==";

    public static String pulicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFh9n224RCBUYrkdWvdD/gANgznHDOxxEHAqeO/7zmpeqaSWrGmfC8jBJE5L69gk3C1b/PH4spZSXJuZJUKvDmpkLuxRb4cK8lECriEYiuJ9Y/ZCHCWdGvsOtwlJo7YIa/e0AJSLYKCMAyMiSAyFC1BIzoEZO/7O8p2deGe7AQJQIDAQAB";


    //0 加密入口
    public static String myencode(String str) {
        return strToMd5(str);
    }

    //0 解密
    public static String mydecode(String str) {
        return myself(str);
    }

    //0 不加密
    public static String myself(String str) {
        return str;
    }


    /**
     * 对字符串进行md5加密 （不可逆）
     *
     * @param text 待加密的字符串
     * @return 加密后的字符串
     */
    public static String strToMd5(String text) {
        String md5str = DigestUtil.md5Hex(text);
        return md5str;
    }


    /**
     * 对字符串进行SHA1加密（不可逆）
     *
     * @param text 待加密的字符串
     * @return 加密后的字符串
     */
    public static String strToSha1(String text) {
        text = DigestUtil.sha1Hex(text);
        return text;
    }

    /**
     * 对字符串进行SHA256加密（不可逆）
     *
     * @param text 待加密的字符串
     * @return 加密后的字符串
     */
    public static String strToSha256(String text) {
        text = DigestUtil.sha256Hex(text);
        return text;
    }

    /**
     * 对字符串进行SHA512加密（不可逆）
     *
     * @param text 待加密的字符串
     * @return 加密后的字符串
     */
    public static String strToSha512(String text) {
        text = DigestUtil.sha512Hex(text);
        return text;
    }

    /**
     * 对字符串进行AES加密（可逆,对称加密，加密和解密用同一个key）
     *
     * @param text 待加密的字符串
     * @return 加密后的字符串
     */
    public static String strToAes(String text) {
        String key = "1234567890abcdef1234567812345678";
        text = strToAes(key, text);
        return text;
    }

    /**
     * 对字符串进行AES加密（可逆,对称加密，加密和解密用同一个key）
     *
     * @param key  密钥(只能16位、24位或32位)
     * @param text 待加密的字符串
     * @return 加密后的字符串
     */
    public static String strToAes(String key, String text) {
        AES aes = new AES(key.getBytes());
        text = aes.encryptBase64(text);
        return text;
    }

    /**
     * AES解密
     *
     * @param encryptStr
     * @return
     */
    public static String aesDecrypt(String encryptStr) {
        String key = "1234567890abcdef1234567812345678";
        return aesDecrypt(key, encryptStr);
    }

    /**
     * AES解密
     *
     * @param key        密钥(和加密的密钥必须是同一个，只能16位、24位或32位)
     * @param encryptStr
     * @return
     */
    public static String aesDecrypt(String key, String encryptStr) {
        AES aes = new AES(key.getBytes());
        return aes.decryptStr(encryptStr);
    }

    /**
     * DES加密（可逆,对称加密，加密和解密用同一个key）
     *
     * @param text
     * @return
     */
    public static String strToDes(String text) {

        String key = "12345678";
        text = strToDes(key, text);
        return text;
    }

    /**
     * DES加密（可逆,对称加密，加密和解密用同一个key）
     *
     * @param key  密钥(至少8位)
     * @param text
     * @return
     */
    public static String strToDes(String key, String text) {
        DES aes = new DES(key.getBytes());
        text = aes.encryptBase64(text);
        return text;
    }

    /**
     * DES解密
     *
     * @param encryptStr
     * @return
     */
    public static String desDecrypt(String encryptStr) {
        String key = "12345678";
        DES aes = new DES(key.getBytes());
        return aes.decryptStr(encryptStr);
    }

    /**
     * DES解密
     *
     * @param key        密钥(至少8位)
     * @param encryptStr
     * @return
     */
    public static String desDecrypt(String key, String encryptStr) {
        DES aes = new DES(key.getBytes());
        return aes.decryptStr(encryptStr);
    }


    /**
     * RSA加密（可逆,非对称加密，私钥加密，公钥解密）
     *
     * @param text
     * @return
     */
    public static String strToRsa(String text) {

        return strToRsa(privateKey, pulicKey, text);
    }

    /**
     * RSA加密（可逆,非对称加密，私钥加密，公钥解密）
     *
     * @param privateKey
     * @param pulicKey
     * @param text
     * @return
     */
    public static String strToRsa(String privateKey, String pulicKey, String text) {
        RSA rsa = new RSA(AsymmetricAlgorithm.RSA_ECB_PKCS1.getValue(), privateKey, pulicKey);
        // 私钥加密(每次加密结果相同，公钥加密则每次结果不一样)
        String encryptByPrivate = rsa.encryptBase64(text, KeyType.PrivateKey);

        return encryptByPrivate;
    }


    /**
     * RSA解密
     *
     * @param text
     * @return
     */
    public static String rsaDecrypt(String text) {
        return rsaDecrypt(privateKey, pulicKey, text);

    }

    /**
     * RSA解密
     *
     * @param text
     * @return
     */
    public static String rsaDecrypt(String privateKey, String pulicKey, String text) {
        RSA rsa = new RSA(AsymmetricAlgorithm.RSA_ECB_PKCS1.getValue(), privateKey, pulicKey);
        //公钥解密
        String decryptByPublic = rsa.decryptStr(text, KeyType.PublicKey);
        return decryptByPublic;

    }

    /**
     * 获取RSA密钥对
     *
     * @return [0] 私钥，[1] 公钥
     */
    public static String[] generateKeyPair() {
        KeyPair pair = SecureUtil.generateKeyPair("RSA", 1024);
        String privateKey = Base64.encode(pair.getPrivate().getEncoded());
        String pulicKey = Base64.encode(pair.getPublic().getEncoded());
        String[] result = {privateKey, pulicKey};
        return result;
    }
}

//密码字段长度设计建议为 200，避免密码加密后长度变大无法存储