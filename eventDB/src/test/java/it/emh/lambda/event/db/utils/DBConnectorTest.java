package it.emh.lambda.event.db.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class DBConnectorTest {

    @Test
    public void testInsertTable() throws SQLException {

        Connection conn =  DBConnector.getConnection();
        assertNotNull(conn);

        try (PreparedStatement pStatement = conn.prepareStatement("select count(1) as count from users;")) {

            ResultSet resultSet = pStatement.executeQuery();
            if(resultSet.next()){
                Long r = resultSet.getLong("count");
                assertNotNull(r);
            }


            resultSet.close();
        }
        conn.close();

    }
}
