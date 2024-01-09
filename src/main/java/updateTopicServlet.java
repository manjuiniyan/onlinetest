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
        String add_topic = request.getParameter("addtopic");
        String update_topic = request.getParameter("updatetopic");
        System.out.println("Add Topic =" + add_topic + "Update Topic =" + update_topic);
         
      if(add_topic != null){
        System.out.println("add_topic"); 
        System.out.println("Inside the Topic Servlet");
            String topic_id = request.getParameter("topic_id");
            String topic_name = request.getParameter("topic_name");
            System.out.println("Topic ID="+topic_id+"\nTopic Name="+topic_name);
            try{

                Connection con=DBConnection.getConnection();
                String insert_query="INSERT INTO u933391433_onlinetest.Topics (topic_id, topic_name) VALUES (?,?)";
                try (PreparedStatement preparedStatement = con.prepareStatement(insert_query)) {
                    preparedStatement.setString(1, topic_id);
                    preparedStatement.setString(2, topic_name);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if(rowsAffected > 0){
                        System.out.println("Successful login");
                        response.getWriter().write("Topic data added successful");

                    }else{
                       System.out.println("failed login");
                        response.getWriter().write("Failed to add Topic data"); 
                    }
                    preparedStatement.close();
                    con.close();               
                 }
            }catch(SQLException e){
                e.printStackTrace();
               response.getWriter().write("Database error: " + e.getMessage());

            }
            RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("edit_topic.jsp");
		dispatcher.forward(request, response);
 
      }else if(update_topic != null){
        System.out.println("update_topic");
        String topicid = request.getParameter("topic_id");
        String topicname = request.getParameter("topic_name");
      
        System.out.println("Topic ID=" + topicid + "\nTopicName=" + topicname);
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        try (Connection Connection = DriverManager.getConnection(
                "jdbc:mysql://193.203.166.25:3306/u933391433_onlinetest", "u933391433_gurukalvi", "GuruKalvi2023");) {
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
        dispatcher = request.getRequestDispatcher("edit_topic.jsp");
        dispatcher.forward(request, response);
      }
        
    }

}