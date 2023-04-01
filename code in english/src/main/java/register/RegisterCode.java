package register;

import java.io.FileWriter;
import java.io.IOException;

public class RegisterCode {

    public static void register(String code) {
    	
        String fileName = "codigos.txt";
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(code);
            writer.write(System.lineSeparator());
            writer.close();
            System.out.println("Code added to file.");
        } catch (IOException e) {
            System.out.println("An error has Okuued.");
            e.printStackTrace();
        }
    }
}