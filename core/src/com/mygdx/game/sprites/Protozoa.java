package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Tools.Point2D;
import com.mygdx.game.Tools.Square;

import java.util.Random;

public class Protozoa extends Sprite{
    public static Random rand = new Random();
    public Vector2 vector = new Vector2(); // длина вектора равна 1(вектор нормализован)
    public static double speed;
    public int width;
    public int height;
    public Texture sprite;
    public static Point2D position;
    public static float R;
    Square bounds;
    public Protozoa(Texture sprite,Point2D p,double speed) {
        super(sprite);
        //super(sprite);
        // super(sprite);
        // super(actor);
       // super(sprite);
       // this.sprite= sprite;
        this.speed = speed;

        this.position = new Point2D(1,1,10);



        //this.R=R;
        this.bounds = new Square(position ,R);
        vector=new Vector2(0,0);

    }
}
