import DBManagePack.DBManager;
import Models.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "MainPage", value = "")
public class MainPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students;
        if (request.getParameter("value") != null){
            students = DBManager.readStudents(request.getParameter("key"), request.getParameter("value"));
        }else {
            students = DBManager.readStudents();
        }
        request.setAttribute("students", students);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
