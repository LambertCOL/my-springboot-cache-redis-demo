//package cn.lamb.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//
///**
// * @Description TODO
// * @Date 2020/4/19 20:40
// * @Creator Lambert
// */
////@Configuration
//public class MyRedisTemplateConfig {
//
//    @Bean(name = "redisTemplate")    //将返回值放入 ioc 容器，bean 的名称一定要叫做 redisTemplate
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        //创建一个 RedisTemplate 对象，这是用来操作 Redis 数据的
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        //如果不对 RedisTemplate 进行任何处理，那么它默认的序列化方式就是 JDK 序列化方式，这样搞出来的文字是人看不懂的
//        //我的目标是在将数据存入 Redis 时是阳间的文字，是人能看懂的，所以需要来通过setDefaultSerializer方法手动设置序列化器为Json序列化
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        //TODO 为了解决查询缓存转换异常的问题，搞多一步这个，但是原理不详，日后再探
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        //设置我们自定义的序列化器
//        template.setDefaultSerializer(jackson2JsonRedisSerializer);
//        return template;
//    }
//}
