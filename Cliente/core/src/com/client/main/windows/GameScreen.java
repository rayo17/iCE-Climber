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
import com.client.main.hud.Hud;
import com.client.main.Sprites.Elements.*;
import com.client.main.Sprites.Enemies.*;
import com.client.main.Sprites.Characters.Popo;
import com.client.main.Sprites.Characters.Nana;
import com.client.main.Gadgets.B2WorldCreator;
import com.client.main.Gadgets.WorldContactListener;
import com.client.main.Sockets.Connect;
import com.client.main.Sockets.jsonManager.jsonFactory;
import com.client.main.Sockets.jsonManager.jsonHandler;

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

    private Hud data;

    //variables 2d
    private World world;

    private Box2DDebugRenderer b2dr;

    //variables tile map
    private TmxMapLoader mapLoader;

    private TiledMap map;

    private OrthogonalTiledMapRenderer renderer;

    //personajes
    private Popo popocharacter;

    private Nana nanacharacter;

    //musica del juego
    private Music music;

    //private Pterodactyl teroFinal;

    private LinkedBlockingQueue<EnemyDef> enemiesToSpawn;
    private Array<Enemy> enemigos;
    public LinkedBlockingQueue<FruitDef> fruitsToSpawn;
    private Array<Fruit> frutas;

    Connect connect;

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
        data = new Hud(game.batch);

        //inicia el mapa
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("mainClient.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1 / mainClient.PPM);

        // inicia la musica
        if (!this.bonus) {
            music = mainClient.manager.get("audio/music/ice_climber.mp3",Music.class);
            music.setLooping(true);
            music.play();
        } else {
            music = mainClient.manager.get("audio/music/bonus_stage.mp3",Music.class);
            music.setLooping(true);
            music.play();
        }

        //coloca la posicion de la camara e inicia algunas variables necesarias para que funcione el juego
        gameCamera.position.set(gameport.getWorldWidth() / 2, (gameport.getWorldHeight() + 0) / 2, 0);

        world = new World(new Vector2(0, -10), true);
        b2dr = new Box2DDebugRenderer();

        //Los arrays que contienen a todos los personajes que habra en la pantall, cada uno en su respectiva clase
        enemigos = new Array<Enemy>();
        frutas = new Array<Fruit>();

        //Lista de espera para los enemigos que se crearan
        enemiesToSpawn = new LinkedBlockingQueue<>();
        fruitsToSpawn = new LinkedBlockingQueue<>();

        //Verifica la cantidad de jugadores
        if (this.characters == 1) {
            popocharacter = new Popo(this);
        } else {
            popocharacter = new Popo(this);
            nanacharacter = new Nana(this);
        }

        world.setContactListener(new WorldContactListener());

        //teroFinal = new Pajaro(this, 760, true);
    }
    /**
     * Funcion que crea los enemigos en el GameScreen.
     * @param enemydef Definicion de un enemigo que se desea crear en pantalla y se agrega a enemiesToSpawn.
     */
    public void spawnEnemy(EnemyDef enemydef) {
        enemiesToSpawn.add(enemydef);
    }

    /**
     * Funcion que revisa enemiesToSpawn, para saber si existe algo nuevo. Si la esta no se encuentra vacia
     * corrobora al tipo de enemigo al que pertenece y lo ingresa al array de enemies segun su clase correspondiente*/
    public void handleSpawningEnemies() {
        if (!enemiesToSpawn.isEmpty()) {
            EnemyDef edef = enemiesToSpawn.poll();
            if (edef.type == Pajaro.class) {
                enemigos.add(new Pajaro(this, edef.pos.y, edef.facingLeft));
            } else if (edef.type == Foca.class) {
                enemigos.add(new Foca(this, edef.pos.y, edef.facingLeft));
            } else if (edef.type == Hielo.class) {
                enemigos.add(new Hielo(this, edef.pos.y, edef.facingLeft));
            } /**else if (edef.type == Yeti.class) {
                enemigos.add(new Yeti(this, edef.pos.y, edef.facingLeft));
            }*/
        }
    }

    /**
     * Funcion que permite crear las frutas en el GameScreen.
     * @param fruitdef definicion de un fruta que se desea crear en pantalla y se agrega a fruitsToSpawn.
     */
    public void spawnFruit(FruitDef fruitdef) {
        fruitsToSpawn.add(fruitdef);
    }
    /**
     * Funcion que revisa fruitsToSpawn, para saber si existe algo nuevo. Si la esta no se encuentra vacia
     * corrobora al tipo de fruta al que pertenece y lo ingresa al array de frutas segun su clase correspondiente
     */
    public void handleSpawningFruits() {
        if (!fruitsToSpawn.isEmpty()) {
            FruitDef fruitdef = fruitsToSpawn.poll();
            if (fruitdef.type == Naranja.class) {
                frutas.add(new Naranja(this, fruitdef.position.x, fruitdef.position.y));
            } else if (fruitdef.type == Lechugas.class) {
                frutas.add(new Lechugas(this, fruitdef.position.x, fruitdef.position.y));
            } else if (fruitdef.type == Banano.class) {
                frutas.add(new Banano(this, fruitdef.position.x, fruitdef.position.y));
            } else if (fruitdef.type == Berenjenas.class) {
                frutas.add(new Berenjenas(this, fruitdef.position.x, fruitdef.position.y));
            }
        }
    }


    /**
     * Retorna el atlas de los personajes
     */
    public TextureAtlas getAtlas() {
        return atlas;
    }

    /**
     * Retorna el atlas de las frutas
     */
    public TextureAtlas getFruitAtlas() {
        return fruitAtlas;
    }
    public void show() {

    }

    /**
     * La funcion update lo que hace es actualizar todos los actores presentes dentro de la pantalla, sea su posicion,
     * su sprite, agregar, eliminar, etc
     * @param dt El deltatime permite mover los objetos en pantalla no por frames de forma que si fuera por frames
     *           funcionaria diferente dependiendo del hardware.
     */
    public void update(float dt) {

        handleInput(dt);
        handleSpawningFruits();
        handleSpawningEnemies();
        world.step(1 / 60f, 6, 2);

        /**
         jsonHandler jsonChecker = new jsonHandler();
         jsonFactory firstmsg = new jsonFactory(0);
         jsonChecker.jsonWriter(firstmsg);
         connect.out.println(jsonChecker.jsonWriter(firstmsg));
         */

        if (this.characters == 1) {
            popocharacter.update(dt);
            if (Hud.getPopoLives() < 1) {
                game.setScreen(new GameOver(game, data));
            }
            if (teroFinal.destroyed) {
                game.setScreen(new GameOver(game, data));
            }
        } else {
            if (Hud.getPopoLives() < 1) {
                game.setScreen(new GameOver(game, data));
            }
            if (Hud.getNanaLives() < 1) {
                game.setScreen(new GameOver(game, data));
            }
            if (teroFinal.destroyed) {
                game.setScreen(new GameOver(game, data));
            }
            popocharacter.update(dt);
            nanacharacter.update(dt);
        }

        // Si la posicion de popo aumenta arriba de 500 cambia de posicion la camara
        if (this.characters == 2) {
            if ((popocharacter.b2body.getPosition().y * 100 > 700 | nanacharacter.b2body.getPosition().y * 100 > 700) && !bonus) {
                music.dispose();
                game.setScreen(new GameScreen(game, true, this.host, this.characters));
            }
            if (popocharacter.b2body.getPosition().y * 100 > 450 && nanacharacter.b2body.getPosition().y * 100 > 450) {
                gameCamera.position.set(gameport.getWorldWidth() / 2, (gameport.getWorldHeight() + 9) / 2, 0);
            } else {
                gameCamera.position.set(gameport.getWorldWidth() / 2, (gameport.getWorldHeight() + 0) / 2, 0);
            }
        } else {
            if (popocharacter.b2body.getPosition().y * 100 > 450) {
                gameCamera.position.set(gameport.getWorldWidth() / 2, (gameport.getWorldHeight() + 9) / 2, 0);
            } else {
                gameCamera.position.set(gameport.getWorldWidth() / 2, (gameport.getWorldHeight() + 0) / 2, 0);
            }
            if (popocharacter.b2body.getPosition().y * 100 > 700 && !bonus) {
                music.dispose();
                game.setScreen(new GameScreen(game, true, this.host, this.characters));
            }
        }



        // Actualiza cada enemigo en la pantalla
        for (Enemy enemy : enemigos) {
            enemy.update(dt);
        }
        // Actualiza cada fruta en la pantalla
        for (Fruit fruit : frutas) {
            fruit.update(dt);
        }

        teroFinal.update(dt);
        gameCamera.update();
        renderer.setView(gameCamera);
    }

    /**
     * Aqui se revisa el input ingresado por el usuario, usualmente utilizado para mover a popo o nana
     * @param dt El deltatime permite mover los objetos en pantalla no por frames de forma que si fuera por frames
     *           funcionaria diferente dependiendo del hardware.
     */
    private void handleInput(float dt) {
        if (this.host) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.W) && popocharacter.currentState != Popo.State.JUMPING && popocharacter.currentState != Popo.State.FALLING) {
                popocharacter.b2body.applyLinearImpulse(new Vector2(0, 4.5f), popocharacter.b2body.getWorldCenter(), true);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D) && popocharacter.b2body.getLinearVelocity().x <= 2) {

                popocharacter.b2body.applyLinearImpulse(new Vector2(0.1f, 0), popocharacter.b2body.getWorldCenter(), true);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A) && popocharacter.b2body.getLinearVelocity().x >= -2) {
                popocharacter.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), popocharacter.b2body.getWorldCenter(), true);
            }

            if (this.characters == 2) {
                if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && nanacharacter.currentState != Nana.State.JUMPING && nanacharacter.currentState != Nana.State.FALLING) {
                    nanacharacter.b2body.applyLinearImpulse(new Vector2(0, 4.5f), nanacharacter.b2body.getWorldCenter(), true);
                }
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && nanacharacter.b2body.getLinearVelocity().x <= 2) {
                    nanacharacter.b2body.applyLinearImpulse(new Vector2(0.1f, 0), nanacharacter.b2body.getWorldCenter(), true);
                }
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && nanacharacter.b2body.getLinearVelocity().x >= -2) {
                    nanacharacter.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), nanacharacter.b2body.getWorldCenter(), true);
                }
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.T)) {
            game.setScreen(new GameOver(game, data));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.U)) {
            this.spawnEnemy(new EnemyDef(new Vector2(10, 700), Foca.class, true));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
            this.spawnEnemy(new EnemyDef(new Vector2(10, 700), Hielo.class, true));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
            this.spawnEnemy(new EnemyDef(new Vector2(10, 680), Pterodactyl.class, true));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            this.spawnEnemy(new EnemyDef(new Vector2(10, 640), Pajaro.class, true));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.F)) {
            this.spawnFruit(new FruitDef(new Vector2(50 / mainClient.PPM, 100 / mainClient.PPM), Naranja.class));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
            this.spawnFruit(new FruitDef(new Vector2(50 / mainClient.PPM, 100 / mainClient.PPM), Banano.class));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.H)) {
            this.spawnFruit(new FruitDef(new Vector2(50 / mainClient.PPM, 100 / mainClient.PPM), Lechugas.class));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.H)) {
            this.spawnFruit(new FruitDef(new Vector2(50 / mainClient.PPM, 100 / mainClient.PPM), Berenjenas.class));
        }

    }
    /**
     * Este metodo dibuja lo que tenga que dibujar dentro de la pantalla
     */
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        b2dr.render(world, gameCamera.combined);

        game.batch.setProjectionMatrix(gameCamera.combined);
        game.batch.begin();

        // dibuja los jugadores
        if (this.characters == 1) {
            popocharacter.draw(game.batch);
        } else {
            nanacharacter.draw(game.batch);
            popocharacter.draw(game.batch);
        }

        teroFinal.draw(game.batch);
        // dibuja las frutas
        for (Fruit fruit : frutas) {
            fruit.draw(game.batch);
        }
        // dibuja los enemigos
        for (Enemy enemy : enemigos) {
            enemy.draw(game.batch);
        }
        game.batch.end();
        data.stage.draw();



    }

    public void resize(int width, int height) {
        gameport.update(width, height);
    }


    public TiledMap getMap() {
        return map;
    }

    public World getWorld() {
        return world;
    }
    public void pause() {

    }
    public void resume() {

    }
    public void hide() {

    }
    public void dispose() {
        map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        data.dispose();
        game.batch.dispose();

    }
    public void run() {
        int msg = 0;
        jsonHandler jsonChecker = new jsonHandler();
        connect = new Connect();
        Connect.setUp();
        try {
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;

            while ((userInput = stdIn.readLine()) != null) {
                connect.out.println(userInput);

                if (msg != 0) {
                    jsonChecker.jsonReader(connect.in.readLine(), this);
                }
                if(msg==0) {
                    System.out.println("SERVER: " + connect.in.readLine());
                }
                msg = 1;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
