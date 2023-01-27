package com.mygdx.game.screen;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Tools.Point2D;
import com.mygdx.game.sprites.Ameba;
import com.mygdx.game.sprites.Protozoa;
import com.mygdx.game.sprites.Sprite;

import java.util.Random;

public class PlayScreen implements Screen {
    MyGdxGame game;
    public Texture sprite;
    Random rand=new Random();
    public double speed=2;
    Vector2 vector= new Vector2();
 //public final Texture ameba;
    PlayScreen gam;
   // private Ameba ameba;
   // public int x= Gdx.input.getX(), y=Gdx.input.getY();
    public int roundTime = 0;
  //  public Texture background=new Texture();

    //прописать кнопку для настроек
   // Array<Ameba> arrayList;
    public PlayScreen(MyGdxGame game) {
     this.game=game;
        //this.game=game;
        //batch = new SpriteBatch();
        //.. stage = new PlayStage(new ScreenViewport());
      //  ameba = new Ameba(50, 300);
    }

    @Override
    public void show() {
vector = new Vector2();
       // Array<Ameba> amebas=new Array<Ameba>();


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        MyGdxGame.batch.begin();
        Ameba ameba=new Ameba(1,1);
//Protozoa protozoa= new Protozoa();


       int a = rand.nextInt(100) % 50 + 50; //генерация целого числа из диапозона -50 - +50 (вероятность)
       // a=new long[];

        float x=50, y=50;
        if (a <= 50) {
           // double c = Math.random();
            int c = rand.nextInt() % 50 + 50;

            vector.y = (float) (x * Math.cos(c) - y * Math.sin(c));
            vector.x = (float) (x * Math.sin(c) + y * Math.cos(c));
            //перерасчет вектора(в любое ранд напр)
        } else if (a >50) {
            //

            //поворот вектора на угол
            vector.x = (float) (x * Math.cos(a) - y * Math.sin(a));
            vector.y = (float) (x * Math.sin(a) + y * Math.cos(a));
        }
        speed=rand.nextInt(15);
        double dx = vector.x * speed;
        double dy = vector.y * speed;
        x += dx;
        y += dy;

        MyGdxGame.batch.draw(ameba.img,x,y);
        //MyGdxGame.batch.draw(Ameba.img,MyGdxGame.WIDTH/6,MyGdxGame.HEIGHT/4);
        MyGdxGame.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        //game.dispose();
    }
}
