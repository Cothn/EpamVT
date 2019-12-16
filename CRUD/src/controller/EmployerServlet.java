package controller;

import beans.Employer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import service.EmployerService;
import service.impl.EmployerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.font.LineBreakMeasurer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EmployerServlet extends HttpServlet{
    public static final Logger LOG = Logger.getLogger(EmployerServlet.class.getName());
    private static final long serialVersionUID = 15L;
    public EmployerServlet()
    {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            EmployerService employerService = new EmployerServiceImpl();
            List<Employer> employers = employerService.getAllEmployer();
            LOG.log(Level.DEBUG,"request");
            request.setAttribute("employers", employers);
            //System.out.println(librarians);
            LOG.log(Level.DEBUG,"Dispatcher");
            RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/employers");
            LOG.log(Level.DEBUG,"Forward");
            Dispatcher.forward(request, response);

        }catch (Exception e)
        {
            LOG.log(Level.DEBUG,e.getMessage());
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>employers servlet</h2>");
        } finally {
            writer.close();
        }
    }

    private void processRequest()
    {
        System.out.println("proccess");
    }
}
