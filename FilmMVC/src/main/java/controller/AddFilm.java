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
import model.Film;
import db.FilmDAO;

/**
 * Servlet implementation class AddContact
 */

@WebServlet("/add-film")
public class AddFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("NewFilm.jsp").forward(request, response);
	    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String title = request.getParameter("title");
	    String stars = request.getParameter("stars");
	    String review = request.getParameter("review");
	    String directors= request.getParameter("director");
	    int year = Integer.parseInt(request.getParameter("year"));
	    
	    FilmDAO dao = new FilmDAO();
	    
	    
	    //creating film Object , so for film class it need to get 
	    //here I calling upon the public void set methods found in Film.java 
	    Film film = new Film();
	    film.setTitle(title);
	    film.setStars(stars);
	    film.setDirector(directors);
	    film.setYear(year);
	    film.setReview(review);

	    try {
	    	dao.insertFilm(film);
	    	}catch (SQLException e) {
	    			e.printStackTrace();
	    		}
	    	
	    response.sendRedirect("./films");
	}

}
