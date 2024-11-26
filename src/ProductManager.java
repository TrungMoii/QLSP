import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class ProductManager {
    private ArrayList<Product> products = new ArrayList();
    private Scanner scanner;

    ProductManager() {
        this.scanner = new Scanner(System.in);
    }

    public void manageProducts() {
        while(true) {
            System.out.println("\n--- Quản lý sản phẩm ---");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");
            int choice = this.scanner.nextInt();
            this.scanner.nextLine();
            switch (choice) {
                case 1:
                    this.addProduct();
                    break;
                case 2:
                    this.displayProducts();
                    break;
                case 3:
                    this.updateProduct();
                    break;
                case 4:
                    this.deleteProduct();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void addProduct() {
        System.out.print("Nhập ID sản phẩm: ");
        int id = this.scanner.nextInt();
        this.scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = this.scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = this.scanner.nextDouble();
        this.products.add(new Product(id, name, price));
        System.out.println("Thêm sản phẩm thành công!");
    }

    private void displayProducts() {
        if (this.products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            System.out.println("\nDanh sách sản phẩm:");
            Iterator var1 = this.products.iterator();

            while(var1.hasNext()) {
                Product product = (Product)var1.next();
                System.out.println(product);
            }

        }
    }

    private void updateProduct() {
        System.out.print("Nhập ID sản phẩm cần sửa: ");
        int id = this.scanner.nextInt();
        this.scanner.nextLine();
        Iterator var2 = this.products.iterator();

        Product product;
        do {
            if (!var2.hasNext()) {
                System.out.println("Không tìm thấy sản phẩm với ID này.");
                return;
            }

            product = (Product)var2.next();
        } while(product.getId() != id);

        System.out.print("Nhập tên mới: ");
        product.setName(this.scanner.nextLine());
        System.out.print("Nhập giá mới: ");
        product.setPrice(this.scanner.nextDouble());
        System.out.println("Cập nhật thành công!");
    }

    private void deleteProduct() {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        int id = this.scanner.nextInt();
        if (this.products.removeIf((product) -> {
            return product.getId() == id;
        })) {
            System.out.println("Xóa sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy sản phẩm với ID này.");
        }

    }
}
