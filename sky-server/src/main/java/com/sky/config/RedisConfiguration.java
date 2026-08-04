package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Project: sky-take-out
 * @Package: com.sky.config
 * @Author: SUN
 * @Date: 2026/5/24 15:20
 * @Version: v1.0.0
 * @Description: 配置redis
 **/
@Configuration
@Slf4j
public class RedisConfiguration {

	@Bean
	public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		log.info("开始穿件redis模版对象...");
		RedisTemplate redisTemplate = new RedisTemplate();
		// 设置redis的连接工厂对象
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		// 设置redis key的序列化器
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new StringRedisSerializer());
		return redisTemplate;
	}
}
