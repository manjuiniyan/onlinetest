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

@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("inside the Question Servlet");
        String questionText = req.getParameter("question_text");
        String optionA = req.getParameter("option_a");
        String optionB = req.getParameter("option_b");
        String optionC = req.getParameter("option_c");
        String optionD = req.getParameter("option_d");
        String correctOption = req.getParameter("correct_option");
        String explaination = req.getParameter("explaination");
        String subtopic_id = req.getParameter("subtopic_id");

        System.out.println("QuestionText=" + questionText + "\nOptionA ="
                + optionA + "\nOptionB =" + optionB + "\nOptionC =" + optionC + "\nOptionD =" + optionD
                + "\nCorrectOption =" + correctOption + "\nExplaination =" + explaination);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://193.203.166.25:3306/u933391433_onlinetest",
                "u933391433_gurukalvi",
                "GuruKalvi2023");) {
            String insert_query = "INSERT INTO `u933391433_onlinetest`.`Questions`(`question_text`, `option_a`, `option_b`, `option_c`, `option_d`, `correct_option`, `explaination`, `subtopic_id`) VALUES (?,?,?,?,?,?,?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insert_query)) {

                preparedStatement.setString(1, questionText);
                preparedStatement.setString(2, optionA);
                preparedStatement.setString(3, optionB);
                preparedStatement.setString(4, optionC);
                preparedStatement.setString(5, optionD);
                preparedStatement.setString(6, correctOption);
                preparedStatement.setString(7, explaination);
                preparedStatement.setString(8, subtopic_id);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Successfuly inserted login");

                    resp.getWriter().write("Question data added successful");
                } else {
                    resp.getWriter().write("Failed to add Question data");
                    System.out.println("failed login");
                }
                preparedStatement.close();
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().write("Database error: " + e.getMessage());

        }
        RequestDispatcher dispatcher = null;
        dispatcher = req.getRequestDispatcher("create_question.jsp");
        dispatcher.forward(req, resp);

    }
}
