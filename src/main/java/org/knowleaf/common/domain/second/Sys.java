package org.knowleaf.common.domain.second;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "test_sys")
public class Sys implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "sys_name")
    private String sysName;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return sys_name - 用户名
     */
    public String getSysName() {
        return sysName;
    }

    /**
     * 设置用户名
     *
     * @param sysName 用户名
     */
    public void setSysName(String sysName) {
        this.sysName = sysName;
    }
}