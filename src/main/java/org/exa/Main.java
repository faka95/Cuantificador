package org.exa;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        // FileManager.cargarFormula();
        Estructura.pathFormula = System.getProperty("user.dir")+"/src/test/java/formula.txt";
        System.out.println("aa");
        FileManager.cargarFormula();
        System.out.println(Estructura.formula);

    }
}
