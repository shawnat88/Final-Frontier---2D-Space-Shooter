package spaceshooters;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;

public class Player extends Entity {
	
	/*
	 * @Param x, x coordinate of player
	 * @Param y, y coordinate of player
	 */
	
	public Player(float x, float y) throws SlickException
	{
		super(x, y);
		//Load image from disk and associate it with player
		//setGraphic(new Image("/data/images/Player.png"));
		//Load image using resource manager and resource.xml
		Image img = ResourceManager.getImage("player");
		setGraphic(img);
		
		//Handle input
		define("RIGHT", Input.KEY_RIGHT);
		define("LEFT", Input.KEY_LEFT);
		define("UP", Input.KEY_UP);
		define("DOWN", Input.KEY_DOWN);
		
		//Hitbox 
		setHitBox(0,0,img.getWidth(),img.getHeight());
		//Declare Type
		addType("PLAYER");
		
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException
	{
		super.update(gc, delta);
		
		if(check("RIGHT") && (x < gc.getWidth() - 60))
		{
				//Move player Right
				x = x + 5;
		}
		
		if(check("LEFT") && x > 0)
		{
			//Move player Right
			x = x - 5;	
		}
		
		if(check("UP") && y > 0)
		{
			//Move player Right
			y = y - 5;
		}
		
		if(check("DOWN") && (y < gc.getWidth() - 60))
		{
			//Move player Right
			y = y + 5;
		}
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		super.render(gc, g);
	}

}
