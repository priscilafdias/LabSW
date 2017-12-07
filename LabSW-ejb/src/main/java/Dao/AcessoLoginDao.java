package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


import Entidades.Acesso;




public class AcessoLoginDao implements IAcessoLoginDao {

	JTDSUtil gDao=new JTDSUtil();
	Connection c = gDao.getConnection();

	public boolean InsereLogin(Acesso login) throws AcessoLoginDaoException{
		boolean inserido=false;

		String sql="INSERT INTO Acesso VALUES (?,?,?,?,?)";  

		try{



			PreparedStatement ps=c.prepareStatement(sql);
			//ps.setString(1, login.getNome());
			ps.setString(2,login.getCpf());
			ps.setString(3, login.getCargo());
			ps.setString(4, login.getLogin_usuario());
			ps.setString(5, login.getSenha());

			ps.execute();
			ps.close();
			inserido=true;
		}

		catch (Exception e){
			throw new AcessoLoginDaoException("Erro na realizacao do cadastro do login do usuario"+login.getCpf());
		}

		if(inserido==false){
			JOptionPane.showMessageDialog(null,"Esses dados j esto cadastrados no sistema.\nVerifique o cpf, login e senha informados e insira novamente.","Ateno",JOptionPane.CANCEL_OPTION);

		}


		return inserido;
	}


	public boolean AtualizarLogin(Acesso login) throws AcessoLoginDaoException{
		boolean atualizado=false;

		String sql = "UPDATE Acesso SET login, senha = ? Where IDAcesso = ?";



		try{
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1,login.getLogin_usuario());
			ps.setString(2, login.getSenha());

			ps.setInt(3, login.getIDAcesso());
			ps.execute();
			ps.close();
			atualizado=true;
		}
		catch (Exception e){
			throw new AcessoLoginDaoException("Erro na atualizao do login do usuario"+login.getCpf());
		}


		return atualizado;
	}



	public boolean ExcluirLogin(Acesso login) throws AcessoLoginDaoException{
		boolean excluido=false;

		String sql="DELETE Acesso Where cpf = ?";

		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, login.getCpf());
			ps.execute();
			ps.close();
			excluido=true;
		}

		catch (Exception e){
			throw new AcessoLoginDaoException("Erro na excluso do cadastro do login do usuario"+login.getCpf());
		}

		return excluido;
	}

	public Acesso consultaLogin(Acesso login) throws AcessoLoginDaoException{
		Acesso loginConsultado=new Acesso();

		boolean localizado=false;
		String sql="SELECT login_usuario, senha, cpf from Acesso where login_usuario = ? and senha = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, login.getLogin_usuario());
			ps.setString(2, login.getSenha());
			ResultSet rs=ps.executeQuery();    

			if(rs.next()){
				loginConsultado.setLogin_usuario(rs.getString("Login_Usuario"));
				loginConsultado.setSenha(rs.getString("Senha"));
				loginConsultado.setCpf(rs.getString("CPF"));
			}



			ps.close();
			rs.close();
		}



		catch (Exception e){
			throw new AcessoLoginDaoException("Erro na consulta do login do usuario"+login.getCpf());
		}

		return loginConsultado;
	}



	public Acesso consultaDados(Acesso login) throws AcessoLoginDaoException{
		Acesso loginConsultado=new Acesso();

		boolean localizado=false;
		String sql="SELECT CPF, nome, cargo, login_usuario, senha from Acesso where cpf = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, login.getCpf());
			ResultSet rs=ps.executeQuery();    

			if(rs.next()){
				loginConsultado.setCpf(rs.getString("CPF"));
				//loginConsultado.setNome(rs.getString("Nome"));
				loginConsultado.setCargo(rs.getString("Cargo"));
				loginConsultado.setLogin_usuario(rs.getString("Login_Usuario"));
				loginConsultado.setSenha(rs.getString("Senha"));
			}
			else{
				JOptionPane.showMessageDialog(null,"Dados no localizados","Ateno",JOptionPane.CANCEL_OPTION);
			}



			ps.close();
			rs.close();
		}


		catch (Exception e){
			throw new AcessoLoginDaoException("Erro na consulta dos dados do usuario"+login.getCpf());
		}


		return loginConsultado;
	}



}