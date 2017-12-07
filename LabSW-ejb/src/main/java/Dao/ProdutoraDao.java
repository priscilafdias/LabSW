package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidades.Produtora;

public class ProdutoraDao implements IProdutoraDao{

	JTDSUtil gDao=new JTDSUtil();
	Connection c = gDao.getConnection();

	public boolean InsereProdutora(Produtora produtora) throws ProdutoraDaoException{
		boolean inserido=false;

		String sql="INSERT INTO Produtora VALUES (?,?)";  

		try{

			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1, produtora.getNome());
			ps.setString(2,produtora.getDescricao());

			ps.execute();
			ps.close();
			inserido=true;
		}

		catch(Exception e){
			new ProdutoraDaoException("Erro na inserção da Produtora:"+produtora.getIdProdutora());
		}

		return inserido;
	}


	public boolean AtualizarProdutoraID(Produtora produtora) throws ProdutoraDaoException{
		boolean atualizado=false;

		String sql = "UPDATE Produtora SET nome = ?, descricao = ? Where IDProdutora = ?";



		try{
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1, produtora.getNome());
			ps.setString(2, produtora.getDescricao());

			ps.setInt(3, produtora.getIdProdutora());

			ps.execute();
			ps.close();
			atualizado=true;
		}

		catch(Exception e){
			new ProdutoraDaoException("Erro na atualização da Produtora:"+produtora.getIdProdutora());
		}

		return atualizado;
	}



	public boolean AtualizarProdutoraNome(Produtora produtora) throws ProdutoraDaoException{
		boolean atualizado=false;

		String sql = "UPDATE Produtora SET descricao = ? Where nome = ?";



		try{
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1, produtora.getDescricao());
			ps.setString(2, produtora.getNome());

			ps.execute();
			ps.close();
			atualizado=true;
		}

		catch(Exception e){
			new ProdutoraDaoException("Erro na atualização da Produtora:"+produtora.getNome());
		}


		return atualizado;
	}



	public boolean ExcluirProdutora(Produtora produtora) throws ProdutoraDaoException{
		boolean excluido=false;

		String sql="DELETE Produtora Where IDProdutora = ?";

		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, produtora.getIdProdutora());
			ps.execute();
			ps.close();
			excluido=true;
		}

		catch(Exception e){
			new ProdutoraDaoException("Erro na exclusão da Produtora:"+produtora.getIdProdutora());
		}


		return excluido;
	}

	public Produtora consultaProdutoraID(Produtora produtora) throws ProdutoraDaoException{
		Produtora ProdutoraConsultada=new Produtora();

		String sql="SELECT nome, descricao from Produtora where IDProdutora = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, produtora.getIdProdutora());

			ResultSet rs=ps.executeQuery();    

			if(rs.next()){
				ProdutoraConsultada.setIdProdutora(produtora.getIdProdutora());

				ProdutoraConsultada.setNome(rs.getString("Nome"));
				ProdutoraConsultada.setDescricao(rs.getString("descricao"));
			}else{
				JOptionPane.showMessageDialog(null, "Não Encontrado", "Atenção",JOptionPane.CANCEL_OPTION);
			}

			ps.close();
			rs.close();
		}

		catch(Exception e){
			new ProdutoraDaoException("Erro na consulta da Produtora:"+produtora.getIdProdutora());
		}


		return ProdutoraConsultada;
	}

	public Produtora consultaProdutoraNome(Produtora produtora) throws ProdutoraDaoException{
		Produtora ProdutoraConsultada=new Produtora();

		String sql="SELECT IDProdutora, nome, descricao from Produtora where nome = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, produtora.getNome());

			ResultSet rs=ps.executeQuery();    

			if(rs.next()){
				ProdutoraConsultada.setIdProdutora(rs.getInt("IDProdutora"));

				ProdutoraConsultada.setNome(produtora.getNome());
				ProdutoraConsultada.setDescricao(rs.getString("descricao"));
			}else{
				JOptionPane.showMessageDialog(null, "Não Encontrado", "Atenção", JOptionPane.CANCEL_OPTION);
			}

			ps.close();
			rs.close();
		}


		catch(Exception e){
			new ProdutoraDaoException("Erro na atualização da Produtora:"+produtora.getNome());
		}


		return ProdutoraConsultada;
	}


	public List<Produtora> ListaDeProdutoras() throws ProdutoraDaoException{ 
		List<Produtora> listaProdutora=new ArrayList<Produtora>();

		String sql="select IDProdutora, nome from Produtora";

		try{
			PreparedStatement ps= c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				Produtora produtora=new Produtora();
				produtora.setIdProdutora(rs.getInt("IDProdutora"));
				produtora.setNome(rs.getString("Nome"));
				listaProdutora.add(produtora);
			}
		}
		catch(Exception e){
			new ProdutoraDaoException("Erro na geração da lista de Produtoras:");
		}

		return listaProdutora;
	}


}

