package org.knowleaf.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.knowleaf.common.config.PropertyConfig;
import org.knowleaf.common.domain.first.TestUser;
import org.knowleaf.common.domain.second.SysConfig;
import org.knowleaf.common.mapper.first.TestUserMapper;
import org.knowleaf.common.mapper.second.SysConfigMapper;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ author liujianjian
 * @ date 2019/5/14 15:42
 */
public class CommonTest extends BaseSpringBootJunitTest {

    @Resource
    private PropertyConfig propertyConfig;
    @Resource
    private TestUserMapper testUserMapper;
    @Resource
    private SysConfigMapper sysConfigMapper;

    @Test
    public void mybatis() {
        TestUser u = new TestUser();
        u.setUserName("tttt");
        testUserMapper.insertSelective(u);

        SysConfig s = new SysConfig();
        s.setSetBy("t");
        s.setSetTime(new Date());
        s.setValue("v");
        s.setVariable("va");
        sysConfigMapper.insertSelective(s);
    }

    @Test
    public void t() {
        System.out.println(JSON.toJSONString(propertyConfig));
    }
}
