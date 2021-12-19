package fileSearch.commands;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public interface Commands {
    String EXIT = "0";
    String SEARCH = "1";


    static void commands(){
        System.out.println("PRESS " + EXIT + " TO EXIT THE PROGRAM");
        System.out.println("PRESS " + SEARCH + " TO SEARCH A FILE");
    }
}
