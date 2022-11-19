package com.client.main.windows;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.client.main.mainClient;
import com.client.main.hud.Hud;

public class GameOver implements Screen{
    mainClient game;
    Hud hud;
    public GameOver(mainClient game, Hud hud) {
        this.game = game;
        this.hud = hud;
        this.hud.gameOverHud();
    }
    public void show() {

    }
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        hud.stage.draw();
    }
    public void resize(int width, int height) {

    }
    public void pause() {

    }
    public void resume() {

    }
    public void hide() {

    }
    public void dispose() {

    }
}
