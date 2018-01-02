package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Azienda;
import bean.Studente;

import dao.AziendaDaoImpl;
import dao.AziendaDaoInterface;
import dao.StudenteDaoImpl;
import dao.StudenteDaoInterface;
import util.FileManager;



@WebServlet("/RegistrazioneControl")
	
public class RegistrazioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_UPLOAD_PATH = "uploadedFiles";


	public RegistrazioneControl() {

	}

    /**
     * Prende il parametro per controllare il tipo di utente da registrare e a seconda se � uno Studente o Azienda istanzia il bean.
     * Subito dopo istanzia l'interfaccia dao e l'implementazione dell'interfaccia per eseguire le query e ritorna un risoltato a seconda se
     * l'operazione � riuscita oppure no.
     * 
     * @author: Mario Procida,  Francesco D'auria
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String userType = request.getParameter("tipo");
		
		if(userType.equals("Studente")){
			
			String matricola = request.getParameter("matricola");
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String password = request.getParameter("password");
			String codiceFiscale = request.getParameter("codiceFiscale");
			String email = request.getParameter("email");
			String dataNascita = request.getParameter("dataNascita");
			String luogoNascita = request.getParameter("luogoNascita");
			
			String uniqueID = UUID.randomUUID().toString(); //genera un ID univoco per l'utente
			
			Studente user = new Studente();

			user.setMatricola(matricola);
			user.setNome(nome);
			user.setCognome(cognome);
			user.setPassword(password);
			user.setCodiceFiscale(codiceFiscale);
			user.setEmail(email);
			user.setDataNascita(dataNascita);
			user.setLuogoNascita(luogoNascita);
			user.setUniqueID(uniqueID);
			
			StudenteDaoInterface studenteDao = new StudenteDaoImpl();
			
			boolean userRegistered = studenteDao.registerUser(user);

			if(userRegistered){
				
				FileManager fm = new FileManager();
				
				fm.createFolder(FILE_UPLOAD_PATH ,uniqueID); //richiama il metodo di FileManager per creare una folder con l'id unico dell'utente appena registrato
				
				out.println("<script>");
				out.println("alert('Registrazione riuscita. Ora puoi effettuare l'accesso')");
				out.println("window.open('index.jsp','_self')");
				out.println("</script>");
				
				
			}
			else{
				out.println("<script>");
				out.println("alert('Registrazione non riuscita. Riprova!')");
				out.println("window.history.back()");
				out.println("</script>");
				
				
			}
		}
		
		else if(userType.equals("Azienda")){
			
			String nomeAzienda = request.getParameter("nomeAzienda");
			String partitaIva = request.getParameter("partitaIva");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String sede = request.getParameter("sede");
			String telefono = request.getParameter("telefono");
			
			String uniqueID = UUID.randomUUID().toString(); //genera un ID univoco per l'utente
			
			Azienda user = new Azienda();
			
			user.setNomeAzienda(nomeAzienda);
			user.setP_iva(partitaIva);
			user.setEmail(email);
			user.setPassword(password);
			user.setSede(sede);
			user.setTelefono(telefono);
			user.setUniqueID(uniqueID);
			
			AziendaDaoInterface aziendaDao = new AziendaDaoImpl();
			
			boolean userRegistered = aziendaDao.registerUser(user);
			
			if(userRegistered){
				
				FileManager fm = new FileManager();
				
				fm.createFolder(FILE_UPLOAD_PATH ,uniqueID); //richiama il metodo di FileManager per creare una folder con l'id unico dell'utente appena registrato
				
				out.println("<script>");
				out.println("alert('Registrazione riuscita. Ora puoi effettuare l'accesso')");
				out.println("window.open('index.jsp','_self')");
				out.println("</script>");
				
			}
			else{
				
				out.println("<script>");
				out.println("alert('Registrazione non riuscita. Riprova!')");
				out.println("window.history.back()");
				out.println("</script>");
			}
			
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
