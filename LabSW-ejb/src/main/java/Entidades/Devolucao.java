/*  .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   */
package Entidades;

import  java    .io         .Serializable;
import  javax   .persistence.Entity;
import  javax   .persistence.Id;

/**
 * @version 1.00.00
 * @author  Theyous <Theyous @ TheyousTK.Github.IO>;
 */

@Entity
public  class   Devolucao   implements  Serializable    {
    @Id
    private int     idEmprestimo;
    private String  atrasado;
    private int     diasAtraso;
    private float   multa;

    public  int     getIdEmprestimo () {
        return idEmprestimo;
    }

    public  String  getAtrasado     () {
        return atrasado;
    }

    public  int     getDiasAtraso   () {
        return diasAtraso;
    }

    public  float   getMulta        () {
        return multa;
    }

    public  void    setIdEmprestimo (int idEmprestimo) {
        this.idEmprestimo   = idEmprestimo;
    }

    public  void    setAtrasado     (String atrasado) {
        this.atrasado       = atrasado;
    }

    public  void    setDiasAtraso   (int diasAtraso) {
        this.diasAtraso     = diasAtraso;
    }

    public  void    setMulta        (float multa) {
        this.multa          = multa;
    }
}
