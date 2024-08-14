package main.com.webtoons.controller;

import main.com.webtoons.model.Webtoon;
import main.com.webtoons.service.WebtoonService;
import main.com.webtoons.service.WebtoonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

public class ListController implements WebtoonController{
    WebtoonService webtoonService = new WebtoonServiceImpl();

    @Override
    public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            if (action != null && action.equals("addWebtoon")) {
                webtoonService.addWebtoon(req);
                res.sendRedirect(req.getRequestURI());
                return;
            } else if (action != null && action.equals("updateWebtoon")) {
                webtoonService.updateWebtoon(req);
                res.sendRedirect(req.getRequestURI());
                return;
            } else if (action == null) {
                List<Webtoon> list = webtoonService.getWebtoonList();
                req.setAttribute("webtoonList", list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", e.getMessage());
        }

        String view = "/WEB-INF/views/WebtoonList.jsp";
        req.getRequestDispatcher(view).forward(req, res);
    }
}
