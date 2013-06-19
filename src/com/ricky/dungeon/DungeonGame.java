package com.ricky.dungeon;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.ricky.dungeon.states.*;

public class DungeonGame extends StateBasedGame{

	public static String TITLE = "The Dungeon";
	public static String VERSION = "0.0.2a";
	
	public static int width = 320;
	public static int height = 240;
	public static boolean fullscreen = false;
	public static boolean debug = true;
	public static int maxFPS = 60;
	public static boolean vSync = true;
	
	public static int menuID = 1;
	public static int playID = 2;
	
	public DungeonGame() {
		super(TITLE + " - " + VERSION);
		addState(new MainMenuState(menuID));
		addState(new PlayState(playID));
	}

	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new DungeonGame());
			app.setDisplayMode(width, height, fullscreen);
			app.setShowFPS(false);
			app.setVSync(vSync);
			app.setTargetFrameRate(maxFPS);
			app.setAlwaysRender(true);
			app.setUpdateOnlyWhenVisible(false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		getState(menuID).init(gc, this);
		getState(playID).init(gc, this);
	}

	
	
}
