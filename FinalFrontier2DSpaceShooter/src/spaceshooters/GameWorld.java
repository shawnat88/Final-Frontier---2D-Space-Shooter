package spaceshooters;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import it.randomtower.engine.World;

public class GameWorld extends World {
	
	private Player player;
	private Monster monster; 

	public GameWorld(int id, GameContainer container) throws SlickException {
		super(id, container);
		// TODO Auto-generated constructor stub
		
		player = new Player(container.getWidth()/ 2, container.getHeight() / 2);
		add(player);
		
		monster = new Monster(300,200);
		add(monster);
		
	}
	
	@Override
	public void init(GameContainer containter, StateBasedGame game) throws SlickException{
		super.init(containter, game);
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException{
		super.update(container, game, delta);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		super.render(container, game, g);
	}

}
