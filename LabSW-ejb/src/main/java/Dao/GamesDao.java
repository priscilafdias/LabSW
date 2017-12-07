package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


import Entidades.Jogo;

public class GamesDao  implements IGamesDao{
	JTDSUtil gDao=new JTDSUtil();
	Connection c = gDao.getConnection();


	@Override
	public boolean InsereGames(Jogo Games) throws GamesDaoException {
		boolean inserido=false;

		String sql="INSERT INTO Games VALUES (?,?,?,?,?,?,?,?)";   //Realizando uma pr compilao SQL dentro do java

		try{

			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1, Games.getTitulo());
			ps.setString(2, Games.getProdutora());
			ps.setString(3, Games.getConsole());
			ps.setInt(4, Games.getAno());
			ps.setString(5,Games.getCategoria());
			ps.setString(8, Games.getDescricao());


			ps.execute();
			ps.close();
			inserido=true;
		}

		catch(Exception e){
			throw new GamesDaoException("Erro na insero do Games:"+Games.getId());
		}

		return inserido;
	}


	@Override
	public boolean AtualizarGamesNome(Jogo Games) throws GamesDaoException {
		boolean atualizado=false;

		String sql = "UPDATE Games SET  Produtora = ?, Console = ?, ano = ?, Categoria = ?, descricao = ? Where titulo like ?";

		try{
			PreparedStatement ps=c.prepareStatement(sql);


			ps.setString(1, Games.getProdutora());
			ps.setString(2, Games.getConsole());
			ps.setInt(3, Games.getAno());
			ps.setString(4, Games.getCategoria());
			ps.setString(7, Games.getDescricao());

			ps.setString(8, "%"+Games.getTitulo()+"%");

			ps.execute();
			ps.close();
			atualizado=true;
		}

		catch(Exception e){
			throw new GamesDaoException("Erro na atualizao do Games"+Games.getTitulo());
		}

		return atualizado;
	}



	@Override
	public boolean excluirGames(Jogo Games) throws GamesDaoException {
		boolean excluido=false;

		String sql="DELETE Games Where titulo = ?";

		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, Games.getTitulo());
			ps.execute();
			ps.close();
			excluido=true;
		}

		catch(Exception e){
			throw new GamesDaoException("Erro na excluso do Games:"+Games.getId());
		}

		return excluido;
	}


	@Override
	public List<Jogo> consultarGamesNome(String titulo) throws GamesDaoException{

		List <Jogo> geraLista=new ArrayList<Jogo>();

		String sql="Select  id, titulo, Produtora, Console, ano, Categoria, curso, descricao from Games where titulo like ?";


		try{
			Jogo GamesConsultado=new Jogo();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "%"+titulo+"%");
			ResultSet rs=ps.executeQuery();     //retornando um result set

			while(rs.next()){


				GamesConsultado.setId(rs.getInt("id"));
				GamesConsultado.setTitulo(rs.getString("titulo"));
				GamesConsultado.setProdutora(rs.getString("Produtora"));
				GamesConsultado.setConsole(rs.getString("Console"));
				GamesConsultado.setAno(rs.getInt("ano"));
				GamesConsultado.setCategoria(rs.getString("Categoria"));
				GamesConsultado.setDescricao(rs.getString("descricao"));
				geraLista.add(GamesConsultado);
			}



			ps.close();
			rs.close();
		}


		catch(Exception e){
			throw new GamesDaoException("Erro na consulta do Games:"+titulo);
		}

		return geraLista;
	}

}





