import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

@WebServlet("/sortuj")
public class Sortuj extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();

        ArrayList<Integer> list = new ArrayList<>();
        Enumeration<String> iterator = request.getParameterNames();
        String answer;
        try {
            while (iterator.hasMoreElements()) {
                String name = iterator.nextElement();
                Integer integer = Integer.parseInt(request.getParameter(name));
                list.add(integer);
            }
            Collections.sort(list);
            answer = list.toString();
        } catch (NumberFormatException e) {
            answer = "niepoprawne dane";
        }


        out.println("<html>");
        out.println("<head><title>Pierwszy Servlet</title></head>");
        out.println("<body>");
        out.println("<p>" + answer + "");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
