package com.ricky.dungeon.world.tiles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class FloorTile extends Tile {
	
	public FloorTile(float x, float y) {
		super(0, 0, 16, 16);
		this.x = x;
		this.y = y;
		solid = false;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		super.init(gc, sbg);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		super.render(gc, sbg, g);
		g.drawImage(tileImage, x, y);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		super.update(gc, sbg, delta);
	}
	
}
