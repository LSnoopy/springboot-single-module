package org.knowleaf.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.knowleaf.common.config.PropertyConfig;

import javax.annotation.Resource;

/**
 * @ author liujianjian
 * @ date 2019/5/14 15:42
 */
public class CommonTest extends BaseSpringBootJunitTest {

    @Resource
    private PropertyConfig propertyConfig;

    @Test
    public void t() {
        System.out.println(JSON.toJSONString(propertyConfig));
    }
}
