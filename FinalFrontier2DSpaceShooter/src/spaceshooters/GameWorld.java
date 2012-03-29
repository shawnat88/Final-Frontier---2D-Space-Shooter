package spaceshooters;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import it.randomtower.engine.World;

public class GameWorld extends World {
	
	private Player player;
	private Monster monster; 
	//keeps track of time
	long last = System.nanoTime();
	
	public GameWorld(int id, GameContainer container) throws SlickException {
		
		super(id, container);
		// TODO Auto-generated constructor stub
		
		player = new Player(container.getWidth()/ 2, container.getHeight() / 2, getWidth(), getHeight());
		add(player);	
	
	}
	private int getRandomXCoordinate(){
		Random rand = new Random();
		return rand.nextInt(width-50);
	}
	
	@Override
	public void init(GameContainer containter, StateBasedGame game) throws SlickException{
		super.init(containter, game);
		
		for(int i = 0; i < 6; i++)
		{	
			int x = getRandomXCoordinate();
			System.out.println(i+" "+x);
			monster = new Monster(x,0);
			add(monster);
			//try { Thread.sleep(getRandomXCoordinate()); } catch (Exception e) {};
		}
		
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException{

		super.update(container, game, delta);
		long now = System.nanoTime();
		long dif = (now-last)/1000000;
		if(dif>getRandomXCoordinate()*5000)
		{
			int x = getRandomXCoordinate();
			System.out.println(" "+x);
			Monster monster = new Monster(x,0);
			add(monster);
		}
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		super.render(container, game, g);
	}

}
