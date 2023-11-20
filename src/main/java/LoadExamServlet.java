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

@WebServlet("/loadExamServlet")
public class LoadExamServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        Connection connection = DBConnection.getConnection();

        Exam exam = new Exam();
        String exam_id = request.getParameter("exam_id");
        System.out.println("examId =" + exam_id);
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM u933391433_onlinetest.Exams where exam_id = " + exam_id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                exam.setExam_id(rs.getString(1));
                exam.setTopc_id(rs.getString(2));
                exam.setExam_name(rs.getString(3));
                exam.setExam_duration(rs.getString(4));
                exam.setStart_time(rs.getString(5));
                exam.setEnd_time(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        String responseJson = mapper.writeValueAsString(exam);
        System.out.println("response json string =" + responseJson);
        out.println(responseJson);
    }

}
