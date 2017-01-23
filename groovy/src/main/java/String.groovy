javaString = 'java'
groovyString = "${javaString}"
j = '${javaString}'
bigGroovyString = """
${javaString}
${groovyString}
${j}
${2 + 2}
"""

println bigGroovyString

println a = "a"
println a + 123
println a * 5

println ''

println a = 'abc'
println a++
println a++
println a--
println a--

println ''

/*
groovy:000> r =~ '^a$'
===> java.util.regex.Matcher[pattern=^a$ region=0,1 lastmatch=]
*/

a = [1, 2, 5]
b = [1: true, 0: false]

//Range — это такой же объект, поэтому возможны конструции, подобные последней.
// Отрицательные индексы, как в python, возвращают элементы с конца списка.
println a = "0123456789"
println a[1..4]
println a[1..-1]
println a[-1..1]
println a[1..<9]
println a[1, 3, 5]
println b = 1..5
println a[b]

println 'a'..'aa'
//range можно сделать из любого объекта, у которого есть методы next() и prev().

println ''

for (i in 0..9) {
    println i
}
println()
for (int i = 0; i < 9; i++) {
    println i
}
println()
for (Integer i : 0..9) {
    println i
}