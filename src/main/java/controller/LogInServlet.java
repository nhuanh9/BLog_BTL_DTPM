package controller;

import model.Account;
import service.Impl.AccountServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/Login")

public class LogInServlet extends HttpServlet {
    private AccountServiceImpl AccountService;

    public void init() {
        AccountService = new AccountServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("blog01/login.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = AccountService.checkLogin(username, password);
        HttpSession session = request.getSession();
        if(account != null){
            session.setAttribute("accountSession", account);
            System.out.println(session.getAttribute(account.getUsername()));
            response.sendRedirect("Blog");
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("blog01/login.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
