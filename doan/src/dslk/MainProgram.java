package dslk;

import java.io.*;
import java.util.*;

class Shoe {
    private String id;
    private String name;
    private double price;

    public Shoe(String id, String name, double price) {
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

    @Override
    public String toString() {
        // Trang trí hiển thị thông tin giày
        return String.format("🌟 %s [Tên: %s, Giá: %.2f VND]", id, name, price);
    }
}

public class MainProgram {
    private List<Shoe> shoeList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // Mã màu ANSI
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BOLD = "\u001B[1m";

    // Hàm tạo danh sách giày
    public void createShoes() {
        System.out.println(ANSI_YELLOW + "🛠️ Nhập số lượng giày: " + ANSI_RESET);
        int numShoes = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        for (int i = 0; i < numShoes; i++) {
            System.out.println(ANSI_CYAN + "📝 Nhập thông tin giày " + (i + 1) + ANSI_RESET);
            System.out.print("🔖 Mã giày: ");
            String id = scanner.nextLine();
            System.out.print("👟 Tên giày: ");
            String name = scanner.nextLine();
            System.out.print("💲 Giá giày: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer
            shoeList.add(new Shoe(id, name, price));
        }
        System.out.println(ANSI_GREEN + "✅ Đã tạo danh sách giày thành công!" + ANSI_RESET);
    }

    // Hàm duyệt danh sách giày
    public void traverseShoes() {
        if (shoeList.isEmpty()) {
            System.out.println(ANSI_RED + "❌ Danh sách giày rỗng." + ANSI_RESET);
        } else {
            System.out.println(ANSI_BLUE + ANSI_BOLD + "📜 Danh sách giày:" + ANSI_RESET);
            for (Shoe shoe : shoeList) {
                System.out.println(ANSI_GREEN + shoe + ANSI_RESET);
            }
        }
    }

    // Hàm chèn giày mới
    public void insertShoe() {
        System.out.print("🔖 Nhập mã giày: ");
        String id = scanner.nextLine();
        System.out.print("👟 Nhập tên giày: ");
        String name = scanner.nextLine();
        System.out.print("💲 Nhập giá giày: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer
        shoeList.add(new Shoe(id, name, price));
        System.out.println(ANSI_GREEN + "✅ Đã thêm giày thành công." + ANSI_RESET);
    }

    // Hàm xóa giày theo mã
    public void deleteShoe() {
        System.out.print("🔖 Nhập mã giày cần xóa: ");
        String id = scanner.nextLine();
        boolean found = false;
        for (Iterator<Shoe> it = shoeList.iterator(); it.hasNext(); ) {
            Shoe shoe = it.next();
            if (shoe.getId().equals(id)) {
                it.remove();
                found = true;
                System.out.println(ANSI_GREEN + "✅ Đã xóa giày có mã " + id + ANSI_RESET);
                break;
            }
        }
        if (!found) {
            System.out.println(ANSI_RED + "❌ Không tìm thấy giày có mã " + id + ANSI_RESET);
        }
    }

    // Hàm sắp xếp giày theo giá (Bubble Sort)
    public void sortShoesByPrice() {
        for (int i = 0; i < shoeList.size() - 1; i++) {
            for (int j = 0; j < shoeList.size() - i - 1; j++) {
                if (shoeList.get(j).getPrice() > shoeList.get(j + 1).getPrice()) {
                    Collections.swap(shoeList, j, j + 1);
                }
            }
        }
        System.out.println(ANSI_GREEN + "✅ Danh sách giày đã được sắp xếp theo giá." + ANSI_RESET);
    }

    // Hàm tìm kiếm giày theo mã
    public void searchShoeById() {
        System.out.print("🔖 Nhập mã giày cần tìm: ");
        String id = scanner.nextLine();
        boolean found = false;
        for (Shoe shoe : shoeList) {
            if (shoe.getId().equals(id)) {
                System.out.println(ANSI_GREEN + "🔍 Đã tìm thấy: " + shoe + ANSI_RESET);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(ANSI_RED + "❌ Không tìm thấy giày có mã " + id + ANSI_RESET);
        }
    }

    // Đọc danh sách giày từ file
    public void readShoesFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            shoeList.clear();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Shoe shoe = new Shoe(data[0], data[1], Double.parseDouble(data[2]));
                shoeList.add(shoe);
            }
            System.out.println(ANSI_GREEN + "✅ Đọc danh sách giày từ file thành công." + ANSI_RESET);
        } catch (IOException e) {
            System.out.println(ANSI_RED + "❌ Lỗi đọc file: " + e.getMessage() + ANSI_RESET);
        }
    }

    // Ghi danh sách giày ra file
    public void writeShoesToFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Shoe shoe : shoeList) {
                bw.write(shoe.getId() + "," + shoe.getName() + "," + shoe.getPrice() + "\n");
            }
            System.out.println(ANSI_GREEN + "✅ Ghi danh sách giày ra file thành công." + ANSI_RESET);
        } catch (IOException e) {
            System.out.println(ANSI_RED + "❌ Lỗi ghi file: " + e.getMessage() + ANSI_RESET);
        }
    }
}
