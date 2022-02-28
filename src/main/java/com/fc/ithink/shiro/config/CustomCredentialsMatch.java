package com.fc.ithink.shiro.config;

import com.fc.ithink.common.enums.LoginType;
import com.fc.ithink.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

public class CustomCredentialsMatch extends HashedCredentialsMatcher {
    private Cache<String, AtomicInteger> passwordRetryCache;

    public CustomCredentialsMatch (CacheManager cacheManager) {
        this.passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //增加免密登录功能，使用自定义token
        UsernamePasswordToken usertoken = (UsernamePasswordToken) token;

        //免密登录,不验证密码
        if (LoginType.NOPASSWD.equals(usertoken.getType())){
            return true;
        }

        String loginID = usertoken.getUsername();

        AtomicInteger retryTimes = passwordRetryCache.get(loginID);
        if (retryTimes == null) {
            retryTimes = new AtomicInteger(0);
            passwordRetryCache.put(loginID, retryTimes);
        }
        if (retryTimes.incrementAndGet() > 5) {
            throw new ExcessiveAttemptsException();
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches)
            passwordRetryCache.remove(loginID);

        return matches;
    }
}

