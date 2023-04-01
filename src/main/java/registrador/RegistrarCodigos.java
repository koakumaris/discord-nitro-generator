package registrador;

import java.io.FileWriter;
import java.io.IOException;

public class RegistrarCodigos {

    public static void register(String code) {
    	
        String fileName = "codigos.txt";
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(code);
            writer.write(System.lineSeparator()); // Add a new line after the data
            writer.close();
            System.out.println("Codigo adicionado ao arquivo.");
        } catch (IOException e) {
            System.out.println("An error has Okuued.");
            e.printStackTrace();
        }
    }
}
