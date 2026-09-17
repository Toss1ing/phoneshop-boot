<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/user" %>
<common:page pageTitle="Admin panel" showMenu="false">
    <div class="row mb-3">
        <common:back/>
    </div>
    <div class="row justify-content-center">
        <h2>Admin panel page stub</h2>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Avatar</th>
            <th scope="col">Login</th>
            <th scope="col">Name</th>
            <th scope="col">Bio</th>
            <th scope="col">Location</th>
            <th scope="col">Company</th>
            <th scope="col">Role</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <user:tile user="${user}"/>
        </c:forEach>
        </tbody>
    </table>
</common:page>
