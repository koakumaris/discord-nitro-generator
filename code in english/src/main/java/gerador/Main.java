package gerador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import trayicon.TrayIconThing;
import trayicon.TrayIconManipulator;
import register.RegisterCode;

public class Main {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
    	TrayIconThing.trayIconShit();
    	boolean codigoPego = false;
    	
    	while(codigoPego == false) {
    		String code = "";
        	String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        	for(int i = 0; i < 16; i++) {
        	  code += chars.charAt((int) (Math.random() * chars.length()));
        	}
        	
//        	code = "Udzwm3hrQECQBnEEFFCEwdSq";
//				   ^^^^^^^^^^^^^^^^^^^^^^^^^^^ I was using for tests
        	String url = "https://discordapp.com/api/v6/entitlements/gift-codes/" + "?with_application=false&with_subscription_plan=true";
        	
        	HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        	con.setRequestMethod("GET");
        	
        	int responseCode = con.getResponseCode();
        	BufferedReader in = null;
        	String okuu = "";
        	
        	if (responseCode >= 200 && responseCode <= 299) {
        		in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        		okuu = "Valid Code ";
            } else {
            	in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            	okuu = "Unknown Gift Code: " + code;
            }
        	String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            JSONObject json = new JSONObject(response.toString());
            if (responseCode >= 200 && responseCode <= 299) {
            	if(json.getBoolean("redeemed") == false) {
            		okuu += "(Redeemable): " + code;
                    RegisterCode.register(okuu);
            		new TrayIconManipulator().sendNotification("CODE FOUND SHIT FUCK YEAH");
            		System.out.println(okuu);
            	} else {
            		okuu += "(Not Redeemable): " + code;
            		RegisterCode.register(okuu);
            		System.out.println(okuu);
            	}
            } else {
            	RegisterCode.register(okuu);
        		System.out.println(okuu);
            }
            
            Thread.sleep(5000);
    	}
    	
    }
}