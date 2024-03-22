package it.emh.lambda.event.db.factory;

import it.emh.lambda.event.db.entity.LudoPointEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LudoPointFactory {
    public static List<LudoPointEntity>  resultSetToDto(ResultSet resultSet) throws SQLException {
        List<LudoPointEntity> res = new ArrayList<>();
        while (resultSet.next()) {
            LudoPointEntity entity = new LudoPointEntity();

            int id = resultSet.getInt("id");
            int userid =  resultSet.getInt("userid");
            String nome =  resultSet.getString("nome");

            String latitudine =  resultSet.getString("latitudine");
            String longitudine =  resultSet.getString("longitudine");


            entity.setId(id);
            entity.setUserid(userid);
            entity.setNome(nome);

            entity.setLatitudine(latitudine);
            entity.setLogintudine(longitudine);

            res.add(entity);
        }
        return res;
    }
}
