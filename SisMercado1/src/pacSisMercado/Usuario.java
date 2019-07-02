
package pacSisMercado;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josinaldo
 */
public class Usuario {
    private String login;
    private String nome;
    private String senha;
    
    public Usuario(){
        this.setLogin("");
        this.setNome("");
        this.setSenha("");
       
    }
    public Usuario(String login, String nome, String senha){
        this.setLogin(login);
        this.setNome(nome);
        this.setSenha(senha);
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.login);
        return hash;
    }

    
    public boolean equals(Usuario u) {
        if(this.login.equals(u.getLogin())){
            return true;
        }
        return false;
       
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
