package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.FilmDAO;
import model.Film;

@WebServlet("/update-film")
public class UpdateFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//pass id of the contact i want to update
				
		int id = Integer.parseInt(request.getParameter("id"));
		
		FilmDAO dao = new FilmDAO();
		Film f = dao.getFilmByID(id); //  fetches the film with id you wish to update  
		
		request.setAttribute("film", f);    //sets  f  object to film so we can access it 
		RequestDispatcher rd = request.getRequestDispatcher("EditFilmForm.jsp");//telling which page results to get displayed
		rd.include(request, response);//exeutes it
		
		//System.out.println(name);
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String title = request.getParameter("title");
    String director = request.getParameter("director");
    String stars = request.getParameter("stars");
    String review = request.getParameter("review");
    String stringYear = request.getParameter("year");
    String stringId = request.getParameter("id");

    int intYear = Integer.parseInt(stringYear.trim());
    int intId = Integer.parseInt(stringId.trim());

    FilmDAO dao = new FilmDAO();
    Film f = new Film(intId,title,intYear,director,stars,review);

    try {
        dao.updateFilm(f);
        System.out.print("updated");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    response.sendRedirect("./films");
}
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	
	/*protected void doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Strin
		String title = request.getParameter("filmTitle");
		String email = request.getParameter("contactEmail");
		//String id = request.getParameter("id");
		String star = request.getParameter("Stars");
		// get id of contact to update
		// int id = request.getParameter("contactId");
		int id = Integer.parseInt(request.getParameter("id"));
		// use the id to select the contact

		// pass the contact to a JSP page to display the current
		// contact details on a form (you can use the value attribute in an html input
		// to set the value of the input).

		FilmDAO dao = new FilmDAO();
		Film f = new Film(id, year , );
		c.setId(id);
		try {
			dao.updateContact(c);
		} catch (SQLException e) {
			e.printStackTrace();

			}
		response.sendRedirect("./contacts"); //ctrl space))

	}
}
*/

/*
 * @WebServlet("/add-contact") public class AddContact extends HttpServlet {
 * private static final long serialVersionUID = 1L;
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { // TODO Auto-generated
 * method stub String name = request.getParameter("contactName"); String email =
 * request.getParameter("contactEmail");
 * 
 * ContactsDAO dao = new ContactsDAO(); Contact c = new Contact(name,email);
 * 
 * try { dao.insertContact(c); }catch (SQLException e) { e.printStackTrace(); }
 * 
 * ArrayList<Contact> allCons = dao.selectAllContacts();
 * 
 * request.setAttribute("contacts", allCons);
 * 
 * RequestDispatcher rd = request.getRequestDispatcher("contacts.jsp");
 * rd.include(request,response);
 * 
 * }
 * 
 * }
 */