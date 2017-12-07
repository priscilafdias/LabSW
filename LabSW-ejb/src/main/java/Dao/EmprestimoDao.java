package Dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import Entidades.Emprestimo;
import Entidades.Filme;
import Entidades.Cliente;

public class EmprestimoDao implements IEmprestimoDao{
	JTDSUtil gDao=new JTDSUtil();
	Connection c = gDao.getConnection();



	public boolean InsereEmprestimo(Emprestimo emprestimo) throws EmprestimoDaoException{
		boolean inserido=false;

		FilmeDao filme=new FilmeDao();
		int l=emprestimo.getIdFilme();

		try {
			filme.buscaQuantidade(l);
		} catch (FilmeDaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		ClienteDao cliente=new ClienteDao();
		String u=emprestimo.getIdUsuario();
		String reserva=emprestimo.getReserva();

		try {
			cliente.buscaQuantidade(u, reserva);
		} catch (ClienteDaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		try {
			if ((filme.buscaQuantidade(l)==false)&&(cliente.buscaQuantidade(u,reserva)==false)){
				JOptionPane.showMessageDialog(null,"O filme desejado no est disponvel e o usurio est com a quantidade mxima de filmes permitida","Ateno",JOptionPane.CANCEL_OPTION);
			}

			else

				if(filme.buscaQuantidade(l)==false){
					JOptionPane.showMessageDialog(null,"O filme desejado no encontra-se disponvel","Ateno",JOptionPane.CANCEL_OPTION);
				}

				else


					if(cliente.buscaQuantidade(u,reserva)==false){
						JOptionPane.showMessageDialog(null,"O usurio cadastrado encontra-se com a quantidade mxima\nde filmes permitida","Ateno",JOptionPane.CANCEL_OPTION);
					}




					else

						if ((filme.buscaQuantidade(l)==true)&&(cliente.buscaQuantidade(u,reserva)==true)){


							String sql="INSERT INTO Emprestimo VALUES (?,?,?,?,?)";   

							try{


								PreparedStatement ps=c.prepareStatement(sql);
								ps.setInt(1, emprestimo.getIdFilme());
								ps.setString(2, emprestimo.getIdUsuario());
								ps.setString(3, emprestimo.getPeriodo());
								ps.setString(4,emprestimo.getStatus());
								ps.setString(5, emprestimo.getReserva());


								int i=emprestimo.getIdFilme();


								ps.execute();
								ps.close();
								inserido=true;
							}

							catch(Exception e){
								throw new EmprestimoDaoException("Erro na insero do emprstimo:"+emprestimo.getIdEmprestimo());

							}
						}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FilmeDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClienteDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inserido;
	}


	/*
	 * 
	 * 
	 * 
	 */

	public boolean AtualizarEmprestimo(Emprestimo emprestimo) throws EmprestimoDaoException{
		boolean atualizado=false;

		String sql = "UPDATE emprestimo SET  data = ?" +
				" Where IDEmprestimo = ?";

		try{

			//Realizando o pr processamento
			//seta-se o sql e em seguida so procurados os atributos que so setados, ou seja, que tero valores
			//para serem inseridos


			//O Statement ja busca os valores diretamente no SQL Server

			PreparedStatement ps=c.prepareStatement(sql);

			ps.setString(1, emprestimo.getPeriodo());
			ps.setInt(2, emprestimo.getIdEmprestimo());

			//Executando a conexo
			//Finalizando a conexo
			//Atribuindo true a varivel inserido 
			ps.execute();
			ps.close();
			atualizado=true;
		}

		catch(Exception e){
			throw new EmprestimoDaoException("Erro na atualizao do emprstimo:"+emprestimo.getIdEmprestimo());

		}

		return atualizado;
	}



	public boolean AtualizaStatusEmprestimo(Emprestimo emprestimo) throws EmprestimoDaoException{
		boolean atualizado=false;

		String sql = "UPDATE emprestimo SET  statusEmprestimo = ?" +
				" Where IDEmprestimo = ?";

		try{

			PreparedStatement ps=c.prepareStatement(sql);

			ps.setString(1, emprestimo.getStatus());
			ps.setInt(2, emprestimo.getIdEmprestimo());

			ps.execute();
			ps.close();
			atualizado=true;
		}

		catch(Exception e){
			throw new EmprestimoDaoException("Erro na atualizao do status do emprstimo:"+emprestimo.getIdEmprestimo());

		}


		return atualizado;
	}


	/*
	 * 
	 * 
	 * 
	 */

	public boolean excluirEmprestimo(Emprestimo emprestimo) throws EmprestimoDaoException{


		boolean excluido=false;

		String sql="DELETE Emprestimo Where IDEmprestimo = ?";

		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, emprestimo.getIdEmprestimo());
			ps.execute();
			ps.close();
			excluido=true;
		}


		catch(Exception e){
			throw new EmprestimoDaoException("Erro na excluso do emprstimo:"+emprestimo.getIdEmprestimo());

		}
		return excluido;
	}



	/*
	 * 
	 * 
	 * 
	 */

	public Emprestimo consultaEmprestimo(Emprestimo emprestimo) throws EmprestimoDaoException{
		Emprestimo consultaEmprestimo = new Emprestimo();

		String sql="Select IDEmprestimo, IDFilme, IDcliente, data, Statusemprestimo, reserva from emprestimo where IDEmprestimo = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, emprestimo.getIdEmprestimo());
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){

				consultaEmprestimo.setIdEmprestimo(emprestimo.getIdEmprestimo());
				consultaEmprestimo.setIdFilme(rs.getInt("IDFilme"));
				consultaEmprestimo.setIdUsuario(rs.getString("IDcliente"));
				consultaEmprestimo.setPeriodo(rs.getString("data"));
				consultaEmprestimo.setStatus(rs.getString("statusemprestimo"));
				consultaEmprestimo.setReserva(rs.getString("Reserva"));

			}else{
				JOptionPane.showMessageDialog(null, "No Encontrado");
			}


			ps.close();
			rs.close();
		}

		catch(Exception e){
			throw new EmprestimoDaoException("Erro na consulta do emprstimo:"+emprestimo.getIdEmprestimo());
		}

		return consultaEmprestimo;
	}


	public Emprestimo consultaIDQuantidadeSoma(int l) throws EmprestimoDaoException{
		Emprestimo emprestimoConsultado=new Emprestimo();

		String sql="Select IDFilme  from Emprestimo where IDEmprestimo = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, l);
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){
				emprestimoConsultado.setIdFilme(rs.getInt("IDFilme"));

			}

			ps.close();
			rs.close();
			FilmeDao filme=new FilmeDao();

			int ID=emprestimoConsultado.getIdFilme();
			filme.consultaIDQuantidadeSoma(ID);
		}


		catch(Exception e){
			throw new EmprestimoDaoException("Erro na rotina que realizaria a tentativa de atualizao posterior da quantidade do filme disponvel aps o cadastro de uma devoluo");
		}


		return emprestimoConsultado;
	}



	public Emprestimo consultaIDQuantidadeSubtrai(int l) throws EmprestimoDaoException{
		Emprestimo emprestimoConsultado=new Emprestimo();

		String sql="Select IDFilme  from Emprestimo where IDEmprestimo = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, l);
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){
				emprestimoConsultado.setIdFilme(rs.getInt("IDFilme"));

			}

			ps.close();
			rs.close();
			FilmeDao filme=new FilmeDao();

			int ID=emprestimoConsultado.getIdFilme();
			filme.consultaIDQuantidadeSubtrai(ID);
		}


		catch(Exception e){
			throw new EmprestimoDaoException("Erro na rotina que realizaria a tentativa de atualizao posterior da quantidade do filme disponvel aps a excluso de uma devoluo");
		}



		return emprestimoConsultado;
	}



	public Emprestimo consultaQuantidadeSoma(int u) throws EmprestimoDaoException{
		Emprestimo emprestimoConsultado=new Emprestimo();

		String sql="Select IDcliente  from Emprestimo where IDEmprestimo = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, u);
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){
				emprestimoConsultado.setIdUsuario(rs.getString("IDcliente"));

			}

			ps.close();
			rs.close();
			ClienteDao cliente=new ClienteDao();

			String ID=emprestimoConsultado.getIdUsuario();
			cliente.consultaIDQuantidadeSoma(ID);
		}


		catch(Exception e){
			throw new EmprestimoDaoException("Erro na rotina que realizaria a tentativa de atualizao posterior da quantidade de filmes em posse do usurio aps a excluso de uma devoluo");
		}

		return emprestimoConsultado;
	}




	public Emprestimo consultaQuantidadeSubtrai(int u) throws EmprestimoDaoException{
		Emprestimo emprestimoConsultado=new Emprestimo();

		String sql="Select IDcliente  from Emprestimo where IDEmprestimo = ?";


		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, u);
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){
				emprestimoConsultado.setIdUsuario(rs.getString("IDcliente"));

			}

			ps.close();
			rs.close();
			ClienteDao cliente=new ClienteDao();

			String ID=emprestimoConsultado.getIdUsuario();
			cliente.consultaIDQuantidadeSubtrai(ID);
		}


		catch(Exception e){
			throw new EmprestimoDaoException("Erro na rotina que realizaria a tentativa de atualizao posterior da quantidade de filmes em posse do usurio aps o cadastro de uma devoluo");
		}


		return emprestimoConsultado;
	}



	public Emprestimo consultaStatus(int emp) throws EmprestimoDaoException{


		Emprestimo emprestimoConsultado=new Emprestimo();

		String sql="Select Statusemprestimo  from Emprestimo where IDEmprestimo = ?";

		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, emp);
			ResultSet rs=ps.executeQuery();     //retornando um result set

			if(rs.next()){
				emprestimoConsultado.setStatus(rs.getString("StatusEmprestimo"));
			}

			ps.close();
			rs.close();				
		}


		catch(Exception e){
			throw new EmprestimoDaoException("Erro na consulta do status do emprstimo");
		}



		return emprestimoConsultado;

	}


	public List<Filme> ListaDeFilmes() throws EmprestimoDaoException{

		List<Filme> listaFilme=new ArrayList<Filme>();

		String sql="select IDFilme, titulo, Ano from Filme";

		try{

			PreparedStatement ps= c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();


			while(rs.next()){
				Filme filme=new Filme();
				filme.setIdFilme(rs.getInt("IDFilme"));
				filme.setTitulo(rs.getString("Titulo"));
				filme.setAno(rs.getString("Ano"));
				listaFilme.add(filme);
			}
		}

		catch(Exception e){
			throw new EmprestimoDaoException("Erro na gerao da lista de filmes");
		}


		return listaFilme;
	}



	public List<Cliente> ListaDeclientes() throws EmprestimoDaoException{

		List<Cliente> listacliente=new ArrayList<Cliente>();

		String sql="select IDcliente, nome from cliente";

		try{

			PreparedStatement ps= c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();


			while(rs.next()){
				Cliente cliente=new Cliente();
				cliente.setIdentificacao(rs.getString("IDcliente"));
				cliente.setNome(rs.getString("Nome"));
				listacliente.add(cliente);
			}
		}

		catch(Exception e){
			throw new EmprestimoDaoException("Erro na gerao da lista de usurios");
		}

		return listacliente;
	}


	public List<Emprestimo> ListaDeEmprestimos() throws EmprestimoDaoException{

		List<Emprestimo> listaEmprestimo=new ArrayList<Emprestimo>();

		//String sql="select IDEmprestimo, IDcliente, IDFilme from Emprestimo";
		String sql="Select IDEmprestimo, IDFilme, IDcliente, Statusemprestimo from emprestimo where Statusemprestimo like ? order by IDEmprestimo";

		try{

			PreparedStatement ps= c.prepareStatement(sql);
			ps.setString(1, "Em andamento");
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				Emprestimo emprestimo=new Emprestimo();
				emprestimo.setIdEmprestimo(rs.getInt("IDEmprestimo"));
				emprestimo.setIdFilme(rs.getInt("IDFilme"));
				emprestimo.setIdUsuario(rs.getString("IDCliente"));
				emprestimo.setStatus(rs.getString("StatusEmprestimo"));


				listaEmprestimo.add(emprestimo);
			}
		}

		catch(Exception e){
			throw new EmprestimoDaoException("Erro na gerao da lista de emprstimos");
		}

		return listaEmprestimo;
	}



	public List<String> geraLista() throws EmprestimoDaoException{

		List<String> listaEmprestimos= new ArrayList<String>();

		String sql = "select Emprestimo.IDEmprestimo, cliente.nome, Filme.titulo, Filme.Ano " +
				"from cliente " +
				"inner Join Emprestimo " +
				"on Emprestimo.IDcliente=cliente.IDcliente " +
				"inner join Filme "+
				"on Filme.IDFilme=Emprestimo.IDFilme "+
				"where Emprestimo.Statusemprestimo like ? ";


		try{
			PreparedStatement ps= c.prepareStatement(sql);
			ps.setString(1, "Em andamento");
			ResultSet rs=ps.executeQuery();

			while(rs.next()){

				//Emprestimo emprestimo=new Emprestimo();  
				Emprestimo emp=new Emprestimo();
				emp.setIdEmprestimo(rs.getInt("IDEmprestimo"));
				Cliente cliente=new Cliente();
				cliente.setNome(rs.getString("Nome"));
				Filme filme=new Filme();
				filme.setTitulo(rs.getString("Titulo"));
				filme.setAno(rs.getString("Ano"));

				//listaNome.add(String.valueOf(emprestimo.getIdEmprestimo()));
				listaEmprestimos.add("ID:"+String.valueOf(emp.getIdEmprestimo()+" Usurio:"+cliente.getNome()+" Filme:"+filme.getTitulo()+" Edio:"+filme.getAno()));

			}
		}


		catch(Exception e){
			throw new EmprestimoDaoException("Erro na gerao da lista de emprstimos em andamento");
		}

		return listaEmprestimos; 
	}


	public List<String> geraListaReservados() throws EmprestimoDaoException{

		List<String> listaReservas = new ArrayList<String>();

		String sql = "select Emprestimo.IDEmprestimo, cliente.nome, Filme.titulo, Filme.Ano " +
				"from cliente " +
				"inner Join Emprestimo " +
				"on Emprestimo.IDcliente=cliente.IDcliente " +
				"inner join Filme "+
				"on Filme.IDFilme=Emprestimo.IDFilme "+
				"where Emprestimo.Statusemprestimo like ? ";


		try{
			PreparedStatement ps= c.prepareStatement(sql);
			ps.setString(1, "Reservado");
			ResultSet rs=ps.executeQuery();

			while(rs.next()){

				//Emprestimo emprestimo=new Emprestimo();  
				Emprestimo emp=new Emprestimo();
				emp.setIdEmprestimo(rs.getInt("IDEmprestimo"));
				Cliente cliente=new Cliente();
				cliente.setNome(rs.getString("Nome"));
				Filme filme=new Filme();
				filme.setTitulo(rs.getString("Titulo"));
				filme.setAno(rs.getString("Ano"));


				//listaNome.add(String.valueOf(emprestimo.getIdEmprestimo()));
				listaReservas.add("ID:"+String.valueOf(emp.getIdEmprestimo()+" Usurio:"+cliente.getNome()+" Filme:"+filme.getTitulo()+" Edio:"+filme.getAno()));

			}
		}


		catch(Exception e){
			throw new EmprestimoDaoException("Erro na gerao da lista de reservas cadastradas");
		}

		return listaReservas; 
	}


	public List<String> geraListaData(Emprestimo emprestimo) throws EmprestimoDaoException{

		List<String> listaEmprestimosData = new ArrayList<String>();

		String sql = "select Emprestimo.IDEmprestimo, cliente.nome, Filme.titulo, Filme.Ano " +
				"from cliente " +
				"inner Join Emprestimo " +
				"on Emprestimo.IDcliente=cliente.IDcliente " +
				"inner join Filme "+
				"on Filme.IDFilme=Emprestimo.IDFilme "+
				"where Emprestimo.data = ? ";


		try{
			PreparedStatement ps= c.prepareStatement(sql);
			ps.setString(1, emprestimo.getPeriodo());
			ResultSet rs=ps.executeQuery();

			while(rs.next()){

				Emprestimo emp=new Emprestimo();  
				emp.setIdEmprestimo(rs.getInt("IDEmprestimo"));

				Cliente cliente=new Cliente();
				cliente.setNome(rs.getString("Nome"));

				Filme filme=new Filme();
				filme.setTitulo(rs.getString("Titulo"));
				filme.setAno(rs.getString("Ano"));



				listaEmprestimosData.add("ID:"+emp.getIdEmprestimo()+" cliente:"+cliente.getNome()+" Ttulo:"+filme.getTitulo()+" Edio:"+filme.getAno());
			}
		}


		catch(Exception e){
			throw new EmprestimoDaoException("Erro na gerao da lista de emprstimos por data");
		}

		return listaEmprestimosData; 
	}



	public List<String> filmesEmAtraso(Emprestimo emprestimo) throws EmprestimoDaoException{

		List<String> listaEmprestimosData = new ArrayList<String>();

		String sql = "select cliente.nome, cliente.email, Filme.titulo " +
				"from cliente " +
				"inner Join Emprestimo " +
				"on Emprestimo.IDcliente=cliente.IDcliente " +
				"inner join Filme "+
				"on Filme.IDFilme=Emprestimo.IDFilme "+
				"where Emprestimo.data = ? and statusEmprestimo = ? ";


		try{
			PreparedStatement ps= c.prepareStatement(sql);
			ps.setString(1, emprestimo.getPeriodo());
			ps.setString(2, "Em andamento");
			ResultSet rs=ps.executeQuery();

			while(rs.next()){

				Cliente cliente=new Cliente();
				cliente.setNome(rs.getString("Nome"));

				cliente.setEmail(rs.getString("Email"));

				Filme filme=new Filme();
				filme.setTitulo(rs.getString("Titulo"));

				listaEmprestimosData.add("cliente: "+cliente.getNome()+" Email:"+cliente.getEmail() +" Ttulo: "+filme.getTitulo());
			}
		}


		catch(Exception e){
			throw new EmprestimoDaoException("Erro na gerao da lista de emprstimos em atraso");
		}

		return listaEmprestimosData; 
	}


	public List<String> listaDeEmailsEmAtraso(Emprestimo emprestimo) throws EmprestimoDaoException{

		List<String> listaEmprestimosData = new ArrayList<String>();

		String sql = "select cliente.email " +
				"from cliente " +
				"inner Join Emprestimo " +
				"on Emprestimo.IDcliente=cliente.IDcliente " +
				"inner join Filme "+
				"on Filme.IDFilme=Emprestimo.IDFilme "+
				"where Emprestimo.data = ? and statusEmprestimo = ? ";


		try{
			PreparedStatement ps= c.prepareStatement(sql);
			ps.setString(1, emprestimo.getPeriodo());
			ps.setString(2, "Em andamento");
			ResultSet rs=ps.executeQuery();

			while(rs.next()){

				Cliente cliente=new Cliente();				
				cliente.setEmail(rs.getString("Email"));


				listaEmprestimosData.add(cliente.getEmail());
			}
		}


		catch(Exception e){
			throw new EmprestimoDaoException("Erro na gerao da lista de emails de emprstimos em atraso");
		}

		return listaEmprestimosData; 
	}

    @Override
    public List<String> FilmesEmAtraso(Emprestimo emprestimo) throws EmprestimoDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
