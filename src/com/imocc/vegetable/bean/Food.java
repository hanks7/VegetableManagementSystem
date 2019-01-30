package com.imocc.vegetable.bean;

public class Food {
    String id;
    String foodName;
    String taste;
    String foodImage;
    String price;
    String description;

    public Food() {
    }

    public Food(String id, String foodName, String taste, String foodImage, String price, String description) {
        this.id = id;
        this.foodName = foodName;
        this.taste = taste;
        this.foodImage = foodImage;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Food{");
        sb.append("id='").append(id).append('\'');
        sb.append(", foodName='").append(foodName).append('\'');
        sb.append(", taste='").append(taste).append('\'');
        sb.append(", foodImage='").append(foodImage).append('\'');
        sb.append(", price='").append(price).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
