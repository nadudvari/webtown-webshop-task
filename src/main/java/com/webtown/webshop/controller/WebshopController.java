package com.webtown.webshop.controller;

import com.opencsv.CSVReader;
import com.webtown.webshop.model.Product;

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
    private static final String csvProducts = "/home/nadudvari/Webtown/src/main/java/com/webtown/webshop/config/Termékek.csv";


    public WebshopController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<Product> products = createProducts(csvToList(csvProducts));
        out.println(HTML_START + "<form action=\"webtownwebshop\" method=\"POST\">");
        out.println("   <table>");
        out.println("       <thead>");
        out.println("           <th>Termék</th>");
        out.println("           <th>Ár</th>");
        out.println("           <th>Akció</th>");
        out.println("       </thead>");
        out.println("       <tbody>");
        for (Product product : products) {
            out.println("       <tr>");
            out.println("           <td>" + product.getName() + "</td>");
            out.println("           <td>" + product.getPrice() + "Ft</td>");
            if (product.getTwoEqualsThree() != null && product.getTwoEqualsThree().equals("X")) {
                out.println("           <td>2 = 3</td>");
            }
            if (product.getMegaPack() != null && product.getMegaPack().equals("X")) {
                out.println("           <td>Megapack</td>");

            }
            out.println("           <td><input type=\"text\" name=\"" + product.getId() + "\" value=\"\"></td>");
            out.println("       </tr>");
        }
        out.println("       </tbody>");
        out.println("   </table>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>"  + HTML_END);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Collection values = request.getParameterMap().values();
        List<String> productAmounts = new ArrayList<>(values);

    }

    private List<Integer> calculatePrice(List<Product> products, List<Integer> amounts) {
        List<Integer> prices = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {

        }
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

    private List<Product> createProducts(List<List<String>> productStrings) {
        List<Product> products = new ArrayList<>();
        int id = 0;
        for (List list : productStrings) {
            Product product = new Product(id++, (String) list.get(0), (String) list.get(1));
            if (list.get(2).equals("X")) {
                product.setTwoEqualsThree("X");
            } else if (list.get(3).equals("X")) {
                product.setMegaPack("X");
            }
            products.add(product);
        }
        return products;
    }


}