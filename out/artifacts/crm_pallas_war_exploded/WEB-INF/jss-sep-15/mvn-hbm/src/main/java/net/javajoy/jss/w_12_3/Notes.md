Plan
====

0. DAO with Hibernate
1. Entity instances management
2. HQL : parameter binding
3. Native SQL
4. Criteria
5. Advanced mapping
    - @ManyToMany
    - inheritance



1. Entity instances management
==============================================

### Instances may exist in one of three states:

- transient: never persistent, not associated with any Session
- persistent: associated with a unique Session
- detached: previously persistent, not associated with any Session


### Session : DRUD operations

- `get()` – получить Persistent-объект по id, либо null, если в БД такого нет.	
        Возвращаемый объект полностью инициализирован
        
- `load()`– получить Persistent-объект по id. Предполагается, что такой объект есть в БД.	
        Может вернуть прокси без данных, нельзя использовать для проверки существования.
        
- `save()` – только для вновь созданных transient-объектов, назначает им id и сохраняет в БД;

- `saveOrUpdate()`

- `persist()` – сохраняет в БД transient-объект, уже имеющий id;

- `update()` – использует detached-объект для обновления строки с таким же id в БД; 
            Cам перeданный объект становится Persistent 
            
- `merge()` – использует transient или detached-объект для обновления состояния persisternt-объекта с таким же id (если в сесси нет такого persisternt-объекта, то он загружается - load()). 	
Возвращает persisternt-объект, исходный объект остается detached.

- `refresh()` – обновляет состояние объекта, находя в БД его по id . 


### Lifecycle

Transient -> save(), persist(), saveOrUpdate() -> SQL INSERT  -> Persistent

Persistent -> delete() -> SQL DELETE -> Transient

nothing -> get(id), load(id), merge(detached) -> Persistent. 

Detached -> update(), saveOrUpdate(), lock(), replicate() -> Persistent


update(), merge() -> SQL UPDATE

saveOrUpdate(), replicate() ->  INSERT or an UPDATE

Changes to persistent instances are detected at flush time and also result in an SQL UPDATE..




2. HQL : parameter binding
==========================

-> select, update, delete

- Named  ":name"
       - By value
       - By instance
- Positional    "?"   




4. Criteria
===========


    Criteria

        - Criterion
        - Criterion <- LogicalExpression
                        - Criterion
                        - Criterion
        
        - Order
        - Order
        
        - Projection
        
        
5. Advanced mapping
===================
            
### @ManyToMany


### Inheritance

