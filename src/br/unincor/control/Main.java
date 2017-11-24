package br.unincor.control;

import java.util.ArrayList;
import java.util.List;
import br.unincor.dao.AlunoDAO;
import br.unincor.dao.DisciplinaDAO;
import br.unincor.dao.NotasDAO;
import br.unincor.model.Aluno;
import br.unincor.model.Disciplina;
import br.unincor.model.Notas;
import br.unincor.view.ViewGUI;

public class Main {

	public static void main(String[] args) {
		AlunoDAO ad = new AlunoDAO();
		DisciplinaDAO dd = new DisciplinaDAO();
		NotasDAO nd = new NotasDAO();
		Operacoes op = new Operacoes();
		ViewGUI gui = new ViewGUI();
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		List<Notas> notas = new ArrayList<Notas>();
		
		alunos = ad.selectAllAluno();
		disciplinas = dd.selectAllDisciplina();
		notas = nd.selectAllNotas();
		
		op.associarNotas(alunos, disciplinas, notas);
		
		try{
			while(true){
				int opcao = gui.exibeMenuPrincipal();
				String disciplina = "";
				
				if(opcao == -1){
					break;
				}
				
				switch(opcao){
					case 0:
						String nomeBoletim = gui.recebeTexto("Insira o nome do aluno:");
						op.boletim(nomeBoletim, notas);
						break;
					case 1:
						disciplina = gui.recebeTexto("Insira o nome da disciplina:");
						gui.exibeMsg(op.aproveitamentoDisciplina(disciplina, notas));
						break;
					case 2:
						disciplina = gui.recebeTexto("Insira o nome da disciplina:");
						gui.exibeMsg(op.mediaDisciplina(disciplina, notas));
						break;
					case 3:
						gui.exibeMsg(op.calculoMensalidades(alunos));
						break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
