package com.client.main.Gadgets;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.client.main.mainClient;
import com.client.main.windows.GameScreen;
//import com.client.main.Sprites.

public class B2WorldCreator {
    public B2WorldCreator(GameScreen screen){
        World world = screen.getWorld();
        TiledMap mapa = screen.getMap();
        BodyDef bDef =new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fDef = new FixtureDef();
        Body body;

        // creacion de los cuerpo y demas accesorios
        for (MapObject object : mapa.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rectan = ((RectangleMapObject) object).getRectangle();
            bDef.type = BodyDef.BodyType.StaticBody;
            bDef.position.set((rectan.getX() + rectan.getWidth() / 2) / mainClient.PPM, (rectan.getY() + rectan.getHeight() / 2) / mainClient.PPM);
            body = world.createBody(bDef);
            shape.setAsBox(rectan.getWidth() / 2 / mainClient.PPM, rectan.getHeight() / 2 / mainClient.PPM);
            fDef.shape = shape;
            body.createFixture(fDef);
        }

        // crea cuerpo de los bricks y sus accesorios
        for (MapObject object : mapa.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rectang = ((RectangleMapObject) object).getRectangle();
            new Brick(screen, rectang);
        }
    }
}
