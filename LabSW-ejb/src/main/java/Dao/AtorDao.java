package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidades.Ator;

public class AtorDao implements IAtorDao{

	JTDSUtil gDao=new JTDSUtil();
	Connection c = gDao.getConnection();

	public boolean InsereAtor(Ator ator)  throws AtorDaoException{
		boolean inserido=false;

		String sql="INSERT INTO Ator VALUES (?)";  

		try{



			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1, ator.getNome());

			ps.execute();
			ps.close();
			inserido=true;
		}

		catch(Exception e){
			throw new AtorDaoException("Erro na insero do Ator:"+ator.getIdAtor());
		}

		return inserido;
	}


	public boolean AtualizarAtor(Ator Ator)  throws AtorDaoException{
		boolean atualizado=false;

		String sql = "UPDATE Ator SET nome_Ator = ? Where IDAtor = ?";



		try{
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1,Ator.getNome());
			ps.setInt(2,Ator.getIdAtor());
			ps.execute();
			ps.close();
			atualizado=true;
		}

		catch(Exception e){
			throw new AtorDaoException("Erro na atualizao do Ator:"+Ator.getIdAtor());
		}
		return atualizado;
	}



	public boolean ExcluirAtor(Ator ator)  throws AtorDaoException{
		boolean excluido=false;

		String sql="DELETE Ator Where IDAtor = ?";

		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, ator.getIdAtor());
			ps.execute();
			ps.close();
			excluido=true;
		}

		catch(Exception e){
			throw new AtorDaoException("Erro na excluso do Ator:"+ator.getIdAtor());
		}

		return excluido;
	}

	public Ator consultaAtorID(Ator Ator)  throws AtorDaoException{
		Ator AtorConsultado=new Ator();

		String sql="SELECT IDAtor, nome_Ator from Ator where IDAtor = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, Ator.getIdAtor());
			ResultSet rs=ps.executeQuery();    

			if(rs.next()){
				//AtorConsultado.setIdAtor(Ator.getIdAtor());
				AtorConsultado.setNome(rs.getString("Nome_Ator"));
			}else{
				JOptionPane.showMessageDialog(null, "No Encontrado","Ateno", JOptionPane.CANCEL_OPTION);
			}

			ps.close();
			rs.close();
		}



		catch(Exception e){
			throw new AtorDaoException("Erro na consulta do Ator:"+Ator.getIdAtor());
		}

		return AtorConsultado;
	}


	public Ator consultaAtorNome(Ator Ator)  throws AtorDaoException{
		Ator AtorConsultado=new Ator();

		String sql="SELECT IDAtor, nome_Ator from Ator where nome_Ator = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, Ator.getNome());
			ResultSet rs=ps.executeQuery();    

			if(rs.next()){
				//AtorConsultado.setIdAtor(rs.getInt("IDAtor"));
				AtorConsultado.setNome(Ator.getNome());
			}else{
				JOptionPane.showMessageDialog(null, "No Encontrado", "Ateno", JOptionPane.CANCEL_OPTION);
			}

			ps.close();
			rs.close();
		}



		catch(Exception e){
			throw new AtorDaoException("Erro na consulta do Ator:"+Ator.getIdAtor());
		}

		return AtorConsultado;
	}


	public List<Ator> ListaDeAtores()  throws AtorDaoException{
		List<Ator> listaAtor=new ArrayList<Ator>();

		String sql="Select IDAtor, nome_Ator from Ator";

		try{
			PreparedStatement ps=c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				Ator Ator=new Ator();
				//Ator.setIdAtor(rs.getInt("IDAtor"));
				Ator.setNome(rs.getString("Nome_Ator"));
				listaAtor.add(Ator);
			}
		}

		catch(Exception e){
			throw new AtorDaoException("Erro na gerao da lista de Atores");
		}
		return listaAtor;
	}


}

