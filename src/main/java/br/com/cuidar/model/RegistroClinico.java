package br.com.cuidar.model;

import java.time.LocalDate;

/**
 * Representa um registro clínico na evolução de saúde de um {@link Residente}.
 * Registros são imutáveis após criação (append-only).
 * Vinculado ao {@link Medico} responsável.
 */
public class RegistroClinico {

    private int id;
    private LocalDate dataRegistro;
    private String descricaoEvolucao;
    private String observacoesMedicas;
    private String tipoEvento;
    private String intercorrencia;

    // RELACIONAMENTOS
    private Residente residente;
    private Medico medico;

    public RegistroClinico() {
    }

    public RegistroClinico(int id, LocalDate dataRegistro, String descricaoEvolucao,
                           String observacoesMedicas, String tipoEvento, String intercorrencia,
                           Residente residente, Medico medico) {
        this.id = id;
        this.dataRegistro = dataRegistro;
        this.descricaoEvolucao = descricaoEvolucao;
        this.observacoesMedicas = observacoesMedicas;
        this.tipoEvento = tipoEvento;
        this.intercorrencia = intercorrencia;
        this.residente = residente;
        this.medico = medico;
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

    public String getDescricaoEvolucao() {
        return descricaoEvolucao;
    }

    public void setDescricaoEvolucao(String descricaoEvolucao) {
        this.descricaoEvolucao = descricaoEvolucao;
    }

    public String getObservacoesMedicas() {
        return observacoesMedicas;
    }

    public void setObservacoesMedicas(String observacoesMedicas) {
        this.observacoesMedicas = observacoesMedicas;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getIntercorrencia() {
        return intercorrencia;
    }

    public void setIntercorrencia(String intercorrencia) {
        this.intercorrencia = intercorrencia;
    }

    /**
     * Retorna o residente associado a este registro.
     *
     * @return o {@link Residente} associado
     */
    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    /**
     * Retorna o médico responsável por este registro.
     *
     * @return o {@link Medico} responsável
     */
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    // MÉTODOS

    /**
     * Verifica se houve intercorrência neste registro clínico.
     *
     * @return {@code true} se houver intercorrência registrada, {@code false} caso contrário
     */
    public boolean isIntercorrencia() {
        return intercorrencia != null && !intercorrencia.isEmpty();
    }

    @Override
    public String toString() {
        return "RegistroClinico{" +
                "id=" + id +
                ", dataRegistro=" + dataRegistro +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", intercorrencia='" + intercorrencia + '\'' +
                '}';
    }
}
