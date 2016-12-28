Plan

1. JDBC integration
2. Hibernate integration
3. Managing DataSource with application server
4. Spring transaction
5. Validation
6. Localization
7. Logging
8. Testing

1. JDBC integration
* JdbcTemplate - позволяет выполнять SQL-команды, не заботясь о настройке JDBC, обработке ResultSet и исключений
* потокобезопасный( достаточно едиственного экземпляра)
* атрибуты БД обычно задают в виде бина DataSource в конфигурации Spring
    * либо используем tomcat-реализацию DataSource
    `org.apache.tomcat.tomcat-jdbc
    mysql.mysql-connector-java`
    
    * либо настраиваем бин DataSource в ApplicationContext
    `<bean id="dataSource" class="org.apache.tomcat.jdbc.pool.DataSource" destroy-method="close">
         <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
         <property name="url" value="jdbc:mysql://localhost:3306/salesdept?useUnicode=ues&amp;characterEncoding=UTF-8"/>
         <property name="username" value="root"/>
         <property name="password" value="123"/>
         <property name="initialSize" value="5"/>
         <property name="maxActive" value="10"/>
         <property name="maxIdle" value="5"/>
         <property name="minIDle" value="2"/>
    </bean>`
    * используем DataSource для инициализации JdbcTemplate
    * используем JdbcTemplate в Data Access Layer для реализации Repository
    
2. Hibernate integration

2.1 Standard approach
    * Конфигурируем бины
    