package com.imocc.vegetable.servlet;

import com.imocc.vegetable.bean.Food;
import com.imocc.vegetable.uitls.Ulog;
import com.imocc.vegetable.uitls.UploadUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/FoodAddServlet")
public class FoodAddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Map<String, String> map = new HashMap<>();

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> list = upload.parseRequest(request);

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

            List<Food> foodList = (List<Food>) this.getServletContext().getAttribute("list");
            Food bean = new Food();

            bean.setDescription(map.get("username"));
            bean.setId(map.get("id"));
            bean.setFoodName(map.get("foodName"));
            bean.setTaste(map.get("taste"));
            bean.setFoodImage(url);
            bean.setFoodName(map.get("foodName"));

            foodList.add(bean);
            getServletContext().setAttribute("list", foodList);

            request.getRequestDispatcher("showFoodList.jsp").forward(request, response);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


    }

    /**
     * 处理文件上传
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
        if (fileName != null && !"".equals(fileName)) {
            // 通过工具类获得唯一文件名:
            String uuidFileName = UploadUtils.getUUIDFileName(fileName);
            // 获得文件上传的数据：
            InputStream is = fileItem.getInputStream();
            // 获得文件上传的路径:
            String path = this.getServletContext().getRealPath("/upload");

            createDir(path);//创建文件夹

            // 将输入流对接到输出流就可以了:
            url = path + "\\" + uuidFileName;
            OutputStream os = new FileOutputStream(url);
            int len = 0;
            byte[] b = new byte[1024];
            while ((len = is.read(b)) != -1) {
                os.write(b, 0, len);
            }
            is.close();
            os.close();
        }
        return url;
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
