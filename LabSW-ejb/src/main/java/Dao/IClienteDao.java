package Dao;

import Entidades.Cliente;

public interface IClienteDao {
	public boolean InsereCliente(Cliente cliente) throws ClienteDaoException;
	public boolean AtualizarCliente(Cliente cliente) throws ClienteDaoException;
	public boolean excluirCliente(Cliente cliente) throws ClienteDaoException;
	public Cliente consultaCliente(Cliente cliente) throws ClienteDaoException;
	public Cliente consultaIDQuantidadeSubtrai(String u) throws ClienteDaoException;
	public Cliente consultaIDQuantidadeSoma(String u) throws ClienteDaoException;
	public void AtualizaQuantidadeDisponivelSubtrai(Cliente cliente) throws ClienteDaoException;
	public void AtualizaQuantidadeDisponivelSoma(Cliente cliente) throws ClienteDaoException;
	public boolean buscaQuantidade(String u, String reserva) throws ClienteDaoException;

}
