package main.com.webtoons.dao;

import main.com.webtoons.model.Webtoon;

import java.util.List;

public interface WebtoonDAO {
    // 웹툰 추가하기
    void addWebtoon(Webtoon webtoon) throws Exception;
    // 웹툰 전체 보기
    List<Webtoon> getWebtoonList() throws Exception;
    // 특정 웹툰 불러오기
    Webtoon getById(int id) throws Exception;
    // 웹툰 업데이트 하기
    void updateWebtoon(Webtoon webtoon) throws Exception;
    // 웹툰 삭제하기
    void deleteWebtoon(int id) throws Exception;
}
