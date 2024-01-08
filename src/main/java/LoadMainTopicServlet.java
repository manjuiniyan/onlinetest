import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/loadMainTopicServlet")
public class LoadMainTopicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("inaide the LoadMainTopicServlet");
        // Simulating data retrieval from a database
        List<Topic> mainTopics = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            Statement stat = connection.createStatement();
            ResultSet resultSet = stat.executeQuery("SELECT * FROM u933391433_onlinetest.Topics");
            mainTopics.add(new Topic(Integer.parseInt("999"), "-------Select Topic-------"));
            while (resultSet.next()) {
                String topic_id = resultSet.getString(1);
                mainTopics.add(new Topic(Integer.parseInt(topic_id), resultSet.getString(2)));
            }
        } catch (Exception e) {
            System.err.println("Got an exception! " + e.getMessage());
            e.printStackTrace();
        }

        // Convert the list to JSON and send it as the response
        String json = new Gson().toJson(mainTopics);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    // Class representing a Topic (you can create a separate file for this class)
    private static class Topic {
        private int id;
        private String name;

        public Topic(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
