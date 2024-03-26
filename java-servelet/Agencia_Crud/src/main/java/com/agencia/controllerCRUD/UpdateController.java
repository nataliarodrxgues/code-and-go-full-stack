package com.agencia.controllerCRUD;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.agencia.DAO.ClientesDAO;
import com.agencia.models.Clientes;

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            try {
                ClientesDAO cDAO = new ClientesDAO();
                Clientes clientes = cDAO.findClientes(id);

                req.setAttribute("clientes", clientes);

                RequestDispatcher rd = req.getRequestDispatcher("atualizar.jsp");
                rd.forward(req, res);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
        	req.setAttribute("erro", "O ID está ausente ou inválido.");


        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            Clientes clientes = new Clientes();
            clientes.setId_Cliente(Integer.parseInt(req.getParameter("id")));
            clientes.setCPF_Cliente(req.getParameter("CPF_Cliente"));
            clientes.setNome_Cliente(req.getParameter("nome_Cliente"));
            clientes.setTelefone_Cliente(req.getParameter("Telefone_Cliente"));
            clientes.setEmail_Cliente(req.getParameter("email_Cliente"));
            clientes.setSenha_Cliente(req.getParameter("Senha_Cliente"));
            clientes.setEndereco_Cliente(req.getParameter("Endereco_Cliente"));

            ClientesDAO cDAO = new ClientesDAO();
            cDAO.updateClientes(clientes);

            res.sendRedirect("ReadController");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

