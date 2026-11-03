package org.example.barbearia;

public class Servico
{
    private String codigo;
    private String nome;
    private String preco;
    private String duracao;

    public Servico() {}

    public Servico(String codigo, String nome, String preco, String duracao)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.duracao = duracao;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getPreco() { return preco; }
    public String getDuracao() { return duracao; }

    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNome(String nome) { this.nome = nome; }
    public void setPreco(String preco) { this.preco = preco; }
    public void setDuracao(String duracao) { this.duracao = duracao; }
}