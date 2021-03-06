<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring 3 MVC Customer Manager</title>
</head>
<body>

<h2>Customer Manager</h2>

<form:form method="post" action="add.html" commandName="contact">

    <table>
        <tr>
            <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
            <td><form:input path="firstname" /></td>
        </tr>
        <tr>
            <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
            <td><form:input path="lastname" /></td>
        </tr>
        <tr>
            <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
            <td><form:input path="telephone" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.addcustomer"/>"/>
            </td>
        </tr>
    </table>
</form:form>


<h3>Contacts</h3>
<c:if  test="${!empty contactList}">
    <table class="data">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Telephone</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>${customer.lastname}, ${customer.firstname} </td>
                <td>${customer.email}</td>
                <td>${customer.telephone}</td>
                <td><a href="delete/${customer.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>