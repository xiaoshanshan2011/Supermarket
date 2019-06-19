package com.shan.admin.paramsbean;

import java.math.BigDecimal;

/**
 * @Author: chenjunshan
 * @Date: 19-6-4 下午12:04
 */
public class WarehouseGoodsParamsBean2 {
    private String id;

    private BigDecimal vipprice;

    private BigDecimal discountsprice;

    private BigDecimal specialsaleprice;

    private BigDecimal wholesaleprice;

    private BigDecimal price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getVipprice() {
        return vipprice;
    }

    public void setVipprice(BigDecimal vipprice) {
        this.vipprice = vipprice;
    }

    public BigDecimal getDiscountsprice() {
        return discountsprice;
    }

    public void setDiscountsprice(BigDecimal discountsprice) {
        this.discountsprice = discountsprice;
    }

    public BigDecimal getSpecialsaleprice() {
        return specialsaleprice;
    }

    public void setSpecialsaleprice(BigDecimal specialsaleprice) {
        this.specialsaleprice = specialsaleprice;
    }

    public BigDecimal getWholesaleprice() {
        return wholesaleprice;
    }

    public void setWholesaleprice(BigDecimal wholesaleprice) {
        this.wholesaleprice = wholesaleprice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
