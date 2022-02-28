package com.fc.ithink.common.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "tencent")
public class TencentConfig {

    /**
     * 腾讯云的SecretId
     */
    private static String secretId;

    /**
     * 腾讯云的SecretKey
     */
    private static String secretKey;

    /**
     * 腾讯云的bucket (存储桶)
     */
    private static String bucket;

    /**
     * 腾讯云的region(bucket所在地区)
     */
    private static String region;

    /**
     * 腾讯云的allowPrefix(允许上传的路径)
     */
    private static String allowPrefix;

    /**
     * 腾讯云的临时密钥时长(单位秒)
     */
    private static String durationSeconds;

    /**
     * 腾讯云的访问基础链接
     */
    private static String baseUrl;

    /**
     * 腾讯云的cdn访问基础链接
     */
    private static String cdnUrl;


    public static String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        TencentConfig.secretId = secretId;
    }

    public static String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        TencentConfig.secretKey = secretKey;
    }

    public static String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        TencentConfig.bucket = bucket;
    }

    public static String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        TencentConfig.region = region;
    }

    public static String getAllowPrefix() {
        return allowPrefix;
    }

    public void setAllowPrefix(String allowPrefix) {
        TencentConfig.allowPrefix = allowPrefix;
    }

    public static String getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(String durationSeconds) {
        TencentConfig.durationSeconds = durationSeconds;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        TencentConfig.baseUrl = baseUrl;
    }

    public static String getCdnUrl() {
        return cdnUrl;
    }

    public void setCdnUrl(String cdnUrl) {
        TencentConfig.cdnUrl = cdnUrl;
    }
}
