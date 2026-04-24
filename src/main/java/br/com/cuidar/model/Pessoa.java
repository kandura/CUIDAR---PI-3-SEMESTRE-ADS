package br.com.cuidar.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * Classe padrão para a criação de pessoas.
 */
public class Pessoa {
	private final int IDADE_MIN = 18;
	private final int IDADE_MAX = 120;

	private String cpf;
	private String nomeCompleto;
	private Date dataNascimento;
	private Boolean ativo;
	private String genero;

	public Pessoa(String cpf, String nomeCompleto, Date dataNascimento, String genero, Boolean ativo) {

		this.cpf = setCpf(cpf);
		this.nomeCompleto = setNomeCompleto(nomeCompleto);
		this.dataNascimento = setDataNascimento(dataNascimento);
		this.genero = setGenero(genero);
		this.ativo = ativo;
	}

	public String getCpf() {
		return cpf;
	}

	public String setCpf(String cpf) {
		if (!validarCpf(cpf)) {
			throw new IllegalArgumentException("CPF inválido: " + cpf);
		}
		return cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public String setNomeCompleto(String nomeCompleto) {
		if (!validaNome(nomeCompleto)) {
			throw new IllegalArgumentException("Nome inválido: " + nomeCompleto);
		}
		return nomeCompleto;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Date setDataNascimento(Date dataNascimento) {
		if (!validarDataNascimento(dataNascimento, IDADE_MIN, IDADE_MAX)) {
			throw new IllegalArgumentException("Data de Nascimento inválido: " + dataNascimento);
		}
		return dataNascimento;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * Inativa uma pessoa.
	 */
	public void inativarPessoa() {
		if (this.ativo == true) {
			this.ativo = false;
		}
	}

	/**
	 * Ativa uma pessoa.
	 */
	public void ativarPessoa() {
		if (this.ativo == false) {
			this.ativo = true;
		}
	}

	/**
	 * Valida o genero, se está de acordo com o definido no enum, para não gerar
	 * generos inexistentes.
	 * 
	 * @param genero - paramentro passado com o genero escolhido
	 * @return retorna true caso o genero esteja dentro dos aceitos pelo enum
	 */
	public static Boolean validarGenero(String genero) {
		boolean r = false;
		for (Genero g : Genero.values()) {
			if (g.name().equalsIgnoreCase(genero)) {
				r = true;
			}
		}
		return r;
	}

	public String getGenero() {
		return genero;
	}

	public String setGenero(String genero) {
		if (!validarGenero(genero)) {
			throw new IllegalArgumentException("Genero inválido: " + dataNascimento);
		}
		return genero;
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
				r = false; // Encontrou um número, retorna false
			}
		}
		return r; // Percorreu tudo e não achou números
	}

	/**
	 * Valida se a data de nascimento é valida, se ela for uma data futura ou uma
	 * data muito grande(insinuando que a pessoa tenha mais de 120 anos)
	 * 
	 * @param data     - data recebida para a validação
	 * @param idadeMin - idade minima definida por uma variavel final
	 * @param idadeMax - idade maxima definida por uma variavel final
	 * @return - retorna false caso esteja diferente da regra de negocio. True caso
	 *         contrario.
	 */
	public static boolean validarDataNascimento(Date data, int idadeMin, int idadeMax) {
		boolean r = true;
		if (data == null) {
			r = false;
		}
		try {
			// Converte Date para DataLocal, no formato do sistema, DD-MM-AAAA
			LocalDate dataNascimento = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			LocalDate hoje = LocalDate.now();

			// Não pode ser data futura
			if (dataNascimento.isAfter(hoje)) {
				r = false;
			}

			// Calcula a idade em anos, se for menor que 18, não é possivel cadastro
			int idade = Period.between(dataNascimento, hoje).getYears();
			if (idade >= idadeMin && idade <= idadeMax) {
				r = false;
			}

		} catch (Exception e) {
			r = false;
		}

		return r;
	}

	/**
	 * Edita os dados de uma pessoa
	 */
	public void editarPessoa() {

	}

	/**
	 * Consulta um CPF no banco de dados.
	 * 
	 * @param cpf - CPF que passado pelo usuario que sera consultado no banco
	 * @return - todos os dados atraves do CPF.
	 */
	public Pessoa buscarPorCpf(String cpf) {
		return null;
	}

	public void visualizarDetalhes() {
	}

	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nomeCompleto=" + nomeCompleto + ", dataNascimento=" + dataNascimento
				+ ", genero=" + genero + ", ativo=" + ativo + "]";
	}

}
