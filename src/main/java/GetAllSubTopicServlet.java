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

@WebServlet("/GetAllSubTopicServlet")
 public class GetAllSubTopicServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    throws ServletException, IOException {
       System.out.println("InSide the GetAllSubTopicServlet");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        Connection connection = DBConnection.getConnection();
        StringBuilder resultTable = new StringBuilder();
        resultTable.append("<table class=\"table table-striped\" >");
       
        resultTable.append(
            "<thead><tr><th>SubTopic ID</th><th>Topic ID</th><th>SubTopic Name</th></tr></thead>");

  try {
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery("SELECT st.*,t.topic_name FROM u933391433_onlinetest.Subtopics st, u933391433_onlinetest.Topics t where st.topic_id=t.topic_id");
            while (resultSet.next()) {
                String subtopic_id = resultSet.getString(1);
                resultTable.append("<tr><td> <a href='#' onclick=\"loadSubTopic(" + subtopic_id + ")\">" + subtopic_id
                        + "</a> </td><td>"
                        + resultSet.getString("topic_name")
                        + "</td><td>" + resultSet.getString(3) +"</td></tr>");

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