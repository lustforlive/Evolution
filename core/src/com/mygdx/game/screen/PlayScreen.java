package com.mygdx.game.screen;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
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
  //  public Texture background=new Texture()
    //private Ameba ameba;
    private Array<Ameba> amebas;
    private long lastDropTime;
    private Stage stage;
    private Stage stage2;
    private Texture myTexture;
    private TextureRegion myTextureRegion;
    private TextureRegionDrawable myTexRegionDrawable;
    private ImageButton button;
    private Texture myTexture2;
    private TextureRegion myTextureRegion2;
    private TextureRegionDrawable myTexRegionDrawable2;
    private ImageButton button2;
    OrthographicCamera camera;
    int b=0;
    int x,y;double dx,dy;
    Point2D point2D=new Point2D(x,y,speed);
    Ameba ameba= new Ameba(10,10,50,50);
    int width=50,height=50;
    Protozoa prot = new Protozoa(sprite,point2D,speed);
    //конструктор
    public PlayScreen(MyGdxGame game) {
     this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, MyGdxGame.WIDTH,MyGdxGame.HEIGHT);
        //this.game=game;
        //batch = new SpriteBatch();
        //.. stage = new PlayStage(new ScreenViewport());
      //  ameba = new Ameba(50, 300);
        //кнопка

    }
//главный метод в котором мы задаем глобалным переменным в файле значения и тд
    @Override
    public void show() {

        vector = new Vector2();
        amebas=new Array<Ameba>();
        spawn();
        int x=50,y=0;
        //кнопка с изображением
        myTexture = new Texture(Gdx.files.internal("imbutton1.png"));
        myTextureRegion = new TextureRegion(myTexture,0,0,400,140);

        myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        button = new ImageButton(myTexRegionDrawable); //Set the button up

        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(button); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage);

        //функционал кнопки
       button.addListener(new ClickListener(){
           public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               b++;
               return true;
           }
           @Override
           public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
               //spawn();

           }
       });
      // вторая кнопка
    /*  myTexture2 = new Texture(Gdx.files.internal("button2.png"));
        myTextureRegion2 = new TextureRegion(myTexture2,-400,0,400+989,332);
        myTexRegionDrawable2= new TextureRegionDrawable(myTextureRegion2);
        button2 = new ImageButton(myTexRegionDrawable2); //Set the button up

        //stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(button2); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage);
        button2.addListener(new ClickListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                b++;
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                spawn();

            }
        });*/


    }


//метод отвечающий за рисовку
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        MyGdxGame.batch.begin();
        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage.draw();


     //   Ameba ameba=new Ameba(10,10,50,50);
//прописано движение
        int a = rand.nextInt(10) % 50 + 50; //генерация целого числа из диапозона -50 - +50 (вероятность)
        float x, y;

       /* if (a <= 5) {
            // double c = Math.random();
            int c = rand.nextInt(5) % 50 + 50;
            vector.y = (float) (x * Math.cos(c) - y * Math.sin(c));
            vector.x = (float) (x * Math.sin(c) + y * Math.cos(c));
            //перерасчет вектора(в любое ранд напр)
        } else if (a >5) {
            //поворот вектора на угол
            vector.x = (float) (x * Math.cos(a) - y * Math.sin(a));
            vector.y = (float) (x * Math.sin(a) + y * Math.cos(a));
        }
        speed=2;
        double dx = vector.x * speed;
        double dy = vector.y * speed;
        x += dx;
        y += dy;*/

       /*  double d = Math.random();
       if (d < 0.5) {
            speed = 5 + speed;
            width += 1;
            height += 1;
        }
        if (d >= 0.5) {
            speed = 1 + speed;
            width += 2;
            height += 2;
        }*/

//если б=1 то отрисовать амебу
 //if(b==1){
        if((TimeUtils.nanoTime() - lastDropTime)>600000){ evolution();b+=1;}

     for(int i=0;i<b;i++){
        // for(Ameba ameba1:amebas) {
         x=MathUtils.random(0,1000);
         y=MathUtils.random(0,1000);
             MyGdxGame.batch.draw(ameba.img, x, y,width,height);//отрисовка амебы
         if(x<dx && y<dy){

                 x += 1;
                 y += 1;
             }
         else if(x>dx && y>dy){

                 x -= 1;
                 y -= 1;

         }
         if(x>dx && y<dy){

                 x += 1;
                 y += 1;
             }
         else if(x<dx && y>dy){

                 x -= 1;
                 y -= 1;

         }
        // spawn();
         move();
            // evolutionam();


     }



       //  b--;
//}
 //}
        //MyGdxGame.batch.draw(Ameba.img,MyGdxGame.WIDTH/6,MyGdxGame.HEIGHT/4);
        MyGdxGame.batch.end();
       // if(lastDropTime>1000000000) spawn();
    }

    @Override
    public void resize(int width, int height) {

    }
//метод, который я создала движение, но он не работает, поэтому в рисовке он просто записан без метода
    public void move(){
        int a = rand.nextInt(10) % 50 + 50; //генерация целого числа из диапозона -50 - +50 (вероятность)
        // a=new long[];

        float x=10, y=10;
        if (a <= 5) {
            // double c = Math.random();
            int c = rand.nextInt(5) % 50 + 50;

            vector.y = (float) (x * Math.cos(c) - y * Math.sin(c));
            vector.x = (float) (x * Math.sin(c) + y * Math.cos(c));
            //перерасчет вектора(в любое ранд напр)
        } else if (a >5) {
            //

            //поворот вектора на угол
            x = (float) (x * Math.cos(a) - y * Math.sin(a));
            y = (float) (x * Math.sin(a) + y * Math.cos(a));
        }
        speed=2;
        double dx = vector.x * speed;
        double dy = vector.y * speed;
      /*  if(x<dx && y<dy){
        while(x<dx && y<dy){
            x += 1;
            y += 1;
        }}
         else if(x>dx && y>dy){
             while(x>dx && y>dy){
             x -= 1;
             y -= 1;
         }
         }
        if(x>dx && y<dy){
            while(x>dx && y<dy){
                x += 1;
                y += 1;
            }}
        else if(x<dx && y>dy){
            while(x<dx && y>dy){
                x -= 1;
                y -= 1;
            }
        }*/



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
    //метод который должен создавать амеб но чтото идет не так
    private void spawn(){lastDropTime = TimeUtils.millis();
        int x ;
        x= MathUtils.random(0,1000);
        Ameba ameba1=new Ameba( x,1,50,50);

        amebas.add(ameba1);



    }
    private void evolution(){
        //long m=

    //    if((TimeUtils.nanoTime() - lastDropTime)>600000){
        double d = Math.random();
        if (d < 0.5) {
            //speed = 1 + speed;
           //  width += 1;
            // height += 1;
        }
        if (d >= 0.5) {
           // speed = 1 + speed;
             width += 2;
             //height += 2;
        }
        //}
    }
}
