package com.jt.manage.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;
import com.jt.manage.service.FileService;

@Service
public class FileServiceImpl implements FileService{

	
	private String localDirPath = "E:/jt-uploadFile";
	private String localUrlPath = "http://image.jt.com/";
	
	/**
	 * 实现步骤和思路
	 * 1.校验图片的类型(jps|png|gif)
	 * 2.防止恶意程序 获取宽度和高度 判断是否为图片
	 * 3.为了减少图片的数量, 一般采用分文件存储的方式, 提高检索效率
	 * 4.问了防止文件重名, 则动态的生成文件名称
	 */
	@Override
	public PicUploadResult uploadFile(MultipartFile uploadFile) {
		PicUploadResult result = new PicUploadResult();
		//1.判断文件类型
		String fileName = uploadFile.getOriginalFilename();
		fileName = fileName.toLowerCase();//将字符都转化为小写字符
		if(!fileName.matches("^.*\\.(jpg|png|gif)$")) {
			//表示不是图片
			result.setError(1);
			return result;
		}
		try {
			//2.判断是否为恶意程序
			BufferedImage bufferedImage = ImageIO.read(uploadFile.getInputStream());
			//a.获取图片的宽度
			int width = bufferedImage.getWidth();
			int height = bufferedImage.getHeight();
			//判断是否为图片
			if (width==0 || height ==0) {
				result.setError(1);
				return result;
			} 
			/**
			 * b.进行分文件存储
			 * 1.按照日期划分 yyyy/MM/dd
			 * 2.hash UUID 32位 8/8/8/8 
			 * 3.随机数2个数字1个文件夹3级 XX/XX/XX
			 * 动态的生成文件名称: UUID.jpg (大概是21亿个文件名称)也有一定的记录出现重复  解决方法:+随机数3位
			 */
			
			//生成日期文件夹
			
			String dateDir = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
			String dirFilePath =localDirPath+"/"+dateDir;
			File  dirFile = new File(dirFilePath);
			
			if(!dirFile.exists()) {
				//如果文件夹不存在, 则新建
				dirFile.mkdirs();
			}
			
			
			//4.1生成UUID
			String uuid = UUID.randomUUID().toString().replace("-", "");//替换生成的UUID中的"-"
			//4.2生成随机数
			int randomNum = new Random().nextInt(1000);
			//4.3截取文件后缀
			String fileType = 
					fileName.substring( fileName.lastIndexOf("."));
			//4.4获取文件名称
			String imageFileName = uuid +randomNum +fileType;
			uploadFile.transferTo(new File(dirFilePath+"/"+imageFileName));
			//处理返回值
			result.setWidth(width+"");
			result.setHeight(height+"");
			
			//封装一个本地url
			String url = localUrlPath + dateDir + "/" +imageFileName;
			
			result.setUrl(url);
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setError(1); //图片有问题
			return result;
		}
	
		return result;
	}

}
