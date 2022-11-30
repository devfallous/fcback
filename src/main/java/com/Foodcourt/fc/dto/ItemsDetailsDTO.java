package com.Foodcourt.fc.dto;

public class ItemsDetailsDTO {

    private String dishName;

    private String imageUrl;

    private String category;

    private int price;

    private String availability;

    public ItemsDetailsDTO(){

    }

    public ItemsDetailsDTO(String dishName, String imageUrl, String category, int price, String availability) {
        this.dishName = dishName;
        this.imageUrl = imageUrl;
        this.category = category;
        this.price = price;
        this.availability = availability;
    }


    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "ItemsDetailsDTO{" +
                "dishName='" + dishName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", availability='" + availability + '\'' +
                '}';
    }
}
