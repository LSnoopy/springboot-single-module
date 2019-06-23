package org.knowleaf.common.mapper.first;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.knowleaf.common.domain.first.TestUser;
import org.knowleaf.common.domain.first.TestUserQuery;

public interface TestUserMapper {
    long countByExample(TestUserQuery example);

    int deleteByExample(TestUserQuery example);

    int insert(TestUser record);

    int insertSelective(TestUser record);

    List<TestUser> selectByExample(TestUserQuery example);

    int updateByExampleSelective(@Param("record") TestUser record, @Param("example") TestUserQuery example);

    int updateByExample(@Param("record") TestUser record, @Param("example") TestUserQuery example);
}