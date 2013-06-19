package com.ricky.dungeon.world;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.ricky.dungeon.entities.*;
import com.ricky.dungeon.world.tiles.*;

public class World {

	
	private static final int wall = 1;
	private static final int floor = 0;
	
	private static final int tileSize = 16;
	
	public static float sx = 1.0f, sy = 1.0f;
	public static int sizeX, sizeY;
	public static int x, y;
	private static int[][] data;
	
	List<Tile> worldTiles = new ArrayList<Tile>();
	List<Entity> worldEntities = new ArrayList<Entity>();
	
	Player player;
	
	public World(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		data = new int[sizeX][sizeY];
		for(int i = 0; i < sizeX; i++) {
			for(int j = 0; j < sizeY; j++) {
				data[i][0] = wall;
				data[0][j] = wall;
				data[sizeX-1][j] = wall;
				data[i][sizeY-1] = wall;
			}
		}
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		player = new Player(320 / 2, 240 / 2, this);
		player.init(gc, sbg);
		worldEntities.add(player);
		
		for(int x = 0; x < sizeX; x++) {
			for(int y = 0; y < sizeY; y++) {
				if(data[x][y] == wall) {
					worldTiles.add(new WallTile(x*tileSize, y*tileSize, 0));
				}
				if(data[x][y] == floor) {
					worldTiles.add(new FloorTile(x*tileSize, y*tileSize));
				}
			}
		}
		for(int i = 0; i < worldTiles.size(); i++) {
			worldTiles.get(i).init(gc, sbg);
		}
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.translate(x, y);
		g.scale(sx, sy);
		for(int i = 0; i < worldTiles.size(); i++) {
			worldTiles.get(i).render(gc, sbg, g);
		}
		for(int i = 0; i < worldEntities.size(); i++) {
			worldEntities.get(i).render(gc, sbg, g);
		}
		g.resetTransform();
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		for(int i = 0; i < worldTiles.size(); i++) {
			worldTiles.get(i).update(gc, sbg, delta);
		}
		for(int i = 0; i < worldEntities.size(); i++) {
			if(worldEntities.get(i).getHp() < 0)
				worldEntities.remove(i);
			worldEntities.get(i).update(gc, sbg, delta);
		}
	}
	
	public void panCameraX(int x) {
		this.x += x;
	}
	
	public void panCameraY(int y) {
		this.y += y;
	}
	
	public float getScaleX() {
		return sx;
	}
	
	public float getScaleY() {
		return sy;
	}
	
	public void setScaleX(float sx) {
		this.sx = sx;
	}
	
	public void setScaleY(float sy) {
		this.sy = sy;
	}
	
	public boolean canMove(float newX, float newY) {
		if(newX <= 16 && newY <= 16) {
			return false;
		} else 
		if(newX <= 16) {
			return false;
		} else
		if(newY <= 16) {
			return false;
		}
		return true;
	}
	
	public void focusOnEntity(Entity entity, Graphics g) {
		g.translate(entity.getX(), entity.getY());
	}
	
	public boolean blocked(float x, float y) {
		return data[(int) x][(int) y] == wall;
	}
	
}
