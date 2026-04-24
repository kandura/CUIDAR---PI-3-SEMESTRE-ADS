package br.com.cuidar.model;

/**
 * Representa uma receita médica (medicamento) prescrita a um {@link Residente}.
 * Vinculada ao {@link Medico} que a prescreveu.
 */
public class Receita {

    private int id;
    private String nome;
    private String dosagem;
    private String frequencia;
    private String horarios;
    private boolean ativo;
    private String observacoes;

    // RELACIONAMENTOS
    private Residente residente;
    private Medico medico;

    public Receita() {
    }

    public Receita(int id, String nome, String dosagem, String frequencia, String horarios,
                   boolean ativo, String observacoes, Residente residente, Medico medico) {
        this.id = id;
        this.nome = nome;
        this.dosagem = dosagem;
        this.frequencia = frequencia;
        this.horarios = horarios;
        this.ativo = ativo;
        this.observacoes = observacoes;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    // MÉTODOS

    /**
     * Cadastra um novo medicamento na receita do residente.
     */
    public void cadastrarMedicamento() {
    }

    /**
     * Atualiza os dados de um medicamento existente na receita.
     */
    public void atualizarMedicamento() {
    }

    /**
     * Desativa o medicamento, indicando que ele foi suspenso.
     */
    public void desativarMedicamento() {
        this.ativo = false;
    }

    /**
     * Reativa o medicamento que havia sido suspenso.
     */
    public void ativarMedicamento() {
        this.ativo = true;
    }

    /**
     * Visualiza os medicamentos ativos do residente.
     */
    public void visualizarMedicamentosAtivos() {
    }

    @Override
    public String toString() {
        return "Receita{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dosagem='" + dosagem + '\'' +
                ", frequencia='" + frequencia + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
