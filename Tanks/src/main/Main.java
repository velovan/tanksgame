package main;


import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Timer;

import display.Display;
import game.Game;

public class Main {
	
	public static void main(String[] args) {
	Game tanks = new Game();
	tanks.start();
	}
	
}
