/*
 * Comandos:
 * javac BancaServerImpl.java BancaServer.java
*/

package WS_bancaTcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;

@WebService(endpointInterface = "WS_bancaTcc.BancaServer")
public class BancaServerImpl implements BancaServer {

	private final String url = "jdbc:mysql://localhost:3306/";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String userName = "root";
    private final String password = "root";
    private final String dbName = "wsBanca";
    
    private Connection connectionDatabase;
    private PreparedStatement pst = null;
	private ResultSet rs = null;  
	
	@Override
	public String consultaBanca() {
		String aux = "";
		try {
			aux = "";
			Class.forName(driver).newInstance();
            connectionDatabase = DriverManager.getConnection(url + dbName, userName, password);
            pst = connectionDatabase.prepareStatement("SELECT * FROM bancas");
            rs = pst.executeQuery();
            System.out.println("Select executado... criando string");
            while (rs.next()) {
                aux += rs.getString("apresentador") + ", ";
                aux += rs.getString("titulo") + ", ";
                aux += rs.getString("palavras_chave") + ", ";
                aux += rs.getString("membros_banca") + ", ";
                aux += rs.getString("horario") + ", ";
                aux += rs.getString("resumo");
                aux += "\n";
                //resultado.add(aux);
            }
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(aux);
		return aux;
	}

	@Override
	public String consultaBancaApresentador(String apresentador) {
		String aux = "";
        try {
            aux = "";
			Class.forName(driver).newInstance();
            connectionDatabase = DriverManager.getConnection(url + dbName, userName, password);
            pst = connectionDatabase.prepareStatement("SELECT * FROM bancas WHERE apresentador = ?");
            pst.setString(1, apresentador);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                aux += rs.getString("apresentador") + ", ";
                aux += rs.getString("titulo") + ", ";
                aux += rs.getString("palavras_chave") + ", ";
                aux += rs.getString("membrosBanca") + ", ";
                aux += rs.getString("horario") + ", ";
                aux += rs.getString("resumo");
                aux += "\n";
            }
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return aux;
	}

	@Override
	public String consultaBancaTitulo(String titulo) {
        String aux = "";
		try {
            aux = "";
			Class.forName(driver).newInstance();
            connectionDatabase = DriverManager.getConnection(url + dbName, userName, password);
            pst = connectionDatabase.prepareStatement("SELECT * FROM bancas WHERE titulo = ?");
            pst.setString(1, titulo);
            rs = pst.executeQuery();

            while (rs.next()) {
                aux += rs.getString("apresentador") + ", ";
                aux += rs.getString("titulo") + ", ";
                aux += rs.getString("palavras_chave") + ", ";
                aux += rs.getString("membrosBanca") + ", ";
                aux += rs.getString("horario") + ", ";
                aux += rs.getString("resumo");
                aux += "\n";
            }
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return aux;
	}
}