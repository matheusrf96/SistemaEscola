package br.unincor.control;

import java.util.ArrayList;
import java.util.List;
import br.unincor.model.*;
import br.unincor.view.ViewGUI;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class Operacoes {
	
	public void associarNotas(List<Aluno> alunos, List<Disciplina> disciplinas, List<Notas> notas) {
		for(int i = 0; i < notas.size(); i++) {
			for(int j = 0; j < alunos.size(); j++) {
				if(notas.get(i).getMat_aluno() == alunos.get(j).getMatricula()) {
					notas.get(i).setAluno(alunos.get(j));
				}
			}
			
			for(int j = 0; j < disciplinas.size(); j++) {
				if(notas.get(i).getId_disc() == disciplinas.get(j).getId()) {
					notas.get(i).setDisciplina(disciplinas.get(j));
				}
			}
		}
	}
	
	public int selecionarDisciplina(String nomeDisciplina) {
		int idDisciplina = 0;
		nomeDisciplina = nomeDisciplina.toLowerCase();
		
		if(nomeDisciplina.equals("português") || nomeDisciplina.equals("portugues"))
			idDisciplina = 1;
		else if(nomeDisciplina.equals("matemática") || nomeDisciplina.equals("matematica"))
			idDisciplina = 2;
		else if(nomeDisciplina.equals("história") || nomeDisciplina.equals("historia"))
			idDisciplina = 3;
		else if(nomeDisciplina.equals("geografia"))
			idDisciplina = 4;
		else if(nomeDisciplina.equals("ciências") || nomeDisciplina.equals("ciencias"))
			idDisciplina = 5;
		else
			idDisciplina = 0;
		
		return idDisciplina;
	}
	
	public String calculoMensalidades(List<Aluno> listaAlunos) {
		DecimalFormat df = new DecimalFormat("#.##");
		double totalMensalidades = 0d;

		for(int i = 0 ; i < listaAlunos.size(); i++) {
			totalMensalidades += listaAlunos.get(i).getMensalidade();
		}
		

		return "Receita arrecadada: R$" + df.format(totalMensalidades);

	}
	
	public String mediaDisciplina(String nomeDisciplina, List<Notas> listaNotas) {
		DecimalFormat df = new DecimalFormat("#.##");
		double somaNotas = 0.0;
		double media = 0.0;
		int quantNotas = 0;	
		int disciplina = -1;
		
		int idDisciplina = selecionarDisciplina(nomeDisciplina);
		
		if(idDisciplina == 0) {
			return "Disciplina inválida!";
		}
		else {		
			for(int i = 0; i < listaNotas.size(); i++) {	
				if(listaNotas.get(i).getDisciplina().getId() == idDisciplina) {
					disciplina = i;
					somaNotas += listaNotas.get(i).getNota();
					quantNotas++;
				}
			}
			
			if(quantNotas > 0)
				media = somaNotas / quantNotas;
			else
				media = 0.0;
			
			return "Média da disciplina " + listaNotas.get(disciplina).getDisciplina().getNome() + ": " + df.format(media);
		}
	}
	
	public String aproveitamentoDisciplina(String nomeDisciplina, List<Notas> listaNotas) throws FileNotFoundException{
		IO io = new IO();
		String notasDisciplina = "";
		int idDisciplina = selecionarDisciplina(nomeDisciplina);
		String disciplina = "";
		
		if(idDisciplina == 0) {
			return "Disicplina inválida!";
		}
		else {
			for(int i = 0; i < listaNotas.size(); i++) {			
				if(listaNotas.get(i).getDisciplina().getId() == idDisciplina) {
					if(disciplina.equals("")) {
						disciplina = listaNotas.get(i).getDisciplina().getNome();
					}
					
					if(notasDisciplina.equals("")){
						notasDisciplina += "Disciplina " + listaNotas.get(i).getDisciplina().getNome() + "\n-- NOTAS --\n";
					}
					
					notasDisciplina += "\n" + listaNotas.get(i).getAluno().getNome() + ": " +
							listaNotas.get(i).getNota();
					
					if(listaNotas.get(i).getNota() < 60.0)
						notasDisciplina += "*";
				}
			}
			
			io.escreverArquivo(notasDisciplina, disciplina + ".txt");
			
			return notasDisciplina;
		}
	}
	
	public List<List<String>> getListBoletim(String nomeAluno, List<Notas>listaNotas) throws FileNotFoundException{
		String textoBoletim = "";
		List<List<String>> listaBoletins = new ArrayList<List<String>>();
		
		for(int i = 0; i < listaNotas.size(); i++) {			
			if(listaNotas.get(i).getAluno().getNome().toLowerCase().contains(nomeAluno.toLowerCase())){
				if(textoBoletim.equals("")) {
					textoBoletim += "Nome: " + listaNotas.get(i).getAluno().getNome() +
							"\nData de Nascimento: " + listaNotas.get(i).getAluno().getDataNasc() + 
							"\nCPF: " + listaNotas.get(i).getAluno().getCpf() + 
							"\n-- BOLETIM --";
				}
				
				if(listaNotas.get(i).getDisciplina().getId() == 1) {
					textoBoletim += "\nPortuguês: " + listaNotas.get(i).getNota();
					
					if(listaNotas.get(i).getNota() < 60.0) {
						textoBoletim += "*";
					}
				}
				else if(listaNotas.get(i).getDisciplina().getId() == 2) {
					textoBoletim += "\nMatemática: " + listaNotas.get(i).getNota();
					
					if(listaNotas.get(i).getNota() < 60.0) {
						textoBoletim += "*";
					}
				}
				else if(listaNotas.get(i).getDisciplina().getId() == 3) {
					textoBoletim += "\nHistória: " + listaNotas.get(i).getNota();
					
					if(listaNotas.get(i).getNota() < 60.0) {
						textoBoletim += "*";
					}
				}
				else if(listaNotas.get(i).getDisciplina().getId() == 4) {
					textoBoletim += "\nGeografia: " + listaNotas.get(i).getNota();
					
					if(listaNotas.get(i).getNota() < 60.0) {
						textoBoletim += "*";
					}
				}
				else if(listaNotas.get(i).getDisciplina().getId() == 5) {
					textoBoletim += "\nCiências: " + listaNotas.get(i).getNota();
					
					if(listaNotas.get(i).getNota() < 60.0) {
						textoBoletim += "*";
					}
					
					List<String> listaInterna = new ArrayList<String>();
					
					listaInterna.add(textoBoletim);
					listaInterna.add(listaNotas.get(i).getAluno().getNome());
					
					listaBoletins.add(listaInterna);
					textoBoletim = "";					
				}
			}
		}		
		
		return listaBoletins;
	}
	
	public void boletim(String nomeAluno, List<Notas>listaNotas) throws FileNotFoundException{
		IO io = new IO();
		ViewGUI gui = new ViewGUI();
		
		List<List<String>> listaBoletins = getListBoletim(nomeAluno, listaNotas);
		
		if(listaBoletins.isEmpty()) {
			gui.exibeMsgErro("Nenhum aluno encontrado");
		}
		else {
			for(int i = 0; i < listaBoletins.size(); i++) {
				gui.exibeMsg(listaBoletins.get(i).get(0));
				
				int opcao = gui.exibeMenuExportarBoletim();
				
				if(opcao == 0) {
					io.escreverArquivo(listaBoletins.get(i).get(0), listaBoletins.get(i).get(1) + ".txt");
				}
			}
		}
	}
}
