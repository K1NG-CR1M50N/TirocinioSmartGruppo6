package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Azienda;
import bean.Studente;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;

/**
 * Servlet implementation class TirocinantiViewControl
 */
@WebServlet("/TirocinantiViewControl")
public class TirocinantiViewControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TirocinantiViewControl() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String email = (String) session.getAttribute("email");
		AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
		Azienda a = aziendaDao.getAziendaByEmail(email);
		String piva = a.getP_iva();//prendo la p.iva dell'azienda loggata 
			
		StudenteDaoInterface studenteDAO = new StudenteDaoImpl();
		ArrayList<Studente> studenti = studenteDAO.getTirocinanti(piva);//la p.iva precedentemente presa � usata come parametro della query
		
        request.setAttribute("studenti", studenti);
		
		/* Crea lista */
		getServletConfig().getServletContext().getRequestDispatcher("/ListaTirocinanti.jsp").forward(request, response);
		
		
	}

}