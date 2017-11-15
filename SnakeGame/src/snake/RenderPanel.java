/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author Р“Р Р�Р“РћР Р�Р™
 */
@SuppressWarnings("serial")
public class RenderPanel extends JPanel{
    
    public static final Color GREEN = new Color(1666073);
    
    @Override
    protected void paintComponent(Graphics g){
    	super.paintComponent(g);
        Snake snake = Snake.snake;
        g.setColor(GREEN);
        g.fillRect(0, 0, 800, 700);
        g.setColor(Color.BLUE);
        
        for(Point point: snake.snakeParts){
            g.fillRect(point.x * Snake.SCALE, point.y*Snake.SCALE, Snake.SCALE, Snake.SCALE);  
        }
        g.setColor(Color.RED);
            g.fillRect(snake.cherry.x * Snake.SCALE, snake.cherry.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
            String string = "Score: "+snake.score +", Length:" +snake.tailLength+"Time: "+ snake.time/20;
            g.setColor(Color.RED);
            g.drawString(string, (int)(getWidth()/2 -string.length()*2.5f), 10);
            string = "Game Over";
            
            if(snake.over){
                g.drawString(string, (int)(getWidth()/2 -string.length()*2.5f), (int)(snake.dim.getHeight()/4));
            }
            string = "Paused!";
             if(snake.paused&&!snake.over){
                g.drawString(string, (int)(getWidth()/2 -string.length()*2.5f), (int)(snake.dim.getHeight()/4));
            }
    }
            
}
