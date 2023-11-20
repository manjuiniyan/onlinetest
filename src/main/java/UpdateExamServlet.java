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

@WebServlet("/updateExamServlet")
public class UpdateExamServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside the UpdateExamServlet ");
        String examid = request.getParameter("examid");
        String topicid = request.getParameter("topicid");
        String examname = request.getParameter("exam_name");
        String examduration = request.getParameter("exam_duration");
        String starttime = request.getParameter("start_date");
        String endtime = request.getParameter("end_date");
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
        System.out.println("Exam ID=" + examid +"\nTopic ID=" + topicid + "\nExamName=" + examname
                + "\nExamDuration=" + examduration + "\nStartTime=" + starttime + "\nEndTime=" +endtime);
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        try (Connection Connection = DriverManager.getConnection(
                "jdbc:mysql://193.203.166.25:3306/u933391433_onlinetest", "u933391433_gurukalvi", "GuruKalvi2023");) {
           // String insert_Query = "INSERT INTO `u933391433_onlinetest`.`Exams` (`topic_id`, `exam_name`, `exam_duration`, `start_time`,`end_time`) VALUES (?,?,?,?,?)";
           String update_Query = "update u933391433_onlinetest.Exams set topic_id='"+topicid+"', exam_name='"+examname+"', exam_duration='"+examduration+"',start_time='"+starttime+"',end_time='"+endtime+"' where exam_id="+examid;
                    System.out.println("Update Query="+update_Query);
           
           try (PreparedStatement preparedStatement = Connection.prepareStatement(update_Query)) {
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Successfuly Updated Exam");
                    response.getWriter().write("Edit Exam data added successfuly");
                } else {
                    System.out.println("failed Exam inserted");
                    response.getWriter().write("Failed to Updated edit exam data");
                }
                preparedStatement.close();
                Connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Database error:" + e.getMessage());
        }
        RequestDispatcher dispatcher = null;
        dispatcher = request.getRequestDispatcher("create_exam.jsp");
        dispatcher.forward(request, response);
    }

}
