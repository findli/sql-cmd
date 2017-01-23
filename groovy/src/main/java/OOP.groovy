import groovy.transform.Immutable

class App {
    String title = "Title"
    BigDecimal bigDecimal = 0.123
    private main() {
        println("Hello World!")
        println(title)
        println(bigDecimal)
    }

    void setTitle(title) {
        println "${this.title} is become ${title})"
        this.title = title
    }
}

app = new App(title: "Title 1", bigDecimal: new BigDecimal(1.123))
app.main()

def title = app.getTitle()
println(title)

println("\n")

app = new App()
app.setTitle("Title 2")
app.main()

class ExtendedApp extends App {
    def desc

    ExtendedApp(title, bigDecimal, desc) {
        this.title = title
        setBigDecimal(bigDecimal)
        this.desc = desc
    }

    def String toString(){
        "${title} ${bigDecimal} ${desc}"
    }
}
// Could not find matching constructor for: ExtendedApp()
//e = new ExtendedApp()

println new ExtendedApp("Title 3", new BigDecimal(1.1), 1)

println()

//При использовании этой аннотации нужно явно указывать, какого типа данных поле.
@Immutable
class ImmutableClass {
    String a
    Integer b
}

def ic = new ImmutableClass(a : "a", b : 1)