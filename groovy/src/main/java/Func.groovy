def functionA(argA) {
    println argA
}

int functionB(int argB) {
    println argB
//    Ключевое слово return указывать не обязательно —
// по умолчанию будет возвращено значение последней упомянутой переменной в фукции.
    return argB
}

String functionC() {
    "Hello world"
}

functionA('a')
println()
println functionB(12)
println()
println functionC()

def c1 = {a,b ->
    println a
    println b
}

println()

c1(1,2)

//У многих объектов есть методы, в качестве параметров которым передаются closure:

1.upto 10, ({
    println( it)
})

println()

10.times {
    println(it)
}

'qwerty'.each{
    print(it + ' ')
}

println()

('a'..'z').each{
    print(it + ' ')
}

println()

('a'..'z').findAll{ el -> // = filter
    el in ['e', 'y', 'u', 'i', 'o', 'a']
}.each {
    print(it + ' ')
}
println()

(0..10).collect{el -> // = map
el * 10 }.each {
    print it + ' '
}

println()

def sum = (0..3).inject (0) { prev, elem -> // = reduce
return prev + elem }
println(sum)

println()

//В closure так же не обязательно использовать ключевое слово return. Если явно не задано имя параметру,
// то по умолчанию используется it.

//Так как closure является объектом, то ничего не мешает возвращать его из другого closure,
// и таким образом создавать функции высших порядков:

def cloA = {param ->
    def cloB = {
        return param * 10
    }
}

def b = cloA(10)
println b(10)