package br.com.cuidar.model;

import java.time.LocalDate;

public class Residente {

    private int id;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String cpf;
    private Genero genero;
    private String telefone;
    private LocalDate dataEntradaInstituicao;
    private String observacoesGerais;
    private boolean ativo;

    public Residente() {
    }
   
    public Residente(
        String nomeCompleto,
        LocalDate dataNascimento,
        String cpf,
        Genero genero,
        String telefone,
        LocalDate dataEntradaInstituicao,
        String observacoesGerais,
        boolean ativo) {

        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.genero = genero;
        this.telefone = telefone;
        this.dataEntradaInstituicao = dataEntradaInstituicao;
        this.observacoesGerais = observacoesGerais;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataEntradaInstituicao() {
        return dataEntradaInstituicao;
    }

    public void setDataEntradaInstituicao(LocalDate dataEntradaInstituicao) {
        this.dataEntradaInstituicao = dataEntradaInstituicao;
    }

    public String getObservacoesGerais() {
        return observacoesGerais;
    }

    public void setObservacoesGerais(String observacoesGerais) {
        this.observacoesGerais = observacoesGerais;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Residente{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", cpf='" + cpf + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}