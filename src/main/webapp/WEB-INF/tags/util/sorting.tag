<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="sortField" required="true" type="java.lang.String" %>
<%@ attribute name="searchDto" required="true" type="com.expertsoft.phoneshop.dto.SearchDto" %>
<c:set var="upperArrow" value="&#x25B2;"/>
<c:set var="downArrow" value="&#x25BC;"/>

<c:url var="ascUrl" value="/phones">
    <c:param name="sort" value="${sortField},asc" />
    <c:if test="${not empty searchDto.modelOrBrand}">
        <c:param name="modelOrBrand" value="${searchDto.modelOrBrand}" />
    </c:if>
    <c:if test="${not empty searchDto.fromPrice}">
        <c:param name="fromPrice" value="${searchDto.fromPrice}" />
    </c:if>
    <c:if test="${not empty searchDto.toPrice}">
        <c:param name="toPrice" value="${searchDto.toPrice}" />
    </c:if>
</c:url>

<c:url var="deskUrl" value="/phones">
    <c:param name="sort" value="${sortField},desc" />
    <c:if test="${not empty searchDto.modelOrBrand}">
        <c:param name="modelOrBrand" value="${searchDto.modelOrBrand}" />
    </c:if>
    <c:if test="${not empty searchDto.fromPrice}">
        <c:param name="fromPrice" value="${searchDto.fromPrice}" />
    </c:if>
    <c:if test="${not empty searchDto.toPrice}">
        <c:param name="toPrice" value="${searchDto.toPrice}" />
    </c:if>
</c:url>

<span class="sorting">
    <a href="${ascUrl}"
       class="sorting-arrow ${param.sort eq (sortField.concat(',asc')) ? 'active' : ''}">
        <c:out value="${upperArrow}" escapeXml="false"/>
    </a>

    <a href="${deskUrl}"
       class="sorting-arrow ${param.sort eq (sortField.concat(',desc')) ? 'active' : ''}">
        <c:out value="${downArrow}" escapeXml="false"/>
    </a>
</span>