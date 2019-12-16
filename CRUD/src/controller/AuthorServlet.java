package controller;


import beans.Author;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import service.AuthorService;
import service.impl.AuthorServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AuthorServlet extends HttpServlet {
    public static final Logger LOG = Logger.getLogger(AuthorServlet.class.getName());
    private static final long serialVersionUID = 12L;
    public AuthorServlet()
    {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LOG.log(Level.DEBUG,"Get");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try {

            List<Author> authors = null;
            AuthorService service = new AuthorServiceImpl();
            authors = service.getAllAuthor();
            LOG.log(Level.DEBUG,"authors:"+authors);
            writer.println("<h2>Authors</h2>");
            writer.println("<table>");
            for (Author author: authors)
            {
                LOG.log(Level.INFO,"for");
                System.out.println(author);
                writer.println("<tr>");

                writer.println("<td>" + author.getId() + "</td>");
                writer.println("<td>" + author.getName() + "</td>");
                writer.println("<td>" + author.getSurname() + "</td>");
                writer.println("<td>" + author.getBirthDate() + "</td>");
                writer.println("<td>" + author.getDescription() + "</td>");

                writer.println("</tr>");
            }
            LOG.log(Level.DEBUG,"table");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>authors servlet</h2>");
        } finally {
            writer.close();
        }
    }

    private void processRequest()
    {
        System.out.println("proccess");
    }
}