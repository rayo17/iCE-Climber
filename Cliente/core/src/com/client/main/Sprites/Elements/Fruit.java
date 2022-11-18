package com.client.main.Sprites.Elements;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.client.main.mainClient;
import com.client.main.windows.GameScreen;

/**
 * Clase abstracta de todas las frutas. Provee ciertos atributos que comparten todas las frutas
 */
public abstract class Fruit extends Sprite{
    protected GameScreen screen;
    protected World world;
    protected boolean toDestroy;
    protected boolean destroyed;
    protected Body b2body;

    /**
     * Constructor de la clase temporal. POR SER MODIFICADO.
     * @param screen La pantalla en la que actualmente se encuentra el enemigo.
     * @param x Un entero correspondiente al nivel o piso en el que se desea spawnear el enemigo.
     * @param y  Un booleano que dice si esta moviendose a la izquierda si es true
     *                    en caso de ser false esta moviendose a la derecha.
     */
    public Fruit (GameScreen screen, float x, float y) {
        this.screen = screen;
        this.world = screen.getWorld();
        setPosition(x, y);
        setBounds(getX(), getY(), 16 / mainClient.PPM, 16 / mainClient.PPM );
        toDestroy = false;
        destroyed = false;
        defFruit();

    }

    public abstract void defFruit();
    public abstract void use(boolean Popo);

    /**
     * Actualiza la fruta en la pantalla.
     * @param dt El deltatime permite mover los objetos en pantalla no por frames de forma que si fuera por frames
     *           funcionaria diferente dependiendo del hardware.
     */
    public void update(float dt) {
        if (toDestroy && !destroyed) {
            world.destroyBody(b2body);
            destroyed = true;
        }
    }

    public void destroy() {
        toDestroy = true;
    }

    public void draw(Batch batch) {
        if (!destroyed) {
            super.draw(batch);
        }
    }
}
