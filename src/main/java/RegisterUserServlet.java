import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside the RegisterUserServlet");
        response.setContentType("text/html");
        String firstname = request.getParameter("fname");
        String lastname = request.getParameter("lname");
        String username = request.getParameter("username");
        String password = request.getParameter("password1");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String dob = request.getParameter("dob");

        System.out.println(
                "firstname = " + firstname + "\n lastname = " + lastname + "\n username = " + username
                        + "\n password = "
                        + password + "\n email = " + email + " \nmobile = " + mobile + "\n dob = " + dob);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://193.203.166.25:3306/u933391433_onlinetest", "u933391433_gurukalvi",
                "GuruKalvi2023");) {
            String insert_query = "INSERT INTO `u933391433_onlinetest`.`Users`(`first_name`, `last_name`, `username`, `password`, `email`, `phone`, `dob`, `user_type`) VALUES (?,?,?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insert_query)) {
                preparedStatement.setString(1, firstname);
                preparedStatement.setString(2, lastname);
                preparedStatement.setString(3, username);
                preparedStatement.setString(4, password);
                preparedStatement.setString(5, email);
                preparedStatement.setString(6, mobile);
                preparedStatement.setString(7, dob);
                preparedStatement.setString(8, "student");
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Successfully inserted login");
                } else {
                    System.out.println("Failed to insert login");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().write("Database error: " + e.getMessage());
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Database connection error: " + e.getMessage());
        }
    }
}
