package pacSisMercado;

import java.io.IOException;
import java.util.ArrayList;
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
public class SisMercadoLCC implements SisMercado {

    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Produto> ListaDeProdutos;
    private List<Cliente> clientes;
    private List<Venda> vendas;
    GravadorDeDados gravador = new GravadorDeDados();

    public SisMercadoLCC() {
        this.usuarios = new ArrayList<Usuario>();
        this.ListaDeProdutos = new ArrayList<Produto>();
        this.clientes = new ArrayList<Cliente>();
        this.vendas = new ArrayList<Venda>();
    }

    public void cadastraUsuario(Usuario u) throws UsuarioJaExiste {

        for (Usuario us : this.usuarios) {
            if (us.equals(u)) {
                throw new UsuarioJaExiste("Já existe esse usuário!");
            }
        }
        this.usuarios.add(u);
    }

    @Override
    public void cadastraProduto(Produto produto) {

        boolean achou = false;
        for (Produto p : this.ListaDeProdutos) {
            if (p.getCodigo().equals(produto.getCodigo())) {
                achou = true;
            }
        }
        if (!achou) {
            this.ListaDeProdutos.add(produto);
        } else {
            System.out.println("Produto já cadastrado");
        }
    }

    @Override
    public void cadastraVenda(Venda venda) {
        this.vendas.add(venda);
    }

    @Override
    public boolean verificaLogin(String login, String senha) {
        boolean logado = false;
        try {
            for (Usuario u : this.gravador.recuperaUsuarios("usuario.txt")) {
                if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                    logado = true;

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SisMercadoLCC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logado;
    }

    @Override
    public List<Usuario> pesquisaUsuarioComNomeComecandoCom(String prefixo) {
        List<Usuario> listaUsuario = new ArrayList<>();
        for (Usuario u : this.usuarios) {
            if (u.getNome().startsWith(prefixo)) {
                listaUsuario.add(u);
            }
        }
        return listaUsuario;
    }

    @Override
    public List<Cliente> obterListaDeCliente() {
        return this.clientes;
    }

    @Override
    public void cadastrarCliente(Cliente cliente) throws ClienteJaExiste {
        for (Cliente c : this.clientes) {
            if (c.equals(cliente)) {
                throw new ClienteJaExiste("Já existe esse Cliente!");

            }
        }
        this.clientes.add(cliente);
    }

    @Override
    public void recuperarDados() throws IOException {
        try {
            this.usuarios = gravador.recuperaUsuarios("usuario.txt");
            this.clientes = gravador.recuperaClientes("clientesPF.txt", "clientesPJ.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void gravarDados() throws IOException {
        try {
            this.gravador.gravaUsuario(usuarios, "usuario.txt");
            List<ClientePF> clientespf = new ArrayList<ClientePF>();
            List<ClientePJ> clientespj = new ArrayList<ClientePJ>();
            for (Cliente c : this.clientes) {
                if (c.getClass() == pacSisMercado.ClientePF.class) {
                    clientespf.add((ClientePF) c);
                } else if (c.getClass() == pacSisMercado.ClientePJ.class) {
                    clientespj.add((ClientePJ) c);
                }
            }
            this.gravador.gravaClientesPF(clientespf, "clientesPF.txt");
            this.gravador.gravaClientesPJ(clientespj, "clientesPJ.txt");
        } catch (IOException erro) {
            erro.printStackTrace();
        }

    }
}
