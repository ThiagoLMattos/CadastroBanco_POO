// Sistema.java
package controllers;

import models.Cliente;
import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;
import java.util.ArrayList;
import java.util.List;

// Classe que coordena a lógica de negócio do sistema
public class Sistema {

    // Listas para armazenar clientes e contas (simulando um banco de dados em memória)
    private List<Cliente> clientes;
    private List<Conta> contas;

    // Construtor
    public Sistema() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    // Metódo para a criação de cadastro, recebe todos (menos saldo) os parametros de Cliente e Conta
    public boolean gravarCadastro(String nome, String endereco, String telefone, String cpf, int agencia,
            int numeroConta, String tipoConta) {

        // Verifica se a conta já existe antes de gravar
        if (consultarCompleto(agencia, numeroConta) != null) {
            System.out.println("Erro: A conta com a agência e número informados já existe.");
            return false;
        }
        
        // Cria e armazena o objeto Cliente
        Cliente novoCliente = new Cliente(nome, endereco, telefone, cpf);
        this.clientes.add(novoCliente);

        // Cria o objeto Conta (Corrente ou Poupança) e o armazena
        Conta novaConta;
        if (tipoConta.equalsIgnoreCase("Corrente")) {
            novaConta = new ContaCorrente(agencia, numeroConta, 0.0);
        } else if (tipoConta.equalsIgnoreCase("Poupanca")) {
            novaConta = new ContaPoupanca(agencia, numeroConta, 0.0);
        } else {
            return false;
        }

        this.contas.add(novaConta);

        return true;
    }

    // Metódo para a consulta de uma conta, recebendo os parametros de identificação (Conta) e retornando os dados (Cliente)
    public Object[] consultarCompleto(int agencia, int numeroConta) {
        System.out.println("Buscando conta e cliente...");

        // Procura a Conta na lista de contas
        Conta contaEncontrada = null;
        for (Conta conta : this.contas) {
            if (conta.getAgencia() == agencia && conta.getNumero() == numeroConta) {
                contaEncontrada = conta;
                break;
            }
        }

        // Se a conta for encontrada, procura o Cliente
        if (contaEncontrada != null) {
            System.out.println("Conta encontrada. Buscando cliente...");

            // A suposição é que o cliente e a conta estão no mesmo índice em suas listas
            int indice = this.contas.indexOf(contaEncontrada);

            // Evita erros de índice
            if (indice >= 0 && indice < this.clientes.size()) {
                Cliente clienteEncontrado = this.clientes.get(indice);
                if (clienteEncontrado != null) {
                    System.out.println("Cliente encontrado!");
                    // Retorna um array com a conta e o cliente
                    return new Object[] { contaEncontrada, clienteEncontrado };
                }
            }
        }

        System.out.println("Conta ou cliente não encontrados.");
        return null;
    }

    // Método para a atualização de dados, recebe os parametros de identificação (Conta) e os dados (Cliente) para modifica-los
    public boolean atualizarCadastro(int agencia, int numeroConta, String nome, String endereco, String telefone,
            String cpf) {
        // Consulta os dados existentes para garantir que a conta e o cliente existem
        Object[] dados = consultarCompleto(agencia, numeroConta);

        if (dados != null) {
            // Extrai o cliente do array
            // A conta não precisa ser atualizada, pois a agência e o número não mudam
            Cliente clienteParaAtualizar = (Cliente) dados[1];

            // Atualiza os dados do cliente
            clienteParaAtualizar.setNome(nome);
            clienteParaAtualizar.setEndereco(endereco);
            clienteParaAtualizar.setTelefone(telefone);
            clienteParaAtualizar.setCPF(cpf);

            return true;
        }
        return false;
    }
}