package Cosmetics;

public class Stock {
    String name;
    String description;
    String price;
    String imagePath;
    String quantity;

    public Stock(String name, String description, String price, String imagePath, String quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.quantity = quantity;
    }

    public Stock(String name) {
        this.name = name;
    }

    public Stock(String name, String description, String price, String imagePath) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getName();
    }
}
