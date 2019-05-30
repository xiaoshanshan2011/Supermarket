package com.shan.admin.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: chenjunshan
 * @Date: 19-5-30 上午10:29
 */
public class TestBean {
    @NotBlank(message = "a不能为空")
    private String a;
    private String b;
    @NotNull(message = "c不能为空")
    private Long c;
    private Integer d;
    @NotNull(message = "e不能为空")
    private Boolean e;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Long getC() {
        return c;
    }

    public void setC(Long c) {
        this.c = c;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    public Boolean getE() {
        return e;
    }

    public void setE(Boolean e) {
        this.e = e;
    }
}
