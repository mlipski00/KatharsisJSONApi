package org.katharsis;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.katharsis.persistence.dao.RoleRepository;
import org.katharsis.persistence.dao.UserRepository;
import org.katharsis.persistence.model.Role;
import org.katharsis.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Setup {
    
    @Autowired
    private DataSource dataSource;

    private final String SQL_FILE = "mock25000users.sql";

    @PostConstruct
    private void setupData() {
        try {
            setupDataFromSQLFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setupDataFromSQLFile()  throws IOException, SQLException {
        List<String> sqls = Resources.readLines(Resources.getResource(SQL_FILE), Charsets.UTF_8);
        try (Connection conn = dataSource.getConnection()) {
            for (String sql : sqls) {
                if (!sql.trim().isEmpty()) {
                    conn.createStatement().executeUpdate(sql);
                }
            }
        }
    }

}