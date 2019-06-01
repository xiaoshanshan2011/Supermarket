package com.shan.admin.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class GoodsDto {
    private Long goodscode;
    @NotNull(message = "barcode不能为空")
    private Long barcode;
    @NotBlank(message = "classifyid不能为空")
    private String classifyid;
    @NotBlank(message = "pclassifyid不能为空")
    private String pclassifyid;
    @NotBlank(message = "goodsname不能为空")
    private String goodsname;
    @NotBlank(message = "goodsimg不能为空")
    private String goodsimg;
    @NotBlank(message = "goodsunit不能为空")
    private String goodsunit;

    private Integer ishot;
    private Integer goodstype;
    @NotNull(message = "vipprice不能为空")
    private BigDecimal vipprice;
    @NotNull(message = "discountsprice不能为空")
    private BigDecimal discountsprice;
    @NotNull(message = "specialsaleprice不能为空")
    private BigDecimal specialsaleprice;
    @NotNull(message = "wholesaleprice不能为空")
    private BigDecimal wholesaleprice;
    @NotNull(message = "price不能为空")
    private BigDecimal price;

    private Integer deleted;

    private Date createtime;

    private Date updatetime;

    private String goodsdesc;

    private String goodsspec;

    private GoodsClassifyDto pclassify;

    private GoodsClassifyDto classify;

    public GoodsClassifyDto getPclassify() {
        return pclassify;
    }

    public void setPclassify(GoodsClassifyDto pclassify) {
        this.pclassify = pclassify;
    }

    public GoodsClassifyDto getClassify() {
        return classify;
    }

    public void setClassify(GoodsClassifyDto classify) {
        this.classify = classify;
    }

    public Integer getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(Integer goodstype) {
        this.goodstype = goodstype;
    }

    public Long getGoodscode() {
        return goodscode;
    }

    public void setGoodscode(Long goodscode) {
        this.goodscode = goodscode;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public String getClassifyid() {
        return classifyid;
    }

    public void setClassifyid(String classifyid) {
        this.classifyid = classifyid == null ? null : classifyid.trim();
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg == null ? null : goodsimg.trim();
    }

    public String getGoodsunit() {
        return goodsunit;
    }

    public void setGoodsunit(String goodsunit) {
        this.goodsunit = goodsunit == null ? null : goodsunit.trim();
    }

    public Integer getIshot() {
        return ishot;
    }

    public void setIshot(Integer ishot) {
        this.ishot = ishot;
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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

    public String getGoodsdesc() {
        return goodsdesc;
    }

    public void setGoodsdesc(String goodsdesc) {
        this.goodsdesc = goodsdesc == null ? null : goodsdesc.trim();
    }

    public String getGoodsspec() {
        return goodsspec;
    }

    public void setGoodsspec(String goodsspec) {
        this.goodsspec = goodsspec == null ? null : goodsspec.trim();
    }

    public String getPclassifyid() {
        return pclassifyid;
    }

    public void setPclassifyid(String pclassifyid) {
        this.pclassifyid = pclassifyid;
    }
}