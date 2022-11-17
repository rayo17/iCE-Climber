package com.client.main.Gadgets;
import com.badlogic.gdx.physics.box2d.*;
import com.client.main.mainClient;
import com.client.main.Sprites.Enemies.Enemy;
import com.client.main.Sprites.Elements.Fruit;
import com.client.main.Sprites.Characters.Nana;
import com.client.main.Sprites.Characters.Popo;
//import com.client.main.Sprites.TileObjects.InteractiveTileObject;

public class WorldContactListener implements ContactListener{
    @Override
    public void beginContact(Contact contact) {
        Fixture fixt_A = contact.getFixtureA();
        Fixture fixt_B = contact.getFixtureB();

        int CDef = fixt_A.getFilterData().categoryBits | fixt_B.getFilterData().categoryBits;
        if (fixt_A.getUserData() == "head" || fixt_B.getUserData() == "head"){
            Fixture head = fixt_A.getUserData() == "head" ? fixt_A : fixt_B;
            Fixture objt = head == fixt_A ? fixt_B : fixt_A;
            if (objt.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(objt.getUserData().getClass())){
                if (objt.getUserData() instanceof Popo){
                    ((InteractiveTileObject) objt.getUserData()).onHeadHit(true);
                }
                else {
                    ((InteractiveTileObject) objt.getUserData()).onHeadHit(false);
                }
            }
        }
        //Coliciones
        switch (CDef){
            //Caso donde se encuentre el jugador y un bloque
            case mainClient.PLAYER_HEAD_BIT | mainClient.BRICK_BIT:
                if (fixt_A.getFilterData().categoryBits == mainClient.PLAYER_HEAD_BIT){
                    if (fixt_A.getUserData() instanceof Popo){
                        ((InteractiveTileObject) fixt_B.getUserData()).onHeadHit(true);
                    } else if (fixt_A.getUserData() instanceof Nana) {
                        ((InteractiveTileObject) fixt_B).onHeadHit(false);
                    }
                }
                else {
                    if (fixt_B.getUserData() instanceof Popo){
                        ((InteractiveTileObject) fixt_A.getUserData()).onHeadHit(true);
                    } else if (fixt_B.getUserData() instanceof Nana) {
                        ((InteractiveTileObject) fixt_A.getUserData()).onHeadHit(false);
                    }
                }
                break;

            //Caso entre la cabeza del enemigo y el jugador
            case mainClient.ENEMY_HEAD_BIT | mainClient.PLAYER_BIT:
                if (fixt_A.getFilterData().categoryBits == mainClient.ENEMY_HEAD_BIT)

                    if (fixt_A.getUserData() instanceof Enemy) {
                        if (fixt_B.getUserData() instanceof Popo) {
                            ((Enemy) fixt_A.getUserData()).hitOnHead((Popo) fixt_B.getUserData(), true);
                        } else {
                            ((Enemy) fixt_A.getUserData()).hitOnHead((Nana) fixt_B.getUserData(), true);
                        }

                    } else if (fixt_B.getUserData() instanceof Enemy) {
                        if (fixt_A.getUserData() instanceof Popo) {
                            ((Enemy) fixt_B.getUserData()).hitOnHead((Popo) fixt_A.getUserData(), true);
                        } else {
                            ((Enemy) fixt_B.getUserData()).hitOnHead((Nana) fixt_A.getUserData(), true);
                        }

                    }

                break;

            //Caso de colision enemigo y jugador
            case mainClient.PLAYER_BIT | mainClient.ENEMY_BIT:
                if (fixt_A.getUserData() instanceof Enemy) {
                    if (fixt_B.getUserData() instanceof Popo) {
                        ((Popo) fixt_B.getUserData()).hit((Enemy) fixt_A.getUserData());
                    } else if (fixt_B.getUserData() instanceof Nana) {
                        ((Nana) fixt_B.getUserData()).hit((Enemy) fixt_A.getUserData());
                    }

                } else if (fixt_B.getUserData() instanceof Enemy) {
                    if (fixt_A.getUserData() instanceof Popo) {
                        ((Popo) fixt_A.getUserData()).hit((Enemy) fixt_B.getUserData());
                    } else if (fixt_B.getUserData() instanceof Nana) {
                        ((Nana) fixt_A.getUserData()).hit((Enemy) fixt_B.getUserData());
                    }
                }
                break;

            // Caso ed colision entre un jugador y una fruta
            case mainClient.FRUIT_BIT | mainClient.PLAYER_BIT:
                if (fixt_A.getUserData() instanceof Fruit) {
                    if (fixt_B.getUserData() instanceof Popo) {
                        ((Fruit) fixt_A.getUserData()).use(true);
                    } else if (fixt_B.getUserData() instanceof Nana) {
                        ((Fruit) fixt_A.getUserData()).use(false);
                    }
                } else if (fixt_B.getUserData() instanceof Fruit) {
                    if (fixt_A.getUserData() instanceof Popo) {
                        ((Fruit) fixt_B.getUserData()).use(true);
                    } else if (fixt_A.getUserData() instanceof Nana) {
                        ((Fruit) fixt_B.getUserData()).use(false);
                    }
                }
                break;
        }
    }

    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
