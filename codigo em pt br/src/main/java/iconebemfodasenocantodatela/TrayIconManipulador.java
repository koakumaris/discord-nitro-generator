package iconebemfodasenocantodatela;


import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

public class TrayIconManipulador {

	private SystemTray tray = SystemTray.getSystemTray();
	private TrayIcon[] trayIcon = new TrayIcon[1];
	
	public TrayIconManipulador() {
		trayIcon = tray.getTrayIcons();
	}

	public void sendNotification(String msg) {
		trayIcon[0].displayMessage("Notificação!", msg, MessageType.NONE);
	}
}