package com.ricky.dungeon.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import com.ricky.dungeon.DungeonGame;
import com.ricky.dungeon.world.World;

public class Player extends Entity {

	public Player(float x, float y, World world) {
		super(20, x, y, world);
		width = height = 16;
	}

	public void init(GameContainer gc, StateBasedGame sbg) {
		super.init(gc, sbg);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		super.render(gc, sbg, g);
		g.setColor(Color.black);
		g.fillRect(x, y, 16, 16);
		
		if (DungeonGame.debug) {
			g.setColor(Color.black);
			g.drawString("X: " + x + ", Y: " + y, 0, 0);
		}
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		super.update(gc, sbg, delta);
		Input input = gc.getInput();
		
		if(input.isKeyDown(input.KEY_UP)) {
			if(world.canMove(x, y-1)) {
				world.panCameraY(1);
				setY(-1);
			} else {
				return;
			}
		}
		if(input.isKeyDown(input.KEY_DOWN)) {
			if(world.canMove(x, y+1)) {
				world.panCameraY(-1);
				setY(1);
			} else {
				return;
			}
		}
		
		if(input.isKeyDown(input.KEY_LEFT)) {
			if(world.canMove(x-1, y)){
				world.panCameraX(1);
				setX(-1);
			} else {
				return;
			}
		}
		if(input.isKeyDown(input.KEY_RIGHT)) {
			world.panCameraX(-1);
			if(world.canMove(x+1, y))
				setX(1);
			else
				return;
		}
	}
	
	boolean validLocation(float newX, float newY) {
		if(world.blocked((newX - width), (newY - height))) {
			return false;
		}
		if(world.blocked((newX + width), (newY - height))) {
			return false;
		}
		if(world.blocked((newX - width), (newY + height))) {
			return false;
		}
		if(world.blocked((newX + width), (newY + height))) {
			return false;
		}
		
		return true;
	}
	
	public float getHP() {
		return hp;
	}
	
	public void setHP(float hp) {
		this.hp += hp;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x += x;
	}
	
	public void setY(float y) {
		this.y += y;
	}
	
}
