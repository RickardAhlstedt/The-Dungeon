package com.ricky.dungeon.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.ricky.dungeon.world.World;


public class PlayState extends BasicGameState{

	int stateID = -1;
	
	float x, y;
	
	World world;
	
	public PlayState(int stateID) {
		this.stateID = stateID;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		world = new World(16, 16);
		world.init(gc, sbg);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//g.translate(x, y);
		world.render(gc, sbg, g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		world.update(gc, sbg, delta);
	}

	@Override
	public int getID() {
		return stateID;
	}

}
