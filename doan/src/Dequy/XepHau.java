package Dequy;

public class XepHau {
    // Biến đếm số cách xếp hậu
    private int count = 0;

    // Hàm xếp hậu
    private void xepHau(int[] x, int row, int n) {
        if (row == n) {
            inKetQua(x, n);
            count++; // Mỗi khi tìm được 1 cách xếp, tăng biến đếm
        } else {
            for (int col = 0; col < n; col++) {
                if (anToan(x, row, col)) {
                    x[row] = col;
                    xepHau(x, row + 1, n);
                }
            }
        }
    }

    // Hàm in kết quả (cách xếp hậu hợp lệ)
    private void inKetQua(int[] x, int n) {
        System.out.println("Cách xếp hậu hợp lệ:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i] == j) {
                    System.out.print("H ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Hàm kiểm tra liệu vị trí đặt hậu có an toàn hay không
    private boolean anToan(int[] x, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (x[i] == col || Math.abs(x[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    // Hàm chính để khởi động bài toán và hiển thị số lượng cách xếp
    public void giaiBaiToanHau(int n) {
        int[] x = new int[n]; // Mảng lưu vị trí của các hậu trên bàn cờ
        xepHau(x, 0, n); // Bắt đầu từ dòng 0
        System.out.println("Tổng số cách xếp hậu hợp lệ: " + count);
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        XepHau xh = new XepHau();
        int n = 8; // Số lượng hậu (ví dụ: bài toán 8 hậu)
        xh.giaiBaiToanHau(n);
    }
}

