package Servlets;

import Logic.Guests;
import Logic.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LogIn extends HttpServlet {
    private Guests guestList = new Guests();

    LogIn(){
        User user = new User("ziom","password", "Ziom", "Ziomal");
        guestList.addGuest(user);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = Optional.ofNullable(request.getParameter("username")).map(String::trim).orElse("");
        String password = Optional.ofNullable(request.getParameter("password")).map(String::trim).orElse("");

        if (username.isEmpty()){
            this.sendWithError(request,response,"Username not provided");
            return;
        }

        if (password.isEmpty()){
            this.sendWithError(request,response,"Password not provided");
            return;
        }

        if (this.guestList.hasGuest(username,password)){
            request.getSession().setAttribute("isSignedIn", true);
            response.sendRedirect("/book");
            return;
        }

        sendWithError(request,response,"invalid credentials");
    }

    private void sendWithError(HttpServletRequest request, HttpServletResponse response, String error) throws ServletException, IOException {
        System.out.println(error);
        request.setAttribute("error", error);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
