package org.knowleaf.common.domain.second;

import java.io.Serializable;
import java.util.Date;

public class SysConfig implements Serializable {
    private String variable;

    private String value;

    private Date setTime;

    private String setBy;

    private static final long serialVersionUID = 1L;

    public SysConfig(String variable, String value, Date setTime, String setBy) {
        this.variable = variable;
        this.value = value;
        this.setTime = setTime;
        this.setBy = setBy;
    }

    public SysConfig() {
        super();
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable == null ? null : variable.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Date getSetTime() {
        return setTime;
    }

    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    public String getSetBy() {
        return setBy;
    }

    public void setSetBy(String setBy) {
        this.setBy = setBy == null ? null : setBy.trim();
    }
}