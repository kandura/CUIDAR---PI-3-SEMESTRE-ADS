package br.com.cuidar.model;

import java.time.LocalDate;

/**
 * Representa a rotina diária de cuidados de um {@link Residente}.
 * Registra alimentação, banho, higiene e observações gerais.
 */
public class RotinaCuidado {

    private int id;
    private LocalDate dataRegistro;
    private String alimentacao;
    private String banho;
    private String higiene;
    private String observacoesGerais;

    // RELACIONAMENTO 1:1 com Residente
    private Residente residente;

    public RotinaCuidado() {
    }

    public RotinaCuidado(int id, LocalDate dataRegistro, String alimentacao, String banho,
                         String higiene, String observacoesGerais, Residente residente) {
        this.id = id;
        this.dataRegistro = dataRegistro;
        this.alimentacao = alimentacao;
        this.banho = banho;
        this.higiene = higiene;
        this.observacoesGerais = observacoesGerais;
        this.residente = residente;
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

    public String getObservacoesGerais() {
        return observacoesGerais;
    }

    public void setObservacoesGerais(String observacoesGerais) {
        this.observacoesGerais = observacoesGerais;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    // MÉTODOS

    /**
     * Registra uma nova rotina de cuidados para o residente.
     */
    public void registrarRotina() {
    }

    /**
     * Edita os dados de uma rotina de cuidados existente.
     */
    public void editarRotina() {
    }

    /**
     * Visualiza as rotinas de cuidados registradas para o residente.
     */
    public void visualizarRotinas() {
    }

    /**
     * Consulta e lista as rotinas de cuidados cadastradas.
     */
    public void consultas() {
    }

    /**
     * Verifica se todos os cuidados obrigatórios da rotina foram preenchidos,
     * ou seja, se alimentação, banho e higiene possuem valores válidos.
     *
     * @return - true se a rotina estiver completa, false caso contrário
     */
    public boolean isCompleta() {
        return alimentacao != null && !alimentacao.isEmpty()
                && banho != null && !banho.isEmpty()
                && higiene != null && !higiene.isEmpty();
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