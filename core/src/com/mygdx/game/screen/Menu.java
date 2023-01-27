package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.MyGdxGame;

public class Menu implements Screen {

    Menu menu;
    PlayScreen gam;
   public static MyGdxGame game;
    private Stage stage;
    private TextButton play;
    private TextButton exit;
    private Table table;
    private Label.LabelStyle labelStyle;

   // private final Texture background;
Skin skin;
    ImageButton playbt;
    String s="dfghj";

    public Menu(MyGdxGame game) {

        this.game = game;

       // skin=new Skin(FileHandle.tempFile("button.png"));
   // playbt = new ImageButton(skin);


        }


    @Override
    public void show() {gam = new PlayScreen(game) ;
       // game.setScreen(new PlayScreen(game));

        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {

                return true;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                return false;
            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.batch.begin();

        game.batch.draw(game.playbutton,MyGdxGame.WIDTH/6,MyGdxGame.HEIGHT/4);
       // game.batch.draw(background,0,0);

        game.batch.end();
    }
    public void update(float dt) {
        handleInput();

    }
    public  void handleInput() {

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

    }
}
