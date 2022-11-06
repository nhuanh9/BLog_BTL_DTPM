package controller;

import model.Account;
import model.Comment;
import model.Post;
import service.BlogService;
import service.Impl.AccountServiceImpl;
import service.Impl.BlogServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BlogServlet", value = "/Blog")
public class BlogServlet extends HttpServlet {
    public static Integer detailId = null;
    private static final long serialVersionUID = 1L;
    private BlogServiceImpl blogService;
    private AccountServiceImpl accountService;

    public void init() {
        blogService = new BlogServiceImpl();
        accountService = new AccountServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "detail":
                detailPost(request,response);
                break;
            default:
                listPost(request, response);
                break;
        }
    }


    private void detailPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blogId =request.getParameter("id");
        detailId = Integer.valueOf(request.getParameter("id"));
        BlogServiceImpl blogService1 = new BlogServiceImpl();
        Post blog=new Post();
        if(blogId != null){
            blog=blogService1.selectPostById(Integer.parseInt(blogId));
        }
        request.setAttribute("blog",blog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog01/detailpost.jsp");
        dispatcher.forward(request, response);
    }
    private void listPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("name");
        List<Post> listPost = blogService.selectAllPosts();
        if(title != null){
            listPost = blogService.searchPost("%"+title+"%");
        }
        request.setAttribute("listPost", listPost);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog01/listpost.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
