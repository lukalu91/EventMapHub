package it.emh.lambda.event.db.factory;

import it.emh.lambda.event.db.entity.EventoEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventFactory {

    public static List<EventoEntity> resultSetToDto(ResultSet resultSet) throws SQLException {
        List<EventoEntity> res = new ArrayList<>();
        while (resultSet.next()) {
            EventoEntity entity = new EventoEntity();
            int id = resultSet.getInt("id");
            int ludoid =  resultSet.getInt("ludoid");
            String tipoid =  resultSet.getString("tipoid");

            entity.setId(id);
            entity.setLudoid(ludoid);
            entity.setTipoid(tipoid);

            res.add(entity);
        }
        return res;
    }
}
