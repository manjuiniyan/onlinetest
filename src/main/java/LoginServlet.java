import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside the Login Servlet");
        response.setContentType("text/html");
        HttpSession session = request.getSession(true); // true create new session
        String username = request.getParameter("user_name");
        String password = request.getParameter("password");
        String errorMessage = "";
        try {
            if (username.length() < 3 || password.length() < 5) {
                errorMessage = "Username should be more than 3 characters and Password should be more than 5 characters.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                // Validate user from the database
                Map<String, String> userDetailsMap = validateUser(username, password);
                String userType = userDetailsMap.get("userType");
                System.out.println("User Type=" + userType);
                session.setAttribute("userName", username);
                String userId = userDetailsMap.get("userID");
                session.setAttribute("userID", userId);
                session.setAttribute("userType", userType);

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
        } catch (Exception e) {
            e.printStackTrace();
            errorMessage = "Exception whil login.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private Map<String, String> validateUser(String username, String password) {
        Map<String, String> userDetailsMap = new HashMap();
        try {
            // JDBC connection to MySQL database
            Connection con = DBConnection.getConnection();
            // Query to check user credentials
            String query = "SELECT * FROM u933391433_onlinetest.Users WHERE username='" + username + "' AND password='"
                    + password + "'";
            System.out.println("***************** sql login Query=" + query);
            // PreparedStatement pstmt = con.prepareStatement(query);
            Statement stmt = con.createStatement();

            System.out.println("User Name=" + username + "\nPassword=" + password);
            ResultSet rs = stmt.executeQuery(query);
            String userID = "";
            String user_type = "";
            while (rs.next()) {
                userID = String.valueOf(rs.getString("user_id"));
                user_type = String.valueOf(rs.getString("user_type"));
                System.out.println("User ID=" + userID + "\nUser Type=" + user_type);

                userDetailsMap.put("userID", userID);
                userDetailsMap.put("userType", user_type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("User Details Map=" + userDetailsMap);
        return userDetailsMap;
    }
}