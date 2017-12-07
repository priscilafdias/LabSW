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
public  class   Emprestimo  implements  Serializable    {
    @Id
    private int     idEmprestimo;
    private String  idUsuario;
    private int     idFilme;
    private String  periodo; 
    private String  status; 
    private String  reserva;

    public  int     getIdEmprestimo () {
        return idEmprestimo;
    }

    public  String  getIdUsuario    () {
        return idUsuario;
    }

    public  int     getIdFilme      () {
        return idFilme;
    }

    public  String  getPeriodo      () {
        return periodo;
    }

    public  String  getStatus       () {
        return status;
    }

    public  String  getReserva      () {
        return reserva;
    }

    public  void    setIdEmprestimo (int idEmprestimo) {
        this.idEmprestimo   = idEmprestimo;
    }

    public  void    setIdUsuario    (String idUsuario) {
        this.idUsuario      = idUsuario;
    }

    public  void    setIdFilme      (int idFilme) {
        this.idFilme        = idFilme;
    }

    public  void    setPeriodo         (String periodo) {
        this.periodo        = periodo;
    }

    public  void    setStatus       (String status) {
        this.status         = status;
    }

    public  void    setReserva      (String reserva) {
        this.reserva        = reserva;
    }
}