package com.agencia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencia.database.DatabaseConnection;
import com.agencia.models.Clientes;

public class ClientesDAO {
    private Connection connection;


    public ClientesDAO() {
        try {
            connection = DatabaseConnection.createConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createClientes(Clientes cliente) {
        String sql = "INSERT INTO clientes (cpf_cliente, nome_cliente, telefone_cliente, email_cliente, senha_cliente, endereco_cliente) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCPF_Cliente());
            stmt.setString(2, cliente.getNome_Cliente());
            stmt.setString(3, cliente.getTelefone_Cliente());
            stmt.setString(4, cliente.getEmail_Cliente());
            stmt.setString(5, cliente.getSenha_Cliente());
            stmt.setString(6, cliente.getEndereco_Cliente());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente criado com sucesso!");
            } else {
                System.out.println("Nenhum cliente foi criado. Verifique os valores e a estrutura do banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Clientes findClientes(int id) {
        String sql = "SELECT * FROM clientes WHERE id_Cliente = ?";
        Clientes cliente = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                cliente = new Clientes();
                cliente.setId_Cliente(resultSet.getInt("id_Cliente")); 				
                cliente.setCPF_Cliente(resultSet.getString("CPF_Cliente")); 			
                cliente.setNome_Cliente(resultSet.getString("Nome_Cliente")); 		
                cliente.setTelefone_Cliente(resultSet.getString("Telefone_Cliente")); 
                cliente.setEmail_Cliente(resultSet.getString("Email_Cliente"));  
                cliente.setSenha_Cliente(resultSet.getString("Senha_Cliente"));	
                cliente.setEndereco_Cliente(resultSet.getString("Endereco_Cliente"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    public List<Clientes> findAllClientes() {
        String sql = "SELECT * FROM clientes";
        List<Clientes> clientesList = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Clientes cliente = new Clientes();
                cliente.setId_Cliente(resultSet.getInt("id_cliente"));
                cliente.setCPF_Cliente(resultSet.getString("cpf_cliente"));
                cliente.setNome_Cliente(resultSet.getString("nome_cliente"));
                cliente.setTelefone_Cliente(resultSet.getString("telefone_cliente"));
                cliente.setEmail_Cliente(resultSet.getString("email_cliente"));
                cliente.setSenha_Cliente(resultSet.getString("senha_cliente"));
                cliente.setEndereco_Cliente(resultSet.getString("endereco_cliente"));

                System.out.printf("ID: %d\n CPF: %s\n Nome: %s\n Telefone: %s\n Email: %s\n Senha: %s\n Endereco: %s\n",
                        cliente.getId_Cliente(), cliente.getCPF_Cliente(), cliente.getNome_Cliente(),
                        cliente.getTelefone_Cliente(), cliente.getEmail_Cliente(), cliente.getSenha_Cliente(),
                        cliente.getEndereco_Cliente());

                clientesList.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientesList;
    }

    public void updateClientes(Clientes clientes) {
    	String sql = "UPDATE clientes SET cpf_cliente = ?, nome_cliente = ?, telefone_cliente = ?, email_cliente = ?, senha_cliente = ?, endereco_cliente = ? WHERE id_Cliente = ?";


        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, clientes.getCPF_Cliente());
            stmt.setString(2, clientes.getNome_Cliente());
            stmt.setString(3, clientes.getTelefone_Cliente());
            stmt.setString(4, clientes.getEmail_Cliente());
            stmt.setString(5, clientes.getSenha_Cliente());
            stmt.setString(6, clientes.getEndereco_Cliente());
            stmt.setInt(7, clientes.getId_Cliente());


			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

    public void deleteClientes(int id) {
        String sql = "DELETE FROM clientes WHERE id_Cliente = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente deletado com sucesso!");
            } else {
                System.out.println("Nenhum cliente foi deletado. Verifique o ID e a estrutura do banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
