package com.ricky.dungeon.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.RotateTransition;

import com.ricky.dungeon.DungeonGame;

public class MainMenuState extends BasicGameState{

	int stateID = -1;
	
	Image titleImage;
	
	String newGame = 	new String("1. Descend");
	String exitGame = 	new String("2. Exit");
	
	Music titleMusic;
	
	public MainMenuState(int stateID) {
		this.stateID = stateID;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		titleImage = new Image("res/img/thedungeonTitle.png");
		titleMusic = new Music("res/music/Dungeon.ogg");
		titleMusic.loop();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(titleImage, gc.getWidth() / 2 - titleImage.getWidth() / 2, 10);
		g.drawString(newGame, gc.getWidth() / 2 - newGame.length() * 5, 36);
		g.drawString(exitGame, gc.getWidth() / 2 - exitGame.length() * 5, 50);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyPressed(input.KEY_1)){
			titleMusic.stop();
			sbg.enterState(DungeonGame.playID, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
			System.out.println("Descending...");
		}
		if(input.isKeyPressed(input.KEY_2)){
			System.exit(0);
		}
	}

	@Override
	public int getID() {
		return stateID;
	}


}
