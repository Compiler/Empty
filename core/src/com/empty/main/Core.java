package com.empty.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.*;
public class Core extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private OrthographicCamera camera;

	private Sprite sprite;
	private ShapeRenderer render;

	@Override
	public void create () {

		ShaderProgram.pedantic = false;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		batch = new SpriteBatch();
	
		img = new Texture(Gdx.files.internal("badlogic.jpg"));
		sprite = new Sprite(img);

		render = new ShapeRenderer();
		render.setAutoShapeType(true);

	}

	@Override
	public void render () {
		//update
		camera.update();
		batch.setProjectionMatrix(camera.combined);


		//render
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		int incrementer = 25;
	
		render.begin();
		render.setColor(0.0f, 0.0f, 100.0f);
		for(int i = 0; i < Gdx.graphics.getWidth(); i+=incrementer){
			for(int k = 0; k < Gdx.graphics.getHeight(); k+=incrementer){
				render.rect(i, k, incrementer - 5, incrementer - 5);
			
			}
		}
		render.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
