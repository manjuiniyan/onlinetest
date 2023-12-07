import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoadSubTopicServlet")
public class LoadSubTopicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
        System.out.println("Inside the LoadSubTopicServlet");
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        Connection connection = DBConnection.getConnection();
        SubTopic subtopic = new SubTopic();
        String subtopic_id = request.getParameter("subtopic_id");
        System.out.println("SubTopic Id =" + subtopic_id);
        try {
            PreparedStatement statement = connection
         .prepareStatement("SELECT * FROM u933391433_onlinetest.Subtopics where subtopic_id = " + subtopic_id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                subtopic.setSubTopic_id(rs.getString(1));
                subtopic.setTopic_id(rs.getString(2));
                subtopic.setSubTopic_name(rs.getString(3));
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String responseJson = mapper.writeValueAsString(subtopic);
        System.out.println("response json string =" + responseJson);
        out.println(responseJson);
    }

}
