package org.knowleaf.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * 一些项目相关的属性配置
 */
@Component
@ConfigurationProperties(prefix = "config")
public class PropertyConfig {

    private String env; //运行环境的配置，dev-本地开发，test-测试环境，production-线上
    private String domainHost; //项目域名

    @NestedConfigurationProperty
    private RedisConfig redis;

    @NestedConfigurationProperty
    private OssConfig oss;

    public boolean isDev() {
        return "dev".equals(env);
    }

    public boolean isTest() {
        return "test".equals(env);
    }

    public boolean isProd() {
        return "production".equals(env);
    }

    public boolean isNotProd() {
        return !isProd();
    }

    public static class OssConfig {
        private String bucketName;
        private String endpoint;
        private String accessKeyId;
        private String secretAccessKey;

        public String getBucketName() {
            return bucketName;
        }

        public void setBucketName(String bucketName) {
            this.bucketName = bucketName;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        public String getAccessKeyId() {
            return accessKeyId;
        }

        public void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        public String getSecretAccessKey() {
            return secretAccessKey;
        }

        public void setSecretAccessKey(String secretAccessKey) {
            this.secretAccessKey = secretAccessKey;
        }
    }

    public static class RedisConfig {
        private boolean enable;
        private String url;
        private String pwd;
        private Integer port;

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }
    }

    public RedisConfig getRedis() {
        return redis;
    }

    public void setRedis(RedisConfig redis) {
        this.redis = redis;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public OssConfig getOss() {
        return oss;
    }

    public void setOss(OssConfig oss) {
        this.oss = oss;
    }

    public String getDomainHost() {
        return domainHost;
    }

    public void setDomainHost(String domainHost) {
        this.domainHost = domainHost;
    }

}
