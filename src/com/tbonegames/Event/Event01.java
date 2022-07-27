package com.tbonegames.Event;

import com.tbonegames.GameManager;

public class Event01 {

	GameManager gm;
	
	public Event01(GameManager gm) {
		
		this.gm = gm;
		
	}
	
	public void lookHut() {
		gm.ui.textArea.setText("This is your house. It may have herpes");
		
	}
	
	public void talkHut() {
		gm.ui.textArea.setText("Talking to your house again? It might be time to call it a day...");
		
	}
	
	public void restHut() {
		
		if (gm.player.playerLife != gm.player.playerMaxLife) {
			gm.ui.textArea.setText("You rested and gained some life");
			gm.player.playerLife++;
			gm.player.updatePlayerStatus();
			gm.playeSE(gm.healsound);
			
		}
		else {
			gm.ui.textArea.setText("Your life is full");
		}
		
		gm.ui.textArea.setText("Your rest at the house \n (Your HP increased, and you've got a little, itchy surprise)");
	}
	
	public void lookGuard() {
		
		gm.ui.textArea.setText("The fatass guard is standing in front of you. Look at his smile. ");
	}

	public void talkGuard() {
	
	gm.ui.textArea.setText("Guard: Oh yesh, I remember my first time inside of the herpes hut. Good times, good itchy, little times...");
}

public void attackGuard() {
	
	if (gm.player.hasShield == 0) {
		if (gm.player.hasSword == 0) {
			if(gm.player.playerLife != 1) {
				
			
				gm.ui.textArea.setText("Guard: Geeze, I'm a lover not a fighter. \n But I'll fight you now, bitch!");
				gm.player.playerLife--;
				gm.playeSE(gm.hitsound);
				gm.player.updatePlayerStatus();
				
				
			}
			else if (gm.player.playerLife == 1) {
				gm.ui.textArea.setText("Guard: Good golly, miss molly!");
				gm.player.playerLife--;
				gm.player.updatePlayerStatus();
				gm.sChanger.showGameOverScreen(1);
			}
			
		}
		
		else if (gm.player.hasSword ==1 ) {
			gm.ui.textArea.setText("Guard: I told you I am a lover and not a fighter. GEEEEEZ! ");
			gm.player.hasShield=1;
			gm.player.updatePlayerStatus();
			gm.playeSE(gm.enemyhitsound);
		}
		gm.player.updatePlayerStatus();
	}
	else {
		gm.ui.textArea.setText("Guard: Just leave me alone, Michael");
	}
	
	
}

public void lookChest() {
	
	gm.ui.textArea.setText("A chest is on the ground.");
}

public void talkChest() {
	
	gm.ui.textArea.setText("If you keep talking to the chest like that, they're going to throw you in the crazy bin again.");
}

public void openChest() {
	if (gm.player.hasSword == 0) {
		gm.ui.textArea.setText("You open the chest and find a sword, a metal sword, not like the ones inside of the hut over there");
		gm.player.hasSword = 1;
		gm.player.updatePlayerStatus();
		gm.playeSE(gm.itemsound);
	}
	else {
		gm.ui.textArea.setText("It's empty and yet you feel the need to put a sword deep inside it.");
	}
	
}
	
}
