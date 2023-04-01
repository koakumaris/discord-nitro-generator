package registrador;

import java.io.FileWriter;
import java.io.IOException;

public class RegistrarCodigos {

    public static void register(String code) {
    	
        String fileName = "codigos.txt";
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(code);
            writer.write(System.lineSeparator());
            writer.close();
            System.out.println("Codigo adicionado ao arquivo.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
    }
}