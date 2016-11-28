<%@ page import="java.io.OutputStream" %>
<%@ page import="JSS.w07_p02.bean.PhotoDAO" %>
<%@ page import="JSS.w07_p02.servlet.PhotoServlet" %>
<%@ page contentType="image/jpeg" %>
<%
    // ->>>> new PhotoServlet();
    int id = Integer.parseInt(request.getParameter("id"));
    OutputStream binaryOut = response.getOutputStream();
    PhotoDAO dao = PhotoDAO.getPhotoDAO(request.getSession());
    if (dao != null && id < dao.getSize()) {
        byte[] data = dao.getPhotoData(id);
        binaryOut.write(data, 0, data.length);
    } else {
        // error image
    }
%>
