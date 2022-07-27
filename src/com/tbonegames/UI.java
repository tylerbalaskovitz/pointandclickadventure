package com.tbonegames;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class UI {

	GameManager gm;
	//new user interface
	
	JFrame gameWindow;
	public JTextArea textArea;
	//notice you can do JPanels and JLabels as arrays to allow for scaling the application.
	public JPanel bgPanel[] = new JPanel[10]; //this is using an array so that way scaling the program to more backgrounds becomes more practical.
	public JLabel bgLabel[] = new JLabel[10];
	
	// Player UI
	JPanel lifePanel;
	JLabel lifeLabel[] = new JLabel[6];
	JPanel inventoryPanel;
	
	public JLabel swordLabel, shieldLabel, lanternLabel;
	
	
	//Game Over UI
	public JLabel titleLabel;
	public JButton restartButton;
	
	
	
	public UI(GameManager gm) {
		
		this.gm = gm;
		
		createMainField();
		createPlayerField();
		createGameOverField();
		generateScene();
		
		gameWindow.setVisible(true);

	}
	
	public void createMainField() {
		
		gameWindow = new JFrame();
		gameWindow.setSize(800,600);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.getContentPane().setBackground(Color.black);
		gameWindow.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(50,410,700, 150);
		textArea.setBackground(Color.black);
		textArea.setForeground(Color.white);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
		
		gameWindow.add(textArea);
		
		
		
		
		
		
	}
	
	
	public void createBackground(int bgNum, String bgFileName) {
		
		
		
		//note that you can call additional methods to the background panel ARRAY because it is a JFrame object. Also the Array version of JPanels can be added to the JFrame gameWindow.
		bgPanel[bgNum] = new JPanel();
		bgPanel[bgNum].setBounds(50,50,700,350);
		bgPanel[bgNum].setBackground(Color.white);
		bgPanel[bgNum].setLayout(null);
		bgPanel[bgNum].setVisible(false);
		gameWindow.add(bgPanel[bgNum]);
		
		bgLabel[bgNum] = new JLabel();
		bgLabel[bgNum].setBounds(0,0,700,350);
		
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
		bgLabel[bgNum].setIcon(bgIcon);
		
		
	}
	
	public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName, String choice1Name,String choice2Name,String choice3Name, String choice1Command, String choice2Command, String choice3Command) {
		
		//the JPopupMenu and the JMenuItem allows you to to go into and create items to click that will allow for other things to be rendered. Interesting for Loveletter perhaps?
		//Creates a popup menu
		JPopupMenu popMenu = new JPopupMenu();
		
		//Creates items that will appear in the popup menu
		JMenuItem menuItem[] = new JMenuItem[4];
		
		
		menuItem[1] = new JMenuItem(choice1Name);
		menuItem[1].addActionListener(gm.aHandler);
		menuItem[1].setActionCommand(choice1Command);
				
		
		popMenu.add(menuItem[1]);
		
		menuItem[2] = new JMenuItem(choice2Name);
		menuItem[2].addActionListener(gm.aHandler);
		menuItem[2].setActionCommand(choice2Command);
		popMenu.add(menuItem[2]);
		
		menuItem[3] = new JMenuItem(choice3Name);
		menuItem[3].addActionListener(gm.aHandler);
		menuItem[3].setActionCommand(choice3Command);
		popMenu.add(menuItem[3]);
		
		JLabel objectLabel = new JLabel();
		objectLabel.setBounds(objx, objy, objWidth, objHeight);
		
		
		//the lines of code allow you to see where the hitboxes are for creating and laying objects out via the x and y coordinates.
		//objectLabel.setOpaque(true); objectLabel.setBackground(Color.yellow);
		 
		
		ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
		objectLabel.setIcon(objectIcon);
		
		//mouse listener is another way to do a KeyEvent, but MouseListener will do presses with the mouse
		objectLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					//the popup menu is activated only when you press the right mouse button on this object label.
					//the e.getX(), and e.getY() are methods created inside of SwingUtilities that allows you to be able to make the popup menu show at the location of where your
					//mouse's X and Y coordinates are when clicking.
					popMenu.show(objectLabel, e.getX(), e.getY());
					
				}
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
		});
		
		bgPanel[bgNum].add(objectLabel);
		
		
		
	}
	
	//the method below is receiving the String called arrowFileName
	public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command) {
		
		ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));
		
		JButton arrowButton = new JButton();
		
		//note within the JButton method called setBounds(), there is a setBounds(x, y, width, height) with the parameter requirements that need to be met.
		arrowButton.setBounds(x, y, width, height);
		arrowButton.setBackground(null);
		arrowButton.setContentAreaFilled(false);
		arrowButton.setFocusPainted(false);
		arrowButton.setIcon(arrowIcon);
		arrowButton.addActionListener(gm.aHandler);
		arrowButton.setActionCommand(command);
		arrowButton.setBorderPainted(false);
		
		
		bgPanel[bgNum].add(arrowButton);
		
	}
	
	
	public void createPlayerField() {
		
		lifePanel = new JPanel();
		lifePanel.setBounds(50, 0, 250, 50);
		lifePanel.setBackground(Color.black);
		
		//this GrideLayout() method shows you the number of rows, 1, and the number of columns, 5. So, it'll have 5 squares adjacent to each other. 
		// [][][][][]
		lifePanel.setLayout(new GridLayout(1, 5));
		gameWindow.add(lifePanel);
		
		ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
		
		//if you need to rescale the image you have to use the image class to get the image to the proper size
		Image image = lifeIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		lifeIcon = new ImageIcon(image);
		
		int i = 1; 
		while (i< 6) {
			lifeLabel[i] = new JLabel();
			lifeLabel[i].setIcon(lifeIcon);
			lifePanel.add(lifeLabel[i]);
			i++;
			
		}
		
		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(650, 0, 100, 50);
		inventoryPanel.setBackground(Color.black);
		inventoryPanel.setLayout(new GridLayout(1,3));
		gameWindow.add(inventoryPanel);
		
		//creating the items and item lables for each of the items
		swordLabel = new JLabel();
		ImageIcon swordIcon = new ImageIcon(getClass().getClassLoader().getResource("stiletto.png"));
		image = swordIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		swordIcon = new ImageIcon(image);
		swordLabel.setIcon(swordIcon);
		inventoryPanel.add(swordLabel);
		
		shieldLabel = new JLabel();
		ImageIcon shieldIcon = new ImageIcon(getClass().getClassLoader().getResource("magicshield.png"));
		image = shieldIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		shieldIcon = new ImageIcon(image);
		shieldLabel.setIcon(shieldIcon);
		inventoryPanel.add(shieldLabel);
		
		lanternLabel = new JLabel();
		ImageIcon lanternIcon = new ImageIcon(getClass().getClassLoader().getResource("lanternflame.png"));
		image = lanternIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		lanternIcon = new ImageIcon(image);
		lanternLabel.setIcon(lanternIcon);
		inventoryPanel.add(lanternLabel);
		
		
		
		
	}
	
	public void createGameOverField() {
		//centers the text to the center of the panel
		titleLabel = new JLabel("", JLabel.CENTER);
		titleLabel.setBounds(200, 150, 400, 200);
		titleLabel.setForeground(Color.red);
		titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 70));
		titleLabel.setVisible(false);
		gameWindow.add(titleLabel);
		
		restartButton = new JButton();
		restartButton.setBounds(340, 320, 120, 50);
		restartButton.setBorder(null);
		restartButton.setBackground(null);
		restartButton.setForeground(Color.white);
		restartButton.setFocusPainted(false);
		
		restartButton.addActionListener(gm.aHandler);
		restartButton.setActionCommand("restart");
		restartButton.setVisible(false);
		gameWindow.add(restartButton);
		
	}
	
	
	public void generateScene() {
		//Scene 1
		createBackground(1, "greenbg.png");
		
		//the EIGHT parameters below correspond to all of the parameters in the createObject method and the values will be passed to the method via the parameters in the 
		//multiple methods being called at the same time.
		//the last three are the action commands for going into the switch.
		createObject(1, 440, 140, 200, 200, "hut.png", "Look", "Talk", "Rest", "lookHut", "talkHut", "restHut");
		createObject(1, 70, 180, 150, 150, "guard.png", "Look", "Talk", "Attack", "lookGuard", "talkGuard", "attackGuard");
		createObject(1, 350, 280, 70, 70, "chest.png", "Look", "Talk", "Open", "lookChest","talkChest","openChest");
		createArrowButton(1, 0, 150, 50, 50, "leftarrow.png", "goScene2");
		//Since the background and create methods were already created above, we can reuse the code by having additional objects, and additional objects appear on screen
		//when we need them to.
		bgPanel[1].add(bgLabel[1]);
		
		
		//Scene 2
		createBackground(2, "cave.jpg");
		createObject(2, 0, 100, 100, 300, "blankimage.png", "Look", "Talk", "Enter", "lookCave", "talkCave", "enterCave");
		createObject(2, 350, 250, 50, 50, "blankimage.png", "Look", "Talk", "Search", "lookRoot", "talkRoot", "searchRoot");
		createArrowButton(2, 650, 150, 50, 50, "rightarrow.png", "goScene1");
		
		bgPanel[2].add(bgLabel[2]);
		
		
		//Scene 3
		createBackground(3, "caveInside.png");
		
		
		createArrowButton(3, 650, 150, 50, 50, "rightarrow.png", "goScene2");
				
				bgPanel[3].add(bgLabel[3]);
	
	}
	
}
