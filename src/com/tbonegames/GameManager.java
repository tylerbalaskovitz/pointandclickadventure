package com.tbonegames;

import java.net.URL;

import com.tbonegames.Event.Event01;
import com.tbonegames.Event.Event02;

public class GameManager {

	//
	ActionHandler aHandler = new ActionHandler(this);
	
	//sends to the UI class. Having the UI and public allow them to be accessed from other packages.
	public UI ui = new UI(this);
	public SceneChanger sChanger = new SceneChanger(this);
	public Player player = new Player(this);
	Music music = new Music();
	SE se = new SE();
	
	
	public Event01 ev1 = new Event01(this);
	public Event02 ev2 = new Event02(this);
	
	//Sound.
	//when doing URL you need two forward slahes // also these URL variables thatt are being created will be passed
	//inside the parameters of the the methods used to play, and stop playing music. 
	public URL fieldMusic = getClass().getClassLoader().getResource("audio//acousticbreeze.wav");
	public URL fieldMusic2 = getClass().getClassLoader().getResource("audio//ofeliasdream.wav");
	public URL deathsound = getClass().getClassLoader().getResource("audio//deathsound.wav");
	public URL entersound = getClass().getClassLoader().getResource("audio//entersound.wav");
	public URL healsound = getClass().getClassLoader().getResource("audio//healsound.wav");
	public URL hitsound = getClass().getClassLoader().getResource("audio//hitsound.wav");
	public URL itemsound = getClass().getClassLoader().getResource("audio//itemsound.wav");
	public URL enemyhitsound = getClass().getClassLoader().getResource("audio//enemyhitsound.wav");
	public URL currentMusic;
	
	public static void main(String[] args) {
		//all other classes are connected to the game manager
		
		new GameManager();
		
		
	}
	
	
	public GameManager() {
		
		currentMusic =  fieldMusic;
		playMusic(currentMusic);
		
		player.setPlayerDefaultStatus();
		sChanger.showScreen1();
		
	}
	
	public void playeSE(URL url) {
		se.setFile(url);
		se.play(url);
		
	
	}
	
	public void playMusic(URL url) {
		music.setFile(url);
		music.play(url);
		music.loop(url);
	}
	
	public void stopMusic(URL url) {
		
		music.stop(url);
	}
	
}
