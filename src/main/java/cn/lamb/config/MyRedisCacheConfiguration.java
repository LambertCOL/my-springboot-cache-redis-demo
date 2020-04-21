//package cn.lamb.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.time.Duration;
//
///**
// * @Description TODO
// * @Date 2020/4/20 9:25
// * @Creator Lambert
// */
////@Configuration
//public class MyRedisCacheConfiguration {
//    @Bean
//    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        // 分别创建 String 和 JSON 格式序列化对象，对缓存数据 key 和 value 进行转换
//        RedisSerializer<String> strSerializer = new StringRedisSerializer();
//        Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);
//
//        // 解决查询缓存转换异常问题
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jacksonSeial.setObjectMapper(om);
//
//        // 定制缓存数据序列化方式及时效
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofDays(1))   //时效
//                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(strSerializer))   //key 的序列化方式为 StringRedisSerializer
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jacksonSeial))  //value 的序列化方式为 Jackson2JsonRedisSerializer
//                .disableCachingNullValues();    //不缓存空值
//
//        RedisCacheManager cacheManager = RedisCacheManager
//                .builder(redisConnectionFactory)
//                .cacheDefaults(config)
//                .build();
//
//        return cacheManager;
//
//    }
//}
