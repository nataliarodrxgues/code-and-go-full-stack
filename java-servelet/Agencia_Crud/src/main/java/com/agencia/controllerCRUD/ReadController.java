package com.agencia.controllerCRUD;

import java.io.IOException;
import java.util.List;

import com.agencia.DAO.ClientesDAO;
import com.agencia.models.Clientes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/ReadController")
public class ReadController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            ClientesDAO cDAO = new ClientesDAO();
            List<Clientes> clientes = cDAO.findAllClientes();
            req.setAttribute("clientes", clientes);
            
            RequestDispatcher rd = req.getRequestDispatcher("listaCliente.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

