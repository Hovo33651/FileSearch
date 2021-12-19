package fileSearch;

import java.io.File;
import java.util.Arrays;

public class Hhh {
    public static void main(String[] args) {

        String path = "C:\\Hovo";
        File file = new File(path);
        for (File listFile : file.listFiles()) {
            if(listFile.getName().contains("\\.")){
            }
        }


    }
}
