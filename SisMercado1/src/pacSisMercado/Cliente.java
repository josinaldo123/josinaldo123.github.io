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
public abstract class Cliente {

    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public abstract String getCodigo();

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cliente{" + "Nome: " + nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.getCodigo());
        return hash;
    }

    public abstract boolean equals(Cliente c);

}
