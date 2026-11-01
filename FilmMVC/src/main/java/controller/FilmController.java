package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.FilmDAO;
import model.Film;
/*The Servlet is
using the FilmDAO to select a single film from the sqlite database and display it. Run
the Servlet and check the output in the browser.
*/

@WebServlet("/films")
public class FilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FilmDAO dao = new FilmDAO();
		ArrayList<Film> allFilms = dao.getAllFilms();
		request.setAttribute("films",allFilms); //(gets servelt i named "Contact.java and the arraylist has all the contacts 
				//so itll call it so the function will be called  ,, fetches that shit )
				//RequestDispatcher rd = request.getRequestDispatcher("ContactList.jsp");
		//request.setAttribute("FilmList",allFilms); 
		for(Film f: allFilms) {
			System.out.println(f.getTitle());
		}
		
		//gets servelt i named "Film.java and the array list has all the films 
		RequestDispatcher rd = request.getRequestDispatcher("FilmList.jsp");
				//("films.jsp");
		rd.include(request, response);
		/*my code above is making an instance of contactsDAO into my servlet
		 * so I can use its functions such as i did where i select all contacts 
		 *Im fetching / storing in the allCons arraylist and then  its sending it to execute on the results page*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	RequestDispatcher rd = request.getRequestDispatcher("NewFilm.jsp");  //new film change up in abit
	}
	
}
