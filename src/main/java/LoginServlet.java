import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside the Login Servlet");
        response.setContentType("text/html");

        String username = request.getParameter("user_name");
        String password = request.getParameter("password");
        String errorMessage = "";

        if (username.length() < 3 || password.length() < 5) {
            errorMessage = "Username should be more than 3 characters and Password should be more than 5 characters.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            // Validate user from the database
            String userType = validateUser(username, password);
            System.out.println("User Type=" + userType);

            if (userType.equals("staff")) {
                System.out.println("In side user type Staff");
                response.sendRedirect("create_question.jsp");
            } else if (userType.equals("student")) {
                System.out.println("In side user type Student");
                response.sendRedirect("student_index.jsp");
            } else {
                System.out.println("Invalid username or password.");
                errorMessage = "Invalid username or password.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }

    private String validateUser(String username, String password) {

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
                return rs.getString("user_type");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "invalid";
    }
}