<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${content != null}">
                <h2>id : ${content.id} のタスク詳細ページ</h2>
                <table>
                    <tbody>
                        <tr>
                            <th>タスク</th>
                            <td><c:out value="${content.content}" /></td>
                        </tr>
                        <tr>
                            <th>作成日時</th>
                            <td><fmt:formatDate value="${content.created_at}"
                                    pattern="yyyy-MM-dd HH:mm:ss" /></td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td><fmt:formatDate value="${content.updated_at}"
                                    pattern="yyyy-MM-dd HH:mm:ss" /></td>
                        </tr>
                    </tbody>
                </table>
                <p>
                    <a href="${pageContext.request.contextPath}/index">一覧に戻る</a>
                </p>
                <p>
                    <a href="${pageContext.request.contextPath}/edit?id=${content.id}">このタスクを編集する</a>
                </p>

            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
    </c:param>
</c:import>