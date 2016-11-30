package jss.w13_1.bean.dao;

public class Connection {
    ConnectionProvider provider;
    long id;

    public Connection(ConnectionProvider provider, long id) {
        this.provider = provider;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "id=" + id +
                '}';
    }
}
