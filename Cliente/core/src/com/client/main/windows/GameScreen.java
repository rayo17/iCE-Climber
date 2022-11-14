package com.client.main.windows;

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
//import com.client.main.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Pantalla de juego principal, donde se dasarrolla todo la jugabilidad*/
public class GameScreen implements Screen, Runnable {

    //ultimas variables
    public static final float SPEED = 250;
    public static final float ANIMATION_SPEED = 0.6f;
    public static final int PLAYER_PIXEL_WIDTH = 20;
    public static final int PLAYER_PIXEL_HEIGHT = 30;

    public int characters;

    public boolean host;

    mainClient game;

    private TextureAtlas atlas;

    private TextureAtlas fruitAtlas;

    public boolean bonus;

    private OrthographicCamera gameCamera;

    private Viewport gameport;

    //private Hud hud;

    //variables 2d
    private World world;

    private Box2DDebugRenderer b2dr;

    //variables tile map
    private TmxMapLoader mapLoader;

    private TiledMap map;

    private OrthogonalTiledMapRenderer renderer;

    //personajes
    //private Popo popocharacter;

    //private Nana nanacharacter;

    //musica del juego
    //private Music music;

    //private Pterodactyl teroFinal;

    //private LinkedBlockingQueue<EnemyDef> enemiesToSpawn;
    //private Array<Enemy> enemies;
    //public LinkedBlockingQueue<FruitDef> fruitsToSpawn;
    //private Array<Fruit> fruits;

    //Connect connect;

    private Thread t;
    /**
     * Constructor de clase GameScreen. Se da inicio a aquello necesario para empezar le juego
     * @param game Al igual que las demas pantallas se requiere un parametro de la clase Game, para este caso seria mainClient*/
    public GameScreen(mainClient game, boolean bonus, boolean host, int characters){
        //se crea el hilo para iniciar la conexcion cliente-servidor
        t = new Thread(this);
        t.start();

        this.characters = characters;
        this.host = host;
        this.game = game;
        this.bonus = bonus;

    }
}
