package fileSearch;

import com.sun.org.apache.xpath.internal.SourceTree;
import fileSearch.commands.Commands;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class FileSearch implements Commands {
    private static Scanner scanner = new Scanner(System.in);
    private static String fileName;

    public static void main(String[] args) {


        boolean isRun = true;
        while (isRun) {
            Commands.commands();
            String commands = scanner.nextLine();
            switch (commands) {
                case EXIT:
                    isRun = false;
                    System.out.println("GOOD BYE!!!");
                    break;
                case SEARCH:
                    System.out.println("PLEASE INPUT THE PATH");
                    String path = scanner.nextLine();
                    System.out.println("INPUT THE FILE NAME");
                    String fileName = scanner.nextLine();
                    search(path, fileName);
                    break;
                default:
                    System.out.println("INVALID COMMAND");
                    break;
            }
        }
    }

    private static void search(String path, String fileName) {
        File file = new File(path);
        if (file.isDirectory()) {
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                search(listFile.getPath(), fileName);
                if (listFile.isFile() && listFile.getName().equals(fileName)) {
                    System.out.println(listFile.getName());
                }
            }
        }
    }
}

