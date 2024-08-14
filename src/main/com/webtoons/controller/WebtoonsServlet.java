package main.com.webtoons.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/webtoons/*")
@MultipartConfig(location = "/Users/daisy/Desktop/java/webtoon-practice/src/main/webapp/images")
public class WebtoonsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Map<String, WebtoonController> mapController = new HashMap<>();
        mapController.put("/webtoons/list", new ListController());

        req.setCharacterEncoding("UTF-8"); // 서버에 한글 전송
        String reqURI = req.getRequestURI();
        WebtoonController controller = mapController.get(reqURI);

        if (controller == null) {
            System.out.println("아아 오류입니다");
            return;
        }

        controller.process(req, res);
    }
}
