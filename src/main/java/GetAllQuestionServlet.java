
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

@WebServlet("/getAllQuestionServlet")
public class GetAllQuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Connection connection = DBConnection.getConnection();
        StringBuilder resultTable = new StringBuilder();
        resultTable.append("<table class=\"table table-striped\" >");
        resultTable.append(
                "<thead><tr><th>Question ID</th><th>SubTopic ID</th><th>Question Text</th><th>Option A</th><th>Option B</th><th>Option C</th><th>Option D</th><th>Correct Option</th><th>Explaination</th></tr></thead>");

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select q.*,st.subtopic_name from u933391433_onlinetest.Questions q,u933391433_onlinetest.Subtopics st where q.subtopic_id=st.subtopic_id");
            while (resultSet.next()) {
                String question_id = resultSet.getString(1);
                resultTable.append("<tr><td> <a href='#' onclick=\"loadQuestion(" + question_id + ")\">" + question_id
                        + "</a> </td> <td>" + resultSet.getString("subtopic_name") + "</td><td>" + resultSet.getString(3)
                        + "</td><td>" + resultSet.getString(4) + "</td><td>" + resultSet.getString(5) + "</td><td>"
                        + resultSet.getString(6) + "</td><td>" + resultSet.getString(7) + "</td><td>"
                        + resultSet.getString(8) + "</td><td>" + resultSet.getString(9) + "</td></tr>");
            }
            
            resultTable.append("</table>");
            System.out.println(resultTable);
            out.print(resultTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
