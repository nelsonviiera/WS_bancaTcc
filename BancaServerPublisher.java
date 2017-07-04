/*
 * javac WS_bancaTcc/BancaServerPublisher.java
 * java -cp .:WS_bancaTcc/mysql-connector-java-5.1.42-bin.jar WS_bancaTcc.BancaServerPublisher
*/

package WS_bancaTcc;

import javax.xml.ws.Endpoint;

public class BancaServerPublisher {

	public static void main(String[] args)
	{
		Endpoint.publish("http://127.0.0.1:9876/WS_bancaTcc",
		new BancaServerImpl());
	}
}