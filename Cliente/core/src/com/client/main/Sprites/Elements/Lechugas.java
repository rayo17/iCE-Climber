package com.client.main.Sprites.Elements;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.client.main.mainClient;
import com.client.main.hud.Hud;
import com.client.main.windows.GameScreen;

public class Lechugas extends Fruit{
    public Lechugas(GameScreen screen, float x, float y) {
        super(screen, x, y);
        setRegion(screen.getFruitAtlas().findRegion("fruit"), 2, 21, 16, 16);
    }

    public void defFruit() {
        BodyDef BDef = new BodyDef();
        BDef.position.set(getX(), getY());
        BDef.type = BodyDef.BodyType.DynamicBody;
        this.b2body = world.createBody(BDef);

        FixtureDef FDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(8 / mainClient.PPM);

        FDef.filter.categoryBits = mainClient.FRUIT_BIT;
        FDef.filter.maskBits = mainClient.GROUND_BIT |
                mainClient.BRICK_BIT |

                mainClient.PLAYER_BIT;

        FDef.shape = shape;
        this.b2body.createFixture(FDef);
        this.b2body.createFixture(FDef).setUserData(this);
    }
    public void use(boolean Popo) {
        if (!this.toDestroy) {
            if (Popo) {
                Hud.addScore(400, Lechugas.class,true);
                Hud.addScorePopo(400);
            } else {
                Hud.addScore(400,Lechugas.class,false);
                Hud.addScoreNana(400);
            }
        }
        destroy();
    }
    public void update(float DT) {
        super.update(DT);
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);

    }
}
