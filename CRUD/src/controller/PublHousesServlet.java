package controller;

import beans.PublishingHouse;
import service.PublishingHouseService;
import service.impl.PublishingHouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PublHousesServlet extends HttpServlet {
    private static final long serialVersionUID = 14L;
    public PublHousesServlet()
    {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {

            List<PublishingHouse> publHouses = null;
            PublishingHouseService service = new PublishingHouseServiceImpl();
            publHouses = service.getAllPublishingHouse();
            System.out.println(publHouses);

            writer.println("<h2>Publishing houses</h2>");
            writer.println("<table>");
            for (PublishingHouse publHouse: publHouses)
            {
                System.out.println(publHouse);
                writer.println("<tr>");

                writer.println("<td>" + publHouse.getId() + "</td>");
                writer.println("<td>" + publHouse.getTitle() + "</td>");
                writer.println("<td>" + publHouse.getAddress() + "</td>");
                writer.println("<td>" + publHouse.getPhone() + "</td>");
                writer.println("<td>" + publHouse.getFoundationDate() + "</td>");
                writer.println("<td>" + publHouse.getDescription() + "</td>");

                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.println("<a href=\"index.jsp\">return</a>");

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            writer.println(e.getMessage());
        }
        finally {
            writer.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>publHouses servlet</h2>");
        } finally {
            writer.close();
        }
    }

    private void processRequest()
    {
        System.out.println("proccess");
    }
}