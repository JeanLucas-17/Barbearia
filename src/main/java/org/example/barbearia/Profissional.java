package org.example.barbearia;

public class Profissional
{
    private String codigo;
    private String nome;
    private String idade;
    private String telefone;
    private String endereco;
    private String cpf;

    public Profissional() {}

    public Profissional(String codigo, String nome, String idade, String telefone, String endereco, String cpf)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getIdade() { return idade; }
    public String getTelefone() { return telefone; }
    public String getEndereco() { return endereco; }
    public String getCpf() { return cpf; }

    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(String idade) { this.idade = idade; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}