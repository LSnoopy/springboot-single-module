package org.knowleaf.common.mapper.first;

import org.knowleaf.common.domain.first.TestUser;

public interface TestUserMapper {
    int insert(TestUser record);

    int insertSelective(TestUser record);
}