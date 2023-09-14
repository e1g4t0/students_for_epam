package controller;

import DBManagePack.DBManager;
import Models.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddStudent", value = "/add")
public class AddStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String group = request.getParameter("group");
        int year = Integer.parseInt(request.getParameter("year"));
        Student student = new Student(name, surname, group, year);

        DBManager.writeStudent(student);
        response.sendRedirect("/");
    }
}
