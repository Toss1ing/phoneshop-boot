<%@ attribute name="page" required="true" type="org.springframework.data.domain.Page" %>
<%@ attribute name="plpMaxPageNumber" required="true" type="java.lang.Integer" %>
<%@ attribute name="searchDto" required="true" type="com.expertsoft.phoneshop.dto.SearchDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${page.totalPages > 0}">

    <c:set var="currentPage" value="${page.number}"/>
    <c:set var="maxPages" value="${plpMaxPageNumber}"/>

    <c:set var="pagesBefore" value="${maxPages / 2}"/>
    <c:set var="pagesAfter" value="${maxPages - pagesBefore - 1 }"/>

    <c:set var="startPage" value="${currentPage - pagesBefore}"/>
    <c:set var="endPage" value="${currentPage + pagesAfter}"/>

    <c:if test="${startPage < 0}">
        <c:set var="startPage" value="0"/>
        <c:set var="endPage" value="${maxPages - 1}"/>
    </c:if>

    <c:if test="${endPage >= page.totalPages}">
        <c:set var="endPage" value="${page.totalPages - 1}"/>
        <c:set var="startPage" value="${page.totalPages - maxPages}"/>
    </c:if>

    <c:if test="${startPage < 0}">
        <c:set var="startPage" value="0"/>
    </c:if>

    <div class="pagination">
        <c:if test="${page.hasPrevious()}">
            <c:url var="previousUrl" value="/phones">
                <c:param name="page" value="${currentPage - 1}"/>
                <c:param name="size" value="${page.size}"/>

                <c:if test="${not empty param.sort}">
                    <c:param name="sort" value="${param.sort}"/>
                </c:if>

                <c:if test="${not empty searchDto.modelOrBrand}">
                    <c:param name="modelOrBrand" value="${searchDto.modelOrBrand}"/>
                </c:if>

                <c:if test="${not empty searchDto.fromPrice}">
                    <c:param name="fromPrice" value="${searchDto.fromPrice}"/>
                </c:if>

                <c:if test="${not empty searchDto.toPrice}">
                    <c:param name="toPrice" value="${searchDto.toPrice}"/>
                </c:if>
            </c:url>

            <a href="${previousUrl}" class="page-link">
                <<
            </a>

        </c:if>

        <c:forEach begin="${startPage}" end="${endPage}" var="i">

            <c:url var="pageUrl" value="/phones">
                <c:param name="page" value="${i}"/>
                <c:param name="size" value="${page.size}"/>

                <c:if test="${not empty param.sort}">
                    <c:param name="sort" value="${param.sort}"/>
                </c:if>

                <c:if test="${not empty searchDto.modelOrBrand}">
                    <c:param name="modelOrBrand" value="${searchDto.modelOrBrand}"/>
                </c:if>

                <c:if test="${not empty searchDto.fromPrice}">
                    <c:param name="fromPrice" value="${searchDto.fromPrice}"/>
                </c:if>

                <c:if test="${not empty searchDto.toPrice}">
                    <c:param name="toPrice" value="${searchDto.toPrice}"/>
                </c:if>
            </c:url>

            <a href="${pageUrl}"
               class="page-link ${i == currentPage ? 'active' : ''}">
                    ${i + 1}
            </a>
        </c:forEach>

        <c:if test="${page.hasNext()}">

            <c:url var="nextUrl" value="/phones">
                <c:param name="page" value="${currentPage + 1}"/>
                <c:param name="size" value="${page.size}"/>

                <c:if test="${not empty param.sort}">
                    <c:param name="sort" value="${param.sort}"/>
                </c:if>

                <c:if test="${not empty searchDto.modelOrBrand}">
                    <c:param name="modelOrBrand" value="${searchDto.modelOrBrand}"/>
                </c:if>

                <c:if test="${not empty searchDto.fromPrice}">
                    <c:param name="fromPrice" value="${searchDto.fromPrice}"/>
                </c:if>

                <c:if test="${not empty searchDto.toPrice}">
                    <c:param name="toPrice" value="${searchDto.toPrice}"/>
                </c:if>
            </c:url>

            <a href="${nextUrl}" class="page-link">
                >>
            </a>

        </c:if>
    </div>
</c:if>