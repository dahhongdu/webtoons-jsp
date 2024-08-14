package main.com.webtoons.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface WebtoonController {
    void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
