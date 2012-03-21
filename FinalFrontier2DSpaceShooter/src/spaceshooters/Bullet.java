package spaceshooters;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;

public class Bullet extends Entity {
	
	private Image bullet;
	
	public Bullet(float x, float y) throws SlickException
	{
		super(x,y);
		bullet = ResourceManager.getImage("bullet");
		setGraphic(bullet);
		
		width = bullet.getWidth();
		height = bullet.getHeight();
		
		setHitBox(0, 0, width, height); //previously 2,1,4,6
		addType("BULLET");
		
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException
	{
		super.update(gc, delta);
		y -= (.7 * delta); 
		
		if(y <= 0)
		{
			ME.world.remove(this);
		}
		
		if(collide("MONSTER", x, y + 15) != null)
		{
			ME.remove(this);
		}
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		super.render(gc, g);
	}

}
