package com.example1.demo1.models;

public class Product {

    private int ProductId;
    private String Name;
    private int Price;
    private String Description;
    private int CategoryId;
    private int SupplierId;

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        this.ProductId = productId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int supplierId) {
        SupplierId = supplierId;
    }

    public Product() {
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

}