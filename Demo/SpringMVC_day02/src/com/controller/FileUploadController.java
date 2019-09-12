package com.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {
	
	//传统文件上传(使用fileupload组件完成文件上传,common-fileupload.jar和common-io.jar)
    @RequestMapping("/fileupload1")
    public String fileuoload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传...");
        String path = request.getSession().getServletContext().getRealPath("/uploads/");//上传的位置
        File file = new File(path);//判断，该路径是否存在
        if(!file.exists()){
            file.mkdirs();//如果不存在，则创建该文件夹
        }
        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        for(FileItem item:items){//遍历   
            if(item.isFormField()){// 进行判断，当前item对象是否是上传文件项
                //说明普通表单向
            }else{
                //说明上传文件项
                String filename = item.getName().substring(item.getName().lastIndexOf("\\") + 1);//获取上传文件的名称
                String uuid = UUID.randomUUID().toString().replace("-", "");//把文件的名称设置唯一值，uuid
                filename = uuid+"_"+filename;
                item.write(new File(path,filename));//完成文件上传
                item.delete();//删除临时文件
            }
        }
        return "success";
    }

    //SpringMVC文件上传
    @RequestMapping("/fileupload2")
    public String fileuoload2(HttpServletRequest request, MultipartFile upload) throws Exception {//MultipartFile upload的upload必须与表单file类型的input的name一致
        System.out.println("SpringMVC文件上传...");
        //使用fileupload组件完成文件上传
        String path = request.getSession().getServletContext().getRealPath("/uploads/");//上传的位置
        File file = new File(path);
        if(!file.exists()){//判断，该路径是否存在
            file.mkdirs();//若不存在，则创建该文件夹
        }
        String filename = upload.getOriginalFilename();//获取上传文件的名称
        String uuid = UUID.randomUUID().toString().replace("-", "");//把文件的名称设置唯一值，uuid
        filename = uuid+"_"+filename;
        upload.transferTo(new File(path,filename));//完成文件上传

        return "success";
    }

    //SpringMVC跨服务器文件上传
    @RequestMapping("/fileupload3")
    public String fileuoload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传...");
        //定义上传文件服务器路径(这是新开启的本地服务器，模拟跨服务器的模式)
        String path = "http://localhost:9090/uploads/";//新tomcat服务器参数：HTTP prot:9090, JMX port:1090
        String filename = upload.getOriginalFilename();//获取上传文件的名称
        String uuid = UUID.randomUUID().toString().replace("-", "");//把文件的名称设置唯一值，uuid
        filename = uuid+"_"+filename;
        
        Client client = Client.create();//创建客户端的对象
        WebResource webResource = client.resource(path + filename);//和图片服务器进行连接
        webResource.put(upload.getBytes());//上传文件;目前没有uploads文件，代码里也没自动创建，因此需手动创建，否则409错误

        return "success";
    }
}
