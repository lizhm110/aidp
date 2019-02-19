package com.aidp.redis;

import com.aidp.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author lizhm
 * @Date 2019-2-19
 */
@RestController
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }

    /**
     * redis key值存储
     * @return
     */
    @RequestMapping("/get")
    public String setkey() {

        if (!redisUtil.hasKey("test")) {
            redisUtil.set("test", "12345");
        }

        String value = redisUtil.get("test").toString();
        return value;
    }

    /**
     * redis key删除
     * @return
     */
    @RequestMapping("/delete")
    public boolean deleteKey() {

        if (redisUtil.hasKey("test")) {
            redisUtil.del("test");
        }

        return redisUtil.hasKey("test");
    }
}