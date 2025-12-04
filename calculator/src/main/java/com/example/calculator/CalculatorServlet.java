package com.example.calculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String aStr = req.getParameter("a");
        String bStr = req.getParameter("b");
        String op = req.getParameter("op");

        double a = 0, b = 0;
        try {
            a = Double.parseDouble(aStr);
            b = Double.parseDouble(bStr);
        } catch (Exception e) {
            req.setAttribute("result", "Invalid number");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }

        String result;
        switch (op) {
            case "add": result = String.valueOf(a + b); break;
            case "sub": result = String.valueOf(a - b); break;
            case "mul": result = String.valueOf(a * b); break;
            case "div":
                if (b == 0) result = "Division by zero";
                else result = String.valueOf(a / b);
                break;
            default: result = "Unknown operation"; break;
        }

        req.setAttribute("result", result);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
