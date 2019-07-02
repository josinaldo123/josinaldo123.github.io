/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacSisMercado;

/**
 *
 * @author Josinaldo
 */
public class Produto {
    private String codigo;
    private String nome;
    private double precoAtacado;
    private double precoVarejo;
    public Produto(String codigo, String nome, double precoAtacado, double precoVarejo) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoAtacado = precoAtacado;
        this.precoVarejo = precoVarejo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoAtacado() {
        return precoAtacado;
    }

    public void setPrecoAtacado(double precoAtacado) {
        this.precoAtacado = precoAtacado;
    }

    public double getPrecoVarejo() {
        return precoVarejo;
    }

    public void setPrecoVarejo(double precoVarejo) {
        this.precoVarejo = precoVarejo;
    }


    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", nome=" + nome + ", precoAtacado=" + precoAtacado + ", precoVarejo=" + precoVarejo + '}';
    }
    
    
    
}
