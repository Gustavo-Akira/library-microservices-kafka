package br.com.gustavoakira.library.author.adapters.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.time.Duration;

@Configuration
public class SpringRedisCacheConfiguration {

    @Value("${cache.host}")
    private String host;
    @Value("${cache.password}")
    private String password;
    @Value("${cache.port}")
    private Integer port;
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.builder(connectionFactory)
                .transactionAware()
                .allowCreateOnMissingCache(true)
                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1L)))
                .build();
    }

    @Bean
    public  RedisConnectionFactory connectionFactory(){
        RedisClusterConfiguration clusterConfiguration = new RedisClusterConfiguration();
        clusterConfiguration.setPassword("");
        RedisNode redisNode = RedisNode.newRedisNode()
                .listeningAt(host,port)
                .build();
        clusterConfiguration.addClusterNode(redisNode);
        return new JedisConnectionFactory(clusterConfiguration);
    }
}
