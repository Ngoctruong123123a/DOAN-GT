package Dequy;

public class baiKhuDeQuy {
    public int gthua(int n) {
        int i, gt = 1;
        if (n == 0) return 1;
        else {
            for (i = 1; i <= n; i++) gt = gt * i;
            return gt;
        }
    }

    public int Fibo(int n) {
        if (n == 1 || n == 2) return 1;
        int f1 = 1, f2 = 1, f = f1 + f2;
        for (int i = 3; i <= n; i++) {
            f1 = f2;
            f2 = f;
            f = f1 + f2;
        }
        return f;
    }

    // Bài tính giai thừa không dùng đệ quy (vòng lặp)
    public int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) 
            result *= i;
		return result;
        }
     
  

    // Bài tính lũy thừa không dùng đệ quy
    public int power(int x, int n) {
        int result = 1;
        while (n > 0) {
            if (n % 2 == 1) { // Nếu n lẻ
                result *= x;
            }
            x *= x; // Bình phương x
            n /= 2; // Chia đôi n
        }
        return result;
    }
}
