package pacSisMercado;

import java.io.IOException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josinaldo
 */
public interface SisMercado {
    public void cadastraUsuario(Usuario u) throws UsuarioJaExiste;
    public void cadastrarCliente(Cliente cliente) throws ClienteJaExiste;
    public void cadastraProduto(Produto produto);
    public void cadastraVenda(Venda venda);
    public boolean verificaLogin(String login,String senha);
    public List<Usuario> pesquisaUsuarioComNomeComecandoCom(String prefixo);
    public List<Cliente> obterListaDeCliente();
    public void recuperarDados()throws IOException;
    public void gravarDados() throws IOException; 
    
    
        
    
}
