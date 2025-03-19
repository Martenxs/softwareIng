package servicios;

import java.sql.SQLException;
import java.util.List;

public interface PatronDAO<T> {
    void create(T obj) throws SQLException;
    List<T> read() throws SQLException;
    T read(String id) throws SQLException;
    void update(String id, T obj) throws SQLException;
    void delete(String id) throws SQLException;
}
