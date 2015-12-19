package com.nilsonmassarenti.test.docler.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import com.nilsonmassarenti.test.docler.utils.ReadProperties;

/**
 * This class is responsible to connect with socket server
 * @author Nilson Massarenti
 * @version 0.1
 */
public class SocketClient {
	private Properties prop = ReadProperties.getProperties();
	private Socket server;
	private String command;

	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * This method is responsible to create a connection with server
	 */
	public void serverConnection() {
		try {
			server = new Socket(prop.getProperty("prop.ping.server.ip"),
					Integer.parseInt(prop.getProperty("prop.ping.server.port")));
			System.out.println(prop.getProperty("prop.ping.server.connect.success"));
			MessageReceiver messageReceiver = new MessageReceiver(server.getInputStream());
			new Thread(messageReceiver).start();
			PrintStream printCommand = new PrintStream(server.getOutputStream());
			printCommand.println(command);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
