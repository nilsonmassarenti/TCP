package com.nilsonmassarenti.test.view;

import java.util.Properties;

import com.nilsonmassarenti.test.docler.controller.SocketClient;
import com.nilsonmassarenti.test.docler.utils.ReadProperties;

/**
 * This main class manage the arguments to execute the socket
 *
 */
public class App {
	public static void main(String[] args) {
		Properties prop = ReadProperties.getProperties();
		String command = "";
		if (args.length == 2) {
			if ((args[0].toUpperCase().equals("PING") || args[0].toUpperCase().equals("TRACERT"))) {
				command = args[0] + " " + args[1];

			} else {
				System.out.println(prop.getProperty("prop.ping.server.args.unsuccess") + " - "
						+ prop.getProperty("prop.ping.server.args.help"));
			}
		} else if (args.length == 1) {
			if (args[0].toUpperCase().equals("STATUS")) {
				command = args[0];
			}
		}
		if (!command.equals("")) {
			SocketClient socketClient = new SocketClient();
			socketClient.setCommand(command);
			socketClient.serverConnection();
		} else {
			System.out.println(prop.getProperty("prop.ping.server.args.unsuccess") + " - "
					+ prop.getProperty("prop.ping.server.args.help"));
		}

	}
}
