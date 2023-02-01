package com.mygdx.game.screen;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Tools.MyTextInputListener;
import com.mygdx.game.Tools.Point2D;
import com.mygdx.game.sprites.Ameba;
import com.mygdx.game.sprites.Protozoa;

import java.awt.Color;
import java.util.Random;

public class PlayScreen implements Screen {
    MyTextInputListener text;
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

    private ImageButton button1;
    private Texture myTexture2;

    private ImageButton button2;
    private Texture myTexture3;
    private ImageButton button3;
   private ImageButton buttonsetting;
   private Texture myTexture4;
    private ImageButton buttonback;
    private Texture myTexture5;
    private Texture eat;
    private Texture cycle;
    private ImageButton btcycle;
    private ImageButton chooseam;
    private ImageButton btsetting1;
    private ImageButton btsetting2;
    OrthographicCamera camera;
  //int b=0;
    int x,y,q=0;double dx,dy;
    Point2D point2D=new Point2D(x,y,speed);
    Ameba ameba= new Ameba(10,10,50,50);
    int width=50,height=50;
    Protozoa prot = new Protozoa(sprite,point2D,speed);
    //конструктор
    int xe,ye;
    int m;int n=0,c=0;
    BitmapFont font=new BitmapFont();
    String cycle1="1";
    private Texture one;
    private Texture two;
    private Texture three;
    private Texture four;
    String b=new String();
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
        one= new Texture(Gdx.files.internal("one.jpg"));
        two= new Texture(Gdx.files.internal("two.jpg"));
        three= new Texture(Gdx.files.internal("three.jpg"));
        four= new Texture(Gdx.files.internal("four.jpg"));
        myTexture3 = new Texture(Gdx.files.internal("выборамеб.png"));
        vector = new Vector2();
        amebas=new Array<Ameba>();
        spawn();
        int x=50,y=0;
        eat=new Texture(Gdx.files.internal("food.png")); stage = new Stage(new ScreenViewport());
// b = new String();
        //кнопка с изображением
        myTexture = new Texture(Gdx.files.internal("imbutton1.png"));
        button1 = new ImageButton(new TextureRegionDrawable(myTexture)); //Set the button up
        button1.setPosition(0,0);
        //Set up a stage for the ui
        stage.addActor(button1); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage);

        //функционал кнопки
       button1.addListener(new ClickListener(){
           public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

               myTexture3 = new Texture(Gdx.files.internal("выборамеб.png"));
               button3 = new ImageButton(new TextureRegionDrawable(myTexture3));
               button3.setPosition(0,140);
               stage.addActor(button3);
               button3.addListener(new ClickListener(){
                   @Override
                   public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                       m++;
                      // MyTextInputListener listener = new MyTextInputListener();
                       //Gdx.input.getTextInput(listener,"количество амеб",b,"введите количество амёб",Input.OnscreenKeyboardType.NumberPad);
                     // String b = toString();
                      // if(b==null)return;

                       q=m*5;
                       xe=MathUtils.random(0,2000);
                       ye=MathUtils.random(0,2000);

                       return true;
                   }
                   @Override
                   public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                      // spawn();
                      // m=Integer.parseInt(b.trim());
                   }
               });
               myTexture3 = new Texture(Gdx.files.internal("выборамеб.png"));
               chooseam = new ImageButton(new TextureRegionDrawable(myTexture3));
               chooseam.setPosition(330,140);
               stage.addActor(chooseam);
               chooseam.addListener(new ClickListener(){
                   public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                       m=MathUtils.random(5,10);
                       // MyTextInputListener listener = new MyTextInputListener();
                       //Gdx.input.getTextInput(listener,"количество амеб",b,"введите количество амёб",Input.OnscreenKeyboardType.NumberPad);
                       // String b = toString();
                       // if(b==null)return;

                       q=m*5;
                       xe=MathUtils.random(0,2000);
                       ye=MathUtils.random(0,2000);

                       return true;
                   }
               });



               return true;
           }
           @Override
           public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
               //spawn();

           }
       });
      // вторая кнопка
        myTexture2 = new Texture(Gdx.files.internal("button2.png"));
        button2= new ImageButton(new TextureRegionDrawable(myTexture2));
        button2.setPosition(400,0);
        stage.addActor(button2);
        Gdx.input.setInputProcessor(stage);
        button2.addListener(new ClickListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                spawn();

            }
        });
        myTexture4= new Texture(Gdx.files.internal("setting.png"));
        buttonsetting=new ImageButton(new TextureRegionDrawable(myTexture4));
        buttonsetting.setPosition(0,1000);
        stage.addActor(buttonsetting);
        buttonsetting.addListener(new ClickListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                btsetting1=new ImageButton(new TextureRegionDrawable(myTexture3));
                btsetting1.setPosition(130,1000);
                stage.addActor(btsetting1);
                btsetting1.addListener(new ClickListener(){
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        n=1;
                        return true;
                    }
                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    }
                });
                btsetting2=new ImageButton(new TextureRegionDrawable(myTexture3));
                btsetting2.setPosition(230,1000);
                stage.addActor(btsetting2);

                btsetting2.addListener(new ClickListener(){
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        n=0;
                        return true;
                    }
                    @Override
                    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    }
                });
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });
        myTexture5=new Texture(Gdx.files.internal("back.png"));
        buttonback = new ImageButton(new TextureRegionDrawable(myTexture5));
        buttonback.setPosition(2150,960);
        stage.addActor(buttonback);
        buttonback.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
m=0;width=50;height=50;
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //stage.addActor(button1);
                //stage.addActor(button2);
            }
        });
     cycle = new Texture(Gdx.files.internal("циклы.png"));

        btcycle = new ImageButton(new TextureRegionDrawable(cycle)); //Set the button up
        btcycle.setPosition(950,920);
        stage.addActor(btcycle);
        btcycle.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });
        /*button2.setPosition(1200,0);stage.addActor(button2);
        button2.setPosition(1600,0);stage.addActor(button2);
        button2.setPosition(2000,0);stage.addActor(button2);
        button2.setPosition(2400,0);stage.addActor(button2);*/
    }


//метод отвечающий за рисовку
    @Override
    public void render(float delta) {

      if(n==0){ Gdx.gl.glClearColor(1, 1, 1, 1);}
        if(n==1){ Gdx.gl.glClearColor(0, 0, 0, 0);}
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        MyGdxGame.batch.begin();
        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage.draw();
        //while(c==0){ MyGdxGame.batch.draw(one,1200,935);}
       // while(c==1){ MyGdxGame.batch.draw(one,1200,935);}
       // if(c==2){ MyGdxGame.batch.draw(one,1200,935);}
       // if(c==3){ MyGdxGame.batch.draw(one,1200,935);}
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


//int m=Integer.parseInt(b.trim());
       // int m=8;
        if(c==0) font.draw(MyGdxGame.batch,cycle1, 1250, 1008);
        if(c==1)font.draw(MyGdxGame.batch,"2",1255,1008);
        if(c==2)font.draw(MyGdxGame.batch,"3",1260,1008);
        if(c==3)font.draw(MyGdxGame.batch,"4",1265,1008);
       // try {
        //    m=Integer.parseInt(b);
       // }catch (NumberFormatException e){

        // if ( time1 >6000) { evolution();time=0;}

        for(int i = 0; i<m; i++){
            if(TimeUtils.millis()-lastDropTime>60000){evolution();spawn();c++; }
        // for(Ameba ameba1:amebas) {
         x=MathUtils.random(0,2000);
         y=MathUtils.random(0,2000);

         if(x<dx && y<dy){
             MyGdxGame.batch.draw(ameba.img, x, y,width,height);//отрисовка амебы
             MyGdxGame.batch.draw(eat,xe,ye,25,25);

                 x += 1;
                 y += 1;
             }
         else if(x>dx && y>dy){
             MyGdxGame.batch.draw(ameba.img, x, y,width,height);//отрисовка амебы
             MyGdxGame.batch.draw(eat,xe,ye,25,25);

                 x -= 1;
                 y -= 1;
            // ухй
         }
         if(x>dx && y<dy){
             MyGdxGame.batch.draw(ameba.img, x, y,width,height);//отрисовка амебы
             MyGdxGame.batch.draw(eat,xe,ye,25,25);

                 x += 1;
                 y += 1;
             }
         else if(x<dx && y>dy){
             MyGdxGame.batch.draw(ameba.img, x, y,width,height);//отрисовка амебы
             MyGdxGame.batch.draw(eat,xe,ye,25,25);

                 x -= 1;
                 y -= 1;

         }
        // spawn();
         move();
            // evolutionam();


     }

      //  for(int j=0;j<q;j++) {

           // MyGdxGame.batch.draw(eat,xe,ye,25,25);
         //   q--;

//}

        //MyGdxGame.batch.draw(Ameba.img,MyGdxGame.WIDTH/6,MyGdxGame.HEIGHT/4);

       // if(lastDropTime>1000000000) spawn();
        MyGdxGame.batch.end();
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
    private void spawn(){;
        x= MathUtils.random(0,1000);
        Ameba ameba1=new Ameba( x,1,50,50);
        amebas.add(ameba1);
        lastDropTime = TimeUtils.millis();
    }
    private void evolution(){
        double d = Math.random();
        if (d < 20) {
            speed = 1 + speed;
            width += 40;
            height += 40;
            m=m*2;
        }
        if (d >= 20) {
            speed = 1 + speed;
            width += 50;
            height += 50;
            m=m*2;
        }

    }
}
