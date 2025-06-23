package com.alumni;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    try {
      Connection con = DBConnection.initialize();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM alumni WHERE email=? AND password=?");
      ps.setString(1, email);
      ps.setString(2, password);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        HttpSession session = request.getSession();
        session.setAttribute("user", email);
        response.sendRedirect("welcome.jsp");
      } else {
        response.getWriter().println("Invalid credentials");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

