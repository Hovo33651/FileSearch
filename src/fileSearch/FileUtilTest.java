package fileSearch;

import fileSearch.commands.Commands;

import java.io.IOException;
import java.util.Scanner;

public class FileUtilTest implements Commands {
    private static Scanner scanner = new Scanner(System.in);
    private static FileUtil fileUtil = new FileUtil();

    public static void main(String[] args) throws IOException {

        boolean isRun = true;
        while (isRun) {
            Commands.utilCommands();
            String commands = scanner.nextLine();
            switch (commands) {
                case EXIT:
                    isRun = false;
                    System.out.println("GOOD BYE!!!");
                    break;
                case FIND_LINES:
                    findLines();
                    break;
                case PRINT_SIZE:
                    printSize();
                    break;
                case CREATE_FILE:
                    createFile();
                    break;
                default:
                    System.out.println("INVALID COMMAND");
                    break;
            }
        }
    }

    private static void createFile() throws IOException {
        System.out.println("PLEASE INPUT THE PATH");
        String path = scanner.nextLine();
        System.out.println("PLEASE INPUT THE FILE NAME");
        String fileName = scanner.nextLine();
        System.out.println("INPUT FILE EXTENSION");
        String extension = scanner.nextLine();
        System.out.println("INPUT THE FILE CONTENT");
        String content = scanner.nextLine();
        fileUtil.createFileWithContent(path, fileName, content, extension);
    }

    private static void printSize() {
        System.out.println("PLEASE INPUT THE PATH");
        String path = scanner.nextLine();
        fileUtil.printSizeOfPackage(path);
    }

    private static void findLines() throws IOException {
        System.out.println("PLEASE INPUT THE PATH");
        String path = scanner.nextLine();
        System.out.println("PLEASE INPUT THE KEYWORD");
        String keyword = scanner.nextLine();
        fileUtil.findLines(path, keyword);
    }
}
