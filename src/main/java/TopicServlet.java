import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TopicServlet")

public class TopicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         System.out.println("Inside the Topic Servlet");
            String topic_id = request.getParameter("topic_id");
            String topic_name = request.getParameter("topic_name");
            System.out.println("Topic ID="+topic_id+"\nTopic Name="+topic_name);
            try{

                Connection con=DBConnection.getConnection();
                String insert_query="INSERT INTO `u933391433_onlinetest`.`Topics` (`topic_id`, `topic_name`) VALUES (?,?)";
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
		dispatcher = request.getRequestDispatcher("create_topic.jsp");
		dispatcher.forward(request, response);

    }
    
}
