// OperacoesContaDialog.java
package src.view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import src.models.Conta;

import java.awt.*;
import java.text.ParseException;

// Classe JDialog para realizar operações de depósito e saque em uma conta
public class OperacoesConta extends JDialog {

    // Atributos dos componentes
    private JLabel jlSaldo, jlValor;
    private JTextField jtfValor;
    private JButton jbDepositar, jbSacar, jbCancelar;
    private Conta conta;
    MaskFormatter maskAgencia = null;

    // Construtor
    public OperacoesConta(JFrame parent, Conta conta) {
        super(parent, "Operações de Conta", true);
        this.conta = conta;

        // Configuração da janela
        setLayout(null);
        setSize(320, 160);
        setResizable(false);
        setLocationRelativeTo(parent);

        criarComponentes();
        adicionarComponentes();
        adicionarListeners();

        // Inicializa o label com o saldo atual
        atualizarSaldoLabel();
    }

    // Método para criar e configurar todos os componentes
    private void criarComponentes() {
        jlSaldo = new JLabel("Saldo Atual: R$ 0.00", SwingConstants.CENTER);
        jlValor = new JLabel("Valor:");
        jtfValor = new JTextField(10);
        jbDepositar = new JButton("Depositar");
        jbSacar = new JButton("Sacar");
        jbCancelar = new JButton("Cancelar");
    }

    // Método para adicionar e posicionar os componentes na janela
    private void adicionarComponentes() {
        jlSaldo.setBounds(10, 10, 285, 20);
        add(jlSaldo);
        jlValor.setBounds(40, 45, 60, 20);
        add(jlValor);
        jtfValor.setBounds(100, 45, 150, 20);
        add(jtfValor);
        jbDepositar.setBounds(10, 85, 95, 25);
        add(jbDepositar);
        jbSacar.setBounds(115, 85, 75, 25);
        add(jbSacar);
        jbCancelar.setBounds(200, 85, 95, 25);
        add(jbCancelar);
    }

    // Método para adicionar os listeners de eventos aos botões
    private void adicionarListeners() {
        // Listener do botão Depositar
        jbDepositar.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(jtfValor.getText());
                // Verifica se o valor é positivo
                if (valor > 0) {
                    conta.depositar(valor);
                    atualizarSaldoLabel();
                    JOptionPane.showMessageDialog(this, "Depósito realizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "O valor do depósito deve ser positivo.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um valor válido.");
            }
        });

        // Listener do botão Sacar
        jbSacar.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(jtfValor.getText());
                // Verifica se o valor é positivo
                if (valor > 0) {
                    // Tenta realizar o saque e verifica o retorno
                    if (conta.sacar(valor)) {
                        atualizarSaldoLabel();
                        JOptionPane.showMessageDialog(this, "Saque realizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Saldo insuficiente!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "O valor do saque deve ser positivo.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um valor válido.");
            }
        });

        // Listener do botão Cancelar para fechar o diálogo
        jbCancelar.addActionListener(e -> dispose());
    }

    // Método para atualizar o texto do label de saldo com o valor atual da conta
    private void atualizarSaldoLabel() {
        jlSaldo.setText("Saldo Atual: R$ " + String.format("%.2f", conta.getSaldo()));
    }
}