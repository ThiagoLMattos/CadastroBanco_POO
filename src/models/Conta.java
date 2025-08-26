package src.models;

// Classe abstrata que serve como modelo para todos os tipos de contas (Corrente, Poupança)
public abstract class Conta {
    // Atributos encapsulados
    private int agencia;
    private int numero;
    private double saldo;

// Construtor 
    public Conta(int agencia, int numero, double saldo){
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    // Getters e Setters 
    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Métodos (Serão heradados)
    public void gravar() {
        System.out.println("Gravando conta...");
    }

    public void editar() {
        System.out.println("Editando conta...");
    }

    public void excluir() {
        System.out.println("Excluindo conta...");
    }

    public void cancelar() {
        System.out.println("Cancelando operação de conta...");
    }

    // Realiza um depósito na conta
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    // Realiza um saque na conta
    public boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }
    
}