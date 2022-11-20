package com.client.main.Sockets.jsonManager;
import com.badlogic.gdx.math.Vector2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.client.main.mainClient;
import com.client.main.windows.GameScreen;
import com.client.main.Sprites.Enemies.*;
import com.client.main.Sprites.Elements.Naranja;
import com.client.main.Sprites.Elements.FruitDef;
import com.client.main.Sprites.Elements.Banano;
import com.client.main.Sprites.Elements.Lechugas;
import com.client.main.Sprites.Elements.Berenjenas;


public class jsonHandler {
    public String jsonWriter(jsonFactory student) {
        Gson gson = null;
        if (student.getID() == null) {
            gson = new GsonBuilder()
                    .create();
        }
        else {
            gson = new Gson();
        }
        return gson.toJson(student);
    }
    public boolean jsonReader(String serverMessage, GameScreen gameScreen) {

        Gson gson = new Gson();

        jsonFactory message = gson.fromJson(serverMessage, jsonFactory.class);

        //System.out.println(message.getID());
        boolean facing = true;

        int items[] = message.getItems();

        if(gameScreen.host) {
            if (items[0] == 1 || items[0] == 2 || items[0] == 3 || items[0] == 4) {
                if (items[1] == 0) {
                    facing = false;
                }
            }
            if (items[0] == 1) {
                gameScreen.spawnEnemy(new EnemyDef(new Vector2(10, items[2]), Pajaro.class, facing));
            } else if (items[0] == 2) {
                gameScreen.spawnEnemy(new EnemyDef(new Vector2(10, items[2]), Foca.class, facing));
            } else if (items[0] == 3) {
                gameScreen.spawnEnemy(new EnemyDef(new Vector2(10, items[2]), Hielo.class, facing));
            } else if (items[0] == 4) {
                gameScreen.spawnFruit(new FruitDef(new Vector2(items[1] / mainClient.PPM, items[2]/ mainClient.PPM), Banano.class));
            } else if (items[0] == 5) {
                gameScreen.spawnFruit(new FruitDef(new Vector2(items[1] / mainClient.PPM, items[2]/ mainClient.PPM), Naranja.class));
            } else if (items[0] == 6) {
                gameScreen.spawnFruit(new FruitDef(new Vector2(items[1] / mainClient.PPM, items[2] / mainClient.PPM), Lechugas.class));
            } else if (items[0] == 7) {
                gameScreen.spawnFruit(new FruitDef(new Vector2(items[1] / mainClient.PPM, items[2] / mainClient.PPM), Berenjenas.class));
            }
        }
        //System.out.println(message.getLevel());

        return true;
    }
}
