package com.imocc.vegetable;

import com.imocc.vegetable.bean.Food;
import com.imocc.vegetable.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * http://localhost:8080/vegetable/
 */
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

        List<Food> list = new ArrayList<>();
        getServletContext().setAttribute("list",list);
        Ulog.i("菜品后台系统服务开始了");
        list.add(new Food("1","111","11","53413a31a4e14b42bcef7e8cb663e843.jpg","11","1111"));
        list.add(new Food("2","2222","222222","2003456288fa4c5dbee54e2eb2061799.bmp","22222","22"));

    }
}
