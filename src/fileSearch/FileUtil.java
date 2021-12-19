package fileSearch;

import java.io.*;
import java.util.Objects;

public class FileUtil {

    public void findLines(String txtPath, String keyword) throws IOException {
        File file = new File(txtPath);
        if (file.isDirectory()) {
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(listFile));
                if (bufferedReader.readLine().contains(keyword)) {
                    System.out.println(bufferedReader.readLine());
                } else
                    System.out.println("KEYWORD DOESN'T EXIST");
            }
        }else if(file.isFile()){
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            if(bufferedReader.readLine().contains(keyword)){
                System.out.println(bufferedReader.readLine());
            }
        }else{
            System.out.println("FILE DOESN'T EXIST");
        }
    }

    public void printSizeOfPackage(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            long size = 0;
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                size += listFile.length();
            }
            double sizeMb = (double) size / (1024 * 1024);
            System.out.println("PACKAGE FILES GENERAL SIZE IS " + sizeMb + " MB");
        } else if (file.isFile()) {
            System.out.println("FILE SIZE IS " + (double) file.length() / (1024 * 1024) + "MB");
        } else {
            System.out.println("PATH IS INCORRECT");
        }
    }

    public void createFileWithContent(String path, String fileName, String content) throws IOException {
        File file = new File(path + "\\" + fileName + ".txt");
        if (file.createNewFile()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()))) {
                writer.write(content);
                System.out.println("FILE HAS BEEN CREATED");
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("FILE ALREADY EXISTS");
        }
    }
}
