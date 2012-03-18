package spaceshooters;
import it.randomtower.engine.ResourceManager;

import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Final Frontier - 2D Space Shooter Game
 * Shawn Taylor
 * ... 
 *  
 **/

public class FinalFrontierGame extends StateBasedGame {

	public FinalFrontierGame(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		try 
		{
			//Load in Resources
			ResourceManager.loadResources("data/resources.xml");
		}
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addState(new GameWorld(1, container));
		
	}
	
	public static void main(String[] args) throws SlickException {
		// TODO Auto-generated method stub
		AppGameContainer app = new AppGameContainer(new FinalFrontierGame("Final Frontier"));
		app.setDisplayMode(600, 600, false);
		app.setTargetFrameRate(60);
		app.start();
	}

}
