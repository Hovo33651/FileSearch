package fileSearch;

import java.io.*;
import java.util.Objects;

public class FileUtil {

    public void findLines(String txtPath, String keyword) throws IOException {
        File file = new File(txtPath);
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File listFile : Objects.requireNonNull(file.listFiles())) {
                    findLines(listFile.getPath(), keyword);
                    if (listFile.isFile()) {
                        try (BufferedReader inputStream = new BufferedReader(new FileReader(listFile.getPath()))) {
                            String line = "";
                            while ((line = inputStream.readLine()) != null) {
                                if (line.contains(keyword))
                                    System.out.println(line);
                            }
                        }
                    }
                }
            }
        } else System.out.println("THE PATH //" + txtPath + "// DOESN'T EXIST");
    }


    public void printSizeOfPackage(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            long size = 0;
            for (File listFile : Objects.requireNonNull(file.listFiles()))
                size += listFile.length();
            double sizeMb = (double) size / (1024 * 1024);
            System.out.println("PACKAGE FILES GENERAL SIZE IS " + sizeMb + " MB");
        } else if (file.isFile()) {
            System.out.println("FILE SIZE IS " + (double) file.length() / (1024 * 1024) + "MB");
        } else {
            System.out.println("THE PATH //" + path + "// DOESN'T EXIST");
        }
    }


    public void createFileWithContent(String path, String fileName, String content) throws IOException {
        File file = new File(path + "\\" + fileName);
        if (file.createNewFile()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()))) {
                writer.write(content);
                System.out.println("FILE HAS BEEN CREATED");
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("FILE ALREADY EXISTS");
        }
    }
}
