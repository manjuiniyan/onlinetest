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

@WebServlet("/SubTopicServlet")
public class SubTopicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
     throws ServletException, IOException {
      System.out.println("Inside the SubTopic Servlet"); 
      String sub_topic_id = req.getParameter("sub_topic_id");
      String topic_id = req.getParameter("topic_id");
      String sub_topic_name = req.getParameter("sub_topic_name");
      System.out.println(" SubTopic Id=" + sub_topic_id +"\n Topic ID=" + topic_id + "\n SubTopic Name=" + sub_topic_name);
      try{
       Connection con = DBConnection.getConnection();
       String insert_query ="INSERT INTO `u933391433_onlinetest`.`Subtopics` (`subtopic_id`, `topic_id`, `subtopic_name`) VALUES (?, ?,?)";
try(PreparedStatement preparedStatement = con.prepareStatement(insert_query)){
preparedStatement.setString(1, sub_topic_id);
preparedStatement.setString(2, topic_id);
preparedStatement.setString(3, sub_topic_name);
int rowsAffected = preparedStatement.executeUpdate();
if(rowsAffected > 0){
  System.out.println("Sucessful Added");
  resp.getWriter().write("SubTopic data added successful");

}else{
  System.out.println("Failed login");
  resp.getWriter().write("Failed to add SubTopic data");
}
preparedStatement.close();
con.close();
}
      }catch(SQLException e){
        e.printStackTrace();
        resp.getWriter().write("Database error : " + e.getMessage());
      }
RequestDispatcher dispatcher =null;
dispatcher = req.getRequestDispatcher("create_subtopic.jsp");
dispatcher.forward(req, resp);

    }
    
}
