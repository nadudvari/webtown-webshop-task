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
    private static final String products = "/home/nadudvari/Webtown/src/main/java/com/webtown/webshop/config/Termékek.csv"


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
        Date date = new Date();
        out.println(HTML_START + "<h2>Hi There!</h2><br/><h3>Date: "+ date +"</h3>");
        for (List<String> record : records) {
            out.println("<p>" + record + "</p>");
        }
        out.println(HTML_END);
//        response.setContentType("text/html");
//
//        try {
//            request.getRequestDispatcher("../../webapp/webshop.jsp").include(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}