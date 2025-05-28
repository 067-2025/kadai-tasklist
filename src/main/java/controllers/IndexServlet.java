package controllers;

import java.io.IOException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import models.Content;
import utils.DBUtil;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        // 開くページ数を取得（デフォルトは1ページ目）
        int page = 1;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
        }

        // 最大件数と開始位置を指定してメッセージを取得
        List<Content> contents = em.createNamedQuery("getAllContents", Content.class)
                .setFirstResult(15 * (page - 1))
                .setMaxResults(15)
                .getResultList();

        // 全件数を取得
        long contents_count = (long) em.createNamedQuery("getContentsCount", Long.class)
                .getSingleResult();

        em.close();

        request.setAttribute("contents", contents);
        request.setAttribute("contents_count", contents_count); // 全件数
        request.setAttribute("page", page); // ページ数

        // フラッシュメッセージがセッションスコープにセットされていたら
        // リクエストスコープに保存する（セッションスコープからは削除）
        if (request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
        rd.forward(request, response);

    }

}
