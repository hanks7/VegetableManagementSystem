<%@ page import="com.imocc.vegetable.uitls.Ulog" %>
<%@ page import="com.imocc.vegetable.bean.Food" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <%
        String basePath = request.getScheme() + ":" + "//" + request.getServerName() + ":" + request.getServerPort() + "/"
                + request.getServletContext().getContextPath();
        Ulog.i("basepath", basePath);
    %>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>菜品信息展示</title>
    <style type="text/css">
        img {
            width: 80px;
            height: 80px;
        }
    </style>

    <%
        List<Food> foodList = new ArrayList<>();
        Ulog.i("request.getParameter(\"foodName\") ",request.getParameter("foodName") );
        if (request.getParameter("foodName") != null) {
            for (Food food : (List<Food>) application.getAttribute("list")) {
                if (food.getFoodName().equals(request.getParameter("foodName"))) {
                    foodList.add(food);
                    break;
                }

            }
        } else {
            foodList = (List<Food>) application.getAttribute("list");
        }
    %>
</head>
<body>
<center>
    <h1>菜品查询</h1>
    <table border="1px" cellspacing="0px" cellpadding="0px" width="800px">
        <thead>
        <tr>
            <th>菜品ID</th>
            <th>菜名</th>
            <th>口味</th>
            <th>菜品图片</th>
            <th>价格</th>
            <th>菜品描述</th>
        </tr>
        </thead>
        <tbody>


        <%
            for (Food food : foodList) {
        %>
        <tr>
            <td align="center"><%=food.getId()%>
            </td>
            <td align="center"><%=food.getFoodName()%>
            </td>
            <td align="center"><%=food.getTaste()%>
            </td>
            <td align="center"><img src="<%= getFoodImage(basePath,food) %>"/></td>
            <td align="center"><%=food.getPrice()%>
            </td>
            <td align="center"><%=food.getDescription()%>
            </td>
        </tr>
        <%
            }
        %>


        </tbody>
    </table>
</center>
</body>
</html>
<%!
    private String getFoodImage(String basePath, Food food) {
        if (food == null) {
            return "";
        }
        String getFoodImage = basePath + "/upload/" + food.getFoodImage();
        return getFoodImage;
    }
%>