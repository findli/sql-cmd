**1. Session: DRUD operations**

* get() - получить Persistent-объект по id, либо null, если в БД такого нет. Возвращаемый объект полностью инициализирован.
* load() - получить Persistent-объект по id. Предполагается, что такой обхект есть в БД. Может вернуть проси без данных, нельзя использовать для проверки существования.
* save() - только для вновь созданных transient-объектов, назначает им id и сохраняет в БД;
* saveOrUpdate()
* persist() - сохраняет в БД transient-объект, уже имеющий id;
* update() - использует detached-объект для обновления строки с таким же id в БД; Сам переданный объект становится Persistent
* merge() - использует transient-объект или detached-объект для обновления состояния persistent-объекта с таким же id( если в сессии нет такого persistent-объекта, то он загружается - load()). Возвращает persistent-объект, исходный объект остается detached.
* refresh() - обновляет состояние обхекта, находя его в БД по id.

Lifecycle

Transient->save()/persist()/saveOrUpdate()->SQL INSERT -> Persistent

Persistent -> delete() -> SQL DELETE ->Transient

nothing -> get(id)/ load(id) / merge(detached) -> Persistent

Detached -> update() / saveOrUpdate() / lock() / replicate() -> Persistent

update()/ merge() -> SQL UPDATE

saveOrUpdate() / replicate() -> INSERT or an UPDATE

Changes to persistent instances are detected at flush time and also result in an SQL UPDATE

**2. HQL: parameter binding**

-> select, update, delete

* named ":name"
    
    by value
    
    by instance
    
* positional "?"

**4. Criteria**

Criteria

- Criterion
- Criterion <- LogicalExpression

        - Criterion
        - Criterion
- Order
- Order

- Projection

**5. Advanced mapping** 

@ManyToMany

inheritance