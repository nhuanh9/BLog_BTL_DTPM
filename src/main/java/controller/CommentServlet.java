package controller;

import model.Account;
import model.Comment;
import service.Impl.AccountServiceImpl;
import service.Impl.BlogServiceImpl;
import service.Impl.CommentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CommentServlet", value = "/Comment")
public class CommentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CommentServiceImpl commentService;

    public void init() {
        commentService = new CommentServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void commentPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("contentcomment");
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("accountSession");
        int idAccount = acc.getId();
        int postId = BlogServlet.detailId;
        Comment comment = new Comment(content, idAccount, postId);
        commentService.addUserComment(comment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog01/detailpost.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "comment":
                commentPost(request, response);
                break;
        }
    }
}
