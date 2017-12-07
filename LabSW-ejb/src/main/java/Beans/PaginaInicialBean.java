/*  .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   */
package Beans;

import          java        .io         .Serializable;
import          javax       .ejb        .Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @version 1.00.00
 * @author  Theyous <Theyous @ TheyousTK.Github.IO>;
 */

@Stateful
@SessionScoped
@ManagedBean (name = "paginaInicialBean")
public  class   PaginaInicialBean    implements  Serializable    {
    private static  final   long    serialVersionUID    = 0xEEL;
    private                 String  urlAtual;
    
    public  PaginaInicialBean   () {
        this.urlAtual   = "boasvindas.xhtml";
    }
    
    public  String  getUrlAtual () {
        return  urlAtual;
    }
    
    public  void    setUrlAtual (String urlAtual) {
        this.urlAtual   = urlAtual + ".xhtml";
        FacesContext.getCurrentInstance().renderResponse();
    }
}