//"?:" Elvis operator
//Проверяет переменную a, и если в ней null или false, то берет указанное следом значение. Иначе берется значение переменной a.
a = null
def b = a ?: "b"

//"?." Safe navigation
//Используется для избежания ошибки NullPointerException
//Вернет null, если в user содержится null вместо того, чтобы бросать NullPointerException.
class User {
def posts
}

class Users {
    def static get(var1) {
        new User()
    }
}

def user = Users.get("a")
def posts = user?.posts
println posts

//"*." Spread operator
//Применяет указанный метод для всех элементов какой-либо коллекции. Эквивалент следующему:
//parent*.action == parent.collect { ch -> child?.action }

//Пример использования:
def sizes = ['string', 'long string']*.size()
println sizes

def x = [2, 3]
def y = [0, 1, *x, 4]
println y

def a = [3 : 'c', 4 : 'd']
def c = [1 : 'a', 2: 'b', * : a, 5 : 'e']
println c
println()
println()
//В Groovy можно перегружать операторы +, -, * и т.п. Для этого нужно определить соотвествующий метод для класса.
// Например, для перегрузки оператора ++ нужно переопределить метод next():

class RandomVal {
    // для этого поля не будут сгенерированы сеттеры и геттеры
    private def value
    private Random randomGen = new Random()

    def next() {
        this.value = randomGen.nextInt()
    }

    RandomVal() {
        this.value = randomGen.nextInt()
    }

    def String toString() {
        "${this.value}"
    }
}

def r = new RandomVal()
println(r)
r++
println(r)

//Оператор "==" уже перегружен для всех объектов — и вызывает метод «isEquals()». Полный список методов,
// которые нужно переопределить для перегрузки операторов, доступен здесь:
// http://groovy.codehaus.org/Operator+Overloading.