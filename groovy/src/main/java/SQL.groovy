import groovy.sql.Sql

def final ADDRESS = "jdbc:jtds:sqlserver://serverName/dbName"
def final USERNAME = "username"
def final PASSWD = "password"
def final DRIVER = "net.sourceforge.jtds.jdbc.Driver"
sql = Sql.newInstance(ADDRESS, USERNAME, PASSWD, DRIVER)

sql.eachRow("select * from tableName") { el ->
    println "${el.id} -- ${el.firstName}"
}

def firstName = "A"
def lastName = "G"
sql.execute("insert into tableName (firstName, lastName) " +
        "values (${firstName}, ${lastName})")

sql.execute("insert into tableName (firstName, lastName) " +
        "values (?, ?)", [firstName, lastName])