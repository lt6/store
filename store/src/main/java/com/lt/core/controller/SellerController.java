package com.lt.core.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import com.lt.common.ResponseUtils;
import com.lt.common.session.SessionProvider;
import com.lt.core.bean.Product;
import com.lt.core.bean.User;
import com.lt.core.service.product.ProductService;
import com.lt.web.Constants;


@Controller
public class SellerController extends HttpServlet{
	@Autowired
	private ProductService productService;
	@Autowired
	private SessionProvider sessionProvider;
	
	//去发布页
	@RequestMapping(value = "/public.do")
	public String toPublic(HttpServletRequest request,ModelMap model){
		if(sessionProvider.getAttribute(request, Constants.PERSON_SESSION)!=null){
			User user = (User) sessionProvider.getAttribute(request, Constants.PERSON_SESSION);
			model.addAttribute("user", user);
			return "public";
		}else{
			return "login";
		}
	}
	//删除产品
	@RequestMapping(value = "/api/delete.do")
	public void delete(Integer id, HttpServletResponse response){
		productService.deleteProduct(id);
		JSONObject jo = new JSONObject();
		int code=200;
		jo.put("code",code);
		jo.put("message", "删除成功");
		jo.put("result", true);
		ResponseUtils.renderJson(response, jo.toString());
	}

	//发布提交
	@RequestMapping(value = "/publicSubmit.do")
	public String publicSubmit(HttpServletRequest request,Product product,ModelMap model){
		if(sessionProvider.getAttribute(request, Constants.PERSON_SESSION)!=null){
			User user = (User) sessionProvider.getAttribute(request, Constants.PERSON_SESSION);
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
		if(sessionProvider.getAttribute(request, Constants.PERSON_SESSION)!=null){
			User user = (User) sessionProvider.getAttribute(request, Constants.PERSON_SESSION);
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
		if(sessionProvider.getAttribute(request, Constants.PERSON_SESSION)!=null){
			User user = (User) sessionProvider.getAttribute(request, Constants.PERSON_SESSION);
			model.addAttribute("user", user);
			productService.updateProductByKey(product);
			model.put("product", product);
			return "editSubmit";
		}else{
			return "login";
		}
	}
	
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
					int code=200;
					jo.put("code",code);
					jo.put("message", "上传成功");
					jo.put("result", relative);
					//jo.put("url", url);
					ResponseUtils.renderJson(response, jo.toString());
					
				} catch (Exception e) {
					throw new ServletException(e);
				} 

			}
	

}
