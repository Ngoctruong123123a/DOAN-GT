	package Dequy;
	
	public class cacBaiDeQuy {
	    public void chuyenNP(int n) {
	        if (n != 0) {
	            chuyenNP(n / 2);
	            System.out.print(n % 2);
	        }
	    }
	
	    public int f(int n) {
	        if (n == 1 || n == 2) return 1;
	        else return f(n - 1) + f(n - 2);
	    }
	
	    public int gthua(int n) {
	        if (n == 0) return 1;
	        else return n * gthua(n - 1);
	    }
	
	    public int us(int a, int b) {
	        if (a == b) return a;
	        else if (a > b) return us(a - b, b);
	        else return us(a, b - a);
	    }
	
	    public int tong(int n) {
	        if (n == 1) return 1;
	        else return n + tong(n - 1);
	    }
	
	    public void quayLui(int n) {
	        int[] x = new int[n];
	        xepHau(x, 0, n);
	    }
	
	    private boolean anToan(int[] x, int row, int col) {
	        for (int i = 0; i < row; i++) {
	            if (x[i] == col || Math.abs(x[i] - col) == Math.abs(i - row)) {
	                return false;
	            }
	        }
	        return true;
	    }
	
	    private void xepHau(int[] x, int row, int n) {
	        if (row == n) {
	            inKetQua(x, n);
	        } else {
	            for (int col = 0; col < n; col++) {
	                if (anToan(x, row, col)) {
	                    x[row] = col;
	                    xepHau(x, row + 1, n);
	                }
	            }
	        }
	    }
	
	    private void inKetQua(int[] x, int n) {
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (x[i] == j) {
	                    System.out.print("Q ");
	                } else {
	                    System.out.print(". ");
	                }
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }
	
	    public void sapXepNoiBot(int[] arr) {
	        int n = arr.length;
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                if (arr[j] > arr[j + 1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                }
	            }
	        }
	    }
	
	    public void sapXepChon(int[] arr) {
	        int n = arr.length;
	        for (int i = 0; i < n - 1; i++) {
	            int minIdx = i;
	            for (int j = i + 1; j < n; j++) {
	                if (arr[j] < arr[minIdx]) {
	                    minIdx = j;
	                }
	            }
	            int temp = arr[minIdx];
	            arr[minIdx] = arr[i];
	            arr[i] = temp;
	        }
	    }
	
	    public void sapXepChen(int[] arr) {
	        int n = arr.length;
	        for (int i = 1; i < n; i++) {
	            int key = arr[i];
	            int j = i - 1;
	            while (j >= 0 && arr[j] > key) {
	                arr[j + 1] = arr[j];
	                j--;
	            }
	            arr[j + 1] = key;
	        }
	    }
	}
