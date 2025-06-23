package com.alumni;

@WebServlet("/UpdateMemberServlet")
public class UpdateMemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String contact = req.getParameter("contact");
        String dept = req.getParameter("department");
        String batch = req.getParameter("batch");

        try {
            Connection con = DBConnection.initialize();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE members SET name=?, email=?, contact=?, department=?, batch=? WHERE id=?"
            );
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, contact);
            ps.setString(4, dept);
            ps.setString(5, batch);
            ps.setInt(6, id);
            ps.executeUpdate();
            res.sendRedirect("members.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

