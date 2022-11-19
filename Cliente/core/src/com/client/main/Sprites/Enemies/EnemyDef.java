package com.client.main.Sprites.Enemies;

import com.badlogic.gdx.math.Vector2;

/**
 * Esta clase funciona como un tipo de factory para los enemigos
 */
public class EnemyDef {

    public Vector2 pos;
    public Class<?> type;
    public boolean facingLeft;

    /**
     * Constructor de la clase.
     * @param pos Un vector con la posicion x y y donde quiere crearse el enemigo
     * @param type El tipo de enemigo (Yeti, Bear, Bird, Pterodactyl, Seal, Yeti)
     * @param facingLeft hacia que direccion se esta moviendo
     */
    public EnemyDef(Vector2 pos, Class<?> type, boolean facingLeft) {
        this.pos = pos;
        this.type = type;
        this.facingLeft = facingLeft;
    }
}
