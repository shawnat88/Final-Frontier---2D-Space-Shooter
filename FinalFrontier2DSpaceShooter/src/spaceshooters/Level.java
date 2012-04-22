package spaceshooters;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;

public class Level extends Entity {
	
	Image background;
	int numberOfFrames; 

	public Level(float x, float y, int frames) {
		super(x, y);
		numberOfFrames = frames;
		// TODO Auto-generated constructor stub
		background = ResourceManager.getImage("background");
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		super.render(gc, g);
		
		for(int frame = 0; frame < numberOfFrames; frame++)
		{
			//Draw frames ahead
			background.draw(x, y-background.getHeight()*frame);
		}
		//Scroll background down
		y++;
	}

}
