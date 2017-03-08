package com.empty.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Core extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private OrthographicCamera camera;


	private ShaderProgram shader;
	private Sprite sprite;

	@Override
	public void create () {

		ShaderProgram.pedantic = false;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		batch = new SpriteBatch();
	
		img = new Texture(Gdx.files.internal("badlogic.jpg"));
		sprite = new Sprite(img);
		sprite.setSize(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() / 2);
		sprite.setPosition(100, 100);
		String one = Gdx.files.internal("Shaders/pass.vert").readString();
		shader = new ShaderProgram(Gdx.files.internal("Shaders/pass.vert"), Gdx.files.internal("Shaders/pass.frag"));
		System.out.println(one);

		System.out.println(shader.isCompiled() ? "Compiled successfully" : "Compiled with cancer:\n" + shader.getLog());
	}

	@Override
	public void render () {
		camera.update();
		batch.setProjectionMatrix(camera.combined);


		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setShader(shader);
		batch.begin();
		batch.draw(sprite, sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());	
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
