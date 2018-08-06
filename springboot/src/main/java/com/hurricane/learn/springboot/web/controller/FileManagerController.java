package com.hurricane.learn.springboot.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hurricane.learn.springboot.web.entity.FileTransfer;

@RestController
@RequestMapping("/file")
public class FileManagerController {
	

	@GetMapping("index")
	public String index(@RequestParam Map map,HttpServletRequest request) {
		String msg = request.getRequestURL().toString();
		return msg + "---this is test";
	}
	
	@GetMapping("getFile")
	public Object getFile(@RequestParam Map map) {
		
		Object object = map.get("path");
		if (StringUtils.isEmpty(object)) {
			return "请求路径参数需存在";
		}
		List<FileTransfer> fileTransfers = new ArrayList<FileTransfer>();
		File file = new File(object.toString());
		if (file.exists()) {
			if (file.isDirectory()) {
				File[] listFiles = file.listFiles();
				for (File file2 : listFiles) {
					FileTransfer fileTransfer = new FileTransfer();
					fileTransfer.setName(file2.getName());
					fileTransfer.setFullPath(file2.getAbsolutePath());
					fileTransfer.setDictionary(file2.isDirectory());
//					fileTransfer.setSize();	//这个值需要读取成流的程度才能够获取到，开销太大，先放弃检验文件完整性
					fileTransfers.add(fileTransfer);
				}
			}else {
				FileTransfer fileTransfer = new FileTransfer();
				fileTransfer.setName(file.getName());
				fileTransfer.setFullPath(file.getAbsolutePath());
				fileTransfer.setDictionary(file.isDirectory());
//					fileTransfer.setSize();	//这个值需要读取成流的程度才能够获取到，开销太大，先放弃检验文件完整性
				fileTransfers.add(fileTransfer);
				
			}
		}
		return fileTransfers;
	}

	

}
