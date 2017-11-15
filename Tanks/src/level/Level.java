package level;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.Game;
import com.graphics.TextureAtlas;
import com.utils.Utils;

public class Level {
	
	public static final int     TILE_SCALE =8;
	public static final int     TILE_IN_GAMW_SCALE = 1;
	public static final int     SCALED_TILE_SIZE = TILE_SCALE * TILE_IN_GAMW_SCALE;
	
	public static final int     TILE_IN_WIDTH = Game.WIDTH/(TILE_SCALE * TILE_IN_GAMW_SCALE);
	public static final int     TILE_IN_HEIGHT = Game.HEIGHT/(TILE_SCALE * TILE_IN_GAMW_SCALE);
	
	
    private Integer[][]             tileMap;
    private        Map<TileType,Tile> tiles ;
    private List<Point> grassCords;
    public Level(TextureAtlas atlas){
    	tileMap = new Integer[TILE_IN_WIDTH][TILE_IN_HEIGHT];	
    	tiles = new HashMap<TileType,Tile>();
    	tiles.put(TileType.BRICK, new Tile(atlas.cut(32*TILE_SCALE, 0*TILE_SCALE, TILE_SCALE, TILE_SCALE),TILE_IN_GAMW_SCALE,TileType.BRICK));
    	tiles.put(TileType.METAL, new Tile(atlas.cut(32*TILE_SCALE, 2*TILE_SCALE, TILE_SCALE, TILE_SCALE),TILE_IN_GAMW_SCALE,TileType.METAL));
    	tiles.put(TileType.WATER, new Tile(atlas.cut(32*TILE_SCALE, 4*TILE_SCALE, TILE_SCALE, TILE_SCALE),TILE_IN_GAMW_SCALE,TileType.WATER));
    	tiles.put(TileType.GRASS, new Tile(atlas.cut(34*TILE_SCALE, 4*TILE_SCALE, TILE_SCALE, TILE_SCALE),TILE_IN_GAMW_SCALE,TileType.GRASS));
    	tiles.put(TileType.ICE,   new Tile(atlas.cut(36*TILE_SCALE, 4*TILE_SCALE, TILE_SCALE, TILE_SCALE),TILE_IN_GAMW_SCALE,TileType.ICE));
    	tiles.put(TileType.EMPTY, new Tile(atlas.cut(36*TILE_SCALE, 6*TILE_SCALE, TILE_SCALE, TILE_SCALE),TILE_IN_GAMW_SCALE,TileType.EMPTY));
    	
    	
    	tileMap = Utils.levelParser("res/level.lvl");
    	grassCords = new ArrayList<Point>();
    	for(int i = 0; i<tileMap.length;i++){
    		for(int j= 0; j<tileMap[j].length;j++){
    			Tile tile = tiles.get(TileType.fromNumeric(tileMap[i][j]));
    			if(tile.type() == TileType.GRASS)
    				grassCords.add(new Point(j * SCALED_TILE_SIZE, i * SCALED_TILE_SIZE));
    			//	tile.render(g, j * SCALED_TILE_SIZE, i * SCALED_TILE_SIZE);
        	}	
    	}

    }
    public void update(){
    	
    }
    public void render(Graphics2D g){
    	for(int i= 0; i<tileMap.length;i++){
    		for(int j= 0; j<tileMap[j].length;j++){
    			Tile tile = tiles.get(TileType.fromNumeric(tileMap[i][j]));
    			if(tile.type() != TileType.GRASS)
    				tile.render(g, j * SCALED_TILE_SIZE, i * SCALED_TILE_SIZE);
        	}
    	}
    }
    
    public void renderGrass(Graphics2D g){
    	for(Point p:grassCords){
    		tiles.get(TileType.GRASS).render(g, 1,1);
    	}
    }
    
    
    
}























