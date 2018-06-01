package com.redis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoController {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisServiceString redisServiceString;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void demoTest(){
        redisService.set("1", "value22222");
    }

    @RequestMapping(value = "/remove1", method = RequestMethod.GET)
    public void demoTest1(){
        redisService.remove("1");
    }

    @RequestMapping(value = "/hmset1", method = RequestMethod.GET)
    public void demoTest2(){
        redisService.hmSet("hash1", "name", "William");
    }

    @RequestMapping(value = "/set1", method = RequestMethod.POST)
    public void demoTest3(){
        redisServiceString.set("name","William");
    }

    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    public String demoTest4(){
        return redisServiceString.get("name");
    }

    @RequestMapping(value = "/setH1", method = RequestMethod.POST)
    public void demoTest5(){
        redisServiceString.hsSet("You","name","Bob");
    }

    @RequestMapping(value = "/getH1",method = RequestMethod.GET)
    public String demoTest6(){
        return redisServiceString.hsGet("You","name");
    }
}
