package com.client.main;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.client.main.mainClient;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setTitle("ICE CLIMBER LENGUAJES CE");
		config.setForegroundFPS(60);
		config.setWindowedMode(mainClient.WIDTH,mainClient.HEIGHT);
		config.setResizable(false);
		config.setWindowPosition(mainClient.POSX,mainClient.POSY);
		new Lwjgl3Application(new mainClient(), config);
	}
}
