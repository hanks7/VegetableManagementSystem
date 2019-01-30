<%@ page import="com.imocc.vegetable.uitls.Ulog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.imocc.vegetable.bean.Food" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%
        String basePath = request.getScheme() + ":" + "//" + request.getServerName() + ":" + request.getServerPort() + "/"
                + request.getServletContext().getContextPath();
        String id = request.getParameter("id");
        Food food = null;
        if (id != null) {
            for (Food f : (List<Food>) application.getAttribute("list")) {
                if (f.getId().equals(request.getParameter("id"))) {
                    food = f;
                    break;
                }

            }
        }
        if (food == null) {
            food = new Food();
        }

    %>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>菜品修改(根据菜品ID进行修改)</title>
    <style type="text/css">

    </style>
</head>
<body>
<center>
    <h1>根据菜品ID修改</h1>
    <form action="<%=getS(basePath)%>" method="post" enctype="multipart/form-data">
        <table border="1px" width="400px" cellspacing="0px" cellpadding="0px">
            <tr>
                <td>修改ID</td>
                <td><input type="text" name="id" value="<%=food.getId()%>"></td>
            </tr>
            <tr>
                <td>菜&nbsp;&nbsp;名</td>
                <td><input type="text" name="foodName" value="<%=food.getFoodName()%>"></td>
            </tr>
            <tr>
                <td>口&nbsp;&nbsp;味</td>
                <td>
                    <input type="radio" name="taste" <%= !food.getTaste().equals("香辣")?"":"checked"%> value="香辣">香辣
                    <input type="radio" name="taste"  <%= !food.getTaste().equals("微辣")?"":"checked"%> value="微辣">微辣
                    <input type="radio" name="taste"  <%= !food.getTaste().equals("麻辣")?"":"checked"%> value="麻辣">麻辣
                    <input type="radio" name="taste"  <%= !food.getTaste().equals("不辣")?"":"checked"%> value="不辣">不辣
                </td>
            </tr>
            <tr>
                <td>菜品图片</td>
                <td><input type="file" name="foodImage" ><%=food.getFoodImage()%>
                </td>
            </tr>
            <tr>
                <td>价&nbsp;&nbsp;格</td>
                <td><input type="text" name="price" value="<%=food.getPrice()%>"></td>
            </tr>
            <tr>
                <td>菜品描述</td>
                <td>
                    <textarea name="description"><%=food.getDescription()%></textarea>
                </td>
            </tr>
            <tr style="text-align:center;width:20px">
                <td colspan="2">
                    <input type="submit" value="修改">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
<%!
    private String getS(String basePath) {
        return basePath + "/FoodUpdateServlet";
    }
%>