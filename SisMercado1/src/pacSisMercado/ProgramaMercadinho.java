package pacSisMercado;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Josinaldo
 */
public class ProgramaMercadinho {

    public static void main(String[] args) throws IOException {
        SisMercadoLCC sistema = new SisMercadoLCC();
        boolean sair = false;
        boolean logado = false;
        sistema.recuperarDados();

        while (!logado) {
            try {
                int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção\n"
                        + "1.Login\n"
                        + "2.Cadastrar novo usuário\n"
                        + "3.Sair"));
                if (opcao == 1) {
                    String login = JOptionPane.showInputDialog("Login: ");
                    String senha = JOptionPane.showInputDialog("Senha: ");
                    if (sistema.verificaLogin(login, senha)) {
                        logado = true;
                    }
                }
                if (opcao == 2) {

                    String nome = JOptionPane.showInputDialog("Informe seu nome: ");
                    String login = JOptionPane.showInputDialog("Novo login: ");
                    String senha = JOptionPane.showInputDialog("Crie sua senha: ");
                    Usuario u = new Usuario(login, nome, senha);
                    sistema.cadastraUsuario(u);
                    sistema.gravarDados();
                    continue;
                }
                if (opcao == 3) {
                    return;
                    
                }
            } catch (UsuarioJaExiste usu) {
                JOptionPane.showMessageDialog(null, usu.getMessage());
                usu.printStackTrace();

            }
        }
        while (!sair) {
            try {
                int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n"
                        + "1.Cadastra novo cliente\n"
                        + "2.Obter lista de clientes\n"
                        + "3.Pesquisar usuários\n"
                        + "4.Sair"));
           
                if (opcao == 1) {
                    int opcao2 = Integer.parseInt(JOptionPane.showInputDialog("1.Pessoa Física\n" + "2.Pessoa Jurídica\n"));
                    String nome = JOptionPane.showInputDialog("Informe seu nome: ");
                    if (opcao2 == 1) {
                        String cpf = JOptionPane.showInputDialog("Informe seu CPF: ");
                        Cliente c = new ClientePF(nome, cpf);
                        sistema.cadastrarCliente(c);
                        sistema.gravarDados();
                    }
                    if (opcao2 == 2) {
                        String cnpj = JOptionPane.showInputDialog("Informe seu CNPJ: ");
                        Cliente c2 = new ClientePJ(nome, cnpj);
                        sistema.cadastrarCliente(c2);
                        sistema.gravarDados();
                    }
                }
                if (opcao == 2) {
                    List<Cliente> clientes = sistema.obterListaDeCliente();
                    for (Cliente c : clientes) {
                        JOptionPane.showMessageDialog(null, c.toString());
                    }
                }
                if (opcao == 3) {
                    String prefixo = JOptionPane.showInputDialog("");
                    for (Usuario u : sistema.pesquisaUsuarioComNomeComecandoCom(prefixo)) {
                        JOptionPane.showMessageDialog(null, u.getNome());
                    }

                }
                if (opcao == 4) {
                    sair = true;
                }
            } catch (ClienteJaExiste c) {
                JOptionPane.showMessageDialog(null, c.getMessage());
                c.printStackTrace();
            }

        }

    }
}
