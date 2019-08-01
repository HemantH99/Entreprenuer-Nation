
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Hackathon {
	//public static DB db = new DB();

	
	public static void main(String[] args) throws SQLException, IOException {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/qa";
			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("conn built");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
                String sql1 = "TRUNCATE news";
			Statement stmt1 = conn.createStatement();
				stmt1.executeUpdate(sql1);
                 
                 String sql3 = "TRUNCATE marketing";
			Statement stmt3 = conn.createStatement();
				stmt3.executeUpdate(sql3);
                String sql4 = "TRUNCATE funding";
			Statement stmt4 = conn.createStatement();
				stmt4.executeUpdate(sql4);
                 String sql5 = "TRUNCATE yourstory";
			Statement stmt5 = conn.createStatement();
				stmt5.executeUpdate(sql5);
                processPageNews("http://www.t-hub.co/news","h3.post-title a");
		//processPageNews("http://msde.gov.in","div.event-text.clearfix a");
		processPageStories("https://yourstory.com/tag/startup-india/","li.grid-full a");
                processPageFunding("https://yourstory.com/resources/funding/","li.grid-full a");
                processPageMarketing("https://www.entrepreneur.com/topic/marketing","h3 a");
		/*for(int i=0;i<204;i++)
		{
			processPage1("https://yourstory.com/ys-stories/page/"+i+"/","div.pill");
		}*/
	}
	
 
	public static void processPageNews(String URL,String p) throws SQLException, IOException{
		Document doc = Jsoup.connect(URL).timeout(30*1000).get();
		String attrs,text;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/qa?zeroDateTimeBehavior=convertToNull";
			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("conn built");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

                 
		// Elements el=doc.getElementsByClass("box-container");
	       Elements links =doc.select(p);
	      for (Element link : links) {
	    	   attrs=link.attr("abs:href");
	    	   	text=link.text();
	    	   	
	    	  String sql = "INSERT INTO  news values (?,?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1,attrs);
				stmt.setString(2,text);
				stmt.execute();
	            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
	      }
	            System.out.println("end");
	           // String attr="gs";
	          //  String tex="ld";
	            //db.runSql2("Insert into yourstory values('1',"+attr+","+tex+");");
	           // PreparedStatement ps=
	        
		
	}
	public static void processPageChallenges(String URL,String p) throws SQLException, IOException{
		Document doc = Jsoup.connect(URL).timeout(30*1000).get();
		String attrs,text;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/qa";
			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("conn built");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

                
		// Elements el=doc.getElementsByClass("box-container");
	       Elements links =doc.select(p);
	      for (Element link : links) {
	    	   attrs=link.attr("abs:href");
	    	   	text=link.text();
	    	   	
	    	  String sql = "INSERT INTO  challenges values (?,?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1,attrs);
				stmt.setString(2,text);
				stmt.execute();
	            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
	      }
	            System.out.println("end");
	           // String attr="gs";
	          //  String tex="ld";
	            //db.runSql2("Insert into yourstory values('1',"+attr+","+tex+");");
	           // PreparedStatement ps=
	        
		
	}
        
        public static void processPageMarketing(String URL,String p) throws SQLException, IOException{
		Document doc = Jsoup.connect(URL).timeout(30*1000).get();
		String attrs,text;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/qa";
			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("conn built");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

                
		// Elements el=doc.getElementsByClass("box-container");
	       Elements links =doc.select(p);
	      for (Element link : links) {
	    	   attrs=link.attr("abs:href");
	    	   	text=link.text();
	    	   	
	    	  String sql = "INSERT INTO  marketing values (?,?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1,attrs);
				stmt.setString(2,text);
				stmt.execute();
	            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
	      }
	            System.out.println("end");
	           // String attr="gs";
	          //  String tex="ld";
	            //db.runSql2("Insert into yourstory values('1',"+attr+","+tex+");");
	           // PreparedStatement ps=
	        
		
	}
	
	
	public static void processPageFunding(String URL,String p) throws SQLException, IOException{
		Document doc = Jsoup.connect(URL).timeout(30*1000).get();
		String attrs,text;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/qa?zeroDateTimeBehavior=convertToNull";
			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("conn built");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
               

		// Elements el=doc.getElementsByClass("box-container");
	       Elements links =doc.select(p);
	      for (Element link : links) {
	    	   attrs=link.attr("abs:href");
	    	   	text=link.text();
	    	   	
	    	  String sql = "INSERT INTO  funding values (?,?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1,attrs);
				stmt.setString(2,text);
				stmt.execute();
	            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
	      }
	            System.out.println("end");
	           // String attr="gs";
	          //  String tex="ld";
	            //db.runSql2("Insert into yourstory values('1',"+attr+","+tex+");");
	           // PreparedStatement ps=
	        
		
	}
	public static void processPageStories(String URL,String p) throws SQLException, IOException{
		Document doc = Jsoup.connect(URL).timeout(30*1000).get();
		String attrs,text;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/qa";
			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("conn built");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

               
		// Elements el=doc.getElementsByClass("box-container");
	       Elements links =doc.select(p);
	      for (Element link : links) {
	    	   attrs=link.attr("abs:href");
	    	   	text=link.text();
	    	   	
	    	  String sql = "INSERT INTO  yourstory values (?,?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1,attrs);
				stmt.setString(2,text);
				stmt.execute();
	            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
	      }
	            System.out.println("end");
	           // String attr="gs";
	          //  String tex="ld";
	            //db.runSql2("Insert into yourstory values('1',"+attr+","+tex+");");
	           // PreparedStatement ps=
	        
		
	}
	
	private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
    /*public static void keySearch(String s)
    {
        processPageStories("https://yourstory.com/tag/"+s+"/","li.grid-full a");
    }*/
}