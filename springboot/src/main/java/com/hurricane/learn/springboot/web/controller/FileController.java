package com.hurricane.learn.springboot.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.hurricane.learn.springboot.web.entity.FilePiece;

@Controller
@RequestMapping("/upload")
public class FileController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

	@RequestMapping("")
	public String index() {
		return "uploadIndex";
	}
	
	/**
	 * 方法描述：直接使用commons-fileupload工具包，只是作为演示，在springmvc中建议使用下面的方法
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("file")
	@ResponseBody
	public String  springUpload(HttpServletRequest request) throws Exception{
		long  startTime=System.currentTimeMillis();
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
		multipartResolver.setMaxUploadSize(1024*1024*10);
		multipartResolver.setDefaultEncoding("UTF-8");
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
			Iterator iter=multiRequest.getFileNames();
			while(iter.hasNext()){
				MultipartFile file=multiRequest.getFile(iter.next().toString());
				if(file!=null){
					LOGGER.trace("正在解析的上传的文件名为{}",file.getOriginalFilename());
					String path="E:/piece/"+file.getOriginalFilename();
					file.transferTo(new File(path));
				}

			}

		}
		long  endTime=System.currentTimeMillis();
		LOGGER.trace("运行时间：{} ms",String.valueOf(endTime-startTime));
		return "success"; 
	}
	/**
	 * 方法描述：单个文件上传
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("singleFile")
	@ResponseBody
	public String  uploadSingleFile(@RequestParam(name="file",required=false) MultipartFile file) throws Exception{
		long  startTime=System.currentTimeMillis();
		LOGGER.trace("正在解析的上传的文件名为{}",file.getOriginalFilename());
		String path="E:/piece/"+file.getOriginalFilename();
		file.transferTo(new File(path));
		long  endTime=System.currentTimeMillis();
		LOGGER.trace("运行时间：{} ms",String.valueOf(endTime-startTime));
		return "success"; 
	}
	/**
	 * 方法描述：表单中上传多个文件
	 * @param files
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("multiFile")
	@ResponseBody
	public String  uploadMultiFile(@RequestParam(name="file",required=false) MultipartFile[] files) throws Exception{
		long  startTime=System.currentTimeMillis();
		for (MultipartFile file : files) {
			if(file!=null){
				LOGGER.trace("正在解析的上传的文件名为{}",file.getOriginalFilename());
				String path="E:/piece/"+file.getOriginalFilename();
				file.transferTo(new File(path));
			}
		}
		long  endTime=System.currentTimeMillis();
		LOGGER.trace("运行时间：{} ms",String.valueOf(endTime-startTime));
		return "success"; 
	}
	
	@RequestMapping("piece")
	@ResponseBody
	public String  pieceUpload(@RequestParam(name="file") MultipartFile file,@ModelAttribute FilePiece piece) throws Exception{
		long  startTime=System.currentTimeMillis();
		
		LOGGER.trace(piece.toString());
		LOGGER.trace("正在解析的上传的文件名为{}",file.getOriginalFilename());
		String path=FilePiece.LOCAL_SAVE_DIR+file.getOriginalFilename();
		if (piece.getChunks()>0) {
			path = path + ".part"+piece.getChunk();
		}
		File localFile = new File(path);
		if (localFile.exists() && localFile.isFile()) {
			LOGGER.trace("本地已存在{},跳过传输",path);
		}else {
			file.transferTo(localFile);
		}
		long  endTime=System.currentTimeMillis();
		LOGGER.trace("运行时间：{} ms",String.valueOf(endTime-startTime));
		
		if (piece.getChunks()>0) {
			LOGGER.trace("校验文件是否全部上传，若全部上传则进行合并");
			checkAnAssemble(piece);
		}
		return "success"; 
	}
	
	//上传过了，路径下有完整文件
	//上传了部分
	//没有上传过
	public void checkAnAssemble(FilePiece piece) {
		String path = FilePiece.LOCAL_SAVE_DIR;
		String fileName = piece.getName();
		int chunks = piece.getChunks();
		boolean isComplete = true;
		for (int i = 0; i < chunks; i++) {
			File file = new File(path+fileName+".part"+i);
			if (!(file.exists() && file.isFile())) {
				isComplete = false;
			}
		}
		//合并文件
		if (isComplete) {
			LOGGER.trace("文件分块上传完成，进行合并");
			byte[] buffer = new byte[1024];
			int length = -1;
			OutputStream outputStream = null;
			InputStream inputStream = null;
			boolean isNormalFinish = true;
			try {
				outputStream = new FileOutputStream(path+fileName);
				for (int i = 0; i < chunks; i++) {
					inputStream = new FileInputStream(path+fileName+".part"+i);
					while ((length = inputStream.read(buffer))!=-1) {
						outputStream.write(buffer, 0, length);
					}
					inputStream.close();
					inputStream = null;
				}
			} catch (Exception e) {
				isNormalFinish = false;
			}finally{
				//关闭资源
				if (inputStream!=null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					} finally{
						inputStream = null;
					}
				}
				if (outputStream!=null) {
					try {
						outputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					} finally{
						outputStream = null;
					}
				}
				//合并资源完成，则删除分块文件
				if (isNormalFinish) {
					for (int i = 0; i < chunks; i++) {
						File file = new File(path+fileName+".part"+i);
						if (file.exists() && file.isFile()) {
							file.delete();
							LOGGER.trace(path+fileName+".part"+i+"存在，进行删除");
						}
					}
				}
			}
		}
	}

}
