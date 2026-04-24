package br.com.cuidar.model;

import java.time.LocalDate;

/**
 * Representa um médico vinculado à ILPI.
 * Herda os dados pessoais de {@link Pessoa} e adiciona CRM e credenciais de acesso.
 */
public class Medico extends Pessoa {

    private String crm;
    private String login;
    private String senha;

    public Medico() {
    }

    public Medico(String cpf, String nomeCompleto, LocalDate dataNascimento, String sexo, boolean ativo,
                  String crm, String login, String senha) {
        super(cpf, nomeCompleto, dataNascimento, sexo, ativo);
        this.crm = crm;
        this.login = login;
        this.senha = senha;
    }

    // GETTERS E SETTERS

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // MÉTODOS

    /**
     * Autentica o médico comparando login e senha informados com os
     * dados armazenados.
     *
     * @param login - login informado pelo médico
     * @param senha - senha informada pelo médico
     * @return - true se as credenciais forem válidas, false caso contrário
     */
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    /**
     * Gera uma nova receita médica para o residente informado, contendo
     * os dados do medicamento prescrito.
     *
     * @param residente   - residente que receberá a receita
     * @param nome        - nome do medicamento prescrito
     * @param dosagem     - dosagem prescrita para o medicamento
     * @param frequencia  - frequência de administração do medicamento
     * @param horarios    - horários em que o medicamento deve ser administrado
     * @param observacoes - observações adicionais sobre a prescrição
     * @return - a Receita criada com os dados informados
     */
    public Receita geraReceita(Residente residente, String nome, String dosagem,
                               String frequencia, String horarios, String observacoes) {
        return new Receita(0, nome, dosagem, frequencia, horarios, true, observacoes, residente, this);
    }

    /**
     * Atualiza os dados de uma receita médica existente.
     */
    public void atualizaReceita() {
    }

    /**
     * Gera um novo registro clínico para o residente informado, contendo
     * a evolução clínica e possíveis intercorrências.
     *
     * @param residente          - residente associado ao registro
     * @param descricaoEvolucao  - descrição da evolução clínica do residente
     * @param observacoesMedicas - observações médicas sobre o estado do residente
     * @param tipoEvento         - tipo do evento clínico registrado
     * @param intercorrencia     - descrição da intercorrência, se houver
     * @return - o RegistroClinico criado com os dados informados
     */
    public RegistroClinico geraRegistroClinico(Residente residente, String descricaoEvolucao,
                                                String observacoesMedicas, String tipoEvento,
                                                String intercorrencia) {
        return new RegistroClinico(0, java.time.LocalDate.now(), descricaoEvolucao,
                observacoesMedicas, tipoEvento, intercorrencia, residente, this);
    }

    /**
     * Atualiza os dados de um registro clínico existente.
     */
    public void atualizaRegistroClinico() {
    }

    @Override
    public String toString() {
        return "Medico{" +
                "cpf='" + getCpf() + '\'' +
                ", nomeCompleto='" + getNomeCompleto() + '\'' +
                ", crm='" + crm + '\'' +
                ", ativo=" + isAtivo() +
                '}';
    }
}
