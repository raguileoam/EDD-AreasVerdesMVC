package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"docs/images/favicon.ico\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet@1.3.4/dist/leaflet.css\" integrity=\"sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA==\" crossorigin=\"\"/>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"test.css\" media=\"screen\" />\n");
      out.write("        <script src=\"https://unpkg.com/leaflet@1.0.3/dist/leaflet.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <h1>Test MVC Areas Verdes</h1>\n");
      out.write("        <div id=\"map\"></div>\n");
      out.write("        <!--        <script type=\"text/javascript\" src=\"datos.js\"></script>-->\n");
      out.write("        <script>\n");
      out.write("            var map = L.map('map').setView([-38.736277, -72.590618], 13);\n");
      out.write("            L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {\n");
      out.write("                attribution: '&copy; <a href=”http://osm.org/copyright”>OpenStreetMap</a> contributors'\n");
      out.write("            }).addTo(map);\n");
      out.write("\n");
      out.write("            var dataPoblacion = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${datosPoblacion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\n");
      out.write("\n");
      out.write("            var datalayer = L.geoJson(dataPoblacion, {style: style});\n");
      out.write("            datalayer.addTo(map);\n");
      out.write("            \n");
      out.write("            function style(feature) {\n");
      out.write("                return {\n");
      out.write("                    fillColor: getColor(10000 * feature.properties.PERSONAS / feature.properties.Shape__Area),\n");
      out.write("                    weight: 2,\n");
      out.write("                    opacity: 1,\n");
      out.write("                    color: 'white',\n");
      out.write("                    dashArray: '3',\n");
      out.write("                    fillOpacity: 0.7\n");
      out.write("                };\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function getColor(d) {\n");
      out.write("                return d > 200 ? '#800026' :\n");
      out.write("                        d > 100 ? '#BD0026' :\n");
      out.write("                        d > 50 ? '#E31A1C' :\n");
      out.write("                        d > 20 ? '#FC4E2A' :\n");
      out.write("                        d > 10 ? '#FD8D3C' :\n");
      out.write("                        d > 5 ? '#FEB24C' :\n");
      out.write("                        d > 2 ? '#FED976' :\n");
      out.write("                        '#FFEDA0';\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            var dataAreasVerdes=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${datosAreasVerdes}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
