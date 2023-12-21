import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saveTestResultServlet")
public class SaveTestResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("inside the Save Test Result Servlet");
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        // Retrieve parameters from the request
        String userID = request.getParameter("userID");
        String testID = request.getParameter("testID");
        String attemptID = request.getParameter("attemptID");
        String score = request.getParameter("score");
        String correctCount = request.getParameter("correctCount");
        String timeSpent = request.getParameter("timeSpent");

        System.out.println("userID=" + userID + "\ntestID=" + testID + "\nattemptID=" + attemptID + "\ncorrectCount="
                + correctCount + "\ntimeSpent=" + timeSpent + " \n score=" + score);

        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO u933391433_onlinetest.TestAttempts(`user_id`, `test_id`, `score`, `correct_count`, `time_spent`) VALUES (?,?,?,?,?)");

            statement.setInt(1, Integer.parseInt(userID));
            statement.setInt(2, Integer.parseInt(testID));
            statement.setInt(3, Integer.parseInt(score));
            statement.setInt(4, Integer.parseInt(correctCount));
            statement.setInt(5, Integer.parseInt(timeSpent));

            int executeUpdate = statement.executeUpdate();
            if (executeUpdate > 0) {
                System.out.println("Successfuly inserted login");
                // select query to get attemptID
                // save to UserAnswer Table methdo()
                out.print("saved success");
            } else {
                out.print("failed");
            }

        } catch (Exception e) {
            System.err.println("exception while saving to DB");
            e.printStackTrace();
        }

    }

}
