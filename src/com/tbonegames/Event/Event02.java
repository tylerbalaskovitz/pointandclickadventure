package com.tbonegames.Event;

import com.tbonegames.GameManager;

public class Event02 {

	public GameManager gm;
	
	public Event02 (GameManager gm) {
		
		this.gm = gm;
	}
	
	public void lookCave() {
		gm.ui.textArea.setText("It's another one of those moist caves");
		
	}
	
	public void talkCave() {
		gm.ui.textArea.setText("You talk to the cave and it talks back."
				+ "\n THat's so funny... it voice sounds like yours");
		
		
	}

	public void enterCave() {
		if (gm.player.hasLantern == 0) {
			
		
		gm.ui.textArea.setText("It's too dark inside");
		}
		else if (gm.player.hasLantern==1) {
			gm.sChanger.showScreen3();
			gm.playeSE(gm.entersound);
		}
	
	}
	
	public void lookRoot() {
		gm.ui.textArea.setText("There's something near the tree");
		
	
	}
	
	public void talkRoot() {
		gm.ui.textArea.setText("It's another root to another tree. Moving on");
		
		
	}
	
	public void searchRoot() {
		if (gm.player.hasLantern == 0) {
			
		
		gm.ui.textArea.setText("You find a lantern!");
		gm.player.hasLantern =1;
		gm.player.updatePlayerStatus();
		gm.playeSE(gm.itemsound);
		
		} else {
		gm.ui.textArea.setText("You didn't find anything");	
		
		}
		
		
	}
	
}
