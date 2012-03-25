package spaceshooters;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;

public class Player extends Entity 
{
	
	/*
	 * @Param x, x coordinate of player
	 * @Param y, y coordinate of player
	 */
	private Image player, playerRight, playerLeft;
	private int milliCount = 0; 
	
	public Player(float x, float y) throws SlickException
	{
		super(x, y);
		
		defineImages();
		defineControls();
		
		//Hitbox and Entity Type
		setHitBox(0,0, 64, 60);
		addType("PLAYER"); 
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException
	{
		super.update(gc, delta);
		setGraphic(player);
		
		if(collide("MONSTER", x, y - 1) != null)
		{
			ME.remove(this);
			System.out.println("Player has Collided with Monster");
		}
		
		if(check("PRIMARYFIRE"))
		{
			milliCount += delta;
			
			if(milliCount >= 100)
			{
				Bullet bullet = new Bullet(x + player.getWidth()/2 - 3, y);
				ME.world.add(bullet);
				milliCount = 0; 
			}
		}
		
		if(check("RIGHT") && (x < gc.getWidth() - player.getWidth()))
		{
			//Move player Right
			x = x + 5;
			setGraphic(playerRight);
		}
		
		if(check("LEFT") && x > 0)
		{
			//Move player Right
			x = x - 5;	
			setGraphic(playerLeft);
		}
		
		if(check("UP") && y > 0)
		{
			//Move player Right
			y = y - 5;
			setGraphic(player);
		}
		
		if(check("DOWN") && (y < gc.getWidth() - player.getWidth()))
		{
			//Move player Right
			y = y + 5;
			setGraphic(player);
		}
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		super.render(gc, g);
	}
	
	public void defineControls()
	{
		//Define Keyboard/Mouse Inputs
		define("RIGHT", Input.KEY_RIGHT, Input.KEY_D);
		define("LEFT", Input.KEY_LEFT, Input.KEY_A);
		define("UP", Input.KEY_UP, Input.KEY_W);
		define("DOWN", Input.KEY_DOWN, Input.KEY_S);
		define("PRIMARYFIRE", Input.KEY_SPACE);
	}
	
	public void defineImages()
	{
		//Load image using resource manager and resource.xml
		player = ResourceManager.getImage("player");
		playerRight = ResourceManager.getImage("playerRight");
		playerLeft = ResourceManager.getImage("playerLeft");
	}
}
