package com.chaoyous.readnote.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.chaoyous.readnote.exception.CreateTokenErrorException;
import com.chaoyous.readnote.exception.VerifyTokenErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
public class CommonUtils {
    private final static String SECRET = "chaoyous";

    @Resource
    private RedisUtil redisUtil;

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String tokenMaker(String id){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    .withIssuer("chaoyous").withClaim("user_id",id)
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new CreateTokenErrorException();
        }
    }

    public static String getMD5(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1,md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String tokenVerify(String token)throws JWTVerificationException{
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("chaoyous")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            String userId = jwt.getClaim("user_id").asString();
            if(RedisUtil.hasKey(userId)){
                RedisUtil.expire(userId,864000);
                return userId;
            }else {
                throw new VerifyTokenErrorException();
            }
    }

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}
