<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/modal.jsp">
    <jsp:param name="id" value="query"/>
</jsp:include>

<button href="<c:url value='<%=request.getParameter("url")%>' />" class="btn btn-default" data-toggle="modal"
        data-target="#query">
    <i class="glyphicon glyphicon-search"></i>&nbsp;查询
</button>