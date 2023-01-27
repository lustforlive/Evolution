package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screen.Menu;
import com.mygdx.game.screen.PlayScreen;

public class MyGdxGame extends Game {
	public static SpriteBatch batch;
	public static Texture img;
	public static Texture background;
	public static Texture ameba;
	public static Texture playbutton;
	public static int WIDTH;
	public static int HEIGHT;
	public PlayScreen gam;
	public Menu menu;
	public static MyGdxGame game;

	@Override
	public void create () {

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		WIDTH= Gdx.graphics.getWidth();
		HEIGHT=Gdx.graphics.getHeight();
	//	background = new Texture("black.jpeg");
		playbutton = new Texture("button.png");
		ameba= new Texture("ameba1.png");
		//if (Gdx.input.justTouched()){
		menu=new Menu(this);
		gam= new PlayScreen(this) ;
			//setScreen(menu);
		setScreen(gam);
	}
	//}


	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
