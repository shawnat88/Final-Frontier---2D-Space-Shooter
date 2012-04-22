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
	private Image player, playerRight, playerLeft, playerUp;
	//this is for acceleration
	private int milliCount = 0; 
	long last = System.nanoTime();
	//important for validation of coordinates
	long width, height;
	
	public Player(float x, float y, long width, long height) throws SlickException
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
		
		// pause a bit so that we don't choke the system
		try { Thread.sleep(4); } catch (Exception e) {};
		
        long deltaPlayer = (System.nanoTime() - last) / 1500000;
       
        //System.out.println("delta:"+deltaPlayer);
        last = System.nanoTime();
        
        // now this needs a bit of explaining. The amount of time
        // passed between rendering can vary quite alot. If we were
        // to move our player based on the normal delta it would
        // at times jump a long distance (if the delta value got really
        // high). So we divide the amount of time passed into segments
        // of 5 milliseconds and update based on that
        for (int i = 0; i < deltaPlayer / 2; i++) {
			logic(gc, delta, 2);
        }
        
        // after we've run through the segments if there is anything
        // left over we update for that
        if (deltaPlayer % 5 != 0) {
            logic(gc, delta, deltaPlayer % 5);
        }
	}
	
	/*
	 * This method simply accelerates and moves the player
	 */
	private void logic(GameContainer gc, int delta, long deltaPlayer)throws SlickException{
		
		if(collide("MONSTER", x, y - 1) != null)
		{
			ME.remove(this);
			//System.out.println("Player has Collided with Monster");
		}
		
		if(check("PRIMARYFIRE"))
		{
			milliCount += delta;
			//System.out.println(milliCount);
			
			//Controls bullet rate of fire
			if(milliCount >= 500)
			{
				Bullet bullet = new Bullet(x + player.getWidth()/2 - 3, y);
				ME.world.add(bullet);
				milliCount = 0; 
			}
		}
		
		if(check("RIGHT") && (x < gc.getWidth() - player.getWidth()))
		{
			//Move player Right
			x = x + deltaPlayer;
			//if(valid())
				setGraphic(playerRight);
		}
		else
		if(check("LEFT") && x > 0)
		{
			//Move player Right
			x = x - deltaPlayer;
			//if(valid())
				setGraphic(playerLeft);
		}
		else
		if(check("UP") && y > 0)
		{
			//Move player Right
			y = y - deltaPlayer;
			//if(valid())
				setGraphic(playerUp);
		}
		else
		if(check("DOWN") && (y < gc.getWidth() - player.getWidth()))
		{
			//Move player Right
			y = y + deltaPlayer;
			//if(valid())
				setGraphic(player);
		}
		else 
		if(y < gc.getWidth() - player.getWidth())
		{  
			y = (float) (y + (.025* deltaPlayer)); //Drag player down while they aren't moving
		}
	}
	
	//Player Boundaries already handled in the if statements
	/*
	 * This method returns false if coordinates are out of the screen
	 *
	private boolean valid(){
		if(x<0 || y<0 || x>width || y>height)
			return false;
		else
			return true;
	}
	*/
	
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
		playerUp = ResourceManager.getImage("playerUp");
		playerRight = ResourceManager.getImage("playerRight");
		playerLeft = ResourceManager.getImage("playerLeft");
	}
}
