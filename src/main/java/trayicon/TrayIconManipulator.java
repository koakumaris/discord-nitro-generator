package trayicon;


import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

public class TrayIconManipulator {

	private SystemTray tray = SystemTray.getSystemTray();
	private TrayIcon[] trayIcon = new TrayIcon[1];
	
	public TrayIconManipulator() {
		trayIcon = tray.getTrayIcons();
	}

	public void sendNotification(String msg) {
		trayIcon[0].displayMessage("Notificação!", msg, MessageType.NONE);
	}
}