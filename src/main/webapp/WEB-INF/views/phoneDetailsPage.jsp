<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<common:page pageTitle="Phone details" showMenu="true">
    <div class="row mb-3" style="margin-left: 50px;">
        <common:back/>
    </div>
    <div class="row justify-content-center">
        <h2>Phone details page stub</h2>
    </div>
    <div class="row mx-3">
        <div class="col-md-2 justify-content-center">
            <img src="https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/${phone.image}" alt="Phone image">
        </div>
        <div class="col-md-2 justify-content-center">
            <h1>
                    ${phone.brand} ${phone.model}
            </h1>
            <h3>
                    ${phone.price}
            </h3>
            <hr>
            <p>
                    ${phone.description}
            </p>
        </div>
    </div>
</common:page>
