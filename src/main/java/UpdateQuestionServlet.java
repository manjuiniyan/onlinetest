import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateQuestionServlet")
public class UpdateQuestionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
      System.out.println("Inside the UpdateQuestionSErvlet");
      String questionText = request.getParameter("question_text");
      String optionA = request.getParameter("option_a");
      String optionB = request.getParameter("option_b");
      String optionC = request.getParameter("option_c");
      String optionD = request.getParameter("option_d");
      String correctOption = request.getParameter("correct_option");
      String explaination = request.getParameter("explaination");

 System.out.println("QuestionText=" + questionText + "\nOptionA ="
                + optionA + "\nOptionB =" + optionB + "\nOptionC =" + optionC + "\nOptionD =" + optionD +"\nCorrectOption =" + correctOption +"\nExplaination =" + explaination);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://193.203.166.25:3306/u933391433_onlinetest",
                "u933391433_gurukalvi",
                "GuruKalvi2023");)
        {
            String insert_query = "INSERT INTO `u933391433_onlinetest`.`Questions`(`question_text`, `option_a`, `option_b`, `option_c`, `option_d`, `correct_option`, `explaination`) VALUES (?,?,?,?,?,?,?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(insert_query)) {

                preparedStatement.setString(1, questionText);
                preparedStatement.setString(2, optionA);
                preparedStatement.setString(3, optionB);
                preparedStatement.setString(4, optionC);
                preparedStatement.setString(5, optionD);
                preparedStatement.setString(6, correctOption);
                preparedStatement.setString(7, explaination);
				int rowsAffected = preparedStatement.executeUpdate();
            
                if (rowsAffected > 0) {
					System.out.println("Successfuly inserted login");

					response.getWriter().write("Question data added successful");
				} else {
					response.getWriter().write("Failed to add Question data");
					System.out.println("failed login");
				}
                preparedStatement.close();
                connection.close();
			}
        
         
		} catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Database error: " + e.getMessage());
          
        }
		 RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("create_question.jsp");
		dispatcher.forward(request, response);

	}
   }


