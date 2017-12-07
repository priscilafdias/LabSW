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
public  class   Ator    implements  Serializable    {
    private static  final   long    serialVersionUID    = 0x03L;
    @Id
    private                 int     idAtor;
    private                 String  nome;
    private                 String  descricao;
    
    public  Ator    () {
        this.nome       = "";
        this.descricao  = "";
    }

    public  int     getIdAtor   () {
        return  idAtor;
    }

    public  String  getNome     () {
        return  nome;
    }

    public  String  getDescricao() {
        return  descricao;
    }

    public  void    setNome     (String nome) {
        this.nome       = nome;
    }

    public  void    setDescricao(String descricao) {
        this.descricao  = descricao;
    }
}