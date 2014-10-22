package control;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import view.*;
import model.*;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

public class Game {

	private int turn;

	private Player player;

	private GeneralView generalView;
	private MonsterManagerView monsterManagerView;

	private WallManager wallManager;
	private MonsterManager monsterManager;
	private AttackManager attackManager;
	private CollisionManager collisionManager;

	private BasicMonsterSpawner basicMonsterSpawner;

	private Vector<Control> controlVector;
	private ConsoleSystemInterface csi;

	public Game() {
		turn = 1;
		try {
			csi = new WSwingConsoleInterface("Monsters Arena", true);
		} catch (ExceptionInInitializerError eiie) {
			System.out
					.println("*** Error: Swing Console Box cannot be initialized. Exiting...");
			eiie.printStackTrace();
			System.exit(-1);
		}
		
		this.inicializeAttributes();
		
		player = new Player(new Point(10, 10), attackManager);
		controlVector.add(new PlayerControl(player, csi));
		
//		this.spawnMonsters();
//		this.addViews();
		generalView.addView(new WallManagerView(wallManager));
		generalView.addView(new PlayerView(player));
		generalView.addView(new AttackManagerView(attackManager));
	}
	
	private void addViews() {
		generalView.addView(new WallManagerView(wallManager));
		generalView.addView(new PlayerView(player));
		generalView.addView(monsterManagerView);
		generalView.addView(new AttackManagerView(attackManager));
	}

	private void spawnMonsters() {
		List<BasicMonster> toAdd = basicMonsterSpawner.spawn(howManyMonster(turn));
		addControlToMonsters(toAdd);
		monsterManagerView = new MonsterManagerView(monsterManager);
		monsterManager.addList(new ArrayList<Monster>(toAdd));
		
		monsterManagerView.addList(toAdd);
	}

	private void inicializeAttributes() {
		monsterManager = new MonsterManager();
		attackManager = new AttackManager();
		collisionManager = new CollisionManager();
		wallManager = new WallManager(csi);
		generalView = new GeneralView(csi);
		controlVector = new Vector<Control>();
		basicMonsterSpawner = new BasicMonsterSpawner(monsterManager, csi);
	}

	private void collide() {
		collisionManager.collide(player, monsterManager);
		collisionManager.collide(player, wallManager);
		collisionManager.collide(monsterManager, attackManager);
		collisionManager.collide(monsterManager, wallManager);
	}

	private void draw() {
		generalView.draw();
	}

	private void update() {
		for (Control actual : controlVector) {
			actual.update();
		}
	}

	private void addControlToMonsters(List<BasicMonster> toAdd) {
		for (BasicMonster actual : toAdd) {
			controlVector.add(new BasicMonsterControl(actual, player));
		}
	}

	private int howManyMonster(int turn) {
		return 3 * turn - 1;
	}
	
	public void run() {
		while(player.isAlive())	{
			this.spawnMonsters();
			while (!monsterManager.isEmpty()) {
				update();
				collide();
				draw();
			}
			turn++;
		}
	}

}