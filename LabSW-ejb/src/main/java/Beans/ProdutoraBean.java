/*  .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   */
package Beans;

import          Entidades   .Produtora;
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
@ManagedBean (name = "produtoraBean")
public  class   ProdutoraBean    implements  Serializable    {
    private static  final   long            serialVersionUID    = 0x90L;
    private         final   List<Produtora> produtoras;
    private                 Produtora       produtoraAtual;
    
    public  ProdutoraBean    () {
        this.produtoras     = new ArrayList<>   ();
        this.produtoraAtual = new Produtora     ();
    }
    
    public  void            adicionarNovo       () {
        produtoras.add(produtoraAtual);
        this.produtoraAtual = new Produtora     ();
    }
    
    public  List<Produtora> getProdutoras       () {
        return  produtoras;
    }

    public  Produtora       getProdutoraAtual   () {
        return  produtoraAtual;
    }

    public  void            setProdutoraAtual   (Produtora produtoraAtual) {
        this.produtoraAtual = produtoraAtual;
    }
}