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
public  class   Cliente     implements  Serializable    {
    private static  final   long    serialVersionUID    = 0x04L;
    @Id
    private String  identificacao;
    private String  nome;
    private String  RG;
    private String  Data_Nasc;
    private String  endereco;
    private int     numero;
    private String  bairro;
    private String  cep;
    private String  cidade;
    private String  UF;
    private String  email;
    private String  telefone;
    private int     quantidade_midia_posse;
    private String  categoria;

    public  String  getIdentificacao            () {
        return identificacao;
    }

    public  String  getNome                     () {
        return nome;
    }

    public  String  getRG                       () {
        return RG;
    }

    public  String  getData_Nasc                () {
        return Data_Nasc;
    }

    public  String  getEndereco                 () {
        return endereco;
    }

    public  int     getNumero                   () {
        return numero;
    }

    public  String  getBairro                   () {
        return bairro;
    }

    public  String  getCep                      () {
        return cep;
    }

    public  String  getCidade                   () {
        return cidade;
    }

    public  String  getUF                       () {
        return UF;
    }

    public  String  getEmail                    () {
        return email;
    }

    public  String  getTelefone                 () {
        return telefone;
    }

    public  int     getQuantidade_midia_posse   () {
        return quantidade_midia_posse;
    }

    public  String  getCategoria                () {
        return categoria;
    }

    public  void    setIdentificacao            (String identificacao) {
        this.identificacao          = identificacao;
    }

    public  void    setNome                     (String nome) {
        this.nome                   = nome;
    }

    public  void    setRG                       (String RG) {
        this.RG                     = RG;
    }

    public  void    setData_Nasc                (String Data_Nasc) {
        this.Data_Nasc              = Data_Nasc;
    }

    public  void    setEndereco                 (String endereco) {
        this.endereco               = endereco;
    }

    public  void    setNumero                   (int numero) {
        this.numero                 = numero;
    }

    public  void    setBairro                   (String bairro) {
        this.bairro                 = bairro;
    }

    public  void    setCep                      (String cep) {
        this.cep                    = cep;
    }

    public  void    setCidade                   (String cidade) {
        this.cidade                 = cidade;
    }

    public  void    setUF                       (String UF) {
        this.UF                     = UF;
    }

    public  void    setEmail                    (String email) {
        this.email                  = email;
    }

    public  void    setTelefone                 (String telefone) {
        this.telefone               = telefone;
    }

    public  void    setQuantidade_midia_posse   (int quantidade_midia_posse) {
        this.quantidade_midia_posse = quantidade_midia_posse;
    }

    public  void    setCategoria                (String categoria) {
        this.categoria              = categoria;
    }
}