package javaFiles.controller;


import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javaFiles.data.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("fornecedores")
public class FornecedorController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	
	public List<Fornecedor> listaFornecedores(){
		
		try {
			
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			return fornecedorDAO.listarFornecedores();
			
		}catch(SQLException | ClassNotFoundException error) {
			Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, error);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Fornecedor getFornecedor(@PathParam("id") int id) {
		//System.out.println("Conectado");
		try {
			
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			//System.out.println("Entrou");
			return fornecedorDAO.selecionarFornecedor(id);
			
		}catch(SQLException | ClassNotFoundException error) {
			Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, error);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response criarFornecedor(Fornecedor fornecedor) {
		
		try {
			
			FornecedorDAO fornecedorDAO = new FornecedorDAO();

			fornecedorDAO.inserirFornecedor(fornecedor);
			
			return Response.status(Response.Status.OK).build(); //codigo 200
			
		}catch(SQLException | ClassNotFoundException error) {
			Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, error);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response atualizarFornecedor(Fornecedor fornecedor) {

		try {
			
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedorDAO.alterarFornecedor(fornecedor);
			
			return Response.status(Response.Status.OK).build(); //codigo 200
			
		}catch(SQLException | ClassNotFoundException error) {
			Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, error);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DELETE
	@Path("{id}/")
	public Response deletarFornecedor(@PathParam("id") int id) {
		try {
			
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedorDAO.excluirFornecedor(id);
			
			return Response.status(Response.Status.OK).build(); //codigo 200
			
		}catch(SQLException | ClassNotFoundException error) {
			Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, error);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
