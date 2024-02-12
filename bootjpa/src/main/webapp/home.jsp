<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Saving and retrieving -- DB</title>
</head>
<body>
    <h1>Sample Form</h1>
    
    <form action="addAlien" method="post">
        <label for="aid">ID:</label>
        <input type="text" id="aid" name="aid" placeholder="Enter aid">
        <br>
        <br>
        <label for="aname">Name:</label>
        <input type="text" id="aname" name="aname" placeholder="Enter aname">
        <br>
        <br>
        <label for="lang">Lang:</label>
        <input type="text" id="lang" name="lang" placeholder="Enter language">
        <br>
        <br>
        <input type="submit" value="ADD DETAILS">
    </form>
    
    <br>
    <hr>
    <form action="getAlien" method="post">
        <label for="aid">ID:</label>
        <input type="text" id="aid" name="aid" placeholder="Enter aid">
        <br>
        <br>
        <input type="submit" value="GET DETAILS">
    </form>
    
    <!--LATER
    <br>
    <hr>
    <form action="updateAlien" method="post">
        <label for="aid">ID:</label>
        <input type="text" id="aid" name="aid" placeholder="Enter aid">
        <br>
        <label for="aname">Name:</label>
        <input type="text" id="aname" name="aname" placeholder="Enter new aname">
        <br>
        <input type="submit" value="UPDATE NAME">
        <p>${status}</p>
    </form>
    -->
</body>
</html>
