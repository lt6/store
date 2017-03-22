package com.lt.core.service.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.core.bean.Content;
import com.lt.core.dao.ContentDao;
@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private ContentDao contentDao;
	
	//发布内容
	public Integer addContent(Content content) {
		return contentDao.addContent(content);
	}

}
