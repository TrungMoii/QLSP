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
