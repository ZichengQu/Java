package com.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/*
 * 文件上传处理类
 */
public class UploadAction extends ActionSupport{
	//file属性名和表单文件上传项的name相同
	private File file;
	//上传文件的名称，属性名=文件上传项的name+FileName
	private String fileFileName;
	//文件类型，属性名=文件上传项的name+ContentType
	private String fileContentType;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	//上传文件的业务方法
	public String upload(){
		if(file!=null){
			System.out.println("file="+file);
			System.out.println("fileFileName="+fileFileName);
			System.out.println("fileContentType="+fileContentType);
			//获取上传文件目录
			String path=ServletActionContext.getRequest().getRealPath("/upload");
			System.out.println("上传文件目录="+path);
			try {
				FileUtils.copyFile(file, new File(path,fileFileName));
				return SUCCESS;
			} catch (IOException e) {
				e.printStackTrace();
				return INPUT;
			}
		}
		return INPUT;
		
	}	
}
