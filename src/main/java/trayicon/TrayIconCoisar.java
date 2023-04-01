package trayicon;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class TrayIconCoisar {

    public static void trayIconShit() throws IOException {
        
        final PopupMenu popup = new PopupMenu();

        InputStream inputStream = TrayIconCoisar.class.getClassLoader().getResourceAsStream("icon.jpg");
        BufferedImage image = ImageIO.read(inputStream);
        
        TrayIcon trayIcon = new TrayIcon(image, "Gerando...");
        trayIcon.setImageAutoSize(true);

        final SystemTray tray = SystemTray.getSystemTray();

        MenuItem exit = new MenuItem("Encerrar");
        popup.add(exit);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
            trayIcon.displayMessage("Gerando códigos...", "Sinta-se livre para fazer seja lá o que você queira fazer.", MessageType.NONE);
        } catch (AWTException e) {
            System.out.println("Incapaz de criar um TrayIcon.");
        }
    }
}
