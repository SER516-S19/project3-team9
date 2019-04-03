package src.main;

import java.awt.EventQueue;
import src.controller.Instructor;

/**
 * The start running point of professor side application.
 *
 * @author Yu-Ting Tsao
 * @version 1.0
 */
public class ProfRunner {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Instructor();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
