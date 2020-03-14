package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FlappyBird;
import com.mygdx.game.sprites.Bird;

public class GameOver extends State{
    private Texture background;
    private Texture gameover;

    private Bird bird;

    public GameOver(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        gameover= new Texture("gameover.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0,0, FlappyBird.WIDTH, FlappyBird.HEIGHT);
        sb.draw(gameover, 0,0);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        gameover.dispose();
    }
}
