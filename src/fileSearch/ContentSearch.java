package fileSearch;

import fileSearch.commands.Commands;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class ContentSearch implements Commands {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

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
                    System.out.println("INPUT THE WORD");
                    String word = scanner.nextLine();
                    searchContent(path, word);
                    break;
                default:
                    System.out.println("INVALID COMMAND");
                    break;
            }
        }
    }

    private static void searchContent(String path, String word) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File listFile : Objects.requireNonNull(file.listFiles())) {
                    searchContent(listFile.getPath(), word);
                    if (listFile.isFile()) {
                        try (BufferedReader inputStream = new BufferedReader(new FileReader(listFile.getPath()))) {
                            String line = "";
                            while ((line = inputStream.readLine()) != null) {
                                if (line.contains(word)) {
                                    System.out.println("THE FILE //" + listFile.getName() + "// CONTAINS WORD /" + word + "/");
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } else System.out.println("THE PATH //" + path + "// DOESN'T EXIST");
    }
}


