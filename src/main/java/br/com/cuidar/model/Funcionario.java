package br.com.cuidar.model;


import java.util.Date;


/**
 * Classe que modela um funcionario
 * A classe é uma especializacao de Pessoa e tem login e senha
 */
public class Funcionario extends Pessoa{

    private  String login;
    private  String senha;
    private Cargo cargo;


    public Funcionario(String cpf, String nomeCompleto, Date dataNascimento, String sexo, Boolean ativo,
    String login, String senha, Cargo cargo){

        super(cpf, nomeCompleto ,dataNascimento, sexo, ativo);
        this.login= login;
        this.senha = senha;
        this.cargo = cargo;
    }

    public  String getLogin(){
        return  login;
    }

    public void  setLogin(String login){
        this.login = login;
    }

    public String getSenha(){
        return senha;
    }

    public void  setSenha(String senha){
        this.senha = senha;
    }


    /**
     * Autentifica login e senha do funcionario
     * @param login - O nome para login nao pode ser nulo
     * @param senha - A senha para login nao pode ser nula
     * @return - retorna true se login e senha coincidirem aos dados armazenados, se nao, false
     */
    public boolean autenticar(String login, String senha) {

        if (login == null || senha == null) {
            return false;
        }

        if (this.login == null || this.senha == null) {
            return false;
        }

        return this.login.equalsIgnoreCase(login) && this.senha.equals(senha);
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * Lista os funcionarios, exibe os dados
     */
    public void listarFuncionario() {
        System.out.println(this.toString());
    }



    @Override
    public String toString() {
        return "Funcionario [cpf=" + getCpf() + ", nomeCompleto=" + getNomeCompleto()
                + ", dataNascimento=" + getDataNascimento() + ", sexo=" + getSexo()
                + ", ativo=" + getAtivo() + ", login=" + login + ", senha=" + senha + "]";
    }


}
