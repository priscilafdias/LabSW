/*  .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   */
package Beans;

import          Entidades   .Filme;
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
@ManagedBean (name = "filmeBean")
public  class   FilmeBean    implements  Serializable    {
    private static  final   long        serialVersionUID    = 0x30L;
    private         final   List<Filme>  filmees;
    private                 Filme        filmeAtual;
    
    public  FilmeBean    () {
        this.filmees     = new ArrayList<>   ();
        this.filmeAtual  = new Filme          ();
    }
    
    public  void        adicionarNovo   () {
        this.filmees.add(filmeAtual);
        this.filmeAtual  = new Filme  ();
    }
    
    public  List<Filme>  getFilmees       () {
        return  filmees;
    }

    public  Filme        getFilmeAtual    () {
        return  filmeAtual;
    }
    
    public  void        setFilmees       () {
        this.filmees.add(filmeAtual);
        this.filmeAtual  = new Filme  ();
    }

    public  void        setFilmeAtual    (Filme filmeAtual) {
        this.filmeAtual  = filmeAtual;
    }
}