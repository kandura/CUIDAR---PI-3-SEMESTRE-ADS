package br.com.cuidar.model;

import java.util.Date;

/**
 * Classe padrão para a criação de pessoas.
 */
public class Pessoa {

	private String cpf;
	private String nomeCompleto;
	private Date dataNascimento;
	private String sexo;
	private Boolean ativo;

	public Pessoa(String cpf, String nomeCompleto, Date dataNascimento, String sexo, Boolean ativo) {

		if (validarCpf(cpf) == true || validaNome(nomeCompleto) == true) {
			this.cpf = cpf;
			this.nomeCompleto = nomeCompleto;
		}
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.ativo = ativo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * Valida um CPF usando o algoritmo oficial da Receita Federal. Aceita CPF
	 * formatado (ex: "123.456.789-09") ou apenas números ("12345678909").
	 * 
	 * @param cpf - String com o CPF a ser validado
	 * @return - true se o CPF for válido, false caso contrário
	 */
	public Boolean validarCpf(String cpf) {
		boolean r = true;

		// Verifica se há alguma coisa escrita no campo.
		if (cpf == null)
			r = false;

		// Remove formatação: pontos e traço
		cpf = cpf.replaceAll("[.\\-]", "").trim();

		// Verifica se tem exatamente 11 dígitos numéricos
		if (!cpf.matches("\\d{11}"))
			r = false;

		// Rejeita CPFs com todos os dígitos iguais (ex: 111.111.111-11)
		if (cpf.chars().distinct().count() == 1)
			r = false;

		// Calcula e valida o 1º dígito verificador
		int primeiroDigito = calcularDigito(cpf, 9);
		if (primeiroDigito != Character.getNumericValue(cpf.charAt(9)))
			r = false;

		// Calcula e valida o 2º dígito verificador
		int segundoDigito = calcularDigito(cpf, 10);
		if (segundoDigito != Character.getNumericValue(cpf.charAt(10)))
			r = false;

		return r;
	}

	/**
	 * Calcula um dígito verificador do CPF.
	 *
	 * @param cpf    - String com os 11 dígitos do CPF
	 * @param length Quantos dígitos usar no cálculo (9 para o 1º, 10 para o 2º)
	 * @return O dígito verificador calculado
	 */
	private static int calcularDigito(String cpf, int tamanho) {
		int soma = 0;
		int peso = tamanho + 1;

		for (int i = 0; i < tamanho; i++) {
			soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
		}

		int resto = soma % 11;
		return (resto < 2) ? 0 : (11 - resto);
	}

	/**
	 * Valida se o nome é valido, se ele não está em branco ou se não há numeros
	 * nele.
	 * 
	 * @param nome - Variavel passada para verificação
	 * @return - true se o Nome for válido, false caso contrário
	 */
	public static Boolean validaNome(String nome) {
		boolean r = true;
		if (nome == null || nome.isEmpty()) {
			r = false;
		}
		for (int i = 0; i < nome.length(); i++) {
			if (Character.isDigit(nome.charAt(i))) {
				r = false; // Encontrou um número, retorna true
			}
		}
		return r; // Percorreu tudo e não achou números
	}

	/**
	 * Edita os dados de uma pessoa 
	 */
	public void editarPessoa() {
		
	}

	/**
	 * Inativa uma pessoa.
	 */
	public void inativarPessoa() {
		if (this.ativo == true){
			this.ativo = false;
		}
	}

	/**
	 * Ativa uma pessoa.
	 */
	public void ativarPessoa() {
		if (this.ativo == false){
			this.ativo = true;
		}
	}

	/**
	 * Consulta um CPF no banco de dados.
	 * 
	 * @param cpf - CPF que passado pelo usuario que sera consultado no banco
	 * @return - todos os dados solicitados atraves do CPF.
	 */
	public Residente buscarPorCpf(String cpf) {
		// TODO: implementar busca por CPF
		return null;
	}

	public void visualizarDetalhes() {
		// TODO: implementar visualização de detalhes
	}
}
