package com.client.main.windows;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import com.client.main.mainClient;


public class GameScreen implements Screen, Runnable{

    public  static final float VEL = 200;
    public static final float ANIMATION_VEL= 0.5f;
    public  static final int PLAYER_PIXELW = 20;
    public  static final int PLAYER_PIXELH = 30;

    public int players;

    public boolean host;

    mainClient game;

    private TextureAtlas atlas;
    private TextureAtlas fruitAtlas;

    public boolean bonus;

    private OrthographicCamera gamecam;

    private Viewport gameport;

    private World world;



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void run() {

    }
    public World getWorld() {
        return world;
    }

    public TextureAtlas getAtlas() {return atlas
    }
}
