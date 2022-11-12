package com.client.main;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.client.main.windows.menuScreen;


public class mainClient extends Game {

	public static final int WIDTH = 800;

	public static final int HEIGHT = 1000;

	public static final int POSY = 50;
	public static final int POSX = 500;

	//PixelsPerMeter
	public static final float PPM = 100;
	public static AssetManager manager;

	public SpriteBatch batch;
	
	@Override
	public void create () {

		batch = new SpriteBatch();
		manager = new AssetManager();
		manager.finishLoading();
		this.setScreen(new menuScreen(this));
	}

	@Override
	public void render () {super.render();}
	
	@Override
	public void dispose () {
		super.dispose();
		manager.dispose();
		batch.dispose();
	}
}
