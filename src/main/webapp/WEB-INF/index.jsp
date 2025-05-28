<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/layout/app.jsp">
    <c:param name="content">
        <h2>タスク一覧</h2>
        <ul>
            <c:forEach var="content" items="${contents}">
                <li>
                    <a href="${pageContext.request.contextPath}/show?id=${content.id}">
                        <c:out value="${content.id}" />
                    </a>
                    ：<c:out value="${content.content}"></c:out>
                </li>
            </c:forEach>
        </ul>

        <p><a href="${pageContext.request.contextPath}/new">新規タスクの投稿</a></p>

    </c:param>
</c:import>