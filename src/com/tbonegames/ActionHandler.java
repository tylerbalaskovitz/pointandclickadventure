package com.tbonegames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

	GameManager gm;
	
	//this is the constructor for the ActionHandler class that implements the ActionListener
	public ActionHandler(GameManager gm) {
		
		this.gm = gm;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String yourChoice = e.getActionCommand();
		
		switch(yourChoice) {
		
		//this is scene 1
		case "lookHut": gm.ev1.lookHut(); break;
		case "talkHut": gm.ev1.talkHut();break;
		case "restHut": gm.ev1.restHut();break;
		case "lookGuard": gm.ev1.lookGuard(); break;
		case "talkGuard": gm.ev1.talkGuard();break;
		case "attackGuard": gm.ev1.attackGuard();break;
		case "lookChest": gm.ev1.lookChest(); break;
		case "talkChest": gm.ev1.talkChest();break;
		case "openChest": gm.ev1.openChest();break;
		
		//scene 2
		case "lookCave": gm.ev2.lookCave();break;
		case "talkCave": gm.ev2.talkCave();break;
		case "enterCave": gm.ev2.enterCave();break;
		case "lookRoot": gm.ev2.lookRoot();break;
		case "talkRoot": gm.ev2.talkRoot();break;
		case "searchRoot": gm.ev2.searchRoot();break;
		
		
		
		
		
		//changing the scenes within the game
		case "goScene1": gm.sChanger.showScreen1();break;
		case "goScene2": gm.sChanger.showScreen2();break;
		
		//others
		case "restart": gm.sChanger.existGameOverScreen();gm.sChanger.showScreen1();break;
		
		
		}
		
	}

}
