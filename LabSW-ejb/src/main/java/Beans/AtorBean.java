/*  .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   */
package Beans;

import          Entidades   .Ator;
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
@ManagedBean (name = "atorBean")
public  class   AtorBean    implements  Serializable    {
    private static  final   long        serialVersionUID    = 0x30L;
    private         final   List<Ator>  atores;
    private                 Ator        atorAtual;
    
    public  AtorBean    () {
        this.atores     = new ArrayList<>   ();
        this.atorAtual  = new Ator          ();
    }
    
    public  void        adicionarNovo   () {
        this.atores.add(atorAtual);
        this.atorAtual  = new Ator  ();
    }
    
    public  List<Ator>  getAtores       () {
        return  atores;
    }

    public  Ator        getAtorAtual    () {
        return  atorAtual;
    }
    
    public  void        setAtores       () {
        this.atores.add(atorAtual);
        this.atorAtual  = new Ator  ();
    }

    public  void        setAtorAtual    (Ator atorAtual) {
        this.atorAtual  = atorAtual;
    }
}