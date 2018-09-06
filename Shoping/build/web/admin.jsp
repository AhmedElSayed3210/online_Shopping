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
            admin.admindb db = new admindb();
            ResultSet rs1 = db.getcart(0);
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
                <h2>Current Order</h2>
                <div class="span9">
                    <table class="table table-bordered" id="myTable2" style="width: 1100px;margin-left: 0px;margin-top: 0px;">
                        <thead>
                            <tr>
                                <th style="width:200px;cursor: pointer" onclick="sortTable(0)">Product Name &#8593;&#8595;</th>
                                <th style="cursor: pointer;width: 120px" onclick="sortTable(1)">Quantity &#8593;&#8595;</th>
                                <th style="width:140px;cursor: pointer" onclick="sortTable(2)">Price &#8593;&#8595;</th>
                                <th style="width:120px;cursor: pointer" onclick="sortTable(3)">Date &#8593;&#8595;</th>
                                <th style="width:200px;cursor: pointer" onclick="sortTable(4)">Buyer Name &#8593;&#8595;</th>
                                <th style="width:200px;cursor: pointer" onclick="sortTable(5)">Buyer Phone &#8593;&#8595;</th>
                                <th style="width:200px;cursor: pointer" onclick="sortTable(6)">Buyer Email &#8593;&#8595;</th>
                                <th style="width:200px;cursor: pointer" onclick="sortTable(7)">Buyer Address &#8593;&#8595;</th>
                                <th style="width:30px">Don</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%while (rs1.next()) {%>
                            <tr>
                                <td><%=rs1.getString("product")%> </td>
                                <td><%=rs1.getInt("Quntity")%> </td>
                                <td><%=rs1.getDouble("price")+" * "+ rs1.getInt("Quntity")%>=<%=rs1.getDouble("price") * rs1.getInt("Quntity")%> </td>
                                <td><%=rs1.getString("Date")%> </td>
                                <td><%=rs1.getString("Fname") + " " + rs1.getString("Lname")%> </td>
                                <td><%=rs1.getString("homePhone")%> </td>
                                <td><%=rs1.getString("email")%> </td>
                                <td><%=rs1.getString("country") + "-" + rs1.getString("city") + "-" + rs1.getString("state")%> </td>
                                <td>
                                    <form action="admin_order_don" method="post">
                                        <input type="hidden" name="id" value="<%=rs1.getInt("id")%>">
                                        <button type="submit"> DON</button>
                                    </form>                                    
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </section>
        </main>
    </body>
<script>
function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("myTable2");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  /* Make a loop that will continue until
  no switching has been done: */
  while (switching) {
    // Start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /* Loop through all table rows (except the
    first, which contains table headers): */
    for (i = 1; i < (rows.length - 1); i++) {
      // Start by saying there should be no switching:
      shouldSwitch = false;
      /* Get the two elements you want to compare,
      one from current row and one from the next: */
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      /* Check if the two rows should switch place,
      based on the direction, asc or desc: */
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          // If so, mark as a switch and break the loop:
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          // If so, mark as a switch and break the loop:
          shouldSwitch = true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      // Each time a switch is done, increase this count by 1:
      switchcount ++; 
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
</script>
</html>
