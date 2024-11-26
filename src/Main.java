import java.util.Scanner;

public class Main {
    private static ProductManager productManager = new ProductManager();
    private static CategoryManager categoryManager = new CategoryManager();
    private static SupplierManager supplierManager = new SupplierManager();
    private static Scanner scanner;

    public Main() {
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý danh mục sản phẩm");
            System.out.println("3. Quản lý nhà cung cấp");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    productManager.manageProducts();
                    break;
                case 2:
                    categoryManager.manageCategories();
                    break;
                case 3:
                    supplierManager.manageSuppliers();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    private static int getUserChoice() {
        int choice = true;

        while(true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                return choice;
            } catch (NumberFormatException var2) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
            }
        }
    }

    static {
        scanner = new Scanner(System.in);
    }
}
