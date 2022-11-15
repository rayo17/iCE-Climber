package com.client.main.Sprites.Characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.client.main.Sprites.Enemies.Enemy;
import com.client.main.mainClient;
import com.client.main.windows.GameScreen;

/**
 * Esta clase es la del personaje popo.
 */
public class Popo extends Sprite {
    public enum State {STANDING, JUMPING, RUNNING, ATTACKING, FALLING};
    public State currentState;
    public State previousState;
    public World world;
    public Body b2body;
    private TextureRegion popoStillRight;
    private Animation popoRun;
    private Animation popoJump;
    private Animation popoAttack;
    private float stateTimer;
    private boolean facingleft;
    public boolean attack = false;

    /**
     * Constructor de la clase. Se encarga de oobtener todos los sprites y de definir a popo con sus correspondientes
     * atributos.
     * @param screen La pantalla donde popo va a ser creado.
     */
    public Popo(GameScreen screen) {

        super(screen.getAtlas().findRegion("popoL"));

        this.world= screen.getWorld();

        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        facingleft = true;


        Array<TextureRegion> frames = new Array<TextureRegion>();
        for (int i = 20 ; i < 23; i++) {
            frames.add(new TextureRegion(getTexture(), i * 19, 38, 18, 27));
        }
        popoRun = new Animation(0.1f, frames);
        frames.clear();

        for (int i = 10; i > 5; i--) {
            frames.add(new TextureRegion(getTexture(), i * 18,38,20,27));
        }
        popoJump = new Animation(0.1f, frames);

        for (int i = 15; i > 12; i--) {
            frames.add(new TextureRegion(getTexture(), i * 18,38,20,27));
        }
        popoAttack = new Animation(0.1f, frames);

        definePopo(100 / mainClient.PPM,50 / mainClient.PPM);
        popoStillRight = new TextureRegion(getTexture(),422, 38,16,27);
        setBounds(20,20,16 / mainClient.PPM, 27 / mainClient.PPM);
        setRegion(popoStillRight);
    }

    /**
     * Actualiza a popo en pantalla.
     * @param dt El deltatime permite mover los objetos en pantalla no por frames de forma que si fuera por frames
     *           funcionaria diferente dependiendo del hardware.
     */
    public void update(float dt) {
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);

        if (b2body.getPosition().x * 100 > 300) {
            this.b2body.applyLinearImpulse(new Vector2(10f, 0), this.b2body.getWorldCenter(), true);
            definePopo(20 / mainClient.PPM,b2body.getPosition().y + - getHeight() / 2);
        } else if (b2body.getPosition().x * 100 < 20) {
            this.b2body.applyLinearImpulse(new Vector2(-10f, 0), this.b2body.getWorldCenter(), true);
            definePopo(300 / mainClient.PPM,b2body.getPosition().y + - getHeight() / 2);
        }
        setRegion(getFrame(dt));
    }

    /**
     * Devuelve el frame actual de popo, lo que se utiliza para saber que animacion utilizar
     * @param dt El deltatime permite mover los objetos en pantalla no por frames de forma que si fuera por frames
     *           funcionaria diferente dependiendo del hardware.
     * @return retorna un TextureRegion la cual es correspondiente al estado actual de popo
     */
    private TextureRegion getFrame(float dt) {
        currentState = getState();
        TextureRegion region;
        switch (currentState){
            case JUMPING:
                region = (TextureRegion) popoJump.getKeyFrame(stateTimer);
                break;
            case RUNNING:
                region = (TextureRegion) popoRun.getKeyFrame(stateTimer, true);
                break;
            case ATTACKING:
                region = (TextureRegion) popoAttack.getKeyFrame(stateTimer, true);

                break;
            case STANDING:
            default:
                region = popoStillRight;
                break;
        }
        if ((b2body.getLinearVelocity().x > 0 || !facingleft) && !region.isFlipX()) {
            region.flip(true, false);
            facingleft = false;
        } else if ((b2body.getLinearVelocity().x < 0 || facingleft) && region.isFlipX()){
            region.flip(true, false);
            facingleft = true;
        }
        stateTimer = currentState == previousState ? stateTimer + dt :0;
        previousState = currentState;
        this.attack = false;

        return region;
    }

    /**
     * Devuelve el estado actual de popo
     * @return retorna (STANDING, JUMPING, RUNNING)
     */
    private State getState() {
        if (b2body.getLinearVelocity().y > 0) {
            return State.JUMPING;
        }else if (b2body.getLinearVelocity().x != 0) {
            return State.RUNNING;
        } else if (this.attack) {
            return State.ATTACKING;
        } else if ((b2body.getLinearVelocity().y < 0)
                || (b2body.getLinearVelocity().y < 0 && b2body.getLinearVelocity().x < 0)
                || (b2body.getLinearVelocity().y < 0 && b2body.getLinearVelocity().x > 0)) {
            return State.FALLING;
        } else {
            return State.STANDING;
        }
    }

    /**
     * Esta funcion se llama si popo fue atacado por un enemigo
     */
    public void hit(Enemy enemy){
        enemy.hitOnHead(this, false);


    }

    /**
     * Define a popo y aquello lo necesario para poder utilizar sus colisiones
     * @param x en que x esta popo en este momento
     * @param y en que y esta popo en este momento
     */
    public void definePopo(float x,float y) {
        BodyDef bdef = new BodyDef();
        bdef.position.set(x,y);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(10 / mainClient.PPM);

        fdef.filter.categoryBits = mainClient.PLAYER_BIT;
        fdef.filter.maskBits = mainClient.GROUND_BIT | mainClient.BRICK_BIT | mainClient.ENEMY_HEAD_BIT | mainClient.FRUIT_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData(this);

        EdgeShape head = new EdgeShape();
        head.set(new Vector2(-1 / mainClient.PPM, 11 / mainClient.PPM), new Vector2(1 / mainClient.PPM, 11 / mainClient.PPM));
        fdef.filter.categoryBits = mainClient.PLAYER_HEAD_BIT;
        fdef.shape = head;
        fdef.isSensor = true;

        b2body.createFixture(fdef).setUserData(this);
    }
}
