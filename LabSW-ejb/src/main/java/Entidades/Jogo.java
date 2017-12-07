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
public  class   Jogo    implements  Serializable    {
    private static  final   long    serialVersionUID    = 0x08L;
    @Id
    private int     id;
    private String  titulo;
    private String  produtora;
    private String  console;
    private int     ano;
    private String  categoria;
    private String  descricao;
    
    public  int     getId           () {
        return id;
    }

    public  String  getTitulo       () {
        return titulo;
    }

    public  String  getProdutora    () {
        return produtora;
    }

    public  String  getConsole      () {
        return console;
    }

    public  int     getAno          () {
        return ano;
    }

    public  String  getCategoria    () {
        return categoria;
    }

    public  String  getDescricao    () {
        return descricao;
    }

    public  void    setId           (int id) {
        this.id         = id;
    }

    public  void    setTitulo       (String titulo) {
        this.titulo     = titulo;
    }

    public  void    setProdutora    (String produtora) {
        this.produtora  = produtora;
    }

    public  void    setConsole      (String console) {
        this.console    = console;
    }

    public  void    setAno          (int ano) {
        this.ano        = ano;
    }

    public  void    setCategoria    (String categoria) {
        this.categoria  = categoria;
    }

    public  void    setDescricao    (String descricao) {
        this.descricao  = descricao;
    }
}