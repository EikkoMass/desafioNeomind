package javaFiles.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaFiles.infra.ConexaoJDBC;
import javaFiles.infra.ConexaoMySqlJDBC;

public class FornecedorDAO {

	private final  ConexaoJDBC conexao;
	
	public FornecedorDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMySqlJDBC();	
	}
	
	//inserir
	
	public void inserirFornecedor(Fornecedor fornecedor) throws SQLException, ClassNotFoundException{
		
		
		String sqlQuery = "INSERT INTO fornecedores (name, email, comment, cnpj) VALUES (?, ?, ?, ?)";
		
		try {
			
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, fornecedor.getName()); //preenchendo os campos com "?" no Insert
			stmt.setString(2, fornecedor.getEmail());
			stmt.setString(3, fornecedor.getComment());
			stmt.setString(4, fornecedor.getCnpj());

			stmt.execute();

			
			this.conexao.commit();
			
		}catch(SQLException error) {
			
			this.conexao.rollback();
			throw error;
			
		}
		
		
	}
	//alterar
	
	public int alterarFornecedor(Fornecedor fornecedor) throws SQLException, ClassNotFoundException{
		
		String sqlQuery = "UPDATE fornecedores SET name = ?, email = ?, comment = ?, cnpj = ? WHERE id = ?";
		int linhasAfetadas = 0;
		
		try {
			
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, fornecedor.getName()); //preenchendo os campos com "?" no Insert
			stmt.setString(2, fornecedor.getEmail());
			stmt.setString(3, fornecedor.getComment());
			stmt.setString(4, fornecedor.getCnpj());
			stmt.setLong(5, fornecedor.getId());

			linhasAfetadas = stmt.executeUpdate();
			
			this.conexao.commit();
			
		}catch(SQLException error) {
			
			this.conexao.rollback();
			throw error;
			
		}
		
		return linhasAfetadas;
		
	}
	
	//excluir
	
	public int excluirFornecedor(int id) throws SQLException, ClassNotFoundException{
		
		String sqlQuery = "DELETE FROM fornecedores WHERE id = ?";
		int linhasAfetadas = 0;
		
		try {
			
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, id); //preenchendo os campos com "?" no Insert
			 
			linhasAfetadas = stmt.executeUpdate();
			
			this.conexao.commit();
			
		}catch(SQLException error) {
			
			this.conexao.rollback();
			throw error;
			
		}
		
		return linhasAfetadas;
		
	}
	
	
	//selecionar
	
	public Fornecedor selecionarFornecedor(int id) throws SQLException, ClassNotFoundException{
		
		String sqlQuery = "SELECT * FROM fornecedores WHERE id = ?";
		
		try {
			
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery); //evita SQL injection
			stmt.setLong(1, id); //preenchendo os campos com "?" no Insert
			 
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				return conversorParaObjeto(rs);
			}
			
			this.conexao.commit();
			
		}catch(SQLException error) {
			
			throw error;
			
		}
		
		return null;
		
	}
	
	private Fornecedor conversorParaObjeto(ResultSet result) throws SQLException, ClassNotFoundException{
		
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setId((int)result.getLong("id"));
		fornecedor.setName(result.getString("name"));
		fornecedor.setEmail(result.getString("email"));
		fornecedor.setComment(result.getString("comment"));
		fornecedor.setCnpj(result.getString("cnpj"));
		
		return fornecedor;
	}
	
	//listar
	
	
	public List<Fornecedor> listarFornecedores() throws SQLException, ClassNotFoundException{
		
		String sqlQuery = "SELECT * FROM fornecedores ORDER BY id";
		
		
		try{
		PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery); //evita SQL injection
		ResultSet rs = stmt.executeQuery();
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		
		while(rs.next()) {
			fornecedores.add(conversorParaObjeto(rs));
		}
		
		
		return fornecedores;
		}catch(SQLException error) {
			
			this.conexao.rollback();
			throw error;
			
		}
		
	}
}
