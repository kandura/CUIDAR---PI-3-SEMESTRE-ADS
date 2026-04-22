package br.com.cuidar.model;

import java.time.LocalDate;

public class RotinaCuidado {

    private int id;
    private LocalDate dataRegistro;
    private String alimentacao;
    private String banho;
    private String higiene;
    private String observacoes;

    // RELACIONAMENTOS 
    private Residente residente;
    private Funcionario funcionario;

    public RotinaCuidado() {
    }

    public RotinaCuidado(
            LocalDate dataRegistro,
            String alimentacao,
            String banho,
            String higiene,
            String observacoes,
            Residente residente,
            Funcionario funcionario) {

        this.dataRegistro = dataRegistro;
        this.alimentacao = alimentacao;
        this.banho = banho;
        this.higiene = higiene;
        this.observacoes = observacoes;
        this.residente = residente;
        this.funcionario = funcionario;
    }

    // GETTERS E SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public String getBanho() {
        return banho;
    }

    public void setBanho(String banho) {
        this.banho = banho;
    }

    public String getHigiene() {
        return higiene;
    }

    public void setHigiene(String higiene) {
        this.higiene = higiene;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }


    public void registrarRotina() {
        System.out.println("Rotina registrada para o residente: " + residente.getNomeCompleto());
    }

    public void editarRotina() {
        System.out.println("Rotina editada com sucesso!");
    }

    public void visualizarRotinas() {
        System.out.println("=== Rotina de Cuidado ===");
        System.out.println("Data: " + dataRegistro);
        System.out.println("Alimentação: " + alimentacao);
        System.out.println("Banho: " + banho);
        System.out.println("Higiene: " + higiene);
        System.out.println("Observações: " + observacoes);
    }

    @Override
    public String toString() {
        return "RotinaCuidado{" +
                "id=" + id +
                ", dataRegistro=" + dataRegistro +
                ", alimentacao='" + alimentacao + '\'' +
                ", banho='" + banho + '\'' +
                ", higiene='" + higiene + '\'' +
                '}';
    }
}