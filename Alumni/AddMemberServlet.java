package com.alumni;

@WebServlet("/AddMemberServlet")
public class AddMemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String contact = req.getParameter("contact");
        String dept = req.getParameter("department");
        String batch = req.getParameter("batch");

        try {
            Connection con = DBConnection.initialize();
            PreparedStatement ps = con.prepareStatement("INSERT INTO members(name, email, contact, department, batch) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, contact);
            ps.setString(4, dept);
            ps.setString(5, batch);
            ps.executeUpdate();
            res.sendRedirect("members.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

