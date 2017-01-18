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
        * LocalSessionFactoryBean
    * Используем SessionFactory для реализации Repository

2.2 Spring transaction management
будет применяться как для hibernate так и для jdbc.
    * AOP configuration (tx:...)
    * Annotation-based
        * Настраиваем transactionManager( в dispatcher-контексте)
        * Используем аннотации @Transactional в сервисном слое
        
2.3 Hibernate Template
 * Конфигурационные бины
    * LocalSessionFactoryBean
    * HibernateTemplate
* Используем HibernateTemplate для реализации Repository
* Либо используем механизм Spring Transaction( с аннотациями)
* Либо настраиваем транзакции вручную
    * В Web.xml добавляем фильтр, который создает новую сессию для каждого запроса
    
    <!--Filter to create new hibernate session for each request-->
    <filter>
        <filter-name>hibernateFilter</filter-name>
        <filter-class>
            org.springframework.orm.hibernate4.support.OpenSessionInViewFilter
        </filter-class>
        <init-param>
            <param-name>singleSession</param-name>
            <param-value>false</param-value>
        </init-param>
    </filter>
    
    * В методах редактирования настраиваем свойства сессии
    
    Session session = template.getSessionFactory().getCurrentSession();
    
3. Managing DataSource with application server

* Подключаем Tomcat DataSource support org.apache.tomcat.tomcat-jdbc
* Конфигурируем DataSource в /META-INF/context.xml

    <Resource name="jdbc/java_jss_salesdept" auth="Container"
              type="javax.sql.DataSource"
              maxActive="100"
              maxIdle="30"
              maxWait="10000"
              username="root"
              password="123"
              driverClassName="com.mysql.jdbc.Driver"
              url="jdbc:mysql://localhost:3306/java_jss_salesdept?useUnicode=yes&amp;characterEncoding=UTF-8"
              factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
    />

* В applicationContext.xml получаем ссылку через JNDI
    <beans>
        <jee:jndi-lookup id="myDataSource" jndi-name="java:comp/env/jdbc/salesdept"/>
    </beans>

