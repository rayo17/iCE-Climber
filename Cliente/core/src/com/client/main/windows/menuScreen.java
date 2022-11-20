package com.client.main.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import com.client.main.mainClient;


public class menuScreen implements Screen {

    private static final int ONE_PLAYER_X = 0;

    private  static final int TWO_PLAYER_x = 0;

    private static final int ONE_PLAYER_Y = 500;

    private  static final int TWO_PLAYER_Y = 300;

    private static final int EXIT_BUTTON_X = 0;

    private static final int EXIT_BUTTON_Y = 100;

    public static  int players = 0;



    mainClient game;

    Texture background;

    Texture onePlayer;

    Texture exitButton;

    Texture twoPlayer;

    private Music music;

    public  menuScreen(mainClient game){
        this.game = game;

        background = new Texture("fondo.png");
        onePlayer = new Texture("1playerGame.png");
        twoPlayer = new Texture("2playerGame.png");
        exitButton = new Texture("Exit.png");

        // musica
        music = mainClient.manager.get("audio/music/game_start.mp3", Music.class);
        music.setLooping(false);
        music.play();
    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(180/255f,230/255f,255/255f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        game.batch.draw(background,0,0);

        // 1 player button
        if (Gdx.input.getX() > ONE_PLAYER_X && Gdx.input.getX() < 800
                && mainClient.HEIGHT - Gdx.input.getY() > ONE_PLAYER_Y && mainClient.HEIGHT - Gdx.input.getY() < ONE_PLAYER_Y + 100) {
            game.batch.draw(onePlayer, ONE_PLAYER_X,ONE_PLAYER_Y + 10);
            if (Gdx.input.isTouched()) {
                System.out.println("1");
                players = 1;
                game.setScreen(new GameScreen(game, false, true, players));

            }
        } else {
            game.batch.draw(onePlayer, ONE_PLAYER_X,ONE_PLAYER_Y);
        }

        // 2 player button
        if (Gdx.input.getX() > TWO_PLAYER_x && Gdx.input.getX() < 800
                && mainClient.HEIGHT - Gdx.input.getY() > TWO_PLAYER_Y && mainClient.HEIGHT - Gdx.input.getY() < TWO_PLAYER_Y + 100) {
            game.batch.draw(twoPlayer, TWO_PLAYER_x,TWO_PLAYER_Y + 10);
            if (Gdx.input.isTouched()) {
                System.out.println("2");
                players = 2;
                game.setScreen(new GameScreen(game, false, true, players));
            }
        } else {
            game.batch.draw(twoPlayer, TWO_PLAYER_x,TWO_PLAYER_Y);
        }

        // exit button
        if (Gdx.input.getX() > EXIT_BUTTON_X && Gdx.input.getX() < 625
                && mainClient.HEIGHT - Gdx.input.getY() > EXIT_BUTTON_Y && mainClient.HEIGHT - Gdx.input.getY() < EXIT_BUTTON_Y + 100) {
            game.batch.draw(exitButton, EXIT_BUTTON_X,EXIT_BUTTON_Y + 10);
            if (Gdx.input.isTouched()) {
                System.out.println("Exit");
                Gdx.app.exit();
            }
        } else {
            game.batch.draw(exitButton, EXIT_BUTTON_X,EXIT_BUTTON_Y);
        }
/*
        if (players == 1){
            game.batch.draw(onePlayer, 0, 0, 300,50);
        }
        if (players == 2){
            game.batch.draw(twoPlayer, 0, 0, 300,50);
        }
*/


        game.batch.end();

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


}
