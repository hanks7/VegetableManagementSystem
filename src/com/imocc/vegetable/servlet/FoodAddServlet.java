package com.imocc.vegetable.servlet;

import com.imocc.vegetable.bean.Food;
import com.imocc.vegetable.uitls.AddFoodHelp;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/FoodAddServlet")
public class FoodAddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AddFoodHelp help = new AddFoodHelp(request, response);
        Food bean = help.getData(help.getFileItems());
        List<Food> foodList = (List<Food>) request.getServletContext().getAttribute("list");
        foodList.add(bean);
        request.getServletContext().setAttribute("list", foodList);
        request.getRequestDispatcher("showFoodList.jsp").forward(request, response);

    }


}
