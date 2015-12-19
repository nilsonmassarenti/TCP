package com.nilsonmassarenti.test.docler.controller;

import java.io.InputStream;
import java.util.Scanner;
/**
 * This class is responsible to receive the response from socket server
 * @author Nilson Massarenti
 * @version 0.1
 *
 */
public class MessageReceiver implements Runnable {
	private InputStream server;
	private Scanner scanner;

	/**
	 * This method is responsible to create a superclass
	 * @param server
	 */
	public MessageReceiver(InputStream server) {
		this.server = server;
	}

	/**
	 * This mehtod is responsible to manager the thread 
	 * and receive the  response from server 
	 */
	public void run() {
		scanner = new Scanner(this.server);
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
	}
}
