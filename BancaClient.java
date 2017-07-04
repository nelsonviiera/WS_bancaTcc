/*
 * Comandos:
 * javac WS_bancaTcc/BancaClient.java 
 * java WS_bancaTcc.BancaClient
*/

package WS_bancaTcc;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.ArrayList;

class BancaClient {

	public static void main(String args[]) throws Exception {
		URL url = new URL("http://127.0.0.1:9876/WS_bancaTcc?wsdl");
		QName qname = new QName("http://WS_bancaTcc/","BancaServerImplService");
		Service ws = Service.create(url, qname);
		BancaServer banca = ws.getPort(BancaServer.class);

		String resultado;     

		resultado = banca.consultaBanca();
		System.out.println("Resultado recebido: ");
		System.out.println(resultado);

		resultado = banca.consultaBancaApresentador("Nelson");
		System.out.println("Resultado recebido por Apresentador: ");
		System.out.println(resultado);

		resultado = banca.consultaBancaTitulo("Deface");
		System.out.println("Resultado recebido por Apresentador: ");
		System.out.println(resultado);
	}
}