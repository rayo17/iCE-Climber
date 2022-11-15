package com.client.main.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.client.main.mainClient;
import com.client.main.windows.menuScreen;
import com.client.main.Apparition.Opponents.*;
import com.client.main.Apparition.Elements.Carrot;
import com.client.main.Apparition.Elements.Onion;
import com.client.main.Apparition.Elements.Pumpkin;
import com.client.main.Apparition.Objects.Brick;


/**
 * La clase data dibuja los datos necesrios para el juego en pantalla (vidas y puntuacion de jugadores)*/
public class Data implements Disposable{

    public Stage stage;

    private Viewport viewport;

    private static int Popo_Score;
    private static int Nana_Score;
    private static int Popo_Lifes;
    private static int Nana_Lifes;
    public static int Pumpkin_Score;
    public static int Onion_Score;
    public static int Carrot_Score;
    public static int Bird_Score;
    public static int Bear_Score;
    public static int Yeti_Score;
    public static int Seal_Score;
    public static int Tero_Score;
    public static int Pumpkin_Score2;
    public static int Onion_Score2;
    public static int Carrot_Score2;
    public static int Bird_Score2;
    public static int Bear_Score2;
    public static int Yeti_Score2;
    public static int Seal_Score2;
    public static int Tero_Score2;
    public static int Brick_Score;
    public static int Brick_Score2;

    private static Label Total_Score_Lable1;
    private static Label Total_Score_Lable2;
    private static Label Popo_Score_Label;
    private static Label Nana_Score_Label;
    private static Label Popo_Lifes_Label;
    private static Label Nana_Lifes_Label;
    private static Label Pumpkin_Score_Label;
    private static Label Onion_Score_Label;
    private static Label Carrot_Score_Label;
    private static Label Bird_Score_Label;
    private static Label Bear_Score_Label;
    private static Label Yeti_Score_Label;
    private static Label Seal_Score_Label;
    private static Label Tero_Score_Label;
    private static Label Pumpkin_Score_Label2;
    private static Label Onion_Score_Label2;
    private static Label Carrot_Score_Label2;
    private static Label Bird_Score_Label2;
    private static Label Bear_Score_Label2;
    private static Label Yeti_Score_Label2;
    private static Label Seal_Score_Label2;
    private static Label Tero_Score_Label2;
    private static Label Brick_Score_Label;
    private static Label Brick_Score_Label2;

    private Label Total;
    private Label Total2;
    private Label Pumpkin_Label;
    private Label Onion_Label;
    private Label Carrot_Label;
    private Label Bird_Label;
    private Label Bear_Label;
    private Label Yeti_Label;
    private Label Seal_Label;
    private Label Tero_Label;
    private Label Pumpkin_Label2;
    private Label Onion_Label2;
    private Label Carrot_Label2;
    private Label Bird_Label2;
    private Label Bear_Label2;
    private Label Yeti_Label2;
    private Label Seal_Label2;
    private Label Tero_Label2;
    private Label Score_Label;
    private Label Score_Label2;
    private Label Lifes_Label;
    private Label Lifes_Label2;
    private Label Popo_Label;
    private Label Nana_Label;
    private Label Space_Label;
    private Label Brick;
    private Label Brick2;

    public boolean GameOver;

    /**
     * Constructor
     * @param SB este es el sprite batch en donde se dibuja los labes de los datos*/

    public Data(SpriteBatch SB){
        this.GameOver = false;
        Popo_Score = 0;
        Nana_Score = 0;
        Popo_Lifes = 5;
        Nana_Lifes = 5;
        Pumpkin_Score = 0;
        Onion_Score = 0;
        Carrot_Score = 0;
        Bird_Score = 0;
        Bear_Score = 0;
        Yeti_Score = 0;
        Seal_Score = 0;
        Tero_Score = 0;
        Pumpkin_Score2 = 0;
        Onion_Score2 = 0;
        Carrot_Score2 = 0;
        Bird_Score2 = 0;
        Bear_Score2 = 0;
        Yeti_Score2 = 0;
        Seal_Score2 = 0;
        Tero_Score2 = 0;

        viewport = new FitViewport(mainClient.GWIDTH, mainClient.GHEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, SB);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        Popo_Score_Label = new Label(String.format("%06d", Popo_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Nana_Score_Label = new Label(String.format("%06d", Nana_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Popo_Lifes_Label = new Label(String.format("%01d", Popo_Lifes), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Nana_Lifes_Label = new Label(String.format("%01d", Nana_Lifes), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Pumpkin_Score_Label = new Label(String.format("%05d", Pumpkin_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Onion_Score_Label = new Label(String.format("%05d", Onion_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Carrot_Score_Label = new Label(String.format("%05d", Carrot_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Bird_Score_Label = new Label(String.format("%05d", Bird_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Bear_Score_Label = new Label(String.format("%05d", Bear_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Seal_Score_Label = new Label(String.format("%05d", Seal_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Tero_Score_Label = new Label(String.format("%05d", Tero_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Bird_Score_Label = new Label(String.format("%05d", Bird_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Yeti_Score_Label = new Label(String.format("%05d", Yeti_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Pumpkin_Score_Label2 = new Label(String.format("%05d", Pumpkin_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Onion_Score_Label2 = new Label(String.format("%05d", Onion_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Carrot_Score_Label2 = new Label(String.format("%05d", Carrot_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Bird_Score_Label2 = new Label(String.format("%05d", Bird_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Bear_Score_Label2 = new Label(String.format("%05d", Bear_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Seal_Score_Label2 = new Label(String.format("%05d", Seal_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Tero_Score_Label2 = new Label(String.format("%05d", Tero_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Bird_Score_Label2 = new Label(String.format("%05d", Bird_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Yeti_Score_Label2 = new Label(String.format("%05d", Yeti_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Total_Score_Lable1 = new Label(String.format("%06d", Popo_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Total_Score_Lable2 = new Label(String.format("%06d", Nana_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Brick_Score_Label = new Label(String.format("%06d", Brick_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Brick_Score_Label2 = new Label(String.format("%06d", Brick_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        Popo_Label = new Label("POPO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Nana_Label = new Label("NANA", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Lifes_Label = new Label("LIVES", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Lifes_Label2 = new Label("LIVES", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Score_Label = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Score_Label2 = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Space_Label = new Label("     ", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Pumpkin_Label = new Label("PUMPKINS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Carrot_Label = new Label("CARROTS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Onion_Label = new Label("ONIONS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Bird_Label = new Label("BIRDS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Bear_Label = new Label("BEARS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Yeti_Label = new Label("YETIS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Seal_Label = new Label("SEALS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Tero_Label = new Label("TEROS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Pumpkin_Label2 = new Label("PUMPKINS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Carrot_Label2 = new Label("CARROTS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Onion_Label2 = new Label("ONIONS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Bird_Label2 = new Label("BIRDS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Bear_Label2 = new Label("BEARS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Yeti_Label2 = new Label("YETIS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Seal_Label2 = new Label("SEALS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Tero_Label2 = new Label("TEROS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Total = new Label("TOTAL", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Total2 = new Label("TOTAL", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Brick = new Label("BRICKS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Brick2 = new Label("BRICKS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        if (menuScreen.players == 1){
            table.add(Popo_Label).expandX().padTop(10);
            table.add(Lifes_Label).expandX().padTop(10);
            table.row();
            table.add(Popo_Score_Label).expandX();
            table.add(Popo_Lifes_Label).expandX();
        }
        else {
            table.add(Popo_Label).expandX().padTop(10);
            table.add(Lifes_Label).expandX().padTop(10);
            table.add(Nana_Label).expandX().padTop(10);
            table.add(Lifes_Label2).expandX().padTop(10);
            table.row();
            table.add(Popo_Score_Label).expandX();
            table.add(Popo_Lifes_Label).expandX();
            table.add(Nana_Score_Label).expandX();
            table.add(Nana_Lifes_Label).expandX();
        }
        stage.addActor(table);


    }

    public void GameOverData(){
        Table table = new Table();
        table.top();
        table.setFillParent(true);

        if (menuScreen.players == 1){
            table.add(Popo_Label).expandX().padTop(10);

            table.row();
            table.add(Brick).expandX().padTop(10);
            table.add(Brick_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Lifes_Label).expandX().padTop(10);
            table.add(Popo_Lifes_Label).expandX().padTop(10);

            table.row();
            table.add(Pumpkin_Label).expandX().padTop(10);
            table.add(Pumpkin_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Onion_Label).expandX().padTop(10);
            table.add(Onion_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Carrot_Label).expandX().padTop(10);
            table.add(Carrot_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Bird_Label).expandX().padTop(10);
            table.add(Bird_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Bear_Label).expandX().padTop(10);
            table.add(Bear_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Seal_Label).expandX().padTop(10);
            table.add(Seal_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Yeti_Label).expandX().padTop(10);
            table.add(Yeti_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Tero_Label).expandX().padTop(10);
            table.add(Tero_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Carrot_Label).expandX().padTop(10);
            table.add(Carrot_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Total).expandX().padTop(10);
            table.add(Popo_Score_Label).expandX().padTop(10);
        }
        else {
            table.add(Popo_Label).expandX().padTop(10);
            table.add(Space_Label).expandX().padTop(10);
            table.add(Nana_Label).expandX().padTop(10);

            table.row();
            table.add(Brick).expandX().padTop(10);
            table.add(Brick_Score_Label).expandX().padTop(10);
            table.add(Brick2).expandX().padTop(10);
            table.add(Brick_Score_Label2).expandX().padTop(10);


            table.row();
            table.add(Pumpkin_Label).expandX().padTop(10);
            table.add(Pumpkin_Score_Label).expandX().padTop(10);
            table.add(Pumpkin_Label2).expandX().padTop(10);
            table.add(Pumpkin_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Onion_Label).expandX().padTop(10);
            table.add(Onion_Score_Label).expandX().padTop(10);
            table.add(Onion_Label2).expandX().padTop(10);
            table.add(Onion_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Carrot_Label).expandX().padTop(10);
            table.add(Carrot_Score_Label).expandX().padTop(10);
            table.add(Carrot_Label2).expandX().padTop(10);
            table.add(Carrot_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Bird_Label).expandX().padTop(10);
            table.add(Bird_Score_Label).expandX().padTop(10);
            table.add(Bird_Label2).expandX().padTop(10);
            table.add(Bird_Score_Label2).expandX().padTop(10);


            table.row();
            table.add(Bear_Label).expandX().padTop(10);
            table.add(Bear_Score_Label).expandX().padTop(10);
            table.add(Bear_Label2).expandX().padTop(10);
            table.add(Bear_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Seal_Label).expandX().padTop(10);
            table.add(Seal_Score_Label).expandX().padTop(10);
            table.add(Seal_Label2).expandX().padTop(10);
            table.add(Seal_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Yeti_Label).expandX().padTop(10);
            table.add(Yeti_Score_Label).expandX().padTop(10);
            table.add(Yeti_Label2).expandX().padTop(10);
            table.add(Yeti_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Tero_Label).expandX().padTop(10);
            table.add(Tero_Score_Label).expandX().padTop(10);
            table.add(Tero_Label2).expandX().padTop(10);
            table.add(Tero_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Carrot_Label).expandX().padTop(10);
            table.add(Carrot_Score_Label).expandX().padTop(10);
            table.add(Carrot_Label2).expandX().padTop(10);
            table.add(Carrot_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Total).expandX().padTop(10);
            table.add(Popo_Score_Label).expandX().padTop(10);
            table.add(Total2).expandX().padTop(10);
            table.add(Nana_Score_Label).expandX().padTop(10);
        }
        stage.clear();
        stage.addActor(table);
    }

    public static void addScore(int value, Class<?> type, boolean Popo){
        if (Popo){
            if (type == Onion.class) {
                Onion_Score += value;
                Onion_Score_Label.setText(String.format("%05d", Onion_Score));
            } else if (type == Carrot.class) {
                Carrot_Score += value;
                Carrot_Score_Label.setText(String.format("%05d", Carrot_Score));
            } else if (type == Pumpkin.class) {
                Pumpkin_Score += value;
                Pumpkin_Score_Label.setText(String.format("%05d", Pumpkin_Score));
            } else if (type == Bear.class) {
                Bear_Score += value;
                Bear_Score_Label.setText(String.format("%05d", Bear_Score));
            } else if (type == Seal.class) {
                Seal_Score += value;
                Seal_Score_Label.setText(String.format("%05d", Seal_Score));
            } else if (type == Bird.class) {
                Bird_Score += value;
                Bird_Score_Label.setText(String.format("%05d", Bird_Score));
            } else if (type == Yeti.class) {
                Yeti_Score += value;
                Yeti_Score_Label.setText(String.format("%05d", Yeti_Score));
            } else if (type == Pterodactyl.class) {
                Tero_Score += value;
                Tero_Score_Label.setText(String.format("%05d", Tero_Score));
            } else if (type == Brick.class) {
                Brick_Score += value;
                Brick_Score_Label.setText(String.format("%05d", Brick_Score));
            }
        }
        else {
            if (type == Onion.class) {
                Onion_Score2 += value;
                Onion_Score_Label2.setText(String.format("%05d", Onion_Score2));
            } else if (type == Carrot.class) {
                Carrot_Score2 += value;
                Carrot_Score_Label2.setText(String.format("%05d", Carrot_Score2));
            } else if (type == Pumpkin.class) {
                Pumpkin_Score2 += value;
                Pumpkin_Score_Label2.setText(String.format("%05d", Pumpkin_Score2));
            } else if (type == Bear.class) {
                Bear_Score2 += value;
                Bear_Score_Label2.setText(String.format("%05d", Bear_Score2));
            } else if (type == Seal.class) {
                Seal_Score2 += value;
                Seal_Score_Label2.setText(String.format("%05d", Seal_Score2));
            } else if (type == Bird.class) {
                Bird_Score2 += value;
                Bird_Score_Label2.setText(String.format("%05d", Bird_Score2));
            } else if (type == Yeti.class) {
                Yeti_Score2 += value;
                Yeti_Score_Label2.setText(String.format("%05d", Yeti_Score2));
            } else if (type == Pterodactyl.class) {
                Tero_Score2 += value;
                Tero_Score_Label2.setText(String.format("%05d", Tero_Score2));
            } else if (type == Brick.class) {
                Brick_Score2 += value;
                Brick_Score_Label2.setText(String.format("%05d", Brick_Score2));
            }
        }
    }

    public static int getPopo_Lifes(){
        return Popo_Lifes;
    }
    public static int getNana_Lifes(){
        return Nana_Lifes;
    }
    public static void addScorePopo(int value){
        Popo_Score += value;
        Popo_Score_Label.setText(String.format("%06d", Popo_Score));
    }
    public static void addScoreNana(int value) {
        Nana_Score += value;
        Nana_Score_Label.setText(String.format("%06d", Nana_Score));
    }

    public static void removeLivePopo(int value) {
        Popo_Lifes -= value;
        Popo_Lifes_Label.setText(String.format("%01d", Popo_Lifes));
    }

    public static void removeLiveNana(int value) {
        Nana_Lifes -= value;
        Nana_Lifes_Label.setText(String.format("%01d", Nana_Lifes));
    }

    public void dispose(){
        stage.dispose();
    }

}
