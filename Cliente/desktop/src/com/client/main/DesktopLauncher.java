package com.client.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.client.main.mainClient;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.height = mainClient.HEIGHT;
		config.width = mainClient.WIDTH;
		config.forceExit = false;
		new LwjglApplication(new mainClient(), config);
	}
}
