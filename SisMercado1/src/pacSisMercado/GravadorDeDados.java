/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacSisMercado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Josinaldo
 */
public class GravadorDeDados {

    public void gravaClientesPJ(List<ClientePJ> ClientePJ, String nomeArquivo)
            throws IOException {
        BufferedWriter gravador = null;
        try {  //Começo do try, testando até encontrar algum erro.
            gravador = new BufferedWriter(new FileWriter(nomeArquivo));
            for (Cliente s : ClientePJ) {
                gravador.write(s.getNome() + "\r\n");
                gravador.write(s.getCodigo() + "\r\n");

            }
            //Fim do try        
        } finally {
            if (gravador != null) {
                gravador.close();//fecha o stream(fluxo) de escrita
            }
        }
    }

    public void gravaClientesPF(List<ClientePF> ClientePF, String nomeArquivo)
            throws IOException {
        BufferedWriter gravador = null;
        try { //Começo do try, testando até encontrar algum erro.
            gravador = new BufferedWriter(new FileWriter(nomeArquivo));
            for (Cliente s : ClientePF) {
                gravador.write(s.getNome() + "\r\n");
                gravador.write(s.getCodigo() + "\r\n");
            }
            //Fim do try    
        } finally {
            if (gravador != null) {
                gravador.close();//fecha o stream(fluxo) de escrita
            }
        }
    }

    public void gravaUsuario(List<Usuario> usuario, String nomeArquivo)
            throws IOException {
        BufferedWriter gravador = null;
        try { //Começo do try, testando até encontrar algum erro.
            gravador = new BufferedWriter(new FileWriter(nomeArquivo));
            for (Usuario s : usuario) {
                gravador.write(s.getNome() + "\r\n");
                gravador.write(s.getLogin() + "\r\n");
                gravador.write(s.getSenha() + "\r\n");
            }
            //Fim do try    
        } finally {
            if (gravador != null) {
                gravador.close();//fecha o stream(fluxo) de escrita
            }
        }
    }

    public List<Cliente> recuperaClientes(String nomeArquivo, String nomeArquivo2) throws IOException {
        BufferedReader leitorPF = null, leitorPJ = null;
        List<Cliente> clientelido = new ArrayList<>();
        try {
            leitorPF = new BufferedReader(new FileReader(nomeArquivo));
            leitorPJ = new BufferedReader(new FileReader(nomeArquivo2));
            String nomePF = null, codigoPF = null, nomePJ = null, codigoPJ = null;
            do {
                nomePF = leitorPF.readLine();
                codigoPF = leitorPF.readLine(); 
                if (nomePF != null && codigoPF != null) {
                    ClientePF clientespf = new ClientePF(nomePF, codigoPF);
                    clientelido.add(clientespf);
                }
            } while(codigoPF != null);
            do{
                nomePJ = leitorPJ.readLine();
                codigoPJ = leitorPJ.readLine(); 
                if (nomePJ != null && codigoPJ != null) {
                    ClientePJ clintespj = new ClientePJ(nomePJ, codigoPJ);
                    clientelido.add(clintespj);
                }
            } while (codigoPJ != null);
        } finally {
            if (leitorPF != null && leitorPJ != null) {
                leitorPF.close();//fecha o stream(fluxo) de leitura
                leitorPJ.close();//fecha o stream(fluxo) de leitura

            }

        }
        return clientelido;

    }

    public List<Usuario> recuperaUsuarios(String nomeArquivo) throws IOException {
        BufferedReader leitor = null;
        List<Usuario> usuariosreturn = new ArrayList<Usuario>();
        try {
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String login = null, nome = null, senha = null;
            do {
                nome = leitor.readLine();
                login = leitor.readLine();
                senha = leitor.readLine();
                
                if (nome != null && login != null && senha != null) {
                    Usuario usuarionew = new Usuario(login, nome, senha);
                    usuariosreturn.add(usuarionew);
                    
                }
            } while (nome != null && login != null && senha != null);
           
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
        
        return usuariosreturn;
    }

}
