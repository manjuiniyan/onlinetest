import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateSubTopicServlet")
public class UpdateSubTopicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside the UpdateSubTopicServlet ");
        String subtopic_id = request.getParameter("subtopic_id");
        String topic_id = request.getParameter("topic_id");
        String subtopic_name = request.getParameter("subtopic_name");
      
        System.out.println("SubTopic ID=" + subtopic_id +"\n Topic ID=" + topic_id + "\nSubTopic Name=" + subtopic_name);
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        try (Connection Connection = DriverManager.getConnection(
                "jdbc:mysql://193.203.166.25:3306/u933391433_onlinetest", "u933391433_gurukalvi", "GuruKalvi2023");) {
                   String update_Query = "update u933391433_onlinetest.Subtopics set subtopic_id='"+subtopic_id+"', topic_id='"+topic_id+"', subtopic_name='"+subtopic_name+"' where subtopic_id="+subtopic_id;
                    System.out.println("Update   "+update_Query);
           try (PreparedStatement preparedStatement = Connection.prepareStatement(update_Query)) {
                 
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Successfuly Updated SubTopic");
                    response.getWriter().write("Edit SubTopic data Updated successfuly");
                } else {
                    System.out.println("failed SubTopic Updated");
                    response.getWriter().write("Failed to Update edit Subtopic data");
                }
                preparedStatement.close();
                Connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Database error:" + e.getMessage());
        }
        RequestDispatcher dispatcher = null;
        dispatcher = request.getRequestDispatcher("create_subtopic.jsp");
        dispatcher.forward(request, response);
    }

}
