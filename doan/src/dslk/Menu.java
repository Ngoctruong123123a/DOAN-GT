package dslk;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    // Mã màu ANSI để tạo hiệu ứng và màu sắc
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_UNDERLINE = "\u001B[4m";

    // Hiển thị menu chính và nhận lựa chọn
    public int displayMainMenu() {
        System.out.println(ANSI_PURPLE + "╔═════════════════════════════════════════════════════════════════════╗" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "║" + ANSI_YELLOW + ANSI_BOLD + "                  ✨✨✨  WELCOME TO SHOE MANAGEMENT SYSTEM ✨✨✨        " + ANSI_PURPLE + "║" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "╠═════════════════════════════════════════════════════════════════════╣" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "║" + ANSI_CYAN + "  1. 🏷️  " + ANSI_GREEN + ANSI_BOLD + "Create shoe list                            " + ANSI_PURPLE + "      ║" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "║" + ANSI_CYAN + "  2. 👟  " + ANSI_GREEN + ANSI_BOLD + "View shoe list                              " + ANSI_PURPLE + "      ║" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "║" + ANSI_CYAN + "  3. ➕  " + ANSI_GREEN + ANSI_BOLD + "Insert a new shoe                           " + ANSI_PURPLE + "      ║" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "║" + ANSI_CYAN + "  4. ❌  " + ANSI_GREEN + ANSI_BOLD + "Delete a shoe                               " + ANSI_PURPLE + "      ║" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "║" + ANSI_CYAN + "  5. 📊  " + ANSI_GREEN + ANSI_BOLD + "Sort shoes by price                         " + ANSI_PURPLE + "      ║" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "║" + ANSI_CYAN + "  6. 🔍  " + ANSI_GREEN + ANSI_BOLD + "Search for shoes by ID                      " + ANSI_PURPLE + "      ║" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "║" + ANSI_CYAN + "  7. 📂  " + ANSI_GREEN + ANSI_BOLD + "Read shoe list from file                    " + ANSI_PURPLE + "      ║" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "║" + ANSI_CYAN + "  8. 💾  " + ANSI_GREEN + ANSI_BOLD + "Save shoe list to file                      " + ANSI_PURPLE + "      ║" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "║" + ANSI_CYAN + "  9. 🔙  " + ANSI_GREEN + ANSI_BOLD + "Exit                                        " + ANSI_PURPLE + "      ║" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "╚═════════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
        System.out.print(ANSI_YELLOW + ANSI_BOLD + "🌟 Please select an option: " + ANSI_RESET);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        MainProgram program = new MainProgram();
        Menu menu = new Menu();
        boolean exit = false;

        // Vòng lặp để hiển thị và xử lý lựa chọn của người dùng
        while (!exit) {
            int choice = menu.displayMainMenu();
            switch (choice) {
                case 1:
                    program.createShoes();
                    break;
                case 2:
                    program.traverseShoes();
                    break;
                case 3:
                    program.insertShoe();
                    break;
                case 4:
                    program.deleteShoe();
                    break;
                case 5:
                    program.sortShoesByPrice();
                    break;
                case 6:
                    program.searchShoeById();
                    break;
                case 7:
                    System.out.print("📁 Enter file name to read from: ");
                    String fileNameRead = program.scanner.next();
                    program.readShoesFromFile(fileNameRead);
                    break;
                case 8:
                    System.out.print("💾 Enter file name to save to: ");
                    String fileNameWrite = program.scanner.next();
                    program.writeShoesToFile(fileNameWrite);
                    break;
                case 9:
                    exit = true;
                    System.out.println(ANSI_RED + ANSI_BOLD + "🎉 Exiting the program. Thank you for using Shoe Management System! 🎉" + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_RED + "⚠️ Invalid choice. Please try again." + ANSI_RESET);
            }
        }
    }
}
