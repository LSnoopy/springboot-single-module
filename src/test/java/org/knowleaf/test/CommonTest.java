package org.knowleaf.test;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.knowleaf.common.config.PropertyConfig;
import org.knowleaf.common.domain.first.TestUser;
import org.knowleaf.common.domain.first.TestUserQuery;
import org.knowleaf.common.domain.second.SysConfig;
import org.knowleaf.common.mapper.first.TestUserMapper;
import org.knowleaf.common.mapper.second.SysConfigMapper;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
    public void pageHelper() {
        Page<TestUser> page = PageHelper.startPage(1, 1);
        TestUserQuery query = new TestUserQuery();
        List<TestUser> list = testUserMapper.selectByExample(query);
        System.out.println(page.getTotal());
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void userMapper() {
        TestUser u = new TestUser();
        u.setUserName("dsadsa");
        testUserMapper.insertSelective(u);
    }

    @Test
    public void sysConfigMapper() {
        SysConfig s = new SysConfig();
        s.setSetBy("t");
        s.setSetTime(new Date());
        s.setValue("v");
        s.setVariable("va");
        sysConfigMapper.insertSelective(s);
    }

    @Test
    public void propertyConfig() {
        System.out.println(JSON.toJSONString(propertyConfig));
    }
}
