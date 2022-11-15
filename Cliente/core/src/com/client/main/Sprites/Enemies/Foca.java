package com.client.main.Sprites.Enemies;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.client.main.Sprites.Characters.Nana;
import com.client.main.Sprites.Characters.Popo;
import com.client.main.hud.Hud;
import com.client.main.mainClient;
import com.client.main.windows.GameScreen;

public class Foca extends Enemy{

private float stateTime;
private Animation walkAnimation;
private Array<TextureRegion> frames;
private boolean setToDestroy;
private boolean destroyed;
private boolean facingLeft;

public Foca(GameScreen screen, float floor, boolean facingLeft) {
        super(screen, floor - 20, facingLeft);
        // define su velocidad dependiendo de hacia donde esta viendo y si hay bonus
        if (facingLeft) {
        if (!screen.bonus) {
        velocity = new Vector2(-0.3f, 0);
        } else {
        velocity = new Vector2(-0.7f, 0);
        }

        } else {
        if (!screen.bonus) {
        velocity = new Vector2(0.3f, 0);
        } else {
        velocity = new Vector2(0.7f, 0);
        }
        }

        frames = new Array<TextureRegion>();
        for (int i = 1; i < 3; i++) {
        frames.add(new TextureRegion(screen.getAtlas().findRegion("seal_left"), i * 20, 0, 20, 16));
        }
        walkAnimation = new Animation(0.4f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), 20 / mainClient.PPM, 16 / mainClient.PPM);
        setToDestroy = false;
        destroyed = false;
        }


public void update(float dt) {
        stateTime += dt;
        if (b2body.getPosition().x * 100 > 350) {
        setToDestroy = true;
        } else if (b2body.getPosition().x * 100 < -10) {
        setToDestroy = true;
        }
        if (setToDestroy && !destroyed) {
        world.destroyBody(b2body);
        destroyed = true;
        setRegion(new TextureRegion(screen.getAtlas().findRegion("seal_left"), 0, 0, 20, 16));
        stateTime = 0;
        } else if (!destroyed) {

        b2body.setLinearVelocity(velocity);
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
        setRegion((TextureRegion) walkAnimation.getKeyFrame(stateTime, true));
        }

        }

@Override
protected void defineEnemy() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(getX() / mainClient.PPM, getY() / mainClient.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(10 / mainClient.PPM);

        fdef.filter.categoryBits = mainClient.ENEMY_BIT;
        fdef.filter.maskBits = mainClient.GROUND_BIT |
        mainClient.BRICK_BIT |

        mainClient.PLAYER_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef);
        b2body.createFixture(fdef).setUserData(this);

        PolygonShape head = new PolygonShape();
        Vector2[] vertice = new Vector2[4];
        vertice[0] = new Vector2(-8, 12).scl(1 / mainClient.PPM);
        vertice[1] = new Vector2(8, 12).scl(1 / mainClient.PPM);
        vertice[2] = new Vector2(-3, 3).scl(1 / mainClient.PPM);
        vertice[3] = new Vector2(3, 3).scl(1 / mainClient.PPM);
        head.set(vertice);

        fdef.shape = head;
        fdef.restitution = 0.5f;
        fdef.filter.categoryBits = mainClient.ENEMY_HEAD_BIT;
        b2body.createFixture(fdef).setUserData(this);
        }

public void draw(Batch batch) {
        if (!destroyed || stateTime < 1) {
        super.draw(batch);
        }
        }

@Override
public void hitOnHead(Popo popo, boolean head) {
        if (!setToDestroy && head) {
        Hud.addScore(100, Foca.class, true);
        Hud.addScorePopo(100);
        } else if (!setToDestroy && !head) {
        Hud.removeLivePopo(1);
        }

        setToDestroy = true;
        }

@Override
public void hitOnHead(Nana nana, boolean head) {
        if (!setToDestroy && head) {
        Hud.addScore(100, Foca.class, false);
        Hud.addScoreNana(100);
        } else if (!setToDestroy && !head) {
        Hud.removeLiveNana(1);
        }
        setToDestroy = true;
        }
        }
