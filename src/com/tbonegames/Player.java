package com.tbonegames;

public class Player {

	GameManager gm;
	
	public int playerMaxLife, playerLife, hasSword, hasShield, hasLantern;
	
	
	public Player (GameManager gm) {
		
		this.gm = gm;
		
	}
	
	
	public void setPlayerDefaultStatus() {
		
		playerMaxLife = 5;
		playerLife = 3;
		hasSword = 0;
		hasShield = 0;
		hasLantern = 0;
		
		updatePlayerStatus();
	}
	
	public void updatePlayerStatus() {
		
		//apply the current stats to the screen. 
		//Remove all life icons
		int i = 1;
		while (i < 6) {
			
			gm.ui.lifeLabel[i].setVisible(false);
			i++;
		}
		
		int lifeCount = playerLife;
		while (lifeCount != 0)  {
			
			gm.ui.lifeLabel[lifeCount].setVisible(true);
			lifeCount--;
			
		}
		
		//Checks to see if the player has the items
		if (hasSword == 0) {
			gm.ui.swordLabel.setVisible(false);
			
		}
		
		if (hasSword == 1) {
			gm.ui.swordLabel.setVisible(true);
			
		}
		
		if (hasShield == 0) {
			gm.ui.shieldLabel.setVisible(false);
			
		}
		
		if (hasShield == 1) {
			gm.ui.shieldLabel.setVisible(true);
			
		}
		
		if (hasLantern == 0) {
			gm.ui.lanternLabel.setVisible(false);
			
		}
		
		if (hasLantern == 1) {
			gm.ui.lanternLabel.setVisible(true);
			
		}
		
		
	}
	
	
}
