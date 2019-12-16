package controller;


import beans.Article;
import beans.Book;
import beans.Comics;
import beans.LibraryObj;
import service.LibraryService;
import service.impl.LibraryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class LibraryObjServlet extends HttpServlet {
    private static final long serialVersionUID = 13L;
    public LibraryObjServlet()
    {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {

            List<LibraryObj> libraryObjs = null;
            LibraryService service = new LibraryServiceImpl();
            libraryObjs = service.getAllLibraryObj();
            System.out.println(libraryObjs);

            writer.println("<h2>Library</h2>");
            writer.println("<table style=\" border-style: solid; border-width:1px;\">");

            writer.println("<tr>");
            writer.println("<td>" + "<b>" +  "Id" + "</b>" +  "</td>");
            writer.println("<td>" + "<b>" +  "Author Id" + "</b>" +  "</td>");
            writer.println("<td>" + "<b>" +  "title" + "</b>" + "</td>");
            writer.println("<td>" + "<b>" +  "Publishing House Id" + "</b>" + "</td>");
            writer.println("<td>" + "<b>" +  "pages count" + "</b>" + "</td>");
            writer.println("<td>" + "<b>" +  "description" + "</b>" +  "</td>");
            writer.println("<td>" + "<b>" +  "Type" + "</b>" +  "</td>");
            writer.println("</tr>");
            for (LibraryObj libraryObj: libraryObjs)
            {
                System.out.println(libraryObj);
                writer.println("<tr>");

                writer.println("<td>" + libraryObj.getId() + "</td>");
                writer.println("<td>" + libraryObj.getAuthorId() + "</td>");
                writer.println("<td>" + libraryObj.getTitle() + "</td>");
                writer.println("<td>" + libraryObj.getPublishingHouseId() + "</td>");
                writer.println("<td>" + libraryObj.getPagesNum() + "</td>");
                writer.println("<td>" + libraryObj.getDescription() + "</td>");

                if(libraryObj instanceof Comics){
                    writer.println("<td>" +"comics" + "</td>");
                    writer.println("<td> drawing:" + ((Comics) libraryObj).getDrawing() + "</td>");
                    writer.println("<td> universe:" + ((Comics) libraryObj).getUniverse() + "</td>");
                }
                else if(libraryObj instanceof Book){
                    writer.println("<td>" +"book" + "</td>");
                    writer.println("<td> genre:" + ((Book) libraryObj).getGenre() + "</td>");
                    writer.println("<td> ISBN:" + ((Book) libraryObj).getISBN() + "</td>");
                }
                else if(libraryObj instanceof Article){
                    writer.println("<td>" +"article" + "</td>");
                    writer.println("<td> topic:" + ((Article) libraryObj).getTopic() + "</td>");
                    writer.println("<td> subject:" + ((Article) libraryObj).getSubject() + "</td>");
                }
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
            writer.println("<h2>Welcome to servlets</h2>");
        } finally {
            writer.close();
        }
    }

    private void processRequest()
    {
        System.out.println("proccess");
    }
}