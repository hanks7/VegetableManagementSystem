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

    }
}
