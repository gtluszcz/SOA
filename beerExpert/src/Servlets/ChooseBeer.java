package Servlets;

import Logic.BeerExpert;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/chooseColor")
public class ChooseBeer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String beerColor = request.getParameter("color");
        BeerExpert expert = new BeerExpert();
        String beer = expert.proposeBeer(beerColor);
        request.setAttribute("beer", beer);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
