import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.PreparableStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loadTestAttemptQuestionServlet")
public class LoadTestAttemptQuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/html");

        String test_id = req.getParameter("test_id");
        String test_question_query = "select t.*, tq.question_id from u933391433_onlinetest.Test t, u933391433_onlinetest.TestQuestions tq where t.test_id=tq.test_id and  t.test_id="
                + test_id;
        System.out.println("test question query = " + test_question_query);
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(test_question_query);
            ResultSet resultSet = statement.executeQuery();
            List<String> list = new ArrayList<>();
            Test testObj = new Test();
            Map<String, String> testMap = new HashMap<>();
            while (resultSet.next()) {
                String question_id = resultSet.getString(7);
                list.add(question_id);
                testObj.setTest_id(test_id);
                testMap.put(test_id, test_id);
                String test_name = resultSet.getString(2);
                testObj.setTest_name(test_name);
                testMap.put("test_name", test_name);
                String test_duration = resultSet.getString(3);
                testObj.setTest_duration(test_duration);
                testMap.put("test_duration", test_duration);
                out.println(question_id);

            }

            testMap.put("test_questions", list.size() + "");
            testObj.setTest_questions(list);
            session.setAttribute("test_name", testObj.test_name);
            session.setAttribute("test_duration", testObj.test_duration);
            session.setAttribute("testObj", testMap);
            session.setAttribute("test", testObj);

            ObjectMapper mapper = new ObjectMapper();
            String responseJson = mapper.writeValueAsString(testObj);
            System.out.println("response json string =" + responseJson);
            RequestDispatcher rDispatcher = req.getRequestDispatcher("testAttempt.jsp");
            rDispatcher.forward(req, resp);

            // out.println(responseJson);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
