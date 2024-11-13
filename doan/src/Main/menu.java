package Main;

import java.util.Scanner;
import Dequy.menuDeQuy;
import dslk.Menu;

public class menu {
	
	public static void main(String[] args) {
		int c1;
		Scanner sc = new Scanner(System.in);
		menuDeQuy deQuy = new menuDeQuy();
		
		// Colors for decoration
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_CYAN = "\u001B[36m";
		final String ANSI_YELLOW = "\u001B[33m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_PURPLE = "\u001B[35m";
		final String ANSI_BOLD = "\033[1m";
		
		do {
			System.out.println(ANSI_CYAN + "\n╭───────────────────────────────────────────────────────────╮");
			System.out.println("│" + ANSI_BOLD + ANSI_YELLOW + "                   ✨ CHƯƠNG TRÌNH MENU ✨                 " + ANSI_RESET + ANSI_CYAN + "│");
			System.out.println("├───────────────────────────────────────────────────────────┤");
			System.out.println("│  " + ANSI_GREEN + "1. 🔄 Làm việc với Đệ quy và Khử Đệ quy" + ANSI_CYAN + "                  │");
			System.out.println("│  " + ANSI_GREEN + "2. 📜 Làm việc với Danh sách liên kết đơn" + ANSI_CYAN + "                │");
			System.out.println("│  " + ANSI_RED + "3. ❌ Thoát" + ANSI_CYAN + "                                              │");
			System.out.println("╰───────────────────────────────────────────────────────────╯" + ANSI_RESET);
			System.out.print(ANSI_PURPLE + "🌟 Mời bạn chọn (1-3): " + ANSI_RESET);
			c1 = sc.nextInt();

			switch(c1) {
				case 1: {
					int tam;
					do {
						System.out.println(ANSI_GREEN + "\n╭────────────────────────────────────────────╮");
						System.out.println("│" + ANSI_BOLD + ANSI_YELLOW + "                  ĐỆ QUY                    " + ANSI_RESET + ANSI_GREEN + "│");
						System.out.println("├────────────────────────────────────────────┤");
						System.out.println("│  " + ANSI_PURPLE + "1. 🌀🌀🌀 Làm việc với Đệ quy             " + ANSI_GREEN + " │");
						System.out.println("│  " + ANSI_PURPLE + "2. 🛠  Làm việc với Khử Đệ quy           " + ANSI_GREEN + " │");
						System.out.println("│  " + ANSI_RED + "3. 🔙 Quay lại menu chính                " + ANSI_GREEN + " │");
						System.out.println("╰────────────────────────────────────────────╯" + ANSI_RESET);
						System.out.print(ANSI_PURPLE + "🌟 Mời bạn chọn (1-3): " + ANSI_RESET);
						tam = sc.nextInt();



						switch(tam) {
							case 1:
								deQuy.menuDQ();
								break;
							case 2:
								deQuy.menuKhuDQ();
								break;
							case 3:
								System.out.println(ANSI_RED + "🔙 Quay lại menu chính..." + ANSI_RESET);
								break;
							default:
								System.out.println(ANSI_RED + "⚠️  Lựa chọn không hợp lệ. Vui lòng chọn lại!" + ANSI_RESET);
						}
					} while (tam != 3); // Lặp cho đến khi người dùng chọn 3
					break; // Quay lại menu chính
				}
				case 2: {
					Menu.main(args);
					break;
				}
				case 3: {
					System.out.println(ANSI_GREEN + "🎉 Cảm ơn bạn đã sử dụng chương trình. Hẹn gặp lại!" + ANSI_RESET);
					break;
				}
				default:
					System.out.println(ANSI_RED + "⚠️  Lựa chọn không hợp lệ. Vui lòng chọn lại!" + ANSI_RESET);
			} 
		} while (c1 != 3); // Lặp cho đến khi người dùng chọn 3
		sc.close(); // Đóng Scanner
	}
}
