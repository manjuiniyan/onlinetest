import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int userCount = 0;
    ServletConfig config = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Inside the Login Servlet");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("user_name");
        String password = request.getParameter("password");

        try {
            // JDBC connection to MySQL database
            Connection con = DBConnection.getConnection();

            // Query to check user credentials
            String query = "SELECT * FROM u933391433_onlinetest.StudentLogins WHERE username=? AND password_hash=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            System.out.println("User Name=" + username + "\nPassword=" + password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Successful login
                String user_type = rs.getString(5);
                System.out.println("User Type="+user_type);
                
                if(user_type.equalsIgnoreCase("staff")){
                    System.out.println("In side user type Staff");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("question.jsp");
                    dispatcher.forward(request, response);   
                }else{
                    System.out.println("In side user type Student");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("student_index.jsp");
                    dispatcher.forward(request, response);   
                }
               
            } else {
                // Invalid credentials
                System.out.println("Invalid username and password");
                out.println("<h2>Invalid username and password. Please check your username and password.</h2>");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }

            con.close();
        } catch (Exception e) {
            out.println("Error: " + e);
        }

        out.close();
    }
}
