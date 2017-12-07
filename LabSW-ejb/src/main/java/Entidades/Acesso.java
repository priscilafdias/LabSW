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
public  class   Acesso  implements  Serializable    {
    private static  final   long    serialVersionUID    =   0x02L;
    
    @Id
    private int     IDAcesso;
    private String  login_usuario;
    private String  senha;
    private String  cargo;
    private String  cpf;

    public  int     getIDAcesso     () {
        return  IDAcesso;
    }

    public  String  getLogin_usuario() {
        return  login_usuario;
    }

    public  String  getSenha        () {
        return  senha;
    }

    public  String  getCargo        () {
        return  cargo;
    }

    public  String  getCpf          () {
        return  cpf;
    }

    public  void    setIDAcesso     (int IDAcesso) {
        this.IDAcesso       = IDAcesso;
    }

    public  void    setLogin_usuario(String login_usuario) {
        this.login_usuario  = login_usuario;
    }

    public  void    setSenha        (String senha) {
        this.senha          = senha;
    }

    public  void    setCargo        (String cargo) {
        this.cargo          = cargo;
    }

    public  void    setCpf          (String cpf) {
        this.cpf            = cpf;
    }
}
