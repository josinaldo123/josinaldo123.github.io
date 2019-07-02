
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
public class ClientePJ extends Cliente{
    
    private String cnpj;
    
    public ClientePJ(String nome, String cnpj){
        super(nome);
        this.cnpj = cnpj;
        
    }
    public String getCodigo(){
        return this.cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public boolean equals(Cliente c) {
        if(this.cnpj.equals(c.getCodigo())){
            return true;
        }
        return false;
    }
    
    
}
