package com.lt.core.bean;

import com.lt.web.Constants;


public class Content {
    private Integer id;

    private Long price;

    private String title;

    private String summary;
    
    private String image;

    private String detail;
  //获取全路径
  	public String getAllUrl(){
  		return Constants.IMAGE_URL + image;
  	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
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
    
    
    


	
    
}
