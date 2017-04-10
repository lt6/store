package com.lt.core.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lt.common.CommonUtils;
import com.lt.common.Constants;
import com.lt.common.ResponseUtils;
import com.lt.common.session.SessionProvider;
import com.lt.core.bean.Product;
import com.lt.core.bean.User;
import com.lt.core.service.product.ProductService;



@Controller
public class SellerController extends HttpServlet{
	@Autowired
	private ProductService productService;
	@Autowired
	private SessionProvider sessionProvider;
	
	//发布页
	@RequestMapping(value = "/public.do")
	public String toPublic(HttpServletRequest request,ModelMap model){
		User user = (User) sessionProvider.getAttribute(request, Constants.UER_SESSION);
		if(user!=null && user.getUserType()==1){
			model.addAttribute("user", user);
			return "public";
		}else{
			return "login";
		}
	}
	//删除
	@RequestMapping(value = "/api/delete.do")
	public String delete(HttpServletRequest request,Integer id, HttpServletResponse response){
		User user = (User) sessionProvider.getAttribute(request, Constants.UER_SESSION);
		if(user!=null && user.getUserType()==1){
			productService.deleteProduct(id);
			JSONObject jo = new JSONObject();
			int code=200;
			jo.put("code",code);
			jo.put("message", "删除成功");
			jo.put("result", true);
			ResponseUtils.renderJson(response, jo.toString());
			return null;
		}else{
			return "login";
		}
	}

	//发布
	@RequestMapping(value = "/publicSubmit.do")
	public String publicSubmit(HttpServletRequest request,Product product,ModelMap model){
		User user = (User) sessionProvider.getAttribute(request, Constants.UER_SESSION);
		if(user!=null && user.getUserType()==1){
			model.addAttribute("user", user);
			productService.addProduct(product);
			model.put("product", product);
			return "publicSubmit";
		}else{
			return "login";
		}
	}
	//编辑页
	@RequestMapping(value = "/edit.do")
	public String edit(HttpServletRequest request,Integer id,ModelMap model){
		User user = (User) sessionProvider.getAttribute(request, Constants.UER_SESSION);
		if(user!=null && user.getUserType()==1){
			model.addAttribute("user", user);
			Product product=productService.show(id);
			model.put("product", product);
			return "edit";
		}else{
			return "login";
		}
	}
	
	//编辑提交
	@RequestMapping(value = "/editSubmit.do")
	public String editSubmit(HttpServletRequest request,Product product,ModelMap model){
		User user = (User) sessionProvider.getAttribute(request, Constants.UER_SESSION);
		if(user!=null && user.getUserType()==1){
			model.addAttribute("user", user);
			productService.updateProductByKey(product);
			model.put("product", product);
			return "editSubmit";
		}else{
			return "login";
		}
	}
	//异步上传图片
	@RequestMapping(value = "/api/upload.do")
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
					//生成uuid
					String uuid = CommonUtils.uuid();
					//新的文件名称为uuid + 下划线 + 原始名称
					String filename = uuid + "_" + name;
					//创建file对象，下面会把上传文件保存到这个file指定的路径
					//savepath，即上传文件的保存目录
					//filename，文件名称
					File file = new File(savepath, filename);
					String url="upload/"+filename;
					
					FileOutputStream fos=new FileOutputStream(file);
				    fos.write(fbytes);
				    fos.close();  
				         
					//JSON返回路径
					JSONObject jo = new JSONObject();
					int code=200;
					jo.put("code",code);
					jo.put("message", "上传成功");
					jo.put("result", url);
					ResponseUtils.renderJson(response, jo.toString());
					} catch (Exception e) {
					throw new ServletException(e);
				} 

			}
}
