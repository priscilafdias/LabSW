/*  .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   */
package Beans;

import          java        .io         .Serializable;
import          javax       .ejb        .Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @version 1.00.00
 * @author  Theyous <Theyous @ TheyousTK.Github.IO>;
 */

@Stateful
@ViewScoped
@ManagedBean (name = "paginaInicialBeanAux")
public  class   PaginaInicialBeanAux    implements  Serializable    {
    private static  final   long    serialVersionUID    = 0xEEL;
    private                 String  urlAtual;
    
    public  PaginaInicialBeanAux () {
        this.urlAtual   = "boasvindas.xhtml";
    }
    
    public  String  getUrlAtual () {
        FacesContext.getCurrentInstance().renderResponse();
        return  urlAtual;
    }
    
    public  void    setUrlAtual (String urlAtual) {
        this.urlAtual   = urlAtual + ".xhtml";
        FacesContext.getCurrentInstance().renderResponse();
    }
}