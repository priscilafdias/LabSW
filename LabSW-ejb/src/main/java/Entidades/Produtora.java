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
public  class   Produtora   implements  Serializable    {
    private static  final   long    serialVersionUID    = 0x09L;
    @Id
    private int     idProdutora;
    private String  nome;
    private String  descricao;
    
    public  Produtora   () {
        this.idProdutora    = 1;
        this.nome           = "Produtora";
        this.descricao      = "Descrição da Produtora.";
    }

    public  int     getIdProdutora  () {
        return  idProdutora;
    }

    public  String  getNome         () {
        return  nome;
    }

    public  String  getDescricao    () {
        return  descricao;
    }

    public  void    setIdProdutora  (int idProdutora) {
        this.idProdutora    = idProdutora;
    }

    public  void    setNome         (String nome) {
        this.nome           = nome;
    }

    public  void    setDescricao    (String descricao) {
        this.descricao      = descricao;
    }
}