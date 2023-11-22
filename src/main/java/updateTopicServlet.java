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

@WebServlet("/updateTopicServlet")
public class updateTopicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside the UpdateTopicServlet ");
        String topicid = request.getParameter("topic_id");
        String topicname = request.getParameter("topic_name");
       
        // System.out.println("Start Time=" + starttime);
        // Timestamp timestamp = null;
        // try {
        //     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        //     Date parsedDate = (Date) dateFormat.parse(starttime);
        //     timestamp = new Timestamp(parsedDate.getTime());
        //     System.out.println("Converted Timestamp: " + timestamp);
        // } catch (ParseException e) {
        //     e.printStackTrace();
        // }
        System.out.println("Topic ID=" + topicid + "\nTopicName=" + topicname);
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        try (Connection Connection = DriverManager.getConnection(
                "jdbc:mysql://193.203.166.25:3306/u933391433_onlinetest", "u933391433_gurukalvi", "GuruKalvi2023");) {
           // String insert_Query = "INSERT INTO `u933391433_onlinetest`.`Topics` (`topic_id`, `topic_name`) VALUES (?,?)";
           String update_Query = "update u933391433_onlinetest.Topics set Topics.topic_name ='"+topicname+"' where Topics.topic_id="+topicid;
           System.out.println("Update   "+update_Query);
           try (PreparedStatement preparedStatement = Connection.prepareStatement(update_Query)) {
                
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Successfuly Updated Topic");
                    response.getWriter().write("Edit Topic data Updated successfuly");
                } else {
                    System.out.println("failed Topic Updated");
                    response.getWriter().write("Failed to Update edit topic data");
                }
                preparedStatement.close();
                Connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Database error:" + e.getMessage());
        }
        RequestDispatcher dispatcher = null;
        dispatcher = request.getRequestDispatcher("create_topic.jsp");
        dispatcher.forward(request, response);
    }

}
