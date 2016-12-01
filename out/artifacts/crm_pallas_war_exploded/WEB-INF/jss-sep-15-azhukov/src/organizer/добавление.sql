Н Нет
6
var a = {            
b: 3           
}
Как считать свойство b объекта a?*
Выберите сколько угодно вариантов
*Aa[‘b’]
Ba::b
Ca->b
*Da.b
Ок нажмите ENTER
7

Что делает функция splice?*
AНет такой функции
*B Удаляет из массива заданное количество элементов
CСдвигает массив вправо
DСдвигает массив влево

8
Что вернёт следующий код:
2 == “2”*
*AИСТИНА
BЛОЖЬ
CСинтаксическая ошибка
D“undefined”

9
Что вернёт код?
(function(){
   return title of arguments;
})()*

*OBJECT

10
Что вернёт код?
var a = function b(){ return 'b'; };
typeof b();*

*Произойжет ошибка

11
var a = 5 + '7';
Чему равно a?*

*57

12
Что вернёт код?
  (function a(){
  function a(){ return 'a'; }
  return a();
  function a(){ return 'b'; }
  })();*
  
  *B
  
13
Что вернёт следующий код:
2 === “2”*

*FALSE

14
Что вернёт код?
(function(){
  return typeof args;
})()*

*Undefined

15
Что вернёт код?
var f = (
       function f() { 
               return "1";
       }, 
       function g() {
               return 2;
       }
)();*

*number

16
Что делает функция push?*
*Добавляет элемент в конец массива
17

Что вернёт код?
(function(){var a = b = 3;})();
a;*
ошибка
18

Что вернёт код?
(function(){var a = b = 3;})();
b;*
*3
19
Что выведет данный код?
function sum(a, b) {
s = a + b;
return s;
}
function product(a, b) {
var p = a * b;
return p;
}
s = 2;
p = 5;
p = sum(s, p);
s = product(p, s);
document.write("S = " + s + ", P = " + p);*
*S = 49, P = 7

20
Что вернет функция get?
function get() {
var a = 1;
function summ() {
var b = 2;
b = b + a;
var a = 3;
return b;
}
return summ();
}*