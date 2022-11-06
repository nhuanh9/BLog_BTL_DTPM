package controller;

import model.Account;
import service.Impl.AccountServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignUpServlet", value = "/SignUp")
public class SignUpServlet extends HttpServlet {
    private AccountServiceImpl AccountService;

    public void init() {
        AccountService = new AccountServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("blog01/signup.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rePass = request.getParameter("rePass");
        if(!password.equals(rePass)){
            System.out.println("mat khau khong trung nhau");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("blog01/signup.jsp");
            requestDispatcher.forward(request,response);
        }else {
            Account check = AccountService.checkExistAccount(username);
            if(check == null){
                AccountService.signUp(username, password);
                response.sendRedirect("Blog");
            }else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("blog01/signup.jsp");
                requestDispatcher.forward(request,response);
            }
        }
    }
}
