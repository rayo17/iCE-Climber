package com.client.main.hud;
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
import com.client.main.Sprites.Elements.Banano;
import com.client.main.Sprites.Elements.Berenjenas;
import com.client.main.Sprites.Elements.Lechugas;
import com.client.main.Sprites.Elements.Naranja;
import com.client.main.Sprites.Enemies.Foca;
import com.client.main.Sprites.Enemies.Pajaro;
import com.client.main.Sprites.Enemies.Hielo;

import com.client.main.Sprites.Items.Brick;
import com.client.main.mainClient;
import com.client.main.windows.menuScreen;
import com.client.main.Sprites.Items.Brick;


/**
 * La clase Hud  se utiliza para dibujar en pantalla lo que coresponde a las vidas y el score de los jugadores
 */
public class Hud implements Disposable {
    public Stage stage;
    private Viewport viewport;


    private static int Popo_Score;
    private static int Nana_Score;
    private static int Popo_Lives;
    private static int Nana_Lives;
    public static int Lechuga_Score;
    public static int Naranja_Score;
    public static int Banano_Score;
    public static int Berenjena_Score;
    public static int Pajaro_Score;
    public static int Foca_Score;

    public static int Hielo_Score;
    public static int Lechuga_Score2;
    public static int Naranja_Score2;
    public static int Banano_Score2;
    public static int Berenjena_Score2;
    public static int Pajaro_Score2;
    public static int Foca_Score2;

    public static int Hielo_Score2;
    public static int Brick_Score;
    public static int Brick_Score2;



    private static Label Total_Score_Lable1;
    private static Label Total_Score_Lable2;
    private static Label Popo_Score_Label;
    private static Label Nana_Score_Label;
    private static Label Popo_Lives_Label;
    private static Label Nana_Lives_Label;
    private static Label Lechuga_Score_Label;
    private static Label Naranja_Score_Label;
    private static Label Banano_Score_Label;
    private static Label Berenjena_Score_Label;
    private static Label Pajaro_Score_Label;
    private static Label Foca_Score_Label;

    private static Label Hielo_Score_Label;
    private static Label Lechuga_Score_Label2;
    private static Label Naranja_Score_Label2;
    private static Label Banano_Score_Label2;
    private static Label Berenjena_Score_Label2;
    private static Label Pajaro_Score_Label2;
    private static Label Foca_Score_Label2;

    private static Label Hielo_Score_Label2;

    private static Label Brick_Score_Label;
    private static Label Brick_Score_Label2;


    private Label Total;
    private Label Total2;
    private Label Lechuga_Label;
    private Label Naranja_Label;
    private Label Banano_Label;
    private Label Berenjena_Label;
    private Label Pajaro_Label;
    private Label Foca_Label;

    private Label Hielo_Label;
    private Label Lechuga_Label2;
    private Label Naranja_Label2;
    private Label Banano_Label2;
    private Label Berenjena_Label2;
    private Label Pajaro_Label2;
    private Label Foca_Label2;

    private Label Hielo_Label2;

    private Label Score_Label;
    private Label Score_Label2;
    private Label Lives_Label;
    private Label Lives_Label2;
    private Label Popo_Label;
    private Label Nana_Label;
    private Label Space_Label;
    private Label Brick;
    private Label Brick2;

    public boolean GameOver;


    /**
     * Constructor de la clase
     *
     * @param sb es el sprite batch en el que se dibujan los labels de score,lives y sus respectivos valores
     */
    public Hud(SpriteBatch sb) {
        this.GameOver = false;
        Popo_Score = 0;
        Nana_Score = 0;
        Popo_Lives = 5;
        Nana_Lives = 5;
        Lechuga_Score = 0;
        Naranja_Score = 0;
        Banano_Score = 0;
        Berenjena_Score = 0;
        Pajaro_Score = 0;
        Foca_Score = 0;

        Hielo_Score = 0;
        Lechuga_Score2 = 0;
        Naranja_Score2 = 0;
        Banano_Score2 = 0;
        Berenjena_Score2 = 0;
        Pajaro_Score2 = 0;
        Foca_Score2 = 0;

        Hielo_Score2 = 0;
        Brick_Score = 0;
        Brick_Score2 = 0;



        viewport = new FitViewport(mainClient.WIDTH, mainClient.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);


        Popo_Score_Label = new Label(String.format("%06d", Popo_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Nana_Score_Label = new Label(String.format("%06d", Nana_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Popo_Lives_Label = new Label(String.format("%01d", Popo_Lives), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Nana_Lives_Label = new Label(String.format("%01d", Nana_Lives), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Lechuga_Score_Label = new Label(String.format("%05d", Lechuga_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Naranja_Score_Label = new Label(String.format("%05d", Naranja_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Banano_Score_Label = new Label(String.format("%05d", Banano_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Berenjena_Score_Label = new Label(String.format("%05d", Berenjena_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Pajaro_Score_Label = new Label(String.format("%05d", Pajaro_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Foca_Score_Label = new Label(String.format("%05d", Foca_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        Hielo_Score_Label = new Label(String.format("%05d", Hielo_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Lechuga_Score_Label2 = new Label(String.format("%05d", Lechuga_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Naranja_Score_Label2 = new Label(String.format("%05d", Naranja_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Banano_Score_Label2 = new Label(String.format("%05d", Banano_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Berenjena_Score_Label2 = new Label(String.format("%05d", Berenjena_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Pajaro_Score_Label2 = new Label(String.format("%05d", Pajaro_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Foca_Score_Label2 = new Label(String.format("%05d", Foca_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        Hielo_Score_Label2 = new Label(String.format("%05d", Hielo_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Total_Score_Lable1 = new Label(String.format("%06d", Popo_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Total_Score_Lable2 = new Label(String.format("%06d", Nana_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Brick_Score_Label = new Label(String.format("%06d", Brick_Score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Brick_Score_Label2 = new Label(String.format("%06d", Brick_Score2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));


        Popo_Label = new Label("POPO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Nana_Label = new Label("NANA", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Lives_Label = new Label("LIVES", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Lives_Label2 = new Label("LIVES", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Score_Label = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Score_Label2 = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Space_Label = new Label("     ", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Lechuga_Label = new Label("LECHUGAS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Naranja_Label = new Label("NARANJAS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Banano_Label = new Label("BANANOS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Berenjena_Label = new Label("BERENJENAS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Pajaro_Label = new Label("PAJAROS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Foca_Label = new Label("FOCAS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        Hielo_Label = new Label("HIELOS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Lechuga_Label2 = new Label("LECHUGAS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Naranja_Label2 = new Label("NARANJAS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Banano_Label2 = new Label("BANANOS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Berenjena_Label2 = new Label("BERENJENAS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Pajaro_Label2 = new Label("PAJAROS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Foca_Label2 = new Label("FOCAS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        Hielo_Label2 = new Label("HIELOS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Total = new Label("TOTAL", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Total2 = new Label("TOTAL", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Brick = new Label("BRICKS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Brick2 = new Label("BRICKS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));




        if (menuScreen.players == 1) {

            table.add(Popo_Label).expandX().padTop(10);
            table.add(Lives_Label).expandX().padTop(10);
            table.row();
            table.add(Popo_Score_Label).expandX();
            table.add(Popo_Lives_Label).expandX();

        } else {

            table.add(Popo_Label).expandX().padTop(10);
            table.add(Lives_Label).expandX().padTop(10);
            table.add(Nana_Label).expandX().padTop(10);
            table.add(Lives_Label2).expandX().padTop(10);
            table.row();
            table.add(Popo_Score_Label).expandX();
            table.add(Popo_Lives_Label).expandX();
            table.add(Nana_Score_Label).expandX();
            table.add(Nana_Lives_Label).expandX();

        }
        stage.addActor(table);

    }


    public void gameOverHud() {

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        if (menuScreen.players == 1) {
            table.add(Popo_Label).expandX().padTop(10);

            table.row();
            table.add(Brick).expandX().padTop(10);
            table.add(Brick_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Lives_Label).expandX().padTop(10);
            table.add(Popo_Lives_Label).expandX().padTop(10);

            table.row();
            table.add(Lechuga_Label).expandX().padTop(10);
            table.add(Lechuga_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Naranja_Label).expandX().padTop(10);
            table.add(Naranja_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Banano_Label).expandX().padTop(10);
            table.add(Banano_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Berenjena_Label).expandX().padTop(10);
            table.add(Berenjena_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Pajaro_Label).expandX().padTop(10);
            table.add(Pajaro_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Foca_Label).expandX().padTop(10);
            table.add(Foca_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Hielo_Label).expandX().padTop(10);
            table.add(Hielo_Score_Label).expandX().padTop(10);

            table.row();
            table.add(Total).expandX().padTop(10);
            table.add(Popo_Score_Label).expandX().padTop(10);
        } else {
            table.add(Popo_Label).expandX().padTop(10);
            table.add(Space_Label).expandX().padTop(10);
            table.add(Nana_Label).expandX().padTop(10);

            table.row();
            table.add(Brick).expandX().padTop(10);
            table.add(Brick_Score_Label).expandX().padTop(10);
            table.add(Brick2).expandX().padTop(10);
            table.add(Brick_Score_Label2).expandX().padTop(10);


            table.row();
            table.add(Lechuga_Label).expandX().padTop(10);
            table.add(Lechuga_Score_Label).expandX().padTop(10);
            table.add(Lechuga_Label2).expandX().padTop(10);
            table.add(Lechuga_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Naranja_Label).expandX().padTop(10);
            table.add(Naranja_Score_Label).expandX().padTop(10);
            table.add(Naranja_Label2).expandX().padTop(10);
            table.add(Naranja_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Banano_Label).expandX().padTop(10);
            table.add(Banano_Score_Label).expandX().padTop(10);
            table.add(Banano_Label2).expandX().padTop(10);
            table.add(Banano_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Berenjena_Label).expandX().padTop(10);
            table.add(Berenjena_Score_Label).expandX().padTop(10);
            table.add(Berenjena_Label2).expandX().padTop(10);
            table.add(Berenjena_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Pajaro_Label).expandX().padTop(10);
            table.add(Pajaro_Score_Label).expandX().padTop(10);
            table.add(Pajaro_Label2).expandX().padTop(10);
            table.add(Pajaro_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Foca_Label).expandX().padTop(10);
            table.add(Foca_Score_Label).expandX().padTop(10);
            table.add(Foca_Label2).expandX().padTop(10);
            table.add(Foca_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Hielo_Label).expandX().padTop(10);
            table.add(Hielo_Score_Label).expandX().padTop(10);
            table.add(Hielo_Label2).expandX().padTop(10);
            table.add(Hielo_Score_Label2).expandX().padTop(10);

            table.row();
            table.add(Total).expandX().padTop(10);
            table.add(Popo_Score_Label).expandX().padTop(10);
            table.add(Total2).expandX().padTop(10);
            table.add(Nana_Score_Label).expandX().padTop(10);
        }
        stage.clear();
        stage.addActor(table);

    }

    public static void addScore(int value, Class<?> type, boolean popo) {
        if (popo){
            if (type == Naranja.class) {
                Naranja_Score += value;
                Naranja_Score_Label.setText(String.format("%05d", Naranja_Score));
            } else if (type == Banano.class) {
                Banano_Score += value;
                Banano_Score_Label.setText(String.format("%05d", Banano_Score));
            } else if (type == Lechugas.class) {
                Lechuga_Score += value;
                Lechuga_Score_Label.setText(String.format("%05d", Lechuga_Score));
            }else if (type == Berenjenas.class) {
                Berenjena_Score += value;
                Berenjena_Score_Label.setText(String.format("%05d", Berenjena_Score));
            }else if (type == Foca.class) {
                Foca_Score += value;
                Foca_Score_Label.setText(String.format("%05d", Foca_Score));
            }else if (type == Pajaro.class) {
                Pajaro_Score += value;
                Pajaro_Score_Label.setText(String.format("%05d", Pajaro_Score));
            }else if (type == Hielo.class) {
                Hielo_Score += value;
                Hielo_Score_Label.setText(String.format("%05d", Hielo_Score));
            }else if (type == Brick.class) {
                Brick_Score += value;
                Brick_Score_Label.setText(String.format("%05d", Brick_Score));
            }
        } else {
            if (type == Naranja.class) {
                Naranja_Score2 += value;
                Naranja_Score_Label2.setText(String.format("%05d", Naranja_Score2));
            } else if (type == Banano.class) {
                Banano_Score2 += value;
                Banano_Score_Label2.setText(String.format("%05d", Banano_Score2));
            } else if (type == Lechugas.class) {
                Lechuga_Score2 += value;
                Lechuga_Score_Label2.setText(String.format("%05d", Lechuga_Score2));
            } else if (type == Berenjenas.class) {
                Berenjena_Score2 += value;
                Berenjena_Score_Label2.setText(String.format("%05d", Berenjena_Score2));
            }else if (type == Foca.class) {
                Foca_Score2 += value;
                Foca_Score_Label2.setText(String.format("%05d", Foca_Score2));
            } else if (type == Pajaro.class) {
                Pajaro_Score2 += value;
                Pajaro_Score_Label2.setText(String.format("%05d", Pajaro_Score2));
            } else if (type == Hielo.class) {
                Hielo_Score2 += value;
                Hielo_Score_Label2.setText(String.format("%05d", Hielo_Score2));
            } else if (type == Brick.class) {
                Brick_Score2 += value;
                Brick_Score_Label2.setText(String.format("%05d", Brick_Score2));
            }
        }


    }

    public static int getPopoLives() {
        return Popo_Lives;
    }

    public static int getNanaLives() {
        return Nana_Lives;
    }


    public static void addScorePopo(int value) {
        Popo_Score += value;
        Popo_Score_Label.setText(String.format("%06d", Popo_Score));
    }

    public static void addScoreNana(int value) {
        Nana_Score += value;
        Nana_Score_Label.setText(String.format("%06d", Nana_Score));
    }

    public static void removeLivePopo(int value) {
        Popo_Lives -= value;
        Popo_Lives_Label.setText(String.format("%01d", Popo_Lives));
    }

    public static void removeLiveNana(int value) {
        Nana_Lives -= value;
        Nana_Lives_Label.setText(String.format("%01d", Nana_Lives));
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
