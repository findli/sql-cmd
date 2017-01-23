//web.xml:

/*
<servlet>
<servlet-name>GroovyServlet</servlet-name>
    <servlet-class>groovy.servlet.GroovyServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>GroovyServlet</servlet-name>
<url-pattern>*.groovy</url-pattern>
</servlet-mapping>
*/


//        Теперь все запросы для файлов .groovy будут обрабатываться классом GroovyServlet.
//        В этих скриптах уже доступны для использования следующие переменные:

//— request & response
//— context, application, session
//— out (= response.getWriter())
//— sout (= response.getOutputStream())
//— html (= new MarkupBuilder(out))

html.html() {
    body() {
        div("class" : "main") {
            p("this is the body")
        }

        div() {
            p("this is the body 1")
            p("this is the body 2")
            p("this is the body 3")
        }
    }
}