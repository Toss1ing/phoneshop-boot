<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<%@ taglib prefix="phone" tagdir="/WEB-INF/tags/phone" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<common:page pageTitle="Phone list" showMenu="true">
    <div class="row justify-content-sm-between font-italic mb-3 mx-3">
        <div>
            Current Page : ${phones.number + 1}
        </div>
        <div>
            Found <c:out value="${phones.totalElements}"/> results!
        </div>
    </div>
    <form method="get" action="${pageContext.request.contextPath}/phones">
        <c:if test="${not empty errorMessage}">
            <div class="error">
                <c:out value="${errorMessage}"/>
            </div>
        </c:if>
        <div>
            <label>
                Model or brand
                <input
                    type="text"
                    name="modelOrBrand"
                    value="${searchDto.modelOrBrand}"
                    placeholder="model or brand"
                />
            </label>
            <label>
                From price
                <input
                    type="text"
                    name="fromPrice"
                    value="${searchDto.fromPrice}"
                    placeholder="10"
                />
            </label>
            <label>
                To price
                <input
                    type="text"
                    name="toPrice"
                    value="${searchDto.toPrice}"
                    placeholder="50"
                />
            </label>
            <button type="submit">
                Search
            </button>
        </div>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Image</th>
            <th scope="col">Brand <util:sorting sortField="brand" searchDto="${searchDto}"/></th>
            <th scope="col">Model <util:sorting sortField="model" searchDto="${searchDto}"/></th>
            <th scope="col">Price <util:sorting sortField="price" searchDto="${searchDto}"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="phone" items="${phones.content}">
            <phone:tile phone="${phone}"/>
        </c:forEach>
        </tbody>
    </table>

    <util:pagination page="${phones}" plpMaxPageNumber="${plpMaxPages}" searchDto="${searchDto}"/>
</common:page>