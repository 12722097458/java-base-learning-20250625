import com.ityj.spring.jdbc.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;


@SpringJUnitConfig(locations = "classpath:bean-jdbc.xml")
public class TestJdbc {

    private static final Logger log = LoggerFactory.getLogger(TestJdbc.class);

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbcTemplate() {
        log.info(jdbcTemplate.toString());
    }

    @Test
    public void insert() {
        String sql = "insert into student (name, age, gender) values (?, ?, ?)";
        int insert = jdbcTemplate.update(sql, "SpringTemplate", "33", "男");
        System.out.println("insert = " + insert);
    }

    @Test
    public void update() {
        String sql = "update student set name = ? where id = ?";
        int update = jdbcTemplate.update(sql, "麦克", "5");
        System.out.println("update = " + update);
    }

    @Test
    public void delete() {
        String sql = "delete from student  where id = ?";
        int delete = jdbcTemplate.update(sql, "5");
        System.out.println("delete = " + delete);
    }

    @Test
    public void query() {
        String sql = "select name, age, gender from student where id < ?";

        List<Student> students = jdbcTemplate.query(sql,  new BeanPropertyRowMapper<>(Student.class), 12);
        System.out.println("students = " + students);

    }


}
