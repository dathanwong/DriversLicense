<!doctype html>
<html lang="en">
    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <div class="row my-2">
                        <h1>New License</h1>
                    </div>
                    <form:form action="/licenses" method="post" modelAttribute="license">
	                    <div class="row my-2">
	                        <div class="col-6">Person: </div>
	                        <form:select path="person" name="person" id="person">
	                        	<c:forEach items="${persons}" var="person">
	                            	<form:option value="${person}"><c:out value="${person.firstName} ${person.lastName }"></c:out></form:option>
	                            </c:forEach>
	                        </form:select>
	                    </div>
	                    <div class="row">
	                    	<form:errors class="text-danger" path="person"/>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-6">State: </div>
	                        <form:input path="state" type="text" class="col-6" name="state"></form:input>
	                    </div>
	                    <div class="row">
	                    	<form:errors class="text-danger" path="state"/>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-6">Expiration Date: </div>
	                        <form:input path="expirationDate" type="date" class="col-6" name="state"></form:input>
	                    </div>
	                    <div class="row">
	                    	<form:errors class="text-danger" path="expirationDate"/>
	                    </div>
	                    <div class="row my-2 justify-content-end">
	                        <div class="col-3">
	                            <Button class="btn btn-primary" type="submit">Create</Button>
	                        </div>
	                    </div>
                    </form:form>
                </div>
            </div>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>