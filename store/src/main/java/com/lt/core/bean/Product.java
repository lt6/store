package com.lt.core.bean;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{
    private Integer id;

    private Double price;

    private String title;

    private String summary;
    
    private String image;

    private String detail;
    
    private Boolean isBuy;
    
    private Double buyPrice;
    
    private Integer buyNum;
    
    private Date buyTime;
    
    private Boolean isSell;
    
    private Integer saleNum;
    
    private Integer number;
    

    
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Boolean getIsBuy() {
		return isBuy;
	}

	public void setIsBuy(Boolean isBuy) {
		this.isBuy = isBuy;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Integer getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}

	public Date getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	public Boolean getIsSell() {
		return isSell;
	}

	public void setIsSell(Boolean isSell) {
		this.isSell = isSell;
	}

	public Integer getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}
    
    
    
    
}
