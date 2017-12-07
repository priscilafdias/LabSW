package Dao;

import java.util.List;

import Entidades.Ator;

public interface IAtorDao {
	public boolean InsereAtor(Ator ator) throws AtorDaoException;
	public boolean AtualizarAtor(Ator ator)  throws AtorDaoException;
	public boolean ExcluirAtor(Ator ator)  throws AtorDaoException;
	public Ator consultaAtorID(Ator ator)  throws AtorDaoException;
	public Ator consultaAtorNome(Ator ator)  throws AtorDaoException;
	public List<Ator> ListaDeAtores() throws AtorDaoException;


}
