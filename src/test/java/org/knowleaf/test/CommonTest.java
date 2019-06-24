package org.knowleaf.test;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.knowleaf.common.config.PropertyConfig;
import org.knowleaf.common.domain.first.User;
import org.knowleaf.common.domain.second.Sys;
import org.knowleaf.common.mapper.first.UserMapper;
import org.knowleaf.common.mapper.second.SysMapper;
import org.knowleaf.service.biz.BizUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ author liujianjian
 * @ date 2019/5/14 15:42
 */
public class CommonTest extends BaseSpringBootJunitTest {

    @Resource
    private PropertyConfig propertyConfig;
    @Resource
    private UserMapper userMapper;
    @Resource
    private SysMapper sysMapper;
    @Resource
    private BizUserService bizUserService;

    @Test
    public void userService() {
        User u = new User();
        u.setUserName("000");
        bizUserService.insert(u);
    }

    @Test
    public void pageHelper() {
        Page<User> page = PageHelper.startPage(1, 1);
        List<User> list = userMapper.select(new User());
        System.out.println(page.getTotal());
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void userMapper() {
        User u = new User();
        u.setUserName("dsadsa");
        userMapper.insertSelective(u);
    }

    @Test
    public void sysConfigMapper() {
        Sys s = new Sys();
        s.setSysName("ss");
        sysMapper.insertSelective(s);
    }

    @Test
    public void propertyConfig() {
        System.out.println(JSON.toJSONString(propertyConfig));
    }
}
