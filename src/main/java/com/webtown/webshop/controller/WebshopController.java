package com.webtown.webshop.controller;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = { "/webtownwebshop", "/WebshopController.do", "/"})
public class WebshopController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String HTML_START="<html><body>";
    private static final String HTML_END="</body></html>";
    private static final String products = "/home/nadudvari/Webtown/src/main/java/com/webtown/webshop/config/Termékek.csv";


    public WebshopController() {
        super();
    }

    private List<List<String>> csvToList(String csvFile) throws IOException{
        List<List<String>> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(csvFile))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<List<String>> records = csvToList(products);
        out.println(HTML_START + "<form action=\"shopping-form\" method=\"POST\">");
        out.println("   <table>");
        out.println("       <thead>");
        out.println("           <th>Termék</th>");
        out.println("           <th>Ár</th>");
        out.println("           <th>Akció</th>");
        out.println("       </thead>");
        out.println("       <tbody>");
        for (int i = 1; i < records.size(); i++) {
            out.println("       <tr>");
            out.println("           <td>" + records.get(i).get(0) + "</td>");
            out.println("           <td>" + records.get(i).get(1) + "Ft</td>");
            if (records.get(i).get(2).equals("X")) {
                out.println("           <td>2 = 3</td>");
            }
            if (records.get(i).get(3).equals("X")) {
                out.println("           <td>Megapack</td>");

            }
            out.println("           <td><input type=\"text\" name=\"product" + i + "\" value=\"\"></td>");
            out.println("       </tr>");
        }
        out.println("       </tbody>");
        out.println("   </table>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>"  + HTML_END);
//        response.setContentType("text/html");
//
//        try {
//            request.getRequestDispatcher("../../webapp/webshop.jsp").include(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
    }

}