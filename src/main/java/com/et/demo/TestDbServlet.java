package com.et.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // setup connection variables
        String user = "admin";
        String pass = "123456";
        String jdbcUrl = "jdbc:mysql://localhost:3306/bank_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
        // get connection to database
        try {
            PrintWriter out = response.getWriter();
            out.println("connecting to database : " + jdbcUrl);
            Class.forName(driver);
            Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
            out.println("Connection Successful");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
