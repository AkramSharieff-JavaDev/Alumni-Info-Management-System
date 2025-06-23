package com.alumni;

@WebServlet("/DeleteMemberServlet")
public class DeleteMemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Connection con = DBConnection.initialize();
            PreparedStatement ps = con.prepareStatement("DELETE FROM members WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            res.sendRedirect("members.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

