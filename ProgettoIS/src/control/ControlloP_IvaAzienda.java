package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Azienda;
import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;

/**
 * Servlet per il controllo dell' univocit� della Partita Iva
 * inserita dall'azienda in fase della registrazione
 */
@WebServlet("/ControlloP_IvaAzienda")
public class ControlloP_IvaAzienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControlloP_IvaAzienda() {
        super();
        
    }

    /**
   	 *  controlla nel db la presenza di un' azienda
   	 *  che abbia la Partita Iva passata come parametro 
   	 *  
   	 *  @author Luca Lamberti , Simone Torluccio
   	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text");
		
		String risultato="";
 		String piva=request.getParameter("piva");
 		
 		AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
		Azienda azienda = new Azienda();
		
		azienda= aziendaDao.getAziendaByEmail(piva);
		
		if(azienda== null){risultato="P_Iva valida";}
		else{risultato="P_Iva non  valida, gia' presente nel database";}
		
		response.getWriter().write(risultato);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}