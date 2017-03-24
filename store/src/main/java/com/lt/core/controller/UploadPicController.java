package com.lt.core.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lt.common.CommonUtils;
import com.lt.common.ResponseUtils;
import com.lt.web.Constants;



@Controller
public class UploadPicController extends HttpServlet{
	@RequestMapping(value = "/uploadPic")
	public void uploadPic(HttpServletRequest request,PrintWriter out, HttpServletResponse response)
			throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
						try {
					MultipartHttpServletRequest mulReq = (MultipartHttpServletRequest) request;
					MultipartFile mf = mulReq.getFile("file");
					//获取文件上传流
					byte[] fbytes = mf.getBytes();
					String name=mf.getOriginalFilename();

					// 获取上传文件的保存目录
					String savepath = request.getSession().getServletContext().getRealPath("/upload");
					String uuid = CommonUtils.uuid();//生成uuid
					String filename = uuid + "_" + name;//新的文件名称为uuid + 下划线 + 原始名称
							
					//创建file对象，下面会把上传文件保存到这个file指定的路径
					//savepath，即上传文件的保存目录
					//filename，文件名称
					File file = new File(savepath, filename);
					String url=Constants.IMAGE_URL+"\\"+filename;
					String relative="upload/"+filename;
					
					  FileOutputStream fos=new FileOutputStream(file);
				      fos.write(fbytes);
				      fos.close();  
				         
					//返回二个路径
					JSONObject jo = new JSONObject();
					jo.put("result", relative);
					jo.put("url", url);
					ResponseUtils.renderJson(response, jo.toString());
					
				} catch (Exception e) {
					throw new ServletException(e);
				} 

			}
}
