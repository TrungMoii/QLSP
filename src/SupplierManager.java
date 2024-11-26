    import java.util.ArrayList;
    import java.util.Scanner;

    class SupplierManager {
        private ArrayList<Supplier> suppliers = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        public void manageSuppliers() {
            while (true) { // Sử dụng vòng lặp để cho phép quay lại menu
                System.out.println("\n--- Quản lý nhà cung cấp ---");
                System.out.println("1. Thêm nhà cung cấp");
                System.out.println("2. Hiển thị nhà cung cấp");
                System.out.println("3. Tìm kiếm nhà cung cấp theo địa chỉ");
                System.out.println("4. Hiển thị sản phẩm của nhà cung cấp");
                System.out.println("5. Quay lại menu chính");
                System.out.print("Chọn chức năng: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng trống

                switch (choice) {
                    case 1 -> addSupplier();
                    case 2 -> displaySuppliers();
                    case 3 -> searchSupplierByAddress();
                    case 4 -> displaySupplierProducts();
                    case 5 -> {
                        return; // Quay lại menu chính
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        }

        private void addSupplier() {
            System.out.print("Nhập ID nhà cung cấp: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nhập tên nhà cung cấp: ");
            String name = scanner.nextLine();
            System.out.print("Nhập địa chỉ nhà cung cấp: ");
            String address = scanner.nextLine();
            suppliers.add(new Supplier(id, name, address));
            System.out.println("Thêm nhà cung cấp thành công!");
        }

        private void displaySuppliers() {
            if (suppliers.isEmpty()) {
                System.out.println("Danh sách nhà cung cấp trống.");
                return;
            }
            System.out.println("\nDanh sách nhà cung cấp:");
            for (Supplier supplier : suppliers) {
                System.out.println(supplier);
            }
        }

        private void searchSupplierByAddress() {
            System.out.print("Nhập địa chỉ cần tìm nhà cung cấp: ");
            String address = scanner.nextLine();
            boolean found = false; // Biến để kiểm tra xem có tìm thấy nhà cung cấp hay không
            for (Supplier supplier : suppliers) {
                if (supplier.getAddress().contains(address)) {
                    System.out.println(supplier);
                    found = true; // Đánh dấu đã tìm thấy
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy nhà cung cấp với địa chỉ này.");
            }
        }

        private void displaySupplierProducts() {
            System.out.print("Nhập ID nhà cung cấp để hiển thị sản phẩm: ");
            int id = scanner.nextInt();
            boolean found = false; // Biến để kiểm tra xem có tìm thấy nhà cung cấp hay không
            for (Supplier supplier : suppliers) {
                if (supplier.getId() == id) {
                    found = true;
                    int productCount = (int) (Math.random() * 5) + 1;
                    System.out.println("Nhà cung cấp " + supplier.getName() + " có các sản phẩm sau:");
                    for (int i = 1; i <= productCount; i++) {
                        System.out.println("Sản phẩm " + i + ": ProductName" + i);
                    }
                    break; // Thoát vòng lặp sau khi tìm thấy
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy nhà cung cấp với ID này.");
            }
        }
    }
