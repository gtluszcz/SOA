package Servlets;

import Logic.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet("/book")
public class Book extends HttpServlet {
    ArrayList<Comment> comments = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = Optional.ofNullable(request.getParameter("email")).map(String::trim).orElse("");
        String name = Optional.ofNullable(request.getParameter("name")).map(String::trim).orElse("");
        String text = Optional.ofNullable(request.getParameter("text")).map(String::trim).orElse("");
        if (!email.isEmpty() && !name.isEmpty() && !text.isEmpty()){
            Comment comment = new Comment(email,name,text);
            comments.add(comment);
        }
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("comments", comments);
        request.getRequestDispatcher("/book.jsp").forward(request,response);
    }
}
