package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JTDSUtil {
	private static Connection con;


	public static Connection getConnection(){

		try{
			String driver = "net.sourceforge.jtds.jdbc.Driver";   //especificando o driver que será usado

			String endereco = "jdbc:jtds:sqlserver://127.0.0.1:1433;";     //especificando o IP e a porta do pc em que ocorrerá a conexo
			String database = "DatabaseName=Projeto;";

			String pipeNomeado = "named=true";     //especificando a conexo direta com o banco, somente vlida para conexões locais e no usada em servidores

			String user="sa";

			String senha="1234";

			StringBuffer sb=new StringBuffer();

			sb.append(endereco);                       //adicionando a StringBuffer o endereço em que ocorrerá a conexão com o banco
			sb.append(database);
			sb.append(pipeNomeado);                    //adicionando a StringBuffer a String que determina que a conexão com o banco ocorrerá de forma direta
			sb.append(database);  
			Class.forName(driver);                     //setando o driver, caso ele seja encontrado serão passados os parmetros para  a realização da conexão 

			con=DriverManager.getConnection(sb.toString(),user,senha);  

			//System.out.println("Conexo Ok");

		}catch(ClassNotFoundException e){         //verificando se h erros com a classe para a realização da conexo com o banco
			e.printStackTrace();

		}


		catch(Exception e){                     //Verificando se h algum outro erro qualquer
			e.printStackTrace();
		}

		return con;
	}

}
