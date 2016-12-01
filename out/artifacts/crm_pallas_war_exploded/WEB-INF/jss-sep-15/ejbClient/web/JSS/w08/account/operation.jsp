<%@ page import="JSS.w08.account.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account operations</title>
</head>
<body>

<%
    Account remote = (Account)session.getAttribute("remote");
    String operation = request.getParameter("operation");
    String amount = request.getParameter("amount");

    if(operation!=null){

        if(operation.equals("deposit")){
            remote.deposit(Integer.parseInt(amount));
            out.print("Amount successfully deposited!");
        } else if (operation.equals("withdraw")){
            boolean status=remote.withdraw(Integer.parseInt(amount));
            if(status){
                out.print("Amount successfully withdrawn!");
            }else{
                out.println("Enter less amount");
            }
        } else {
            out.println("Current Amount: "+remote.getBalance());
        }
    }
%>

<hr/>
<form action="" method="post">
    Amount: <input title="text" name="amount"/><br>
    Operation:
    <select name="operation" required>
        <option selected disabled> Select... </option>
        <option value="deposit"> Deposit </option>
        <option value="withdraw"> Withdraw </option>
        <option value="balance"> Balance </option>
    </select>

    <br>
    <input title="submit" value="submit"/>
</form>


</body>
</html>
