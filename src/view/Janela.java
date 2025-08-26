// Janela.java
package src.view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import src.controllers.Sistema;
import src.models.Cliente;
import src.models.Conta;
import src.models.ContaCorrente;

// Classe que cria e gerencia a interface gráfica da aplicação
public class Janela extends JFrame {

    // Atributos dos componentes
    private JLabel jlAgencia, jlConta, jlNome, jlEndereco, jlTelefone, jlCpf;
    private JFormattedTextField jtfAgencia, jtfConta, jtfTelefone, jtfCpf; // Campos com máscara
    private JTextField jtfNome, jtfEndereco; // Campos sem máscara
    private JSeparator jSeparator01, jSeparator02;
    private JRadioButton jrbCorrente, jrbPoupanca;
    private ButtonGroup bgContas;
    private JButton jbGravar, jbConsultar, jbAtualizar, jbFechar;

    // Referência ao Controller para a lógica de negócio
    private Sistema controller;

    // Construtor
    public Janela() {
        controller = new Sistema();
        
        setTitle("Java Swing - Desenvolvimento de Sistemas");
        setSize(400, 255);
        setResizable(false);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        centralizar();
        criarComponentes();
        adicionarComponentes();
        adicionarListeners();
    }

    // Método para centralizar a janela na tela
    private void centralizar() {
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tela.width - getWidth()) / 2;
        int y = (tela.height - getHeight()) / 2;
        setLocation(x, y);
    }
    
    // Método para criar e configurar todos os componentes
    private void criarComponentes() {
        jlAgencia = new JLabel("Código da Agência");
        jlConta = new JLabel("Número da Conta");
        jlNome = new JLabel("Nome:");
        jtfNome = new JTextField();
        jlEndereco = new JLabel("Endereço:");
        jtfEndereco = new JTextField();
        jlTelefone = new JLabel("Telefone:");
        jlCpf = new JLabel("CPF:");
        
        try {
            // Criação das máscaras de formatação
            MaskFormatter maskAgencia = new MaskFormatter("####");
            jtfAgencia = new JFormattedTextField(maskAgencia);
            
            MaskFormatter maskConta = new MaskFormatter("#####-#");
            jtfConta = new JFormattedTextField(maskConta);
            
            MaskFormatter maskTelefone = new MaskFormatter("(##)#####-####");
            jtfTelefone = new JFormattedTextField(maskTelefone);

            MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
            jtfCpf = new JFormattedTextField(maskCpf);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        jrbCorrente = new JRadioButton("Conta Corrente");
        jrbPoupanca = new JRadioButton("Conta Poupança");
        bgContas = new ButtonGroup();
        jSeparator01 = new JSeparator();
        jSeparator02 = new JSeparator();
        
        jbGravar = new JButton("Gravar");
        jbConsultar = new JButton("Consultar");
        jbAtualizar = new JButton("Atualizar");
        jbFechar = new JButton("Fechar");
    }

    // Método para adicionar e posicionar os componentes na janela
    private void adicionarComponentes() {
        // Label
        jlAgencia.setBounds(10, 10, 110, 18);
        getContentPane().add(jlAgencia);
        // Forms
        jtfAgencia.setBounds(125, 10, 50, 20);
        getContentPane().add(jtfAgencia);
        // Label
        jlConta.setBounds(205, 10, 105, 18);
        getContentPane().add(jlConta);
        // Forms
        jtfConta.setBounds(315, 10, 60, 20);
        getContentPane().add(jtfConta);
        // Separator
        jSeparator01.setBounds(10, 40, 365, 10);
        getContentPane().add(jSeparator01);
        // Label
        jlNome.setHorizontalAlignment(SwingConstants.RIGHT);
        jlNome.setBounds(10, 50, 60, 18);
        getContentPane().add(jlNome);
        // Forms
        jtfNome.setBounds(75, 50, 300, 20);
        getContentPane().add(jtfNome);
        // Label
        jlEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
        jlEndereco.setBounds(10, 75, 60, 18);
        getContentPane().add(jlEndereco);
        // Forms
        jtfEndereco.setBounds(75, 75, 300, 20);
        getContentPane().add(jtfEndereco);
        // Label
        jlTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
        jlTelefone.setBounds(10, 100, 60, 18);
        getContentPane().add(jlTelefone);
        // Forms
        jtfTelefone.setBounds(75, 100, 300, 20);
        getContentPane().add(jtfTelefone);
        // Label
        jlCpf.setHorizontalAlignment(SwingConstants.RIGHT);
        jlCpf.setBounds(10, 125, 60, 18);
        getContentPane().add(jlCpf);
        // Forms
        jtfCpf.setBounds(75, 125, 300, 20);
        getContentPane().add(jtfCpf);
        // Radio button
        jrbCorrente.setMnemonic('c');
        jrbCorrente.setSelected(true);
        jrbCorrente.setBounds(100, 150, 111, 20);
        getContentPane().add(jrbCorrente);
        // Radio button
        jrbPoupanca.setMnemonic('p');
        jrbPoupanca.setBounds(225, 150, 118, 20);
        getContentPane().add(jrbPoupanca);
        // Grupo dos Radio Buttons
        bgContas.add(jrbCorrente);
        bgContas.add(jrbPoupanca);
        // Separator
        jSeparator02.setBounds(10, 180, 365, 10);
        getContentPane().add(jSeparator02);
        // Botão (Graar)
        jbGravar.setMnemonic('g');
        jbGravar.setBounds(10, 190, 90, 23);
        getContentPane().add(jbGravar);
        // Botão (Consultar)
        jbConsultar.setMnemonic('s');
        jbConsultar.setBounds(100, 190, 100, 23);
        getContentPane().add(jbConsultar);
        // Botão (Atualizar)
        jbAtualizar.setMnemonic('a');
        jbAtualizar.setEnabled(false);
        jbAtualizar.setBounds(200, 190, 100, 23);
        getContentPane().add(jbAtualizar);
        // Botão (Fechar)
        jbFechar.setMnemonic('f');
        jbFechar.setBounds(300, 190, 80, 23);
        getContentPane().add(jbFechar);
    }
    
    // Método para adicionar os listeners de eventos aos botões
    private void adicionarListeners() {
        jbFechar.addActionListener(e -> dispose());
        
        // Listener do botão Gravar
        jbGravar.addActionListener(e -> {
            try {
                // Obtém o texto dos campos, removendo caracteres de máscara
                String agenciaStr = jtfAgencia.getText().trim();
                String contaStr = jtfConta.getText().replace("-", "").trim();
                String telefoneStr = jtfTelefone.getText().replaceAll("[()\\- ]", "").trim();
                String cpfStr = jtfCpf.getText().replaceAll("[.\\-]", "").trim();
                
                // Validação para garantir que todos os campos estão preenchidos
                if (agenciaStr.isEmpty() || contaStr.isEmpty() || jtfNome.getText().isEmpty() || jtfEndereco.getText().isEmpty() || telefoneStr.isEmpty() || cpfStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
                    return;
                }
                
                String nome = jtfNome.getText();
                String endereco = jtfEndereco.getText();
                String tipoConta = jrbCorrente.isSelected() ? "Corrente" : "Poupanca";

                // Chama o método do controller para gravar o cadastro
                boolean sucesso = controller.gravarCadastro(nome, endereco, telefoneStr, cpfStr, Integer.parseInt(agenciaStr), Integer.parseInt(contaStr), tipoConta);

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                    limparCampos();
                    // Consulta a conta recém-criada e abre a janela de operações
                    Object[] dados = controller.consultarCompleto(Integer.parseInt(agenciaStr), Integer.parseInt(contaStr));
                    if (dados != null) {
                        Conta contaCriada = (Conta) dados[0];
                        new OperacoesConta(this, contaCriada).setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao gravar. A conta já existe.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, insira números válidos para agência e conta.");
            }
        });

        // Listener do botão Consultar
        jbConsultar.addActionListener(e -> {
            try {
                String agenciaStr = jtfAgencia.getText().trim();
                String contaStr = jtfConta.getText().replace("-", "").trim();
                
                if (agenciaStr.isEmpty() || contaStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha a agência e o número da conta.");
                    return;
                }
                
                int agencia = Integer.parseInt(agenciaStr);
                int numeroConta = Integer.parseInt(contaStr);
                
                // Chama o método do controller para consultar os dados completos
                Object[] dados = controller.consultarCompleto(agencia, numeroConta);
                
                if (dados != null) {
                    Conta contaEncontrada = (Conta) dados[0];
                    Cliente clienteEncontrado = (Cliente) dados[1];
                    
                    // Preenche os campos com os dados encontrados
                    jtfNome.setText(clienteEncontrado.getNome());
                    jtfEndereco.setText(clienteEncontrado.getEndereco());
                    jtfTelefone.setText(clienteEncontrado.getTelefone());
                    jtfCpf.setText(clienteEncontrado.getCPF());
                    
                    if (contaEncontrada instanceof ContaCorrente) {
                        jrbCorrente.setSelected(true);
                    } else {
                        jrbPoupanca.setSelected(true);
                    }
                    
                    new OperacoesConta(this, contaEncontrada).setVisible(true);

                    jbAtualizar.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Conta não encontrada.");
                    limparCampos();
                    jbAtualizar.setEnabled(false);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, insira números válidos para agência e conta.");
            }
        });
        
        // Listener do botão Atualizar
        jbAtualizar.addActionListener(e -> {
            try {
                String agenciaStr = jtfAgencia.getText().trim();
                String contaStr = jtfConta.getText().replace("-", "").trim();
                String telefoneStr = jtfTelefone.getText().replaceAll("[()\\- ]", "").trim();
                String cpfStr = jtfCpf.getText().replaceAll("[.\\-]", "").trim();
                
                if (agenciaStr.isEmpty() || contaStr.isEmpty() || jtfNome.getText().isEmpty() || jtfEndereco.getText().isEmpty() || telefoneStr.isEmpty() || cpfStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
                    return;
                }
                
                int agencia = Integer.parseInt(agenciaStr);
                int numeroConta = Integer.parseInt(contaStr);
                String nome = jtfNome.getText();
                String endereco = jtfEndereco.getText();
                
                // Chama o método do controller para atualizar o cadastro
                boolean sucesso = controller.atualizarCadastro(agencia, numeroConta, nome, endereco, telefoneStr, cpfStr);
                
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar. Conta não encontrada.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, verifique se agência e conta são números.");
            }
        });
    }

    // Método para resetar o estado dos campos para o valor inicial
    private void limparCampos() {
        jtfAgencia.setText("");
        jtfConta.setText("");
        jtfNome.setText("");
        jtfEndereco.setText("");
        jtfTelefone.setText("");
        jtfCpf.setText("");
        jrbCorrente.setSelected(true);
    }
}