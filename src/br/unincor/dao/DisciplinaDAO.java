package br.unincor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unincor.connection.DBConnection;
import br.unincor.model.Disciplina;

public class DisciplinaDAO {
	private Disciplina disciplina;
	private  DBConnection dbConnection;
	
	public DisciplinaDAO() {
		disciplina = null;
		dbConnection = new DBConnection();
	}
	
	public List<Disciplina> selectAllDisciplina(){
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		String sql = "SELECT * FROM disciplinas";
		
		try {
			dbConnection.openDBConnection();
			PreparedStatement pStatement = dbConnection.CON.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			
			while(rs.next()) {
				Disciplina discAux = new Disciplina(
					rs.getInt("id"),
					rs.getString("nome")
				);
				
				disciplinas.add(discAux);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}	
		
		return disciplinas;
	}
}
