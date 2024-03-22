package it.emh.lambda.event.db.repositories;

import it.emh.lambda.event.db.entity.LudoPointEntity;
import it.emh.lambda.event.db.factory.LudoPointFactory;
import it.emh.lambda.event.db.utils.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LudoPointRepository {

    public List<LudoPointEntity> findAllLudoPoint() throws Exception {
        List<LudoPointEntity> res = new ArrayList<>();
        Connection conn =  DBConnector.getInstance().getConnection();
        if(conn != null){
            try (PreparedStatement pStatement = conn.prepareStatement("select id,userid,nome,longitudine,latitudine from ludopoint")) {

                ResultSet resultSet = pStatement.executeQuery();
                res = LudoPointFactory.resultSetToDto(resultSet);
                resultSet.close();
            }
            conn.close();

        }else {
            throw new Exception ("Connection fault");
        }


        return res;
    }
}
