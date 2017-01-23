import groovy.xml.MarkupBuilder

//def mb = new MarkupBuilder()
def mb = new MarkupBuilder(new java.io.File('index.html').newPrintWriter())

mb.html() {
    head() {
        title("This is the title")
    }

    body() {
        div("class" : "main") {
            p("this is the body")
        }
    }
}

mb.println()


// Parsing
import groovy.xml.MarkupBuilder
import java.io.StringWriter

def sw = new StringWriter()
def markupBuilder = new MarkupBuilder(sw)

markupBuilder.html() {
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

def xml = sw.toString()

println xml
println()

import groovy.util.XmlParser;

def parser = new XmlParser()
def doc = parser.parseText(xml)
//def doc = parser.parse("index.html")

println doc.body.div[1].p[1] // возвращает Node
println doc.body.div[1].p // возвращает список, состоящий из Node
println doc.body.div["@class"] // список значений аттрибута class для всех div