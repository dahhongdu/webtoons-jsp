<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Webtoons</title>
    <script>
        function showEditForm(id, title, author, platform, summary, img) {
            console.log("editform: ");
            console.log(id);
            console.log(title);
            console.log(author);
            document.getElementById('editTitle').value = title;
            document.getElementById('editAuthor').value = author;
            document.getElementById('editPlatform').value = platform;
            document.getElementById('editSummary').value = summary;
            document.getElementById('editId').value = id;
        }
    </script>
</head>
<body>
<h1>웹툰 리스트입니다!</h1>
<div>
    <ul>
        <c:forEach var="webtoon" items="${webtoonList}">
            <li>
                <div>
                    <h2>${webtoon.getTitle()}</h2>
                    <img src="/images/${webtoon.getCover_img()}" alt="커버 이미지" style="width: 300px; height: auto;" />
                    <br/>
                    <span>작가: ${webtoon.getAuthor()} / ${webtoon.getPlatform()}</span>
                    <br/>
                    <span>${webtoon.getSummary()}</span>
                    <br/>
                    <button onclick="showEditForm(
                            '${webtoon.id}',
                            '${fn:escapeXml(webtoon.getTitle())}',
                            '${fn:escapeXml(webtoon.getAuthor())}',
                            '${fn:escapeXml(webtoon.getPlatform())}',
                            '${fn:escapeXml(webtoon.getSummary())}',
                            '${webtoon.getCover_img()}'
                            )">수정</button>
                </div>
            </li>
        </c:forEach>

    </ul>
</div>

<div id="editForm">
    <h1>웹툰 수정하기</h1>
    <form
            action="/webtoons/list?action=updateWebtoon"
            method="post"
            enctype="multipart/form-data"
    >
        <input type="hidden" id="editId" name="id" />
        <input id="editTitle" name="title" placeholder="title" required />
        <input id="editAuthor" name="author" placeholder="author" required />
        <input id="editPlatform" name="platform" placeholder="platform" required />
        <textarea id="editSummary" name="summary" placeholder="summary" required></textarea>
        <input id="editImg" name="img" type="file" />
        <button type="submit">저장하기</button>
    </form>
</div>

<div>
    <h1>웹툰 추가하기</h1>
    <form
            action="/webtoons/list?action=addWebtoon"
            method="post"
            enctype="multipart/form-data"
    >
        <input id="title" name="title" placeholder="title" required />
        <input id="author" name="author" placeholder="author" required />
        <input id="platform" name="platform" placeholder="platform" required />
        <textarea id="summary" name="summary" placeholder="summary" required></textarea>
        <input id="img" name="img" type="file" required/>
        <button type="submit">저장하기</button>
    </form>
</div>
</body>
</html>
