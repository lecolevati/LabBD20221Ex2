package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agenda;
import persistence.AgendaDao;
import persistence.GenericDao;
import persistence.IAgendaDao;

@WebServlet("/agenda")
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AgendaServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");	
		String botao = request.getParameter("botao");
		
		Agenda a = new Agenda();
		List<Agenda> agendas = new ArrayList<Agenda>();
		GenericDao gDao = new GenericDao();
		IAgendaDao aDao = new AgendaDao(gDao);
		String erro = "";

		try {
			if (botao.equals("Buscar")) {
				if (id.equals("")) {
					erro = "#ID deve ser preenchido";
					a = null;
				} else {
					a.setId(Integer.parseInt(id));
					a = aDao.consultaAgenda(a);
				}
			}
			if (botao.equals("Listar")) {
				agendas = aDao.consultaAgendas();
				a = null;
			}
		} catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("agenda", a);
			request.setAttribute("agendas", agendas);
			request.setAttribute("erro", erro);
			rd.forward(request, response);
		}
	}

}
