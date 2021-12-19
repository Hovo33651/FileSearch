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
                    searchContent();
                    break;
                default:
                    System.out.println("INVALID COMMAND");
                    break;
            }
        }
    }

    private static void searchContent() throws IOException {
        System.out.println("PLEASE INPUT THE PATH");
        String path = scanner.nextLine();
        File file = new File(path);
        if (file.isDirectory()) {
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                FileReader fileReader = new FileReader(listFile);
                BufferedReader inputStream = new BufferedReader(fileReader);
                System.out.println("PLEASE INPUT THE WORD");
                String word = scanner.nextLine();
                if (inputStream.readLine().contains(word)) {
                    System.out.println(listFile.getName());
                }
                else{
                    System.out.println("FILE DOESN'T EXIST");
                }
            }
        }
    }
}



