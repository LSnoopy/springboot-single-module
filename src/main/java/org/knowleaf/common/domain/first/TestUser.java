package org.knowleaf.common.domain.first;

import java.io.Serializable;

public class TestUser implements Serializable {
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    private static final long serialVersionUID = 1L;

    public TestUser(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public TestUser() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

}