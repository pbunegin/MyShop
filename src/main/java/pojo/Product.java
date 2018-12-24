package pojo;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private String productName;
    private int id;
    private double price;
    private Map<String, String> characteristic = new HashMap<>();
    private String imgUrl;

//    public Product(String productName, int id, double price, Map<String, String> characteristic) {
//        this.productName = productName;
//        this.id = id;
//        this.price = price;
//        this.characteristic = characteristic;
//        this.imgUrl = "img/" + id + ".jpg";
//    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<String, String> getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String name, String value) {
        this.characteristic.put(name, value);
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl() {
        this.imgUrl = "/src/main/webapp/prodImg/" + id + ".jpg";
    }
}
