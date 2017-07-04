 //apresentador, título, palavras-chave, membros da banca, horário, data, resumo
//SEI = Service Endpoint Interface
//SIB = Service Implementation Bean

/*
 * Comandos:
 * javac BancaServer.java 
 * 
*/

package WS_bancaTcc;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface BancaServer {
	@WebMethod String consultaBanca();
	@WebMethod String consultaBancaApresentador(String apresentador);
	@WebMethod String consultaBancaTitulo(String titulo);
}
