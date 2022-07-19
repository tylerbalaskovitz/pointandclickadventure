package com.tbonegames;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI {

	GameManager gm;
	//new user interface
	
	JFrame gameWindow;
	public JTextArea textArea;
	//notice you can do JPanels and JLabels as arrays to allow for scaling the application.
	public JPanel bgPanel[] = new JPanel[10]; //this is using an array so that way scaling the program to more backgrounds becomes more practical.
	public JLabel bgLabel[] = new JLabel[10];
	
	public UI(GameManager gm) {
		
		this.gm = gm;
		
		createMainField();
		createBackground();
		createObject();
		
		gameWindow.setVisible(true);

	}
	
	public void createMainField() {
		
		gameWindow = new JFrame();
		gameWindow.setSize(800,600);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.getContentPane().setBackground(Color.black);
		gameWindow.setLayout(null);
		
		textArea = new JTextArea("Testing text to be rendered");
		textArea.setBounds(50,410,700, 150);
		textArea.setBackground(Color.black);
		textArea.setForeground(Color.white);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
		
		gameWindow.add(textArea);
		
		
		
		
		
		
	}
	
	
	public void createBackground() {
		
		//note that you can call additional methods to the background panel ARRAY because it is a JFrame object. Also the Array version of JPanels can be added to the JFrame gameWindow.
		bgPanel[1] = new JPanel();
		bgPanel[1].setBounds(50,50,700,350);
		bgPanel[1].setBackground(Color.white);
		bgPanel[1].setLayout(null);
		gameWindow.add(bgPanel[1]);
		
		bgLabel[1] = new JLabel();
		bgLabel[1].setBounds(0,0,700,350);
		
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("greenbg.png"));
		bgLabel[1].setIcon(bgIcon);
		
		
	}
	
	public void createObject() {
		JLabel objectLabel = new JLabel();
		objectLabel.setBounds(440, 140, 200, 200);
		
		ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource("hut.png"));
		objectLabel.setIcon(objectIcon);
		
		bgPanel[1].add(objectLabel);
		bgPanel[1].add(bgLabel[1]);
		
		
	}
	
}
