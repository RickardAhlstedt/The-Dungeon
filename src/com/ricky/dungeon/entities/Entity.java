package com.ricky.dungeon.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import com.ricky.dungeon.world.World;

public class Entity {

	public float hp;
	public float x, y;
	public float width, height;
	public float dmg;
	Image entitySheet;
	World world;
	
	public Entity(float hp, float x, float y, World world) {
		this.hp = hp;
		this.x = x;
		this.y = y;
		this.world = world;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) {
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x += x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y += y;
	}

	public float getDmg() {
		return dmg;
	}

	public void setDmg(float dmg) {
		this.dmg = dmg;
	}
}
