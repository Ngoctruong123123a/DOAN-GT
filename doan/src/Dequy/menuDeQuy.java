package Dequy;

import Sapxep.Quicksort;
import java.util.Scanner;

public class menuDeQuy {

    Scanner sc = new Scanner(System.in);
    cacBaiDeQuy deQuy = new cacBaiDeQuy();
    baiKhuDeQuy khuDQ = new baiKhuDeQuy();
    Quicksort quicksort = new Quicksort();
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public void menuDQ() {
        int c1;
        do {
        	System.out.println(ANSI_GREEN + "\n╔═══════════════════ " + ANSI_YELLOW + "MENU ĐỆ QUY" + ANSI_GREEN + " ════════════════════╗" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + " 1. 🌀 Đệ quy giai thừa" + ANSI_GREEN + "                             ║");
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + " 2. 🌀 Đệ quy Fibonaci" + ANSI_GREEN + "                              ║");
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + " 3. 🌀 Đệ quy chuyển hệ 10 sang hệ 2" + ANSI_GREEN + "                ║");
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + " 4. 🌀 Đệ quy quay lui (N-Queen)" + ANSI_GREEN + "                    ║");
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + " 5. 🛠  Thuật toán sắp xếp nổi bọt" + ANSI_GREEN + "                  ║");
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + " 6. 🛠  Thuật toán sắp xếp chọn" + ANSI_GREEN + "                     ║");
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + " 7. 🛠  Thuật toán sắp xếp chèn" + ANSI_GREEN + "                     ║");
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + " 8. 🌀 Đệ quy tìm UCLN" + ANSI_GREEN + "                              ║");
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + " 9. 🌀 Đệ quy tính tổng" + ANSI_GREEN + "                             ║");
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + "10. 🛠  Thuật toán QuickSort" + ANSI_GREEN + "                        ║");
            System.out.println(ANSI_GREEN + "╚════════════════════════════════════════════════════╝" + ANSI_RESET);
            System.out.print(ANSI_CYAN + "🎯 Mời bạn chọn (Nhập 0 để thoát): " + ANSI_RESET);
            c1 = sc.nextInt();

            switch (c1) {
                case 1: {
                    System.out.print("Nhập số cần tính giai thừa: ");
                    int n = sc.nextInt();
                    System.out.println("Giai thừa của " + n + " là: " + deQuy.gthua(n));
                    break;
                }
                case 2: {
                    System.out.print("Nhập số Fibonaci cần tính: ");
                    int n = sc.nextInt();
                    System.out.println("Số hạng thứ " + n + " của Fibonaci là: " + deQuy.f(n));
                    break;
                }
                case 3: {
                    System.out.print("Nhập số hệ 10 cần chuyển: ");
                    int n = sc.nextInt();
                    System.out.print("Hệ nhị phân của " + n + " là: ");
                    deQuy.chuyenNP(n);
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.print("Nhập kích thước bàn cờ cho bài toán N-Queen: ");
                    int n = sc.nextInt();
                    XepHau.main(null);
                    break;
                }
                case 5: {
                    int[] arr = nhapMang();
                    deQuy.sapXepNoiBot(arr);
                    xuatMang(arr);
                    break;
                }
                case 6: {
                    int[] arr = nhapMang();
                    deQuy.sapXepChon(arr);
                    xuatMang(arr);
                    break;
                }
                case 7: {
                    int[] arr = nhapMang();
                    deQuy.sapXepChen(arr);
                    xuatMang(arr);
                    break;
                }
                case 8: {
                    System.out.print("Nhập hai số cần tìm UCLN: ");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    System.out.println("UCLN của " + a + " và " + b + " là: " + deQuy.us(a, b));
                    break;
                }
                case 9: {
                    System.out.print("Nhập số cần tính tổng: ");
                    int n = sc.nextInt();
                    System.out.println("Tổng các số từ 1 đến " + n + " là: " + deQuy.tong(n));
                    break;
                }
                case 10: {  // Thêm tùy chọn QuickSort
                    int[] arr = nhapMang();
                    quicksort.sort(arr, 0, arr.length - 1);
                    System.out.println("Mảng sau khi sắp xếp QuickSort:");
                    xuatMang(arr);
                    break;
                }
                case 0: {
                    System.out.println("Thoát chương trình...");
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
                }
            }
        } while (c1 != 0);
    }

    public void menuKhuDQ() {
        int c2;
        do {
            System.out.println(ANSI_GREEN + "\n╔═══════════════════ " + ANSI_YELLOW + "MENU KHỬ ĐỆ QUY" + ANSI_GREEN + " ════════════════════╗" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + " 1. 🌀 Khử đệ quy Giai thừa" + ANSI_GREEN + "                             ║");
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + " 2. 🌀 Khử đệ quy dãy Fibonaci" + ANSI_GREEN + "                          ║");
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + " 3. 🛠  Tính giai thừa không dùng đệ quy (vòng lặp)" + ANSI_GREEN + "     ║");
            System.out.println(ANSI_GREEN + "║" + ANSI_PURPLE + " 4. 🛠  Tính lũy thừa không dùng đệ quy" + ANSI_GREEN + "                 ║");
            System.out.println(ANSI_GREEN + "╚════════════════════════════════════════════════════════╝" + ANSI_RESET);
            System.out.print(ANSI_CYAN + "🎯 Mời bạn chọn (Nhập 0 để thoát): " + ANSI_RESET);
            c2 = sc.nextInt();

            switch (c2) {
                case 1: {
                    System.out.print("Nhập số cần tính giai thừa: ");
                    int n = sc.nextInt();
                    System.out.println("Giai thừa của " + n + " là: " + khuDQ.gthua(n));
                    break;
                }
                case 2: {
                    System.out.print("Nhập số Fibonaci cần tính: ");
                    int n = sc.nextInt();
                    System.out.println("Số hạng thứ " + n + " của Fibonaci là: " + khuDQ.Fibo(n));
                    break;
                }
                case 3: {
                    System.out.print("Nhập số cần tính giai thừa (không đệ quy): ");
                    int n = sc.nextInt();
                    System.out.println("Giai thừa của " + n + " là: " + khuDQ.factorial(n));
                    break;
                }
                case 4: {
                    System.out.print("Nhập cơ số x: ");
                    int x = sc.nextInt();
                    System.out.print("Nhập số mũ n: ");
                    int n = sc.nextInt();
                    System.out.println(x + " ^ " + n + " = " + khuDQ.power(x, n));
                    break;
                }
                case 0: {
                    System.out.println("Thoát chương trình...");
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
                }
            }
        } while (c2 != 0);
    }

    private int[] nhapMang() {
        System.out.print("Nhập số lượng phần tử: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    private void xuatMang(int[] arr) {
        System.out.print("Mảng sau khi sắp xếp: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
