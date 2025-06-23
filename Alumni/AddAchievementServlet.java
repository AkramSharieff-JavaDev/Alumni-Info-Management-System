package com.alumni;

@WebServlet("/AddAchievementServlet")
public class AddAchievementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String desc = request.getParameter("description");
        String email = (String) request.getSession().getAttribute("username");

        try {
            Connection con = DBConnection.initialize();
            PreparedStatement getId = con.prepareStatement("SELECT id FROM alumni WHERE email=?");
            getId.setString(1, email);
            ResultSet rs = getId.executeQuery();
            int id = 0;
            if (rs.next()) id = rs.getInt("id");

            PreparedStatement ps = con.prepareStatement("INSERT INTO achievements (alumni_id, title, description) VALUES (?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, desc);
            ps.executeUpdate();

            response.sendRedirect("achievements.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

