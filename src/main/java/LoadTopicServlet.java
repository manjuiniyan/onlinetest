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

@WebServlet("/LoadTopicServlet")
public class LoadTopicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        Connection connection = DBConnection.getConnection();

       Topic topic = new Topic();
        String topic_id = request.getParameter("topic_id");
        System.out.println("TopicId =" + topic_id);
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM u933391433_onlinetest.Topics where topic_id = " + topic_id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                topic.setTopic_id(rs.getString(1));
                topic.setTopic_name(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String responseJson = mapper.writeValueAsString(topic);
        System.out.println("response json string =" + responseJson);
        out.println(responseJson);
    }

}
