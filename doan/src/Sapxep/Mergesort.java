package Sapxep;

public class Mergesort {
	 // Phương thức trộn hai nửa mảng
    private void tron(int[] arr, int trai, int giua, int phai) {
        int n1 = giua - trai + 1;
        int n2 = phai - giua;

        // Tạo các mảng tạm
        int[] mangTrai = new int[n1];
        int[] mangPhai = new int[n2];

        // Sao chép dữ liệu vào các mảng tạm
        for (int i = 0; i < n1; ++i)
            mangTrai[i] = arr[trai + i];
        for (int j = 0; j < n2; ++j)
            mangPhai[j] = arr[giua + 1 + j];

        // Trộn các mảng tạm lại với nhau

        // Chỉ số ban đầu của các mảng con
        int i = 0, j = 0;

        // Chỉ số ban đầu của mảng trộn
        int k = trai;
        while (i < n1 && j < n2) {
            if (mangTrai[i] <= mangPhai[j]) {
                arr[k] = mangTrai[i];
                i++;
            } else {
                arr[k] = mangPhai[j];
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại của mangTrai, nếu có
        while (i < n1) {
            arr[k] = mangTrai[i];
            i++;
            k++;
        }

        // Sao chép các phần tử còn lại của mangPhai, nếu có
        while (j < n2) {
            arr[k] = mangPhai[j];
            j++;
            k++;
        }
    }
    
 // Phương thức chính để sắp xếp mảng arr[trai...phai] sử dụng tron()
    public void sapXep(int[] arr, int trai, int phai) {
        if (trai < phai) {
            // Tìm chỉ số giữa
            int giua = (trai + phai) / 2;

            // Sắp xếp nửa đầu và nửa sau
            sapXep(arr, trai, giua);
            sapXep(arr, giua + 1, phai);

            // Trộn hai nửa đã sắp xếp
            tron(arr, trai, giua, phai);
        }
    }
}
