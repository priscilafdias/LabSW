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
public  class   Filme   implements  Serializable    {
    @Id
    private int     idFilme;
    private String  titulo;
    private String  ano;
    private int     n_dvd;
    private String  descricao;
    private String  classificacao;
    private String  tema;
    private String  localizacao;
    private int     qtde;
    private String  status;
    private int     quantidade_disponivel;

    public  int     getIdFilme                  () {
        return idFilme;
    }

    public  String  getTitulo                   () {
        return titulo;
    }

    public  String  getAno                      () {
        return ano;
    }

    public  int     getN_dvd                    () {
        return n_dvd;
    }

    public  String  getDescricao                () {
        return descricao;
    }

    public  String  getClassificacao            () {
        return classificacao;
    }

    public  String  getTema                     () {
        return tema;
    }

    public  String  getLocalizacao              () {
        return localizacao;
    }

    public  int     getQtde                     () {
        return qtde;
    }

    public  String  getStatus                   () {
        return status;
    }

    public  int     getQuantidade_disponivel    () {
        return quantidade_disponivel;
    }

    public  void    setIdFilme                  (int idFilme) {
        this.idFilme                = idFilme;
    }

    public  void    setTitulo                   (String titulo) {
        this.titulo                 = titulo;
    }

    public  void    setAno                      (String ano) {
        this.ano                    = ano;
    }

    public  void    setN_dvd                    (int n_dvd) {
        this.n_dvd                  = n_dvd;
    }

    public  void    setDescricao                (String descricao) {
        this.descricao              = descricao;
    }

    public  void    setClassificacao            (String classificacao) {
        this.classificacao          = classificacao;
    }

    public  void    setTema                     (String tema) {
        this.tema                   = tema;
    }

    public  void    setLocalizacao              (String localizacao) {
        this.localizacao            = localizacao;
    }

    public  void    setQtde                     (int qtde) {
        this.qtde                   = qtde;
    }

    public  void    setStatus                   (String status) {
        this.status                 = status;
    }

    public  void    setQuantidade_disponivel    (int quantidade_disponivel) {
        this.quantidade_disponivel  = quantidade_disponivel;
    }
}