<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User  blog Management Application</title>
</head>
<body>
	<center>
		<h1>User blog Management</h1>
        <h2>
        	<a href="new">Add New User Blog Post</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Blog Posts</a>

        </h2>
	</center>
    <div align="center">
		<c:if test="${user != null}">
			<form action="update" method="post">
        </c:if>
        
        <c:if test="${user == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${user != null}">
            			Edit User Blog Posts
            		</c:if>
            		<c:if test="${user == null}">
            			Add New User Blog Post
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${user != null}">
        			<input type="hidden" name="sino" value="<c:out value='${user.sino}' />" />
        		</c:if>            
            <tr>
                <th>Blog title: </th>
                <td>
                	<input type="text" name="title" size="45"
                			value="<c:out value='${user.title}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Blog description : </th>
                <td>
                	<input type="text" name="description" size="45"
                			value="<c:out value='${user.description}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Blog Content: </th>
                <td>
                	<input type="text" name="content" size="15"
                			value="<c:out value='${user.content}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>