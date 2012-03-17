package spaceshooters;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import it.randomtower.engine.World;

public class GameWorld extends World {

	public GameWorld(int id, GameContainer container) {
		super(id, container);
		// TODO Auto-generated constructor stub
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
