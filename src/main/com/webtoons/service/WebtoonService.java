package main.com.webtoons.service;

import main.com.webtoons.model.Webtoon;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface WebtoonService {
    // 웹툰 추가하기
    void addWebtoon(HttpServletRequest req) throws Exception;
    // 웹툰 전체 보기
    List<Webtoon> getWebtoonList() throws Exception;
    // 특정 웹툰 불러오기
    Webtoon getById(HttpServletRequest req) throws Exception;
    // 웹툰 업데이트 하기
    void updateWebtoon(HttpServletRequest req) throws Exception;
    // 웹툰 삭제하기
    void deleteWebtoon(HttpServletRequest req) throws Exception;
}
