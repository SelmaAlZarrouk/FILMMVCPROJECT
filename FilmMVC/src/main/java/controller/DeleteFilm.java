package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import db.FilmDAO;
import model.Film;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete-film")
public class DeleteFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
		
		FilmDAO dao = new FilmDAO();//makes instanct og ContactDao 
		//giving us access to its methods and SQL query executions
		Film f = dao.getFilmByID(id);
		
		try {
			dao.deleteFilm(f);
		} catch (SQLException e) {
			e.printStackTrace();

			}
		response.sendRedirect("./films"); //ctrl space))

	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
