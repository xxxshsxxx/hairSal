<%@ page import="java.util.List" %>
<%@ page import="model.Apointment" %><%--
  Created by IntelliJ IDEA.
  User: Styopa
  Date: 21.11.2019
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
</head>
<body>

<%
    List<Apointment> apointments = (List<Apointment>) request.getAttribute("apointment");
%>

<div>
<div style="float: left; width: 30%">
    <h2>Add new Service</h2>

    <form action="/addService" method="post" enctype="multipart/form-data">

        <input type="text" name="name" placeholder="Please input Title"><br>
        <input type="text" name="price" placeholder="Please input Title"><br>
        <textarea name="description"></textarea><br>

        Image: <input type="file" name="image"><br>
        <input type="submit" value="OK">

    </form>
</div>
    <div style="float: left; width: 30%">
    <h2>Add new Master</h2>

    <form action="/addMaster" method="post" enctype="multipart/form-data">

        <input type="text" name="name" placeholder="Please input Title"><br>
        <input type="text" name="surname" placeholder="Please input Title"><br>

        Image: <input type="file" name="image"><br>
        <input type="submit" value="OK">

    </form>
    </div>
<div style="float: left; width: 30%"><h2>Add Photo in a Gallery</h2>

    <form action="/addGallery" method="post" enctype="multipart/form-data">

        <input type="date" name="date" placeholder="Please input Title"><br>
        <input type="text" name="description" placeholder="Please input Title"><br>

        Image: <input type="file" name="image"><br>
        <input type="submit" value="OK">
    </form>
</div>
</div>
<div style="float: left; width: 80%"><h2>All Apointments</h2>
    <table border="2px">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Email</th>
            <th>Date</th>
            <th>Time</th>
            <th>Created Date</th>
            <th>Phone</th>
            <th>Servise</th>
            <th>Master</th>
            <th>notes</th>
        </tr>
        <%for (Apointment apointment : apointments){%>
        <tr>
            <td><%=apointment.getName()%></td>
            <td><%=apointment.getSurname()%></td>
            <td><%=apointment.getEmail()%></td>
            <td><%=apointment.getDate()%></td>
            <td><%=apointment.getTime()%></td>
            <td><%=apointment.getCreatedDate()%></td>
            <td><%=apointment.getPhone()%></td>
            <td><%=apointment.getServiceId()%></td>
            <td><%=apointment.getMasterId()%></td>
            <td><%=apointment.getNotes()%></td>
        </tr>
        <%}%>
    </table>

</div>

</body>
</html>
