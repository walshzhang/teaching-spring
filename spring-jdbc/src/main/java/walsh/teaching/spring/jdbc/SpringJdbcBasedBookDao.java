package walsh.teaching.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SpringJdbcBasedBookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> findAll() {
        return jdbcTemplate.query("select * from books", new BookRowMapper());
    }

    private static class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setTitle(rs.getString("title"));
            book.setPrice(rs.getFloat("price"));
            return book;
        }
    }


}
