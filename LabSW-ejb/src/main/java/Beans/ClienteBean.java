/*  .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   */
package Beans;

import          Entidades   .Cliente;
import          java        .io         .Serializable;
import          java        .util       .ArrayList;
import          java        .util       .List;
import          javax       .ejb        .Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @version 1.00.00
 * @author  Theyous <Theyous @ TheyousTK.Github.IO>;
 */

@Stateful
@ViewScoped
@ManagedBean (name = "clienteBean")
public  class   ClienteBean    implements  Serializable    {
    private static  final   long        serialVersionUID    = 0x30L;
    private         final   List<Cliente>  clientees;
    private                 Cliente        clienteAtual;
    
    public  ClienteBean    () {
        this.clientees     = new ArrayList<>   ();
        this.clienteAtual  = new Cliente          ();
    }
    
    public  void        adicionarNovo   () {
        this.clientees.add(clienteAtual);
        this.clienteAtual  = new Cliente  ();
    }
    
    public  List<Cliente>  getClientees       () {
        return  clientees;
    }

    public  Cliente        getClienteAtual    () {
        return  clienteAtual;
    }
    
    public  void        setClientees       () {
        this.clientees.add(clienteAtual);
        this.clienteAtual  = new Cliente  ();
    }

    public  void        setClienteAtual    (Cliente clienteAtual) {
        this.clienteAtual  = clienteAtual;
    }
}