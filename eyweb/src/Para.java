import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Para extends HttpServlet{
      public void doPost(HttpServletRequest req, HttpServletResponse res)
           throws ServletException, IOException{
           res.setContentType("text/html");
           PrintWriter pw = res.getWriter();
           // Get enumeration of parameter names
           Enumeration e = req.getParameterNames();
           //display parameter names and values
           while(e.hasMoreElements()){
              String pname = (String) e.nextElement();
              String pvalue = req.getParameter(pname);
              pw.println(pname+" : "+pvalue);
           }           pw.close();
       }   }
