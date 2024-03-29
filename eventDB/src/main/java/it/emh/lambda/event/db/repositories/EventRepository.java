package it.emh.lambda.event.db.repositories;

import it.emh.lambda.event.db.entity.EventoEntity;
import it.emh.lambda.event.db.entity.LudoPointEntity;
import it.emh.lambda.event.db.factory.EventFactory;
import it.emh.lambda.event.db.factory.LudoPointFactory;
import it.emh.lambda.event.db.utils.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventRepository {

    public List<EventoEntity> findAllEventFromLudoPoint(LudoPointEntity entity) throws Exception {
        List<EventoEntity> res = new ArrayList<>();
        Connection conn =  DBConnector.getInstance().getConnection();
        if(conn != null){
            try (PreparedStatement pStatement = conn.prepareStatement("select id,ludoid,tipoid from eventi where ludoId = ?")) {
                pStatement.setInt(1, entity.getId());

                ResultSet resultSet = pStatement.executeQuery();
                res = EventFactory.resultSetToDto(resultSet);
                resultSet.close();
            }
            conn.close();

        }else {
            throw new Exception ("Connection fault");
        }


        return res;
    }
}
