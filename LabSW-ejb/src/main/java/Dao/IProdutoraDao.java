package Dao;

import java.util.List;

import Entidades.Produtora;

public interface IProdutoraDao {
	public boolean InsereProdutora(Produtora produtora) throws ProdutoraDaoException;
	public boolean AtualizarProdutoraID(Produtora produtora) throws ProdutoraDaoException;
	public boolean AtualizarProdutoraNome(Produtora produtora) throws ProdutoraDaoException;
	public boolean ExcluirProdutora(Produtora produtora) throws ProdutoraDaoException;
	public Produtora consultaProdutoraID(Produtora produtora) throws ProdutoraDaoException;
	public Produtora consultaProdutoraNome(Produtora produtora) throws ProdutoraDaoException;
	public List<Produtora> ListaDeProdutoras() throws ProdutoraDaoException;


}
