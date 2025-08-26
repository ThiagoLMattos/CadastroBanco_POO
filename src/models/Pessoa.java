package src.models;

// Classe abstrata que serve como modelo para pessoas, como Clientes
public abstract class Pessoa {
    // Atributos encapsulados
    private String nome;
    private String endereco;
    private String telefone;
    private String CPF;

    // Construtor
    public Pessoa(String nome, String endereco, String telefone, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.CPF = cpf;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    // Métodos (Serão heradados)
    public void gravar() {
        System.out.println("Gravando pessoa...");
    }

    public void editar() {
        System.out.println("Editando pessoa...");
    }

    public void excluir() {
        System.out.println("Excluindo pessoa...");
    }
    
    public void cancelar() {
        System.out.println("Cancelando operação de pessoa...");
    }
}