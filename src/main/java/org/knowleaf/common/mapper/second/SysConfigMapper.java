package org.knowleaf.common.mapper.second;

import org.knowleaf.common.domain.second.SysConfig;

public interface SysConfigMapper {
    int insert(SysConfig record);

    int insertSelective(SysConfig record);
}