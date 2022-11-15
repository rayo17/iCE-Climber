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
import com.client.main.Apparition.Elements.Fruit;
import com.client.main.Apparition.Elements.FruitDef;
import com.client.main.Apparition.Opponents.Opponent;
import com.client.main.Apparition.Opponents.OpponentDef;
import com.client.main.Gadgets.B2WorldCreator;
import com.client.main.Stage.Data;
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

    private Data data;

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

    private LinkedBlockingQueue<OpponentDef> enemiesToSpawn;
    private Array<Opponent> enemigos;
    public LinkedBlockingQueue<FruitDef> fruitsToSpawn;
    private Array<Fruit> frutas;

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
        //Los atlas se usan para realizar las animaciones de los sprites
        atlas = new TextureAtlas("Popo_Nana_and_Enemies.pack");
        fruitAtlas = new TextureAtlas("Fruits.pack");
        //La gamecamera y el gameport que se utilizan para mostrar el juego
        gameCamera = new OrthographicCamera();
        gameport = new FitViewport(mainClient.GWIDTH / mainClient.PPM, mainClient.GHEIGHT /mainClient.PPM, gameCamera);
        data = new Data(game.batch);

        //inicia el mapa
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("mainClient.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1 / mainClient.PPM);

        //coloca la posicion de la camara e inicia algunas variables necesarias para que funcione el juego
        gameCamera.position.set(gameport.getWorldWidth() / 2, (gameport.getWorldHeight() + 0) / 2, 0);

        world = new World(new Vector2(0, -10), true);
        b2dr = new Box2DDebugRenderer();

        //Los arrays que contienen a todos los personajes que habra en la pantall, cada uno en su respectiva clase
        enemigos = new Array<Opponent>();
        frutas = new Array<Fruit>();

        //Lista de espera para los enemigos que se crearan
        enemiesToSpawn = new LinkedBlockingQueue<>();
        fruitsToSpawn = new LinkedBlockingQueue<>();


    }

    public void dispose() {
        map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        data.dispose();
        game.batch.dispose();

    }
}
