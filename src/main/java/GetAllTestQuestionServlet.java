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

@WebServlet("/getAllTestQuestionServlet")
public class GetAllTestQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Connection connection = DBConnection.getConnection();
        StringBuilder resultTable = new StringBuilder();
        resultTable.append("<table id=\"datatablesSimple\" class=\"table table-striped\" >");
        resultTable.append(
                "<thead><tr><th>Test ID</th><th>Test Name</th><th>Test Duration</th><th>Start Time</th><th>End Time</th><th>Test Discription</th><th>Total Questions</th> </tr></thead>");

        try {
            Statement stat = connection.createStatement();
            String test_question_query = "select t.*, count(tq.question_id) from u933391433_onlinetest.Test t, u933391433_onlinetest.TestQuestions tq where t.test_id=tq.test_id GROUP BY t.test_id";
            System.out.println("test_question_query=" + test_question_query);

            ResultSet resultSet = stat.executeQuery(test_question_query);
            while (resultSet.next()) {
                String test_id = resultSet.getString(1);
                resultTable.append("<tr><td> <a href='#' onclick=\"loadTest(" + test_id + ")\">" + test_id
                        + "</a> </td><td>"
                        + resultSet.getString(2)
                        + "</td><td>" + resultSet.getString(3)
                        + "</td><td>" + resultSet.getString(4) + "</td><td>"
                        + resultSet.getString(5) + "</td><td>" + resultSet.getString(6) + "</td><td>"
                        + resultSet.getString(7) + "</td></tr>");

            }
            resultTable.append("</table>");
            System.out.println(resultTable);
            out.print(resultTable);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
