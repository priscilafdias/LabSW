/*  .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   */
package Beans;

import          Entidades   .Jogo;
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
@ManagedBean (name = "jogoBean")
public  class   JogoBean    implements  Serializable    {
    private static  final   long        serialVersionUID    = 0x30L;
    private         final   List<Jogo>  jogoes;
    private                 Jogo        jogoAtual;
    
    public  JogoBean    () {
        this.jogoes     = new ArrayList<>   ();
        this.jogoAtual  = new Jogo          ();
    }
    
    public  void        adicionarNovo   () {
        this.jogoes.add(jogoAtual);
        this.jogoAtual  = new Jogo  ();
    }
    
    public  List<Jogo>  getJogoes       () {
        return  jogoes;
    }

    public  Jogo        getJogoAtual    () {
        return  jogoAtual;
    }
    
    public  void        setJogoes       () {
        this.jogoes.add(jogoAtual);
        this.jogoAtual  = new Jogo  ();
    }

    public  void        setJogoAtual    (Jogo jogoAtual) {
        this.jogoAtual  = jogoAtual;
    }
}