package com.frame.boot.frame.security.entity;

import com.frame.boot.frame.mybatis.model.BaseMysqlModel;
import se.spagettikod.optimist.OptimisticLocking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@OptimisticLocking("sys_module")
public class SysModule extends BaseMysqlModel {

    private String typeCode;

    private String parentCode;

    private Integer level;

    private String validate;

    private String useable;

    private String name;

    private String code;

    private String icon;

    private String url;

    private List<SysFunction> functions = new ArrayList<>();

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate == null ? null : validate.trim();
    }

    public String getUseable() {
        return useable;
    }

    public void setUseable(String useable) {
        this.useable = useable == null ? null : useable.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public List<SysFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(List<SysFunction> functions) {
        this.functions = functions;
    }
}