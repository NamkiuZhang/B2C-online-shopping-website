package com.group6.b2c.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  // TODO Auto-generated method stub
        //�ж��ύ�����ı?�Ƿ�Ϊ�ļ��ϴ��˵� 
        boolean isMultipart= ServletFileUpload.isMultipartContent(request);
        if(isMultipart){
            //����һ���ļ��ϴ��������
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            Iterator items;
            try{
                //�����?���ύ�������ļ�����
                items=upload.parseRequest(request).iterator();
                while(items.hasNext()){
                    FileItem item = (FileItem) items.next();
                    if(!item.isFormField()){
                        //ȡ���ϴ��ļ����ļ����
                        String name = item.getName();
                        //ȡ���ϴ��ļ��Ժ�Ĵ洢·��
                        String fileName=name.substring(name.lastIndexOf('\\')+1,name.length());
                        //�ϴ��ļ��Ժ�Ĵ洢·��
                         //String path= request.getRealPath("/productImg")+File.separatorChar+fileName;  
                        // String path="http://localhost:8080/b2c-1/imgs/products/"+fileName;
                         String path= "C:\\apache-tomcat-6.0.32\\webapps\\b2c-1\\imgs\\products\\"+fileName;
                        //�ϴ��ļ�
                        File uploaderFile = new File(path);
                        item.write(uploaderFile);
                        request.setAttribute("imgUrl", path);
                        //if(request.getParameter("add")!=null)
                        request.getRequestDispatcher("addProduct.jsp").forward(request, response);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

	}
}
