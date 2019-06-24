package org.knowleaf.service.biz;


import org.knowleaf.common.mapper.BaseBizMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class BaseBizService<T, PK extends Serializable> {

    @Autowired
    private BaseBizMapper<T> baseBizMapper;

    public int insert(T entity) {
        return baseBizMapper.insert(entity);
    }

    public int insertSelective(T entity) {
        return baseBizMapper.insertSelective(entity);
    }

    public int delete(T entity) {
        return baseBizMapper.delete(entity);
    }

    public int deleteByPrimaryKey(PK id) {
        return baseBizMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKey(T entity) {
        return baseBizMapper.updateByPrimaryKey(entity);
    }

    public int updateByPrimaryKeySelective(T entity) {
        return baseBizMapper.updateByPrimaryKeySelective(entity);
    }

    public T selectByPrimaryKey(PK id) {
        return baseBizMapper.selectByPrimaryKey(id);
    }

    public T selectOne(T entity) {
        return baseBizMapper.selectOne(entity);
    }

    public int selectCount(T entity) {
        return baseBizMapper.selectCount(entity);
    }

    public List<T> select(T entity) {
        return baseBizMapper.select(entity);
    }

    public List<T> selectAll() {
        return baseBizMapper.selectAll();
    }

}
