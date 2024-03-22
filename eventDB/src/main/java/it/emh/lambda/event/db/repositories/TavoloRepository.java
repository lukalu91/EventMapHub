package it.emh.lambda.event.db.repositories;

import it.emh.lambda.event.db.entity.LudoPointEntity;
import it.emh.lambda.event.db.entity.TavoloEntity;
import it.emh.lambda.event.db.factory.TavoloFactory;
import it.emh.lambda.event.db.utils.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TavoloRepository {

    public List<TavoloEntity> findAllEventFromLudoPoint(LudoPointEntity entity) throws Exception {
        List<TavoloEntity> res = new ArrayList<>();
        Connection conn =  DBConnector.getInstance().getConnection();
        if(conn != null){
            try (PreparedStatement pStatement = conn.prepareStatement("select id,ludoid,posti,descrizione from tavoli where ludoId = ?")) {
                pStatement.setInt(1, entity.getId());

                ResultSet resultSet = pStatement.executeQuery();
                res = TavoloFactory.resultSetToDto(resultSet);
                resultSet.close();
            }
            conn.close();

        }else {
            throw new Exception ("Connection fault");
        }


        return res;
    }
}
