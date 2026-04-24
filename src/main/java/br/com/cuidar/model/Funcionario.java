package br.com.cuidar.model;

import java.time.LocalDate;

/**
 * Representa um funcionário da ILPI.
 * Herda os dados pessoais de {@link Pessoa} e adiciona cargo e credenciais de acesso.
 */
public class Funcionario extends Pessoa {

    private Cargo cargo;
    private String login;
    private String senha;


    public Funcionario(String cpf, String nomeCompleto, LocalDate dataNascimento, String genero, boolean ativo,
                       Cargo cargo, String login, String senha) {
        super(cpf, nomeCompleto, dataNascimento, genero, ativo);
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
    }

    // GETTERS E SETTERS

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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
     * Autentica o funcionário comparando login e senha informados com os
     * dados armazenados.
     *
     * @param login - login informado pelo funcionário
     * @param senha - senha informada pelo funcionário
     * @return - true se as credenciais forem válidas, false caso contrário
     */
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    /**
     * Lista os funcionários cadastrados.
     */
    public void listaFuncionario() {
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "cpf='" + getCpf() + '\'' +
                ", nomeCompleto='" + getNomeCompleto() + '\'' +
                ", cargo=" + cargo +
                ", login='" + login + '\'' +
                ", ativo=" + isAtivo() +
                '}';
    }
}
