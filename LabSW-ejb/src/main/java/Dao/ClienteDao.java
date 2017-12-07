package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Entidades.Cliente;

public class ClienteDao implements IClienteDao {
	JTDSUtil gDao=new JTDSUtil();
	Connection c = gDao.getConnection();

	public boolean InsereCliente(Cliente Cliente) throws ClienteDaoException{
		boolean inserido=false;

		String sql="INSERT INTO Cliente VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";   //Realizando uma pr compilao SQL dentro do java

		try{

			//Realizando o pr processamento
			//seta-se o sql e em seguida so procurados os atributos que so setados, ou seja, que tero valores
			//para serem inseridos


			//O Statement ja busca os valores diretamente no SQL Server

			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1, Cliente.getIdentificacao());
			ps.setString(2, Cliente.getNome());
			ps.setString(3, Cliente.getRG());
			ps.setString(4, Cliente.getData_Nasc());
			ps.setString(5,Cliente.getEndereco());
			ps.setInt(6, Cliente.getNumero());
			ps.setString(7, Cliente.getBairro());
			ps.setString(8, Cliente.getCep());
			ps.setString(9, Cliente.getCidade());
			ps.setString(10, Cliente.getUF());
			ps.setString(11, Cliente.getEmail());
			ps.setString(12, Cliente.getTelefone());
			ps.setInt(13, Cliente.getQuantidade_midia_posse());
			ps.setString(14, Cliente.getCategoria());

			//Executando a conexo
			//Finalizando a conexo
			//Atribuindo true a varivel inserido 
			ps.execute();
			ps.close();
			inserido=true;
		}

		catch(Exception e){
			throw new ClienteDaoException("Erro na insero do usurio:"+Cliente.getIdentificacao());
		}

		return inserido;
	}

	/*
	 * 
	 * 
	 * 
	 */

	public boolean AtualizarCliente(Cliente Cliente) throws ClienteDaoException{
		boolean atualizado=false;

		String sql = "UPDATE Cliente SET   nome = ?, rg = ?, data_nasc = ?,endereco = ?, numero = ?, bairro = ?, cep = ?, cidade = ?,uf = ?, email = ? , telefone = ? Where IDCliente = ?";

		try{

			//Realizando o pr processamento
			//seta-se o sql e em seguida so procurados os atributos que so setados, ou seja, que tero valores
			//para serem inseridos


			//O Statement ja busca os valores diretamente no SQL Server

			PreparedStatement ps=c.prepareStatement(sql);
			//ps.setString(13, Cliente.getIdentificacao());
			ps.setString(1, Cliente.getNome());
			ps.setString(2, Cliente.getRG());
			ps.setString(3, Cliente.getData_Nasc());
			ps.setString(4,Cliente.getEndereco());
			ps.setInt(5, Cliente.getNumero());
			ps.setString(6, Cliente.getBairro());
			ps.setString(7, Cliente.getCep());
			ps.setString(8, Cliente.getCidade());
			ps.setString(9, Cliente.getUF());
			ps.setString(10, Cliente.getEmail());
			ps.setString(11, Cliente.getTelefone());
			ps.setString(12, Cliente.getIdentificacao());

			//Executando a conexo
			//Finalizando a conexo
			//Atribuindo true a varivel inserido 
			ps.execute();
			ps.close();
			atualizado=true;
		}

		catch(Exception e){
			throw new ClienteDaoException("Erro na atualizao do usurio:"+Cliente.getIdentificacao());
		}

		return atualizado;
	}

	/*
	 * 
	 * 
	 * 
	 */

	public boolean excluirCliente(Cliente Cliente) throws ClienteDaoException{


		boolean excluido=false;

		String sql="DELETE Cliente Where IDCliente = ?";

		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, Cliente.getIdentificacao());
			ps.execute();
			ps.close();
			excluido=true;
		}

		catch(Exception e){
			throw new ClienteDaoException("Erro na excluso do usurio:"+Cliente.getIdentificacao());
		}

		return excluido;
	}



	/*
	 * 
	 * 
	 * 
	 */

	public Cliente consultaCliente(Cliente Cliente) throws ClienteDaoException{
		Cliente ClienteConsultado = new Cliente();

		String sql="Select IDCliente, nome, rg, data_nasc, endereco, numero, bairro, cep, cidade, uf, email, telefone, quantidade_filmes_posse from Cliente where IDCliente = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, Cliente.getIdentificacao());
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){

				ClienteConsultado.setIdentificacao(Cliente.getIdentificacao());
				ClienteConsultado.setNome(rs.getString("nome"));
				ClienteConsultado.setRG(rs.getString("RG"));
				ClienteConsultado.setData_Nasc(rs.getString("data_nasc"));
				ClienteConsultado.setEndereco(rs.getString("endereco"));
				ClienteConsultado.setNumero(rs.getInt("numero"));
				ClienteConsultado.setBairro(rs.getString("bairro"));
				ClienteConsultado.setCep(rs.getString("cep"));
				ClienteConsultado.setCidade(rs.getString("cidade"));
				ClienteConsultado.setUF(rs.getString("uf"));
				ClienteConsultado.setEmail(rs.getString("email"));
				ClienteConsultado.setTelefone(rs.getString("telefone"));
				ClienteConsultado.setQuantidade_midia_posse(rs.getInt("Quantidade_filmes_Posse"));
				ClienteConsultado.setIdentificacao(rs.getString("IDCliente"));

			}else{
				JOptionPane.showMessageDialog(null, "No Encontrado", "Ateno",JOptionPane.CANCEL_OPTION);
			}

			ps.close();
			rs.close();
		}

		catch(Exception e){
			throw new ClienteDaoException("Erro na consulta do usurio:"+Cliente.getIdentificacao());
		}
		return ClienteConsultado;
	}



	public Cliente consultaIDQuantidadeSubtrai(String u) throws ClienteDaoException{
		Cliente ClienteConsultado=new Cliente();

		String sql="Select IDCliente, quantidade_filmes_posse from Cliente where IDCliente = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u);
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){

				ClienteConsultado.setIdentificacao(rs.getString("IDCliente"));
				ClienteConsultado.setQuantidade_midia_posse(rs.getInt("Quantidade_filmes_Posse"));
			}else{
				JOptionPane.showMessageDialog(null, "No Encontrado");
			}



			ps.close();
			rs.close();
			AtualizaQuantidadeDisponivelSubtrai(ClienteConsultado);
		}


		catch(Exception e){
			throw new ClienteDaoException("Erro no mtodo que buscar dados para a subtrao da quantidade de filmes que o usurio encontra-se em posse");
		}

		return ClienteConsultado;
	}




	public Cliente consultaIDQuantidadeSoma(String u) throws ClienteDaoException{
		Cliente ClienteConsultado=new Cliente();

		String sql="Select IDCliente, quantidade_filmes_posse from Cliente where IDCliente = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u);
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){

				ClienteConsultado.setIdentificacao(rs.getString("IDCliente"));
				ClienteConsultado.setQuantidade_midia_posse(rs.getInt("Quantidade_filmes_Posse"));
			}else{
				JOptionPane.showMessageDialog(null, "No Encontrado");
			}



			ps.close();
			rs.close();
			AtualizaQuantidadeDisponivelSoma(ClienteConsultado);
		}



		catch(Exception e){
			throw new ClienteDaoException("Erro no mtodo que buscar dados para a soma da quantidade de filmes que o usurio encontra-se em posse");
		}

		return ClienteConsultado;
	}



	public void AtualizaQuantidadeDisponivelSubtrai(Cliente Cliente) throws ClienteDaoException{


		String sql = "UPDATE Cliente SET  quantidade_filmes_posse = ? Where IDCliente = ?";
		try{
			PreparedStatement ps=c.prepareStatement(sql);

			ps.setInt(1, Cliente.getQuantidade_midia_posse()-1);
			ps.setString(2,Cliente.getIdentificacao());
			ps.execute();
			ps.close();


		}


		catch(Exception e){
			throw new ClienteDaoException("Erro no mtodo que a subtraria a quantidade de filmes que o usurio encontra-se em posse");
		}

	}




	public void AtualizaQuantidadeDisponivelSoma(Cliente Cliente) throws ClienteDaoException{


		String sql = "UPDATE Cliente SET  quantidade_filmes_posse = ? Where IDCliente = ?";
		try{
			PreparedStatement ps=c.prepareStatement(sql);

			ps.setInt(1, Cliente.getQuantidade_midia_posse()+1);
			ps.setString(2,Cliente.getIdentificacao());
			ps.execute();
			ps.close();


		}

		catch(Exception e){
			throw new ClienteDaoException("Erro no mtodo que a somaria a quantidade de filmes que o usurio encontra-se em posse");
		}


	}




	public boolean buscaQuantidade(String u, String reserva) throws ClienteDaoException{

		boolean q_filmes_posse=true;
		Cliente consultaQuantidade = new Cliente();

		String sql="Select quantidade_filmes_posse,  IDCliente from Cliente  where IDCliente = ?";

		try{

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u);
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){
				consultaQuantidade.setQuantidade_midia_posse(rs.getInt("Quantidade_filmes_Posse"));
				consultaQuantidade.setIdentificacao(rs.getString("IDCliente"));
			}

			if(reserva=="Sim"){
				q_filmes_posse=true;
			}
			else
				if((consultaQuantidade.getIdentificacao().length()==7) && (consultaQuantidade.getQuantidade_midia_posse()==2)){
					q_filmes_posse=false;	
				}

				else
					if((consultaQuantidade.getIdentificacao().length()==9) && (consultaQuantidade.getQuantidade_midia_posse()==2)){
						q_filmes_posse=false;	
					}
					else
						if((consultaQuantidade.getIdentificacao().length()==10) && (consultaQuantidade.getQuantidade_midia_posse()==10)){
							q_filmes_posse=false;	
						}


			ps.close();
			rs.close();
		}

		catch(Exception e){
			throw new ClienteDaoException("Erro no mtodo que impede o emprstimo que Usuarios Prata tenham  10 filmes em posse e para Usuarios Basico tenham 2");
		}


		return q_filmes_posse; 
	}

}
