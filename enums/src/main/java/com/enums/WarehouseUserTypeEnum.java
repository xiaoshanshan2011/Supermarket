package com.enums;

/**
 * @Author: chenjunshan
 * @Date: 18-12-30 下午2:52
 */
public enum WarehouseUserTypeEnum {
    ADMINISTRATOR(1, "仓库管理员"),
    DELIVERYMAN(2, "配送员"),
    BUYER(3, "采购员"),
    ;
    private Integer id;
    private String typeName;

    WarehouseUserTypeEnum(Integer id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }}
