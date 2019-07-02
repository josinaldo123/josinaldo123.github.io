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
public class ClientePF extends Cliente {

    private String cpf;

    public ClientePF(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;

    }

    public String getCpf() {
        return cpf;
    }

    public String getCodigo() {
        return this.cpf;

    }

    @Override
    public boolean equals(Cliente c) {
        if(this.cpf.equals(c.getCodigo())){
            return true;
        }
        return false;
    }
    

}
