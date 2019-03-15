package com.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/*
 * �ļ��ϴ�������
 */
public class UploadAction extends ActionSupport{
	//file�������ͱ��ļ��ϴ����name��ͬ
	private File file;
	//�ϴ��ļ������ƣ�������=�ļ��ϴ����name+FileName
	private String fileFileName;
	//�ļ����ͣ�������=�ļ��ϴ����name+ContentType
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
	//�ϴ��ļ���ҵ�񷽷�
	public String upload(){
		if(file!=null){
			System.out.println("file="+file);
			System.out.println("fileFileName="+fileFileName);
			System.out.println("fileContentType="+fileContentType);
			//��ȡ�ϴ��ļ�Ŀ¼
			String path=ServletActionContext.getRequest().getRealPath("/upload");
			System.out.println("�ϴ��ļ�Ŀ¼="+path);
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
