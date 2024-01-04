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

@WebServlet("/TestQuestionServlet")
public class TestQuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("Inside the TestQuestionServlet");
        String topic_id = req.getParameter("topic_id");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        Connection connection = DBConnection.getConnection();
        StringBuilder resultTable = new StringBuilder();
        resultTable.append("<table class=\"table table-striped\" width='100%' >");
        resultTable.append(
                "<thead><tr><th>Select</th><th>Question ID</th><th style='width: 30%;' >SubTopic ID</th><th>Question Text</th><th>Option A</th><th>Option B</th><th>Option C</th><th>Option D</th><th>Correct Option</th><th>Diffculty</th><th>Mark</th><th>Explaination</th><th>SubTopic Name</th></tr></thead>");
        try {
            Statement stat = connection.createStatement();

            String query = "SELECT q.*, s.subtopic_name FROM u933391433_onlinetest.Questions q, u933391433_onlinetest.Subtopics s where s.topic_id="
                    + topic_id + " and q.subtopic_id=s.subtopic_id";
            ResultSet resultSet = stat.executeQuery(query);
            System.out.println("Select Query=" + query);
            while (resultSet.next()) {
                String question_id = resultSet.getString(1);
                resultTable.append("<tr><td><input type=\"checkbox\" name=\"selectedQuestions\" value=\"" + question_id
                        + "\"></td>"
                        + "<td> <a href='#' onclick=\"loadTestQuestion(" + question_id + ")\">"
                        + question_id + "</a> </td><td>"
                        + resultSet.getString(2)
                        + "</td><td style='text-align: left;' ><pre> \n" + resultSet.getString(3)
                        + "</pre></td><td>" + resultSet.getString(4)
                        + "</td><td>" + resultSet.getString(5)
                        + "</td><td>" + resultSet.getString(6)
                        + "</td><td>" + resultSet.getString(7)
                        + "</td><td>" + resultSet.getString(8)
                        + "</td><td>" + resultSet.getString(9)
                        + "</td><td>" + resultSet.getString(10)
                        + "</td><td>" + resultSet.getString(11)
                        + "</td><td>" + resultSet.getString(12)
                        + "</td></tr>");

            }
            resultTable.append("</table>");
            System.out.println(resultTable);
            out.println(resultTable);
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
