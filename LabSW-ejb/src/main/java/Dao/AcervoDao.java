package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entidades.Acervo;
import Entidades.Ator;
import Entidades.Produtora;
import Entidades.Filme;

public class AcervoDao implements IAcervoDao {

	JTDSUtil gDao=new JTDSUtil();
	Connection c = gDao.getConnection();


	public boolean InsereFilmeProdutoraAtor(Acervo acervo) throws AcervoDaoException{
		boolean inserido=false;

		String sql="INSERT INTO Acervo values (?,?,?)";

		try{
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, acervo.getIdFilme());
			ps.setInt(2, acervo.getIdAtor());
			ps.setInt(3, acervo.getIdProdutora());
			ps.execute();
			ps.close();
			inserido=true;
		}
		catch (Exception e){
			throw new AcervoDaoException("Erro na inserção do acervo:"+acervo.getIdAcervo());
		}
		return inserido;
	}


	public boolean ExcluirFilme(Acervo acervo) throws AcervoDaoException{
		boolean excluido=false;

		String sql="DELETE Acervo Where IDFilme = ?";

		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, acervo.getIdFilme());
			ps.execute();
			ps.close();
			excluido=true;
		}

		catch(Exception e){
			throw new AcervoDaoException("Erro na exclusão do Filme:"+acervo.getIdFilme());
		}

		return excluido;
	}



	public boolean ExcluirProdutora(Acervo acervo) throws AcervoDaoException{
		boolean excluido=false;

		String sql="DELETE Acervo Where IDProdutora= ?";

		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, acervo.getIdProdutora());
			ps.execute();
			ps.close();
			excluido=true;
		}

		catch(Exception e){
			throw new AcervoDaoException("Erro na exclusão da Produtora:"+acervo.getIdProdutora());
		}


		return excluido;
	}


	public boolean ExcluirAtor(Acervo acervo) throws AcervoDaoException{
		boolean excluido=false;

		String sql="DELETE Acervo Where IDAtor= ?";

		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, acervo.getIdAtor());
			ps.execute();
			ps.close();
			excluido=true;
		}

		catch(Exception e){
			throw new AcervoDaoException("Erro na exclusão do Ator:"+acervo.getIdAtor());
		}


		return excluido;
	}


        @Override
	public List<Filme> ListaDeFilmes() throws AcervoDaoException{

		List<Filme> listaFilme=new ArrayList<Filme>();

		String sql="select IDFilme, titulo, edicao from Filme";

		try{

			PreparedStatement ps= c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();


			while(rs.next()){
				Filme Filme=new Filme();
				Filme.setIdFilme(rs.getInt("IDFilme"));
				Filme.setTitulo(rs.getString("Titulo"));
				//Filme.setEdicao(rs.getString("Edicao"));
				listaFilme.add(Filme);
			}
		}

		catch(Exception e){
			throw new AcervoDaoException("Erro na geração da lista de Filmes");
		}


		return listaFilme;
	}


        @Override
	public List<Produtora> ListaDeProdutoras() throws AcervoDaoException{
		List<Produtora> listaProdutora=new ArrayList<Produtora>();

		String sql="select IDProdutora, nome from Produtora";

		try{
			PreparedStatement ps= c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				Produtora Produtora=new Produtora();
				Produtora.setIdProdutora(rs.getInt("IDProdutora"));
				Produtora.setNome(rs.getString("Nome"));
				listaProdutora.add(Produtora);
			}
		}
		catch(Exception e){
			throw new AcervoDaoException("Erro na geração da lista de Produtoras");
		}

		return listaProdutora;
	}


        @Override
	public List<Ator> ListaDeAtores() throws AcervoDaoException{
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
			throw new AcervoDaoException("Erro na geração da lista de acervos");
		}

		return listaAtor;
	}



	public List<String> geraLista(Filme l) throws AcervoDaoException{

		List<String> listaNome = new ArrayList<String>();

		String sql= "select Filme.titulo, Produtora.Nome, Ator.nome_Ator "+
				"from Acervo "+
				"Inner join Filme "+
				"ON Acervo.IDFilme=Filme.IDFilme "+
				"inner join Produtora "+
				"On Acervo.IDProdutora=Produtora.IDProdutora "+
				"INNER JOIN Ator "+
				"ON Acervo.IDAtor=Ator.IDAtor "+
				"where Filme.IDFilme = ? "; 

		try{
			PreparedStatement ps= c.prepareStatement(sql);
			ps.setInt(1, l.getIdFilme());
			ResultSet rs=ps.executeQuery();

			while(rs.next()){

				//Emprestimo emprestimo=new Emprestimo();  
				Filme Filme=new Filme();
				Filme.setTitulo(rs.getString("Titulo"));

				Produtora Produtora=new Produtora();
				Produtora.setNome(rs.getString("Nome"));

				Ator Ator=new Ator();
				Ator.setNome(rs.getString("Nome_Ator"));

				//listaNome.add(String.valueOf(emprestimo.getIdEmprestimo()));


				listaNome.add("Filme:"+Filme.getTitulo()+" Produtora:"+Produtora.getNome()+" Ator:"+Ator.getNome());
			}
		} catch (Exception e) {
			throw new AcervoDaoException("Erro na geraçãoo da lista geral");
		}
		return listaNome; 
	}

    @Override
    public boolean InsereLivroprodutoraAtor(Acervo acervo) throws AcervoDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> geraFilme(Filme l) throws AcervoDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}







