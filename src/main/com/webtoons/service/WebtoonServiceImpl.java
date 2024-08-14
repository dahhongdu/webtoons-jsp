package main.com.webtoons.service;

import main.com.webtoons.dao.WebtoonDAO;
import main.com.webtoons.dao.WebtoonDAOImpl;
import main.com.webtoons.model.Webtoon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.util.List;

public class WebtoonServiceImpl implements WebtoonService {
    WebtoonDAO webtoonDAO = new WebtoonDAOImpl();

    @Override
    public void addWebtoon(HttpServletRequest req) throws Exception {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String platform = req.getParameter("platform");
        String summary = req.getParameter("summary");

        Part part = req.getPart("img");
        String header = part.getHeader("content-disposition");
        int start = header.indexOf("filename=");
        String filename = header.substring(start + 10, header.length()-1);

        if (filename != null && !filename.isEmpty()) {
            part.write(filename);
        }

        Webtoon webtoon = new Webtoon(title, author, platform, filename, summary);
        webtoonDAO.addWebtoon(webtoon);
    }

    @Override
    public List<Webtoon> getWebtoonList() throws Exception {
        return webtoonDAO.getWebtoonList();
    }

    @Override
    public Webtoon getById(HttpServletRequest req) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        return webtoonDAO.getById(id);
    }

    @Override
    public void updateWebtoon(HttpServletRequest req) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));

        Webtoon webtoon = webtoonDAO.getById(id);

        webtoon.setTitle(req.getParameter("title"));
        webtoon.setAuthor(req.getParameter("author"));
        webtoon.setPlatform(req.getParameter("platform"));
        webtoon.setSummary(req.getParameter("summary"));

        Part part = req.getPart("img");
        String header = part.getHeader("content-disposition");
        int start = header.indexOf("filename=");
        String filename = header.substring(start + 10, header.length()-1);

        if (filename != null && !filename.isEmpty()) {
            part.write(filename);
        }

        webtoon.setCover_img(filename);
        webtoonDAO.updateWebtoon(webtoon);
    }

    @Override
    public void deleteWebtoon(HttpServletRequest req) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        webtoonDAO.deleteWebtoon(id);
    }
}
