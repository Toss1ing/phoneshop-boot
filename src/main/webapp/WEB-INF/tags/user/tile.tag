<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="user" required="true" type="com.expertsoft.phoneshop.persistence.model.User" %>
<tr>
    <td>
        <c:out value="${user.id}" />
    </td>
    <td>
        <img src="${user.avatarUrl}" alt="avatar" style="height: 60px; width: 60px">
    </td>
    <td>
        <c:out value="${user.login}" />
    </td>
    <td>
        <c:out value="${user.name}" />
    </td>
    <td>
        <c:out value="${user.bio}" />
    </td>
    <td>
        <c:out value="${user.location}" />
    </td>
    <td>
        <c:out value="${user.company}" />
    </td>
    <td>
        <c:out  value="${user.role.name()}" />
    </td>
</tr>