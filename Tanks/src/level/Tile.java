package level;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.graphics.SpriteSheet;
import com.utils.Utils;

public class Tile {
	
	private BufferedImage image;
	private TileType     type;
	
	
	protected Tile(BufferedImage image, int scale , TileType type){
		this.type = type;
		this.image = Utils.resize(image, image.getWidth()* scale, image.getHeight()* scale);
	}
	
	protected void render(Graphics2D g,int x, int y){
		g.drawImage(image, x, y, null);
	}
	protected TileType type(){
		return type;
	}

}
