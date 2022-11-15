package com.client.main.Sprites.Enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.client.main.Sprites.Characters.Nana;
import com.client.main.Sprites.Characters.Popo;
import com.client.main.windows.GameScreen;

public abstract class Enemy extends Sprite {
    protected World world;
    protected GameScreen screen;
    public Body b2body;

    // movimiento de los enemigos terrestres
    public Vector2 velocity;
    // movimiento de los enemigos aereos
    public Vector2 birdVelocity;
    private boolean facingLeft;


    /**
     * Constructor de la clase.
     * @param screen La pantalla en la que actualmente se encuentra el enemigo.
     * @param floor Un entero correspondiente al nivel o piso en el que se desea spawnear el enemigo.
     * @param facingLeft  Un booleano que dice si esta moviendose a la izquierda si es true
     *                    en caso de ser false esta moviendose a la derecha.
     */
    public Enemy(GameScreen screen, float floor, boolean facingLeft) {
        this.world = screen.getWorld();
        this.screen = screen;
        this.facingLeft = facingLeft;
        int x;
        // Se settea la posicion en x dependiendo de hacia que direccion se le dice que vaya
        if (facingLeft) {
            x = 270;
        } else {
            x = 0;
        }

        setPosition(x, floor);
        defineEnemy();


    }

    // Polimorfismo

    /**
     * Esta funcion define al enemigo, sus colisiones y la posicion de sus figuras de colision.
     */
    protected abstract void defineEnemy();


    /**
     * Esta funcion se llama si el enemigo fue golpeado en la cabeza por popo o nana.
     * @param popo
     * @param head
     */
    public abstract void hitOnHead(Popo popo, boolean head);
    /**
     * Esta funcion se llama si el enemigo fue golpeado en la cabeza por popo o nana.
     * @param nana
     */
    public abstract void hitOnHead(Nana nana, boolean head);

    /**
     * Actualiza el enemigo en la pantalla.
     * @param dt El deltatime permite mover los objetos en pantalla no por frames de forma que si fuera por frames
     *           funcionaria diferente dependiendo del hardware.
     */
    public abstract void update(float dt);

}
