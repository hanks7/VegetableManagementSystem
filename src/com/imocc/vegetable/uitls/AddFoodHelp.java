package com.imocc.vegetable.uitls;

import com.imocc.vegetable.bean.Food;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddFoodHelp {
    HttpServletRequest request;
    HttpServletResponse response;

    public AddFoodHelp(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public Food getData( List<FileItem> list) throws IOException, ServletException {
        Map<String, String> map = new HashMap<>();


        String url = null;
        for (FileItem fileItem : list) {

            if (fileItem.isFormField()) {
                String name = fileItem.getFieldName();
                String value = fileItem.getString("UTF-8");
                map.put(name, value);
            } else {
                url = fileUpload(url, fileItem);
            }
        }


        Food bean = new Food();

        bean.setId(map.get("id"));
        bean.setFoodName(map.get("foodName"));
        bean.setTaste(map.get("taste"));
        bean.setFoodImage(url);
        bean.setPrice(map.get("price"));
        bean.setDescription(map.get("description"));


        return bean;

    }

    public List<FileItem> getFileItems() {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            return upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 处理文件上传
     *
     * @param url
     * @param fileItem
     * @return
     * @throws IOException
     */
    private String fileUpload(String url, FileItem fileItem) throws IOException {
        //是文件上传项
        // 文件上传功能：
        // 获得文件上传的名称：
        String fileName = fileItem.getName();
        String uuidFileName = "";
        if (fileName != null && !"".equals(fileName)) {
            // 通过工具类获得唯一文件名:
            uuidFileName = UploadUtils.getUUIDFileName(fileName);
            // 获得文件上传的数据：
            InputStream is = fileItem.getInputStream();
            // 获得文件上传的路径:
            String path = request.getServletContext().getRealPath("/upload");

            createDir(path);//创建文件夹

            // 将输入流对接到输出流就可以了:
            url = path + "\\" + uuidFileName;
            Ulog.i("url", url);
            OutputStream os = new FileOutputStream(url);
            int len;
            byte[] b = new byte[1024];
            while ((len = is.read(b)) != -1) {
                os.write(b, 0, len);
            }
            is.close();
            os.close();
        } else {
            uuidFileName = fileName;
            Ulog.i("fileName", fileName);
        }

        return uuidFileName;
    }

    /**
     * 创建文件夹
     *
     * @param path
     */
    private void createDir(String path) {

        Ulog.i("path", path);

        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
}
