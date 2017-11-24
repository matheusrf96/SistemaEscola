package br.unincor.model;

import java.util.Date;

public class Aluno {
	private int matricula;
	private String nome;
	private Date dataNasc;
	private String cpf;
	private double mensalidade;
	
	public Aluno(int matricula, String nome, Date dataNasc, String cpf, double mensalidade) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
		this.mensalidade = mensalidade;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", dataNasc=" + dataNasc + ", cpf=" + cpf
				+ ", mensalidade=" + mensalidade + "]";
	}
	
}
