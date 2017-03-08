package com.empty.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class Core extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private OrthographicCamera camera;
	private ShapeRenderer renderer;
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		renderer = new ShapeRenderer();
		renderer.setAutoShapeType(true);

	}

	@Override
	public void render () {
		camera.update();
		renderer.setProjectionMatrix(camera.combined);


		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		renderer.begin();
		renderer.rect(0.0f, 0.0f, 100.0f, 100.0f);
		renderer.end();


	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
