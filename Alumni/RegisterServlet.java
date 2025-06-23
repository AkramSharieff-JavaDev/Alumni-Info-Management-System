package com.alumni;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    try {
      Connection con = DBConnection.initialize();
      PreparedStatement ps = con.prepareStatement("INSERT INTO alumni(name, email, password) VALUES (?, ?, ?)");
      ps.setString(1, name);
      ps.setString(2, email);
      ps.setString(3, password);
      ps.executeUpdate();
      response.sendRedirect("login.jsp");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

