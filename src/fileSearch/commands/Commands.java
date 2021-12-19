package fileSearch.commands;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import fileSearch.FileUtil;

public interface Commands {
    String EXIT = "0";
    String SEARCH = "1";
    String FIND_LINES = "1";
    String PRINT_SIZE = "2";
    String CREATE_FILE = "3";


    static void commands(){
        System.out.println("PRESS " + EXIT + " TO EXIT THE PROGRAM");
        System.out.println("PRESS " + SEARCH + " TO SEARCH A FILE");
    }

    static void utilCommands(){
        System.out.println("PRESS " + EXIT + " TO EXIT THE PROGRAM");
        System.out.println("PRESS " + FIND_LINES + " TO FIND LINES BY KEYWORD");
        System.out.println("PRESS " + PRINT_SIZE + " TO SEE THE PACKAGE SIZE");
        System.out.println("PRESS " + CREATE_FILE + " TO CREATE A NEW FILE");
    }
}
