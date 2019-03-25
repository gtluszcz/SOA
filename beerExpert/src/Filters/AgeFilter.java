package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "Age Filter", urlPatterns = {"/chooseColor", "/form.html","/result.jsp"})
public class AgeFilter extends HttpFilter {
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("age") == null || ((int) session.getAttribute("age")) < 18) {
            resp.setStatus(403);
            PrintWriter writer = resp.getWriter();
            writer.println("You must be at least 18 years old");
            writer.close();

            return;
        }

        chain.doFilter(req, resp);
    }
}
