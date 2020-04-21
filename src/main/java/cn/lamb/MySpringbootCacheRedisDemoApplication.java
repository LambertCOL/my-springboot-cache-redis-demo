package cn.lamb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MySpringbootCacheRedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringbootCacheRedisDemoApplication.class, args);
    }

}
