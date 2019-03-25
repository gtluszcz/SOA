package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/verify-age")
public class VerifyAge extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            String ageString = request.getParameter("age");
            Integer age = Integer.parseInt(ageString);
            request.getSession().setAttribute("age", age);
            response.sendRedirect("/form.html");

        } catch (NumberFormatException e) {
           out.println("Invalid age provided");
        }

    }
}
