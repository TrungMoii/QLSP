import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    private static final String FILE_NAME = "sanpham.txt";
    private ArrayList<Product> products = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public ProductManager() {
        loadProductsFromFile();
    }

    // Quản lý sản phẩm: thêm, xóa, sửa
    public void manageProducts() {
        int choice;
        do {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("0. Quay lại");
            choice = scanner.nextInt();
            scanner.nextLine(); // Bỏ qua dòng trống
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    private void addProduct() {
        System.out.print("Nhập ID sản phẩm: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        products.add(new Product(id, name, price));
        saveProductsToFile();
        System.out.println("Sản phẩm đã được thêm.");
    }

    private void deleteProduct() {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        String id = scanner.nextLine();
        products.removeIf(product -> product.getId().equals(id));
        saveProductsToFile();
        System.out.println("Sản phẩm đã được xóa.");
    }

    private void updateProduct() {
        System.out.print("Nhập ID sản phẩm cần sửa: ");
        String id = scanner.nextLine();
        for (Product product : products) {
            if (product.getId().equals(id)) {
                System.out.print("Nhập tên mới: ");
                String newName = scanner.nextLine();
                System.out.print("Nhập giá mới: ");
                double newPrice = scanner.nextDouble();
                product.setName(newName);
                product.setPrice(newPrice);
                saveProductsToFile();
                System.out.println("Sản phẩm đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm.");
    }
// Tìm kiếm sản phẩm: theo tên, theo ID
    public void searchProducts() {
        int choice;
        do {
            System.out.println("1. Tìm kiếm theo tên");
            System.out.println("2. Tìm kiếm theo ID");
            System.out.println("0. Quay lại");
            choice = scanner.nextInt();
            scanner.nextLine(); // Bỏ qua dòng trống
            switch (choice) {
                case 1:
                    searchByName();
                    break;
                case 2:
                    searchById();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    private void searchByName() {
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println(product);
            }
        }
    }

    private void searchById() {
        System.out.print("Nhập ID sản phẩm: ");
        String id = scanner.nextLine();
        for (Product product : products) {
            if (product.getId().equals(id)) {
                System.out.println(product);
            }
        }
    }
// Hiển thị sản phẩm
    public void displayProducts() {
        System.out.println("Danh sách sản phẩm:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Lưu sản phẩm vào tệp
    private void saveProductsToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Product product : products) {
                writer.write(product.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu dữ liệu sản phẩm: " + e.getMessage());
        }
    }

    // Tải sản phẩm từ tệp
    private void loadProductsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                products.add(Product.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc dữ liệu sản phẩm từ tệp.");
        }
    }

    // Menu chính
    public void showMenu() {
        int choice;
        do {
            System.out.println("=== MENU CHÍNH ===");
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Tìm kiếm sản phẩm");
            System.out.println("3. Hiển thị sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Bỏ qua dòng trống
            switch (choice) {
                case 1:
                    manageProducts();
                    break;
                case 2:
                    searchProducts();
                    break;
                case 3:
                    displayProducts();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }
}
