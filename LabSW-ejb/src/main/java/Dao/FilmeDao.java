package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidades.Filme;


public class FilmeDao implements IFilmeDao{

	JTDSUtil gDao=new JTDSUtil();
	Connection c = gDao.getConnection();

	public boolean InsereFilme(Filme Filme) throws FilmeDaoException{
		boolean inserido=false;

		String sql="INSERT INTO Filme VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";   //Realizando uma pr compilao SQL dentro do java

		try{

			//Realizando o pr processamento
			//seta-se o sql e em seguida so procurados os atributos que so setados, ou seja, que tero valores
			//para serem inseridos


			//O Statement ja busca os valores diretamente no SQL Server

			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1, Filme.getTitulo());
			ps.setString(2, Filme.getAno());
			ps.setInt(3, Filme.getN_dvd());
			ps.setString(6, Filme.getClassificacao());
			ps.setString(7, Filme.getTema());
			ps.setString(10, Filme.getLocalizacao());
			ps.setInt(11, Filme.getQtde());
			ps.setInt(12, Filme.getQuantidade_disponivel());


			//Executando a conexo
			//Finalizando a conexo
			//Atribuindo true a varivel inserido 
			ps.execute();
			ps.close();
			inserido=true;
		}

		catch(Exception e){
			throw new FilmeDaoException("Erro na insero do Filme:"+Filme.getIdFilme());
		}

		return inserido;
	}


	public boolean AtualizarFilmeID(Filme Filme) throws FilmeDaoException{
		boolean atualizado=false;

		String sql = "UPDATE Filme SET  titulo = ?, Ano = ?, n_dvd = ?,  classificacao = ?, Tema = ?,localizacao = ?, quantidade_total = ?, quantidade_disponivel = ? Where IDFilme = ?";

		try{
			PreparedStatement ps=c.prepareStatement(sql);

			ps.setString(1, Filme.getTitulo());
			ps.setString(2, Filme.getAno());
			ps.setInt(3, Filme.getN_dvd());
			ps.setString(6, Filme.getClassificacao());
			ps.setString(7, Filme.getTema());
			ps.setString(10, Filme.getLocalizacao());
			ps.setInt(11, Filme.getQtde());
			ps.setInt(12, Filme.getQuantidade_disponivel());

			ps.setInt(13,Filme.getIdFilme());
			ps.execute();
			ps.close();
			atualizado=true;
		}

		catch(Exception e){
			throw new FilmeDaoException("Erro na atualizao do Filme:"+Filme.getIdFilme());
		}

		return atualizado;
	}


	public boolean AtualizarFilmeNome(Filme Filme) throws FilmeDaoException{
		boolean atualizado=false;

		String sql = "UPDATE Filme SET  Ano = ?, n_dvd = ?, classificacao = ?, Tema = ?, localizacao = ?, quantidade_total = ?, quantidade_disponivel = ? Where titulo = ?";

		try{
			PreparedStatement ps=c.prepareStatement(sql);


			ps.setString(1, Filme.getAno());
			ps.setInt(2, Filme.getN_dvd());
			ps.setString(5, Filme.getClassificacao());
			ps.setString(6, Filme.getTema());
			ps.setString(9, Filme.getLocalizacao());
			ps.setInt(10, Filme.getQtde());
			ps.setInt(11, Filme.getQuantidade_disponivel());

			ps.setString(12, Filme.getTitulo());
			ps.execute();
			ps.close();
			atualizado=true;
		}

		catch(Exception e){
			throw new FilmeDaoException("Erro na atualizao do Filme"+Filme.getTitulo());
		}

		return atualizado;
	}



	public boolean excluirFilme(Filme Filme) throws FilmeDaoException{
		boolean excluido=false;

		String sql="DELETE Filme Where IDFilme = ?";

		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, Filme.getIdFilme());
			ps.execute();
			ps.close();
			excluido=true;
		}

		catch(Exception e){
			throw new FilmeDaoException("Erro na excluso do Filme:"+Filme.getIdFilme());
		}

		return excluido;
	}

	public Filme consultaFilmeID(Filme Filme) throws FilmeDaoException{
		Filme FilmeConsultado=new Filme();

		String sql="Select IDFilme, titulo, Ano, n_dvd, classificacao, Tema,  localizacao, quantidade_total, quantidade_disponivel from Filme where IDFilme = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, Filme.getIdFilme());
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){

				FilmeConsultado.setIdFilme(Filme.getIdFilme());
				FilmeConsultado.setTitulo(rs.getString("Titulo"));
				FilmeConsultado.setAno(rs.getString("Ano"));
				FilmeConsultado.setN_dvd(rs.getInt("n_dvd"));
				FilmeConsultado.setClassificacao(rs.getString("Classificacao"));
				FilmeConsultado.setTema(rs.getString("Tema"));
				FilmeConsultado.setLocalizacao(rs.getString("Localizacao"));
				FilmeConsultado.setQtde(rs.getInt("Quantidade_Total"));
				FilmeConsultado.setQuantidade_disponivel(rs.getInt("Quantidade_Disponivel"));
			}else{
				JOptionPane.showMessageDialog(null, "No Encontrado","Ateno",JOptionPane.CANCEL_OPTION);
			}



			ps.close();
			rs.close();
		}


		catch(Exception e){
			throw new FilmeDaoException("Erro na consulta do Filme:"+Filme.getIdFilme());
		}

		return FilmeConsultado;
	}



	public Filme consultaFilmeNome(Filme Filme) throws FilmeDaoException{
		Filme FilmeConsultado=new Filme();

		String sql="Select  IDFilme, titulo, Ano, n_dvd, classificacao, Tema, localizacao, quantidade_total, quantidade_disponivel from Filme where titulo = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, Filme.getTitulo());
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){


				FilmeConsultado.setIdFilme(rs.getInt("IDFilme"));
				FilmeConsultado.setTitulo(Filme.getTitulo());
				FilmeConsultado.setAno(rs.getString("Ano"));
				FilmeConsultado.setN_dvd(rs.getInt("n_dvd"));
				FilmeConsultado.setClassificacao(rs.getString("Classificacao"));
				FilmeConsultado.setTema(rs.getString("Tema"));
				FilmeConsultado.setLocalizacao(rs.getString("Localizacao"));
				FilmeConsultado.setQtde(rs.getInt("Quantidade_Total"));
				FilmeConsultado.setQuantidade_disponivel(rs.getInt("Quantidade_Disponivel"));

			}

			else{
				JOptionPane.showMessageDialog(null, "No Encontrado","Ateno",JOptionPane.CANCEL_OPTION);
			}

			ps.close();
			rs.close();
		}


		catch(Exception e){
			throw new FilmeDaoException("Erro na consulta do Filme:"+Filme.getTitulo());
		}

		return FilmeConsultado;
	}



	public Filme consultaIDQuantidadeSubtrai(int l) throws FilmeDaoException{
		Filme FilmeConsultado=new Filme();

		String sql="Select IDFilme, quantidade_disponivel from Filme where IDFilme = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, l);
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){

				FilmeConsultado.setIdFilme(rs.getInt("IDFilme"));
				FilmeConsultado.setQuantidade_disponivel(rs.getInt("Quantidade_Disponivel"));
			}else{
				JOptionPane.showMessageDialog(null, "No Encontrado");
			}



			ps.close();
			rs.close();
			AtualizaQuantidadeDisponivelSubtrai(FilmeConsultado);
		}


		catch(Exception e){
			throw new FilmeDaoException("Erro no mtodo que buscar informaes para a subtrao da quantidade de determinado Filme disponvel");
		}


		return FilmeConsultado;
	}




	public Filme consultaIDQuantidadeSoma(int l) throws FilmeDaoException{
		Filme FilmeConsultado=new Filme();

		String sql="Select IDFilme, quantidade_disponivel from Filme where IDFilme = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, l);
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){

				FilmeConsultado.setIdFilme(rs.getInt("IDFilme"));
				FilmeConsultado.setQuantidade_disponivel(rs.getInt("Quantidade_Disponivel"));
			}else{
				JOptionPane.showMessageDialog(null, "No Encontrado");
			}



			ps.close();
			rs.close();
			AtualizaQuantidadeDisponivelSoma(FilmeConsultado);
		}


		catch(Exception e){
			throw new FilmeDaoException("Erro no mtodo que buscar informaes para a soma da quantidade de determinado Filme disponvel");
		}

		return FilmeConsultado;
	}




	public void AtualizaQuantidadeDisponivelSubtrai(Filme Filme) throws FilmeDaoException{


		String sql = "UPDATE Filme SET  quantidade_disponivel = ? Where IDFilme = ?";
		try{
			PreparedStatement ps=c.prepareStatement(sql);


			ps.setInt(1, Filme.getQuantidade_disponivel()-1);
			ps.setInt(2,Filme.getIdFilme());
			ps.execute();
			ps.close();


		}

		catch(Exception e){
			throw new FilmeDaoException("Erro no mtodo que subtrairia a quantidade de determinado Filme disponvel");
		}

	}



	public void AtualizaQuantidadeDisponivelSoma(Filme Filme) throws FilmeDaoException{


		String sql = "UPDATE Filme SET  quantidade_disponivel = ? Where IDFilme = ?";
		try{
			PreparedStatement ps=c.prepareStatement(sql);


			ps.setInt(1, Filme.getQuantidade_disponivel()+1);
			ps.setInt(2,Filme.getIdFilme());
			ps.execute();
			ps.close();


		}

		catch(Exception e){
			throw new FilmeDaoException("Erro somaria a quantidade de determinado Filme disponvel");
		}

	}


	public boolean buscaQuantidade(int l) throws FilmeDaoException{

		boolean q_disponivel=true;
		Filme consultaQuantidade = new Filme();

		String sql="Select quantidade_disponivel from Filme where IDFilme = ?";

		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, l);
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){
				consultaQuantidade.setQuantidade_disponivel(rs.getInt("Quantidade_disponivel"));
			}

			if(consultaQuantidade.getQuantidade_disponivel()==0){
				q_disponivel=false;	
			}


			ps.close();
			rs.close();
		}

		catch(Exception e){
			throw new FilmeDaoException("Erro no mtodo que impede que determinado Filme passe a ter o valor de sua quantidade disponvel negativo");
		}


		return q_disponivel; 
	}

	public List<Filme> ListaDeFilmes() throws FilmeDaoException{

		List<Filme> listaFilme=new ArrayList<Filme>();

		String sql="select IDFilme, titulo, Ano from Filme";

		try{

			PreparedStatement ps= c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();


			while(rs.next()){
				Filme Filme=new Filme();
				Filme.setIdFilme(rs.getInt("IDFilme"));
				Filme.setTitulo(rs.getString("Titulo"));
				Filme.setAno(rs.getString("Ano"));
				listaFilme.add(Filme);
			}
		}
		catch(Exception e){
			throw new FilmeDaoException("Erro na gerao da lista de Filmes");
		}


		return listaFilme;
	}

}

