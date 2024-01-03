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

@WebServlet("/updateQuestionServlet")
public class UpdateQuestionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Inside the UpdateQuestionSErvlet");
        String question_id = request.getParameter("question_id");// question_id
        String questionText = request.getParameter("question_text");
        String optionA = request.getParameter("option_a");
        String optionB = request.getParameter("option_b");
        String optionC = request.getParameter("option_c");
        String optionD = request.getParameter("option_d");
        String correctOption = request.getParameter("correct_option");
        String explaination = request.getParameter("explaination");

        System.out.println("QuestionText=" + questionText + "\nOptionA ="
                + optionA + "\nOptionB =" + optionB + "\nOptionC =" + optionC + "\nOptionD =" + optionD
                + "\nCorrectOption =" + correctOption + "\nExplaination =" + explaination + " question_id = "
                + question_id);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://193.203.166.25:3306/u933391433_onlinetest",
                "u933391433_gurukalvi",
                "GuruKalvi2023");) {
            String update_query = "UPDATE `u933391433_onlinetest`.`Questions` SET `option_a`=?, `option_b`=?, `option_c`=?, `option_d`=?, `correct_option`=?, `explaination`=? WHERE `question_id`=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(update_query)) {

                preparedStatement.setString(1, optionA);
                preparedStatement.setString(2, optionB);
                preparedStatement.setString(3, optionC);
                preparedStatement.setString(4, optionD);
                preparedStatement.setString(5, correctOption);
                preparedStatement.setString(6, explaination);
                preparedStatement.setString(7, question_id);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Successfully updated data in question table");
                    response.getWriter().write("Question data updated successfully");
                } else {
                    response.getWriter().write("Failed to update question data");
                    System.out.println("Failed to update question data");
                }
                preparedStatement.close();
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Database error: " + e.getMessage());
        }

        RequestDispatcher dispatcher = null;
        dispatcher = request.getRequestDispatcher("create_question.jsp");
        dispatcher.forward(request, response);
    }

}
