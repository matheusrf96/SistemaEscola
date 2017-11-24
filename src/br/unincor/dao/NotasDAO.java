package br.unincor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unincor.connection.DBConnection;
import br.unincor.model.Notas;

public class NotasDAO {
	private Notas notas;
	private DBConnection dbConnection;
	
	public NotasDAO() {
		notas = null;
		dbConnection = new DBConnection();
	}
	
	public List<Notas> selectAllNotas(){
		List<Notas> notas = new ArrayList<Notas>();
		String sql = "SELECT * FROM notas";
		
		try {
			dbConnection.openDBConnection();
			PreparedStatement pStatement = dbConnection.CON.prepareStatement(sql);
			ResultSet rs = pStatement.executeQuery();
			
			while(rs.next()) {
				Notas notaAux = new Notas(
					rs.getInt("mat_aluno"),
					rs.getInt("id_disc"),
					rs.getDouble("nota")
				);
				
				notas.add(notaAux);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}	
		
		return notas;
	}
}
