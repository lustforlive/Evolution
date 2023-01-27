package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GraphicsObj.GraphicsObj;

public class Sprite extends GraphicsObj {
    public double x;
    public double y;

    public Sprite(Texture sprite) {
        super(sprite);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }
}
