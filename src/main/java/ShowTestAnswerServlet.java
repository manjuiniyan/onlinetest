import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ShowTestAnswerServlet")
public class ShowTestAnswerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     System.out.println("Inside the ShowTestAnswerServlet");
     PrintWriter out=response.getWriter();
     response.setContentType("text/html");
    String attemptId = request.getParameter("attemptID");
    out.print(attemptId);
    Connection connection = DBConnection.getConnection();
    StringBuilder answersTable = new StringBuilder();
    answersTable.append("<table class=\"table table-striped\">");
    answersTable.append("<thead><tr><th>Question ID</th><th>Question</th><th>Selected Option</th></tr></thead>");

    try {
       
        Statement statement = connection.createStatement();
        String query ="SELECT q.*, ua.selected_option FROM u933391433_onlinetest.UserAnswers ua, u933391433_onlinetest.Questions q where ua.attempt_id=18 and ua.question_id=q.question_id";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            answersTable.append("<tr><td>").append(resultSet.getString("question_id")).append("</td><td>")
                    .append(resultSet.getString("question_text")).append("</td><td>")
                    .append(resultSet.getString("selected_option")).append("</td></tr>");
        }

             answersTable.append("</table>");
             out.print(answersTable);
             } catch (SQLException e) {
             e.printStackTrace();
    }     
    } 
}
