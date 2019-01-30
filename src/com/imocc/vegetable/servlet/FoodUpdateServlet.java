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

@WebServlet("/FoodUpdateServlet")
public class FoodUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AddFoodHelp help = new AddFoodHelp(request, response);
        List<FileItem> list = help.getFileItems();
        Food bean = help.getData(list);
        List<Food> foodList = (List<Food>) request.getServletContext().getAttribute("list");

        for (Food food : foodList) {
            if (food.getId().equals(bean.getId())) {

                if (bean.getFoodImage().equals("") || bean.getFoodImage() == null) {
                    bean.setFoodImage(food.getFoodImage());
                }
                foodList.remove(food);
                foodList.add(bean);
                break;
            }
        }

        request.getServletContext().setAttribute("list", foodList);
        request.getRequestDispatcher("showFoodList.jsp").forward(request, response);
    }
}
