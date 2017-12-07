package Dao;

import java.util.List;

import Entidades.Filme;

public interface IFilmeDao {
	public boolean InsereFilme(Filme filme) throws FilmeDaoException;
	public boolean AtualizarFilmeID(Filme filme) throws FilmeDaoException;
	public boolean AtualizarFilmeNome(Filme filme) throws FilmeDaoException;
	public boolean excluirFilme(Filme filme) throws FilmeDaoException;
	public Filme consultaFilmeNome(Filme filme) throws FilmeDaoException;
	public Filme consultaIDQuantidadeSubtrai(int l) throws FilmeDaoException;
	public Filme consultaIDQuantidadeSoma(int l) throws FilmeDaoException;
	public void AtualizaQuantidadeDisponivelSubtrai(Filme filme) throws FilmeDaoException;
	public void AtualizaQuantidadeDisponivelSoma(Filme filme) throws FilmeDaoException;
	public boolean buscaQuantidade(int l) throws FilmeDaoException;
	public List<Filme> ListaDeFilmes() throws FilmeDaoException;
}
