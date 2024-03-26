package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.model.Pedidos;
import com.agencia.utils.Colors;

public class PedidosDAO {
	
	private static String sql;
	private final Connection connection;
	public PedidosDAO(Connection connection) {
		this.connection = connection;
	}
	
		// CREATE
		
		 public void createPedidos(Pedidos pedidos) {
			 sql = "INSERT INTO cliente ( id_Cliente, NomeDestino, NomePromocao, StatusPedido, valorCompra) VALUES (?,?,?,?,?)";
				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
					 stmt.setString(1, pedidos.getId_Cliente());
					 stmt.setString(2, pedidos.getNomeDestino());
					 stmt.setString(3, pedidos.getNomePromocao());	
					 stmt.setString(4, pedidos.getStatusPedido());
					 stmt.setString(5, pedidos.getValorCompra());	 

						stmt.executeUpdate();
						System.out.println(Colors.GREEN.get() + "Pedido criado com sucesso\n" + Colors.RESET.get() + "Id do Cliente: "
								+ pedidos.getId_Cliente() + "\nStatus do Pedido: " + pedidos.getStatusPedido());
					} catch (SQLException e) {
						System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel criar o pedido." + Colors.RESET.get() +  "Mensagem: " + e.getMessage());

					}
				}

		 
			// READ
		 
			public void readAllPedidos() {
				sql = "SELECT * FROM pedidos";
				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
					ResultSet r = stmt.executeQuery();
					while (r.next()) {
						Pedidos pedidos = new Pedidos();
						pedidos.setId_Pedidos(r.getInt("id_Pedido"));
						pedidos.setId_Cliente(r.getString("id_Cliente"));
						pedidos.setNomeDestino(r.getString("Nome Destino"));
						pedidos.setNomePromocao(r.getString("Nome Promocao"));
						pedidos.setStatusPedido(r.getString("Status Pedido"));
						pedidos.setValorCompra(r.getString("Valor Compra"));
						

			System.out.printf("ID: %d\n ID Cliente: %s\\n NomeDestino: %s\n NomePromocao: %s\\n\" StatusPèdido: %s\n ValorCompra: %s\n", 
					pedidos.getId_Pedidos(), pedidos.getId_Cliente(), pedidos.getNomeDestino(), pedidos.getNomePromocao(), pedidos.getStatusPedido(), pedidos.getValorCompra());
					}
					if (!r.next()) {
						System.out.println(Colors.PURPLE_BOLD_BRIGHT.get() + "NAO HA DADOS" + Colors.RESET.get());
					}

				} catch (SQLException e) {
					System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel acessar as informacoes." + Colors.RESET.get()
							+ "Mensagem: " + e.getMessage());
				}
			}

			
			// UPDATE 

			public void updatePedidos(Pedidos pedidos) {
				sql = "UPDATE cliente SET Id_Cliente = ? , NomeDestino = ?, NomePromocao = ?, StatusPedido = ?, ValorCompra = ?  WHERE id_Pedido = ?";
				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
					stmt.setString(1, pedidos.getId_Cliente());
					stmt.setString(2, pedidos.getNomeDestino());
					stmt.setString(3, pedidos.getNomePromocao());
					stmt.setString(4, pedidos.getStatusPedido());
					stmt.setString(5, pedidos.getValorCompra());
					

				stmt.executeUpdate();
				System.out.println(Colors.GREEN.get() + "Pedido atualizado com sucesso\n" + Colors.RESET.get() + "Nome Destino: "
						+ pedidos.getNomeDestino() + "\nStatus Pedido: " + pedidos.getStatusPedido());

			} catch (SQLException e) {
				System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o pedido." + Colors.RESET.get()
						+ "Mensagem: " + e.getMessage());
			}
		}
			
			

			// DELETE
			
			public void deletePedidos(int id) {
				sql = "DELETE FROM pedido WHERE id_Pedido = ?";
				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
					stmt.setInt(1, id);

					stmt.executeUpdate();
				System.out.println(Colors.GREEN.get() + "Pedido deletado com sucesso!" + Colors.RESET.get());
			} catch (SQLException e) {
				System.out.println(Colors.RED.get() + "Nao foi possivel deletar o pedido." + Colors.RESET.get()
						+ "Mensagem: " + e.getMessage());
			}
		}

}
	

