package controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.FilmDAO;
import model.Film;

@WebServlet("/searching-film")
public class SearchFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.getRequestDispatcher("./SearchFilm.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creating a request to get the search ability, such that it
				// it will allow the user to write input and it will then get stored as a string 
				
		String searchAbility = request.getParameter("searchAbility");
		String contactData = request.getParameter("filmData");
	
	   FilmDAO dao = new FilmDAO();//this is me creating new instance of my filmsDAO 
	   ArrayList<Film>allFilms = dao.searchingFilms(searchAbility, contactData);//using the contact search method
	 //below  I have used the request set attribute to set contacts to allCons  towhich will be on results page 
	 request.setAttribute("films", allFilms);
	
	 //below I have  request dispatcher towhich will send to the searched contacts page
	 // showing the searched for contacts that the Admin has requested . 
	 RequestDispatcher rd = request.getRequestDispatcher("FilmList.jsp");
	 rd.include(request, response);
	}

}
