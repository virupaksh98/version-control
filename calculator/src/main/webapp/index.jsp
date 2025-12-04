<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="calculate" method="post">
    <input type="text" name="a" placeholder="a" /> 
    <select name="op">
        <option value="add">+</option>
        <option value="sub">-</option>
        <option value="mul">*</option>
        <option value="div">/</option>
    </select>
    <input type="text" name="b" placeholder="b" />
    <button type="submit">Compute</button>
</form>

<% String result = (String) request.getAttribute("result"); %>
<% if (result != null) { %>
    <h2>Result: <%= result %></h2>
<% } %>
</body>
</html>
