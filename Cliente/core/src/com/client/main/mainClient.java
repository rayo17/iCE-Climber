package com.client.main;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.client.main.windows.menuScreen;


public class mainClient extends Game {
	//Dimensiones de la ventana principal
	public static final int WIDTH = 800;

	public static final int HEIGHT = 1000;

	//Dimenciones de la ventana de juego
	public static final int GWIDTH = 300;

	public static final int GHEIGHT = 500;

	public static final int POSY = 50;
	public static final int POSX = 500;

	//PixelsPerMeter
	public static final float PPM = 100;
	//Box2D collision bits
	public static final short NOTHING_BIT = 0;
	public static final short GROUND_BIT = 1;
	public static final short PLAYER_BIT = 2;
	public static final short PLAYER_HEAD_BIT = 512;
	public static final short BRICK_BIT = 4;
	public static final short DESTROYED_BIT = 16;
	public static final short ENEMY_BIT = 62;
	public static final short ENEMY_HEAD_BIT = 128;
	public static final short FRUIT_BIT = 32;
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
