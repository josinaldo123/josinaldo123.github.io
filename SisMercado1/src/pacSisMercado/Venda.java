package pacSisMercado;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josinaldo
 */
public class Venda {
     private int quantidade;
     private Cliente cliente;
     private Produto produto;
     private Usuario usuario;

    public Venda(int quantidade, Cliente cliente, Produto produto, Usuario usuario) {
        this.quantidade = quantidade;
        this.cliente = cliente;
        this.produto = produto;
        this.usuario = usuario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Venda{" + "quantidade=" + quantidade + ", cliente=" + cliente + ", produto=" + produto + ", usuario=" + usuario + '}';
    }
    
    
    
}

