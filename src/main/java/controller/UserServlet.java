package controller;

import model.Account;
import model.Post;
import service.Impl.AccountServiceImpl;
import service.Impl.BlogServiceImpl;
import service.Impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/User")
public class UserServlet extends HttpServlet {
    private UserServiceImpl userService;

    public void init() {
        userService = new UserServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("accountSession");
        int id = acc.getId();
        List<Post> listpost = userService.findPostByAccountId(id);
        request.setAttribute("listpost", listpost);
        request.getRequestDispatcher("/blog01/userprofile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
