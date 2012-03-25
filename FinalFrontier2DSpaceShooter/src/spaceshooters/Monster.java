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
		
		defineImages();
		
		//Hitbox and Entity Type
		setHitBox(20,0, 24,75);
		addType("MONSTER");	
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException
	{	
		super.update(gc, delta);
			
		count += delta;
		
		y++; 
		
		//System.out.println(count);
		
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
		
			health-=50; //Monster has been hit
			System.out.println(health);
			
			if(health == 0)
			{
				ME.remove(this); //Monster has died
				System.out.println("Monster has been hit by Bullet.");
			}
		}
		
		if(collide("PLAYER", x , y) != null)
		{
			ME.remove(this);
			System.out.println("Monster has collided with Player.");
		}
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		super.render(gc, g);
	}
	
	public void defineImages()
	{
		//Monster Images
		khrellKiddieRight = ResourceManager.getImage("khrellKiddieRight");
		khrellKiddieLeft = ResourceManager.getImage("khrellKiddieLeft");
	}
}
