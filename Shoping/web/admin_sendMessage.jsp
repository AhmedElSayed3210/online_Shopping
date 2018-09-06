<%@page import="java.sql.ResultSet"%>
<%@page import="admin.admindb"%>
<%@page import="Database.query"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.cart"%>
<%@page import="Model.user"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="themes/admin_css/style.css">
        <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen"/>
        <link href="themes/css/base.css" rel="stylesheet" media="screen"/>
        <!-- Bootstrap style responsive -->	
        <link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet"/>
        <link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
        <%
            String email = request.getParameter("email");
            String problem = request.getParameter("problem");
        %>
    </head>
    <body>
        <header role="banner">
            <h1>Admin Panel</h1>
            <ul class="utilities">
                <li class="logout warn"><a href="logout">Log Out</a></li>
            </ul>
        </header>
        <nav role='navigation'>
            <ul class="main">
                <li class="dashboard"><a href="admin.jsp">Current Order</a></li>
                <li class="write"><a href="admin_products.jsp">Products</a></li>
                <li class="edit"><a href="admin_last_order.jsp">Previous products</a></li>
                <li class="comments"><a href="admin_contact.jsp">Contacts message</a></li>
            </ul>
        </nav>
        <main role="main" style="margin-left:170px">
            <section class="panel important">
                <h2>Send Message</h2>
                <div class="span9">
                    <form action="sendmessage" method="post">
                        <p>TO : <span><%=email%></span></p><br>
                        The Message :
                        <textarea style="width: 600px;height: 200px" name="message" required="required"></textarea>
                        <input type="hidden" value="<%=email%>" name="email">
                        <input type="submit" value="Send">
                    </form>
                </div>
            </section>
        </main>
    </body>
</html>
