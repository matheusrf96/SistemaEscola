package br.unincor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.unincor.connection.DBConnection;
import br.unincor.model.Aluno;

public class AlunoDAO {

	private Aluno aluno;
	private DBConnection dbConnection;
	
	public AlunoDAO() {
		aluno = null;
		dbConnection = new DBConnection();
	}
	
	public List<Aluno> selectAllAluno(){
		List<Aluno> alunos = new ArrayList<Aluno>();
		String sql = "SELECT * FROM aluno";
		
		try{
			dbConnection.openDBConnection();
			PreparedStatement pStatement = dbConnection.CON.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			
			while(rs.next()){
				Aluno alunoAux = new Aluno(
					rs.getInt("matricula"),
					rs.getString("nome"),
					rs.getDate("dt_nasc"),
					rs.getString("cpf"),
					rs.getDouble("mensalidade")
				);
				
				alunos.add(alunoAux);
			}		
			
			dbConnection.closeDBConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}	
		
		return alunos;
	}
}
