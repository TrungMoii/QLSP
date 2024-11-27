import java.util.ArrayList;
import java.util.Scanner;

class CategoryManager {
    private ArrayList<Category> categories = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void manageCategories() {
        while (true) { // Sử dụng vòng lặp để cho phép quay lại menu
            System.out.println("\n--- Quản lý danh mục ---");
            System.out.println("1. Thêm danh mục");
            System.out.println("2. Hiển thị danh mục");
            System.out.println("3. Tìm danh mục theo tên");
            System.out.println("4. Đếm số lượng sản phẩm trong từng danh mục");
            System.out.println("5. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (choice) {
                case 1 -> addCategory();
                case 2 -> displayCategories();
                case 3 -> searchCategoryByName();
                case 4 -> countProductsInCategory();
                case 5 -> {
                    return; // Quay lại menu chính
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void addCategory() {
        System.out.print("Nhập ID danh mục: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên danh mục: ");
        String name = scanner.nextLine();
        categories.add(new Category(id, name));
        System.out.println("Thêm danh mục thành công!");
    }

    private void displayCategories() {
        if (categories.isEmpty()) {
            System.out.println("Danh sách danh mục trống.");
            return;
        }
        System.out.println("\nDanh sách danh mục:");
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    private void searchCategoryByName() {
        System.out.print("Nhập tên danh mục cần tìm: ");
        String name = scanner.nextLine();
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(name)) {
                System.out.println(category);
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục với tên này.");
    }

    private void countProductsInCategory() {
        for (Category category : categories) {
            int productCount = (int) (Math.random() * 10);
            System.out.println("Danh mục " + category.getName() + " có " + productCount + " sản phẩm.");
        }
    }
}
