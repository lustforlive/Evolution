package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;


public class Ameba extends Protozoa{
   // ArrayList<Protozoa> arrayList;
    public Sprite ameba;
    long lastDropTime;
    //public Texture img;
    Array<Ameba> amebas;

    public Ameba(int x, int y) {
        super(new Texture("ameba1.png"),Protozoa.position,Protozoa.speed);
      //  Array<Protozoa> protozoa=new Array<Protozoa>();

        img = new Texture("ameba1.png");
        img.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        ameba = new Sprite(img);
    }
    /*public void spawnRaindrop() {
       // Array<Protozoa> protozoas=new Array<Protozoa>();
        Ameba ameba1 = new Ameba(1,1);
        //protozoa.x = MathUtils.random(0, 800-64);
        //protozoa.y = 480;
        //protozoa.width = 64;
       // protozoa.height = 64;
        amebas.add(ameba1);
        lastDropTime = TimeUtils.nanoTime();
    }*/
    public Ameba(Texture sprite) {
        super(sprite, position,speed);
          this.ameba = ameba;
    }
    public void update() {
        if (position.getX()+R > MyGdxGame.WIDTH)position.setX(MyGdxGame.WIDTH-R);
        if (position.getY() +R > MyGdxGame.HEIGHT)position.setY(MyGdxGame.HEIGHT-R);
        if (position.getX()+R <  0)position.setX(R);
        if (position.getY() +R < 0)position.setY(R);
        //position.move() ;
    }
    public void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(img,position.getX() ,position.getY());
        batch.end();
    }
}
