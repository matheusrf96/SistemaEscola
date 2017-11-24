package br.unincor.model;

public class Notas{
	private int mat_aluno;
	private int id_disc;
	private double nota;
	private Aluno aluno;
	private Disciplina disciplina;
	public Notas(int mat_aluno, int id_disc, double nota) {
		super();
		this.mat_aluno = mat_aluno;
		this.id_disc = id_disc;
		this.nota = nota;
		this.aluno = null;
		this.disciplina = null;
	}
	
	public int getMat_aluno() {
		return mat_aluno;
	}
	public void setMat_aluno(int mat_aluno) {
		this.mat_aluno = mat_aluno;
	}
	public int getId_disc() {
		return id_disc;
	}
	public void setId_disc(int id_disc) {
		this.id_disc = id_disc;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	@Override
	public String toString() {
		return "Notas [mat_aluno=" + mat_aluno + ", id_disc=" + id_disc + ", nota=" + nota + ", aluno=" + aluno
				+ ", disciplina=" + disciplina + "]";
	}	
	
}
