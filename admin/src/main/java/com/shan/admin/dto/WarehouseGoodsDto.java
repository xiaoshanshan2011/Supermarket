package com.shan.admin.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class WarehouseGoodsDto {
    private String id;

    @NotBlank(message = "warehouseid不能为空")
    private String warehouseid;

    @NotNull(message = "goodscode不能为空")
    private Long goodscode;

    private Integer goodsstock;

    private Integer deleted;

    private Integer salenum;

    private BigDecimal vipprice;

    private BigDecimal discountsprice;

    private BigDecimal specialsaleprice;

    private BigDecimal wholesaleprice;

    private BigDecimal price;

    private Date createtime;

    private Date updatetime;

    private GoodsDto goods;

    public GoodsDto getGoods() {
        return goods;
    }

    public void setGoods(GoodsDto goods) {
        this.goods = goods;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(String warehouseid) {
        this.warehouseid = warehouseid == null ? null : warehouseid.trim();
    }

    public Long getGoodscode() {
        return goodscode;
    }

    public void setGoodscode(Long goodscode) {
        this.goodscode = goodscode;
    }

    public Integer getGoodsstock() {
        return goodsstock;
    }

    public void setGoodsstock(Integer goodsstock) {
        this.goodsstock = goodsstock;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getSalenum() {
        return salenum;
    }

    public void setSalenum(Integer salenum) {
        this.salenum = salenum;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}