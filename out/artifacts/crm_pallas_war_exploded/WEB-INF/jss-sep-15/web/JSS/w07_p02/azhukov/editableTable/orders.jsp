<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>

    <%-- Styles allowing to build a table with <div> and <div> tags --%>
    <%-- Needed because we cannot place a form inside <table> tag --%>
    <style>
        .table { display:table; border: 1px solid #999; table-layout: fixed; }
        .thead { display:table-header-group; font-weight:bold; background-color:#ccc; }
        .tbody { display:table-row-group; }
        .tr { display:table-row; }
        .td { display:table-cell; border: 1px solid #999; padding-left: 4px; padding-right: 4px;}
    </style>

    <%--Scripts for displaying edit controls inside the table--%>
    <script language="JavaScript">

        // Get the value from the table cell
        function getValue(id,col) {
            return document.getElementById("" + id + "_" + col).innerHTML;
        }

        var rowId = "0";      // Id of the row that is being edited
        var rowOldHtml = "";   // Old row data

        // Replace one table row with edit controls
        function showEditControls(id) {
            discardEdit();  // Remove edit controls if they were already shown in other row
            var rowElement = document.getElementById(id);
            rowId = id;
            rowOldHtml = rowElement.innerHTML;

            rowElement.innerHTML =
                    '<div class="td"><input title="text" name="date" value="'+getValue(id,1)+'" size="10"></div>' +
                    '<div class="td"><input title="text" name="description" value="'+getValue(id,2)+'" size="35"></div>' +
                    '<div class="td"><input title="text" name="qty" value="'+getValue(id,3)+'" size="4"></div>' +
                    '<div class="td"><input title="text" name="amount" value="'+getValue(id,4)+'" size="6"></div>' +
                    '<div class="td"><input title="text" name="customer" value="'+getValue(id,5)+'" size="15"></div>' +
                    '<div class="td"><input title="text" name="phone" value="'+getValue(id,6)+'" size="8"></div>' +
                    '<div class="td" width="100px">' +
                        '<input title="hidden" name="id" value="'+id+'">' +
                        '<input title="submit" name="editForm" value="Apply">' +
                        '<input title="button" value="Discard" onclick="discardEdit()">' +
                    '</div>'

        }

        // Replace edit controls with original row contents
        function discardEdit() {
            if (rowId > 0 && rowOldHtml) {
                document.getElementById(rowId).innerHTML = rowOldHtml;
                rowId = 0;
                rowOldHtml = "";
            }
        }

    </script>
</head>
<body>

    <%-- Process the edit form's request --%>
    <c:if test="${not empty param.editForm}">
        Edit id = ${param.id} :
        <div style="margin-left: 50px">
            Date = ${param.date}
            Description = ${param.description}
            Quantity = ${param.qty}
            Amount = ${param.amount}
        </div>
        <%-- Here update the DB --%>
    </c:if>

    <%--Create/retrieve and adjust DAO object--%>
    <jsp:useBean id="orderDAO" class="JSS.w03_pract.model.dao.OrderDAO" scope="session"/>
    <c:set var="ordering" value="${(empty param.ordering)? orderDAO.orderingField : param.ordering}"/>
    <c:if test="${not empty ordering}">
        <c:set target="${orderDAO}" property="orderingField" value="${ordering}"/>
    </c:if>
    ${orderDAO.refresh()}

    <%--Show data--%>
    <div class="table">  <%-- instead of <table> --%>
        <div class="thead">
            <div class="tr">    <%-- instead of <tr> --%>
                <div class="td">Date</div>
                <div class="td">Item</div>
                <div class="td">Quantity</div>
                <div class="td">Amount</div>
                <div class="td">Customer</div>
                <div class="td">Phone</div>
                <div class="td"> </div>
            </div>
        </div>
        <%--Each row and each cell have id, which javascript uses to get their contents--%>
        <div class="tbody">
        <c:forEach var="order" items="${orderDAO.iterator()}"  varStatus="status">
            <form class="tr" id="${order.id}">
                <div class="td" id="${order.id}_1">${order.date}</div>
                <div class="td" id="${order.id}_2">${order.product.description}</div>
                <div class="td" id="${order.id}_3">${order.qty}</div>
                <div class="td" id="${order.id}_4">${order.amount}</div>
                <div class="td" id="${order.id}_5">${order.customer.name}</div>
                <div class="td" id="${order.id}_6">${order.customer.phone}</div>
                <div class="td" id="${order.id}_7">
                    <input title="button" value="Edit" onclick="showEditControls(${order.id});">
                </div>
            </form>
        </c:forEach>
        </div>
    </div>

    <%--Usual ordering form--%>
    <form method="post" action="">
        <label>
            Ordering
            <select name="ordering" required>
                <option disabled ${ordering==''? "selected" : ""}>Select...</option>
                <option value="date" ${ordering=='date'? "selected" : ""}>Date</option>
                <option value="amount" ${ordering=='amount'? "selected" : ""}>Amount</option>
                <option value="name" ${ordering=='name'? "selected" : ""}>Customer</option>
            </select>
        </label>
        <input title="submit" name="orderingForm" value="Apply">
    </form>

</body>
</html>
