package fileSearch;

import fileSearch.commands.Commands;

import java.io.File;
import java.util.Scanner;

public class FileSearch implements Commands {
    private static Scanner scanner = new Scanner(System.in);

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
                    searchFile();
                    break;
                default:
                    System.out.println("INVALID COMMAND");
                    break;
            }
        }
    }

    private static void searchFile() {
        System.out.println("PLEASE INPUT THE PATH");
        File file = new File(scanner.nextLine());
        if (file.isDirectory()) {
            boolean exists = false;
            for (File files : file.listFiles()) {
                loop:
                while (!files.isFile())
                    for (File listFile : files.listFiles()) {
                        if (listFile.isFile()) {
                            System.out.println("PLEASE INPUT THE NAME OF THE FILE");
                            String fileName = scanner.nextLine();
                            if (listFile.getName().contains(fileName)) {
                                exists = true;
                                break loop;
                            }
                        } else continue loop;
                    }
            }
            System.out.println(exists);
        } else if (file.isFile()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
