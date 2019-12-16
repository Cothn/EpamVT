import Interface.impl.console.GlobalInterfaceImpl;
import beans.Employer;
import beans.PublishingHouse;
import service.EmployerService;
import service.PublishingHouseService;
import service.ServiceException;
import service.impl.EmployerServiceImpl;
import service.impl.PublishingHouseServiceImpl;

import java.util.Iterator;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ServiceException {
        List<PublishingHouse> publHouses = null;
        PublishingHouseService service = new PublishingHouseServiceImpl();
        publHouses = service.getAllPublishingHouse();
        System.out.println(publHouses);
        System.out.println("<h2>Publishing houses</h2>");
        System.out.println("<table>");
        Iterator var6 = publHouses.iterator();

        while(var6.hasNext()) {
            PublishingHouse publHouse = (PublishingHouse)var6.next();
            System.out.println(publHouse);
            System.out.println("<tr>");
            System.out.println("<td>" + publHouse.getId() + "</td>");
            System.out.println("<td>" + publHouse.getTitle() + "</td>");
            System.out.println("<td>" + publHouse.getAddress() + "</td>");
            System.out.println("<td>" + publHouse.getPhone() + "</td>");
            System.out.println("<td>" + publHouse.getFoundationDate() + "</td>");
            System.out.println("<td>" + publHouse.getDescription() + "</td>");
            System.out.println("</tr>");
        }

        System.out.println("</table>");
        System.out.println("<a href=\"index.jsp\">return</a>");

        List<Employer> employers = null;
        EmployerService service2 = new EmployerServiceImpl();
        employers = service2.getAllEmployer();
        System.out.println(employers );
        GlobalInterfaceImpl globalInterfaceImpl = new GlobalInterfaceImpl();
        globalInterfaceImpl.Show();
        System.out.println("End");
    }
}
