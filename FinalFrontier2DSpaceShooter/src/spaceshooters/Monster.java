package spaceshooters;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;



public class Monster extends Entity
{
	private Image khrellKiddieRight;
	private Image khrellKiddieLeft;
	private int health; 
	private int count;
	private int numUpdates;
	
	public Monster(float x, float y)
	{
		super(x,y);
		health = 100;
		numUpdates = 0; 
		//Monster Images
		khrellKiddieRight = ResourceManager.getImage("khrellKiddieRight");
		khrellKiddieLeft = ResourceManager.getImage("khrellKiddieLeft");
		
		width = khrellKiddieRight.getWidth();
		height = khrellKiddieRight.getHeight();
		
		//Hitbox and Entity Type
		setHitBox(17,0,width - 10,height - 5);
		addType("MONSTER");
		
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException
	{	
		super.update(gc, delta);
			
		count += delta;
		
		System.out.println(count);
		
		if((count) % 2 == 0)
		{
			setGraphic(khrellKiddieRight);
		}
		else
		{
			setGraphic(khrellKiddieLeft);
		}
		
		count = 0;
		
		if(collide("BULLET", x, y) != null)
		{
		
			health-=20; //Monster has been hit
			
			if(health == 0)
				ME.remove(this); //Monster has died
		}
		
		if(collide("PLAYER", x , y) != null)
		{
			//Monster and Player have collided
			ME.remove(this);
		}
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		super.render(gc, g);
	}
}
