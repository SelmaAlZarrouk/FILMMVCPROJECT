package db;
import java.util.ArrayList;
import java.sql.*;
import model.Film;
//REPORT CLOSRE CONNECTIONS AS IT PREVENTS MEMORY LEAKS  

/* My Film DAO class features all CRUD database operations for the film assignment based upon 
  the givene database.*/
public class FilmDAO {
	
	Film oneFilm = null;
	Connection conn = null;
    Statement stmt = null;
	String user = "zarrouks";
    String password = "stremfoL7";
    // Note none default port used, 6306 not 3306
    String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/"+user;

	public FilmDAO() {}
 
	
	private Statement openConnection(){  // this establishes my JDBC connection, Loading JDBC driver for my sql( Film script)
		
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for demos database, username demos, password demos
 			conn = DriverManager.getConnection(url, user, password);
		    stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }	  
		return stmt;
    }
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Film getNextFilm(ResultSet rs){
    	Film thisFilm=null;
		try {
			thisFilm = new Film(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getInt("year"),
					rs.getString("director"),
					rs.getString("stars"),
					rs.getString("review"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return thisFilm;		
	}
	
	
	//this method selects all Contacts  selectAllContacts() 
	//this gets all the contacts from the database
	//and then returns an arraylist
	

   public ArrayList<Film> getAllFilms(){
	 //this iterates over the arraylist in JSPViews
		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	allFilms.add(oneFilm);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilms;
   }
 //this will select one film , its provided with an id.
   public Film getFilmByID(int id){
	   
		openConnection();
		oneFilm=null;
	    // Create select statement and execute it 
		
		//sql STATMENT OPENCONNECTION CLOSE CONNNECTION ---> this is for mudfoot server db 
		try{
		    String selectSQL = "select * from films where id="+id;
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    }

		    stmt.close();
		    
		} catch(SQLException se) { System.out.println(se); }
				
	   return oneFilm;
	   
   }
   
   //Insert  sql statement :
	public boolean  insertFilm(Film f) throws SQLException {
		boolean b = false;
		try {
			String sql = "INSERT INTO films (title, year, director, stars, review) VALUES ('" + f.getTitle() + "','" + f.getYear() + "','" + f.getDirector() + "','" + f.getStars() + "','" + f.getReview() +"');";
			System.out.println(sql);
			b = openConnection().execute(sql);
			closeConnection();
			b = true;
		} catch (SQLException s) {
			throw new SQLException("Film Not Added");
		}
		return b;
	}
	
   
   //Delete sql Statemnt :
   public boolean deleteFilm(Film f) throws SQLException {
		boolean b = false;
				try {
			//String sql = " DELETEE FROM contacts where id =" + c.getId()+"';";
			String sql = "DELETE FROM films WHERE id = " +f.getId()+ ";";
			System.out.println(sql);
			b = openConnection().execute(sql);		
			 closeConnection();
			
	       b = true;
		} catch (SQLException s) {
			throw new SQLException("Contact Not Delete");
		}
		
		return b;
		
	}
   
   //Update sql Statement :
 //Update CRUD evident , this will allow customers 
 	public boolean updateFilm(Film f) throws SQLException {
 		boolean b = false;
 		try {
 			String sql = "UPDATE films SET title ='"+ f.getTitle() +"', year = '"+f.getYear()+"', director = '"+f.getDirector()+"', stars = '"+f.getStars()+"', review = '"+f.getReview()+"' WHERE id = '" + f.getId() +"';";
 			openConnection();
 			System.out.println(sql);
 		stmt.execute(sql);
 			closeConnection();
 			b = true;
 		} catch (SQLException s) {
 			throw new SQLException("Film Not UPDATED");
 		}
 		return b;
 	}
 	
   
   
   
   //Search sql Statement :
   

	public ArrayList<Film>searchingFilms(String searchAbility, String filmData){
		openConnection();
		ArrayList<Film>filmsArray = new ArrayList<Film>();
		try {
			//String sql= "SELECT * FROM films WHERE " + searchAbility + " = '" + filmData +"';";
			// query will select all from contacts under the condition that 
			/*"SELECT * FROM contacts WHERE " + searchAbililty + " LIKE '%" + contactInfo +"%';";
select all from contacts table where the users search ability is like the contact info
 the % operator symbol just means ANYTHING. so % before and after = ANYTHING can come before or after the search input/contactInfo
SELECT ALL FROM CONTACTS WHERE THE CATEGORY THE USER IS SEARCHING MATCHES THE USERS INPUT :>*/
			String sql = "SELECT * FROM films WHERE " + searchAbility + " LIKE '%" + filmData +"%';";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql); 
				if(rs !=null) {
				while(rs.next()) {
					Film film = new Film();
					try {
						film.setId(rs.getInt("id"));
						film.setTitle(rs.getString("title"));
						film.setStars(rs.getString("stars"));
						film.setYear(rs.getInt("year"));
						film.setDirector(rs.getString("director"));
						film.setReview(rs.getString("review"));
						
						
					}
					catch (SQLException s) {
						s.printStackTrace();
					}
					filmsArray.add(film);
				}
				rs.close();
			}
		}
		
		catch(SQLException s) {
			System.out.println(s);
		}
		closeConnection();
		
		return filmsArray;
		}
	
}