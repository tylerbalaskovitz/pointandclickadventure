package com.tbonegames;

public class SceneChanger {

	GameManager gm;
	
	public SceneChanger (GameManager gm) {
		
		this.gm = gm;
	}
	
	public void showScreen1() {
		
		gm.ui.bgPanel[1].setVisible(true);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.textArea.setText("Let's explore the world and see what kind of mishappenings are happening");
		
		gm.stopMusic(gm.currentMusic);
		gm.currentMusic = gm.fieldMusic;
		gm.playMusic(gm.currentMusic);
		
	}
	
	public void showScreen2() {
		
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(true);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.textArea.setText("The cave is moist looking around the outside. It's kind of interesting.");
		
		gm.stopMusic(gm.currentMusic);
		gm.currentMusic = gm.fieldMusic2;
		gm.playMusic(gm.currentMusic);
		
	}
	
	public void showScreen3() {
		
		
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(true);
		
		
		gm.ui.textArea.setText("You enter the cave. What is wating for you inside \n\n"
				+ "this is the end of the demo. Thank you for trying it out!!");
		
	}
	
	public void showGameOverScreen(int currentBgNum) {
		
		gm.ui.bgPanel[currentBgNum].setVisible(false);
		gm.ui.titleLabel.setVisible(true);
		gm.ui.titleLabel.setText("You're dead");
		gm.ui.restartButton.setVisible(true);
		gm.ui.restartButton.setText("Click to restart");
		
		gm.stopMusic(gm.currentMusic);
		gm.playeSE(gm.deathsound);
		
	}
	
	public void existGameOverScreen() {
		
		gm.ui.titleLabel.setVisible(false);
		gm.ui.restartButton.setVisible(false);
		gm.player.setPlayerDefaultStatus();
	
	}
	
	
}
