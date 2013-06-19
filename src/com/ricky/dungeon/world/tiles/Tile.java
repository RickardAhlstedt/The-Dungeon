package com.ricky.dungeon.world.tiles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Tile {
	
	float x;
	float y;
	
	int tileX = 0;
	int tileY = 0;
	int width = 16;
	int height = 16;
	
	Image tileImage;
	public static boolean solid = false;
	
	public Tile(int tileX, int tileY, int width, int height) {
		this.tileX = tileX;
		this.tileY = tileY;
		this.width = width;
		this.height = height;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		tileImage = new Image("res/img/tileset_1bit.png").getSubImage(tileX, tileY, width, height);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public boolean isSolid() {
		return solid;
	}
	
	public void setSolid(boolean solid) {
		this.solid = solid;
	}
	
}
