package com.jt.manage.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;
import com.jt.manage.service.FileService;
@Controller
public class FileContoller {
	@Autowired
	FileService fileService;
	
	@RequestMapping("/file")
	/**
	 * 当实现了文件上传后, 要求重定向到file.jsp页面
	 * 要求文件的名称必须和页面中的name属性一致
	 * 文件上传的步骤:
	 * 1.获取文件的名称
	 * 2.定义文件上传的文件夹
	 * 3.判断文件夹是否存在
	 * 4.实现文件上传
	 * @return
	 */
	public String file(MultipartFile fileImage) throws IllegalStateException, IOException {
		System.out.println("file()<<<");
		//1.获取文件名称
		String fileName = fileImage.getOriginalFilename();
		//2.定义文件上传的文件夹
		String filePath ="E:/jt-upload";
		//3.判断文件夹是否存在
		File imageFile = new File(filePath);
		if(!imageFile.exists()) {
			//新建文件夹
			imageFile.mkdirs();
		}
		//4.实现文件上传
		fileImage.transferTo(new File(imageFile+"/"+fileName));
		//5.返回
		System.out.println("文件上传成功!");		
		return "redirect:/file.jsp";
	}
	/**
	 * 实现业务的文件上传
	 * @param uploadFile
	 * @return
	 */
	@RequestMapping("/pic/upload")
	@ResponseBody
	public PicUploadResult uploadFile(MultipartFile uploadFile) {
		System.out.println("uploadFile<<<");
		
		return fileService.uploadFile(uploadFile);
	}
	
}
