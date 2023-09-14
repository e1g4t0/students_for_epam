package controller;

import DBManagePack.DBManager;
import Models.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateProduct", value = "/update")
public class UpdateStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.write(DBManager.studentById(Integer.parseInt(request.getParameter("id"))).toString());
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String group = request.getParameter("group");
        int year = Integer.parseInt(request.getParameter("year"));
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = new Student(id, name, surname, group, year);
        DBManager.updateStudent(student);

        response.sendRedirect("/");
    }
}
