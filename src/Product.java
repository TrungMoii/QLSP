public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return id + "," + name + "," + price;
    }

    // Chuyển từ chuỗi thành đối tượng Product
    public static Product fromString(String productString) {
        String[] parts = productString.split(",");
        String id = parts[0];
        String name = parts[1];
        double price = Double.parseDouble(parts[2]);
        return new Product(id, name, price);
    }
}
