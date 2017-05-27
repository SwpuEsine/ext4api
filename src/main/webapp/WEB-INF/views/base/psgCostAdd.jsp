<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <meta charset="UTF-8">
</head>
<body>

<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">通道成本增加</h3>
    </div>
    <form name="child" action="<c:url value="/passageCost/add" />" method="post">
        <jsp:include page="psgCostForm.jsp"/>
    </form>
    <jsp:include page="../common/box-footer.jsp"/>
</div>
</body>
</html>
<script>
    $(function () {
    	var regular={
    			"gt-one":function(value){
    				try{
    			if(isNaN(value)){
    				return false
    			}
    			if (parseFloat(value).toString() == "NaN") {
    				return false	
    			}
    				}
    				catch(error){
    					return false
    				}
    				return true
    			}
    	}
    	ValidateForm('form[name="child"]',regular)  	
    })
</script>