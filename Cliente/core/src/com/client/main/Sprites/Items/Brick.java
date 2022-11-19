package com.client.main.Sprites.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.client.main.hud.Hud;
import com.client.main.mainClient;
import com.client.main.windows.GameScreen;

/**
 * La clase brick es la correspondiente a aquellos bloques que se pueden romper por algun personaje.
 * Al inicializar el mapa en la clase GameScreen se inicializan todos lo bloques dentro del mapa
 */
public class Brick extends Tiles {
    public Brick(GameScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData(this);
        setCategoryFilter(mainClient.BRICK_BIT);
    }

    @Override
    public void onHeadHit(boolean popo) {
        Gdx.app.log("Brick", "Collision");
        setCategoryFilter(mainClient.DESTROYED_BIT);
        getCell().setTile(null);
        mainClient.manager.get("audio/sounds/breakblock.wav", Sound.class).play();

        if (popo) {
            Hud.addScore(50, Brick.class, true);
            Hud.addScorePopo(50);
        }
        if (!popo) {
            Hud.addScore(50, Brick.class, false);
            Hud.addScoreNana(50);
        }

    }


}
