package main.com.webtoons.dao;

import main.com.webtoons.model.Webtoon;
import main.com.webtoons.util.ConnectionPool.DBPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WebtoonDAOImpl implements WebtoonDAO {
    @Override
    public void addWebtoon(Webtoon webtoon) throws Exception {
        String stmt = "INSERT INTO webtoon (title, author, platform, cover_img, summary) values (?, ?, ?, ?, ?)";
        try (
                Connection connection = DBPool.getDataSource();
                PreparedStatement pstmt = connection.prepareStatement(stmt);
                ) {
            String title = webtoon.getTitle();
            String author = webtoon.getAuthor();
            String platform = webtoon.getPlatform();
            String cover_img = webtoon.getCover_img();
            String summary = webtoon.getSummary();
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, platform);
            pstmt.setString(4, cover_img);
            pstmt.setString(5, summary);

            pstmt.executeUpdate();
        }
    }

    @Override
    public List<Webtoon> getWebtoonList() throws Exception {
        List<Webtoon> webtoonList = new ArrayList<>();
        String stmt = "SELECT * FROM webtoon";

        try (
            Connection conn = DBPool.getDataSource();
            PreparedStatement pstmt = conn.prepareStatement(stmt);
        ) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String platform = rs.getString("platform");
                String cover_img = rs.getString("cover_img");
                String summary = rs.getString("summary");
                String created_at = rs.getString("created_at");

                Webtoon webtoon = new Webtoon(id, title, author, platform, cover_img, summary, created_at);
                webtoonList.add(webtoon);
            }
        }

        return webtoonList;
    }

    @Override
    public Webtoon getById(int id) throws Exception {
        Webtoon webtoon = null;
        String stmt = "SELECT title, author, platform, cover_img, summary, created_at FROM webtoon WHERE id = ?";

        try (
                Connection conn = DBPool.getDataSource();
                PreparedStatement pstmt = conn.prepareStatement(stmt);
                ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String platform = rs.getString("platform");
                String cover_img = rs.getString("cover_img");
                String summary = rs.getString("summary");
                String created_at = rs.getString("created_at");

                webtoon = new Webtoon(id, title, author, platform, cover_img, summary, created_at);
            }
        }

        return webtoon;
    }

    @Override
    public void updateWebtoon(Webtoon webtoon) throws Exception {
        String stmt = "UPDATE webtoon SET title = ?, author = ?, platform = ?, cover_img = ?, summary = ? WHERE id = ?";

        try (
                Connection conn = DBPool.getDataSource();
                PreparedStatement pstmt = conn.prepareStatement(stmt);
                ) {
            pstmt.setString(1, webtoon.getTitle());
            pstmt.setString(2, webtoon.getAuthor());
            pstmt.setString(3, webtoon.getPlatform());
            pstmt.setString(4, webtoon.getCover_img());
            pstmt.setString(5, webtoon.getSummary());
            pstmt.setInt(6, webtoon.getId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteWebtoon(int id) throws Exception {
        String stmt = "DELETE FROM webtoon WHERE id = ?";

        try (
                Connection conn = DBPool.getDataSource();
                PreparedStatement pstmt = conn.prepareStatement(stmt);
                ) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
