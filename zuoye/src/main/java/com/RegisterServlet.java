package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String studentId = request.getParameter("studentId");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String className = request.getParameter("class");
        String major = request.getParameter("major");
        String phone = request.getParameter("phone");

        Student student = new Student();
        student.setStudentId(studentId);
        student.setName(name);
        student.setGender(gender);
        student.setClassName(className);
        student.setMajor(major);
        student.setPhone(phone);

        int rowsAffected = DBUtil.insertStudent(student);
        if (rowsAffected > 0) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("register.html?error=true");
        }
    }
}