package Dao;

import java.util.List;

import Entidades.Acervo;
import Entidades.Ator;
import Entidades.Produtora;
import Entidades.Filme;

public interface IAcervoDao {
	public boolean InsereLivroprodutoraAtor(Acervo acervo) throws AcervoDaoException;
	public boolean ExcluirFilme(Acervo acervo) throws AcervoDaoException;
	public boolean ExcluirProdutora(Acervo acervo) throws AcervoDaoException;
	public boolean ExcluirAtor(Acervo acervo) throws AcervoDaoException;
	public List<Filme> ListaDeFilmes() throws AcervoDaoException;
	public List<Produtora> ListaDeProdutoras() throws AcervoDaoException;
	public List<Ator> ListaDeAtores() throws AcervoDaoException;
	public List<String> geraFilme(Filme l) throws AcervoDaoException;
}
