package Dao;

import java.util.List;

import Entidades.Jogo;

public interface IGamesDao {
	public boolean InsereGames(Jogo jogo) throws GamesDaoException;
	public boolean AtualizarGamesNome(Jogo jogo) throws GamesDaoException;
	public boolean excluirGames(Jogo jogo) throws GamesDaoException;
	public List<Jogo> consultarGamesNome(String titulo) throws GamesDaoException;
}

