package com.agencia.controllerCRUD;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.agencia.DAO.ClientesDAO;

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String idParam = req.getParameter("id_cliente");
        
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                ClientesDAO cDAO = new ClientesDAO();
                cDAO.deleteClientes(id);
                res.sendRedirect("ReadController");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                res.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
            } catch (Exception e) {
                e.printStackTrace();
                res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir o cliente");
            }
        } else { 
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID ausente");
        }
    }
}
