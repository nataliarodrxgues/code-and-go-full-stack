package com.agencia.controllerCRUD;


import java.io.IOException;


import com.agencia.DAO.ClientesDAO;
import com.agencia.models.Clientes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;






@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Clientes clientes = new Clientes();
        
        clientes.setCPF_Cliente(req.getParameter("CPF_Cliente"));
        clientes.setNome_Cliente(req.getParameter("nome_Cliente"));
        clientes.setTelefone_Cliente(req.getParameter("telefone_Cliente"));
        clientes.setEmail_Cliente(req.getParameter("email_Cliente"));
        clientes.setSenha_Cliente(req.getParameter("senha_Cliente"));
        clientes.setEndereco_Cliente(req.getParameter("endereco_Cliente"));
        
        try {
            ClientesDAO clientesDAO = new ClientesDAO();
            clientesDAO.createClientes(clientes);
            
            res.sendRedirect("ReadController");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
