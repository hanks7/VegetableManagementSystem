package com.imocc.vegetable.servlet;

import com.imocc.vegetable.bean.Food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FoodDeleteServlet")
public class FoodDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<Food> list = (List<Food>) getServletContext().getAttribute("list");
        for (Food food : list) {
            if (food.getId().equals(id)) {
                list.remove(food);
                break;
            }
        }
        request.getRequestDispatcher("showFoodList.jsp").forward(request, response);
    }

}
