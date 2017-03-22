package com.lt.core.bean;

import java.io.Serializable;
import java.util.Date;

public class Trx implements Serializable{
    private Integer id;

    private Integer contentid;

    private Integer personid;

    private Integer price;

    private Date time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContentid() {
		return contentid;
	}

	public void setContentid(Integer contentid) {
		this.contentid = contentid;
	}

	public Integer getPersonid() {
		return personid;
	}

	public void setPersonid(Integer personid) {
		this.personid = personid;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}



 
}