package com.alumni;

@WebServlet("/AddEventServlet")
public class AddEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String role = (String) request.getSession().getAttribute("role");
        if (!"admin".equals(role)) {
            response.sendRedirect("login.jsp");
            return;
        }

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String date = request.getParameter("event_date");

        try {
            Connection con = DBConnection.initialize();
            PreparedStatement ps = con.prepareStatement("INSERT INTO events(title, description, event_date) VALUES (?, ?, ?)");
            ps.setString(1, title);
            ps.setString(2, description);
            ps.setDate(3, Date.valueOf(date));
            ps.executeUpdate();
            response.sendRedirect("adminDashboard.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

