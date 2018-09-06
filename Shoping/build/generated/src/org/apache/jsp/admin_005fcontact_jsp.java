package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import admin.admindb;
import Database.query;
import java.util.ArrayList;
import Model.cart;
import Model.user;

public final class admin_005fcontact_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" >\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Admin Page</title>\n");
      out.write("        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css'>\n");
      out.write("        <link rel=\"stylesheet\" href=\"themes/admin_css/style.css\">\n");
      out.write("        <link id=\"callCss\" rel=\"stylesheet\" href=\"themes/bootshop/bootstrap.min.css\" media=\"screen\"/>\n");
      out.write("        <link href=\"themes/css/base.css\" rel=\"stylesheet\" media=\"screen\"/>\n");
      out.write("        <!-- Bootstrap style responsive -->\t\n");
      out.write("        <link href=\"themes/css/bootstrap-responsive.min.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"themes/css/font-awesome.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <!-- Google-code-prettify -->\t\n");
      out.write("        <link href=\"themes/js/google-code-prettify/prettify.css\" rel=\"stylesheet\"/>\n");
      out.write("        ");

            admin.admindb db = new admindb();
            ResultSet rs1 = db.contact();
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header role=\"banner\">\n");
      out.write("            <h1>Admin Panel</h1>\n");
      out.write("            <ul class=\"utilities\">\n");
      out.write("                <li class=\"logout warn\"><a href=\"\">Log Out</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </header>\n");
      out.write("        <nav role='navigation'>\n");
      out.write("            <ul class=\"main\">\n");
      out.write("                <li class=\"dashboard\"><a href=\"admin.jsp\">Current Order</a></li>\n");
      out.write("                <li class=\"write\"><a href=\"admin_products.jsp\">Products</a></li>\n");
      out.write("                <li class=\"edit\"><a href=\"admin_last_order.jsp\">Previous products</a></li>\n");
      out.write("                <li class=\"comments\"><a href=\"admin_contact.jsp\">Contacts message</a></li>\n");
      out.write("                <li class=\"users\"><a href=\"#\">Manage Users</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("        <main role=\"main\">\n");
      out.write("            <section class=\"panel important\">\n");
      out.write("                <h2>Contact Message</h2>\n");
      out.write("                <div class=\"span9\">\n");
      out.write("                    <table class=\"table table-bordered\" id=\"myTable2\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th style=\"width:200px;cursor: pointer\" onclick=\"sortTable(0)\">Person Name &#8593;&#8595;</th>\n");
      out.write("                                <th style=\"width: 100px;cursor: pointer\" onclick=\"sortTable(1)\">Email &#8593;&#8595;</th>\n");
      out.write("                                <th style=\"width:100px;cursor: pointer\" onclick=\"sortTable(2)\"> Subject &#8593;&#8595;</th>\n");
      out.write("                                <th style=\"width:300px;cursor: pointer\"onclick=\"sortTable(3)\">Problem &#8593;&#8595;</th>\n");
      out.write("                                <th style=\"width:100px;cursor: pointer\" onclick=\"sortTable(4)\">Date &#8593;&#8595;</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
while (rs1.next()) {
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(rs1.getString("name"));
      out.write(" </td>\n");
      out.write("                                <td>");
      out.print(rs1.getString("email"));
      out.write(" </td>\n");
      out.write("                                <td>");
      out.print(rs1.getString("subject"));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(rs1.getString("problem"));
      out.write(" </td>\n");
      out.write("                                <td>");
      out.print(rs1.getString("date"));
      out.write(" </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("        </main>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("function sortTable(n) {\n");
      out.write("  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;\n");
      out.write("  table = document.getElementById(\"myTable2\");\n");
      out.write("  switching = true;\n");
      out.write("  // Set the sorting direction to ascending:\n");
      out.write("  dir = \"asc\"; \n");
      out.write("  /* Make a loop that will continue until\n");
      out.write("  no switching has been done: */\n");
      out.write("  while (switching) {\n");
      out.write("    // Start by saying: no switching is done:\n");
      out.write("    switching = false;\n");
      out.write("    rows = table.rows;\n");
      out.write("    /* Loop through all table rows (except the\n");
      out.write("    first, which contains table headers): */\n");
      out.write("    for (i = 1; i < (rows.length - 1); i++) {\n");
      out.write("      // Start by saying there should be no switching:\n");
      out.write("      shouldSwitch = false;\n");
      out.write("      /* Get the two elements you want to compare,\n");
      out.write("      one from current row and one from the next: */\n");
      out.write("      x = rows[i].getElementsByTagName(\"TD\")[n];\n");
      out.write("      y = rows[i + 1].getElementsByTagName(\"TD\")[n];\n");
      out.write("      /* Check if the two rows should switch place,\n");
      out.write("      based on the direction, asc or desc: */\n");
      out.write("      if (dir == \"asc\") {\n");
      out.write("        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {\n");
      out.write("          // If so, mark as a switch and break the loop:\n");
      out.write("          shouldSwitch = true;\n");
      out.write("          break;\n");
      out.write("        }\n");
      out.write("      } else if (dir == \"desc\") {\n");
      out.write("        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {\n");
      out.write("          // If so, mark as a switch and break the loop:\n");
      out.write("          shouldSwitch = true;\n");
      out.write("          break;\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("    if (shouldSwitch) {\n");
      out.write("      /* If a switch has been marked, make the switch\n");
      out.write("      and mark that a switch has been done: */\n");
      out.write("      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);\n");
      out.write("      switching = true;\n");
      out.write("      // Each time a switch is done, increase this count by 1:\n");
      out.write("      switchcount ++; \n");
      out.write("    } else {\n");
      out.write("      /* If no switching has been done AND the direction is \"asc\",\n");
      out.write("      set the direction to \"desc\" and run the while loop again. */\n");
      out.write("      if (switchcount == 0 && dir == \"asc\") {\n");
      out.write("        dir = \"desc\";\n");
      out.write("        switching = true;\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("  }\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
