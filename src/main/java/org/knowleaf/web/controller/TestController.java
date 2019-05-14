package org.knowleaf.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ author liujianjian
 * @ date 2019/5/14 10:28
 */
@RestController
public class TestController {

    @RequestMapping("/")
    public Object test() {
        return "hello world";
    }
}
