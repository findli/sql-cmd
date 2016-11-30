<%@ page import="JSS.w08.converter.Converter" %>
<%@ page import="JSS.w08.converter.ConverterHome" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.rmi.PortableRemoteObject" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.Enumeration" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyrill
  Date: 28.10.2014
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Converter page</title>
  </head>
  <body>
  <%!

      private void traceContextNames(Context rootContext, String contextName ) {
          System.out.println("Context " + contextName);
          Context context = null;
          try {
              context = (Context) rootContext.lookup(contextName);
              Enumeration names = context.list ("") ;
              while ( names.hasMoreElements())
                  System.out.println ( "\t" + names.nextElement ()) ;
          } catch (NamingException e) {
              e.printStackTrace();
          }
      }

      @Override
      public void jspInit() {

          // show all available JNDI names
          Context initialContext = null;
          try {
              initialContext = new InitialContext();
              traceContextNames(initialContext,"java:module");
              traceContextNames(initialContext,"java:app/ejbs_ejb");
              traceContextNames(initialContext,"java:global/EEApplication/ejbs_ejb");
          } catch (NamingException e) {
              e.printStackTrace();
          }
      }

  %>
  <%
    try {

        response.getWriter().println("ConverterServlet: remote view <br>");

        Context initialContext = new InitialContext();

        // Create BusinessLocalBeanReference
        // objRef cannot be cast to ConverterHome or LocalConverterHome
        Object objRef = initialContext.lookup("java:module/ConverterEJB");
        if (objRef==null) {
            System.out.println("objRef is null!!!!!");
        }

        // Get remote or local interface
        // can look for it either in "java:app/ejbs_ejb" or in "java:module"
        // can use ordinary type cast or PortableRemoteObject.narrow()
        ConverterHome converterHome = (ConverterHome) PortableRemoteObject
                .narrow(initialContext.lookup("java:module/ConverterEJB!JSS.w08.converter.ConverterHome"), ConverterHome.class);
//        ConverterHome converterHome = (ConverterHome) initialContext.lookup("java:app/ejbs_ejb/ConverterEJB!JSS.w08.converter.ConverterHome");
        Converter converter = converterHome.create();

        // Get local interface
//        LocalConverterHome converterHome = (LocalConverterHome) initialContext.lookup("java:module/ConverterEJB!JSS.w08.converter.LocalConverterHome");
//        LocalConverter converter = converterHome.create();


        // use business interface
        String amount = request.getParameter("amount");
        if (amount==null || amount.isEmpty()) {
            amount = "20";
        }

        BigDecimal d = new BigDecimal(amount);
        BigDecimal yenAmount = converter.dollarToYen(d);
        BigDecimal euroAmount = converter.yenToEuro(yenAmount);

        response.getWriter().format("%s dollars are %s yen or %s euro",amount,yenAmount,euroAmount);

        //converter.setEuroRate(new BigDecimal(3));


    } catch (Exception e) {
        e.printStackTrace(response.getWriter());
    }
  %>

  </body>
</html>
