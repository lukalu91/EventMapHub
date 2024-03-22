package it.emh.lambda.event.db.factory;

import it.emh.lambda.event.db.entity.EventoEntity;
import it.emh.lambda.event.db.entity.TavoloEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TavoloFactory {

    public static List<TavoloEntity> resultSetToDto(ResultSet resultSet) throws SQLException {
        List<TavoloEntity> res = new ArrayList<>();
        while (resultSet.next()) {
            TavoloEntity entity = new TavoloEntity();
            int id = resultSet.getInt("id");
            int ludoid =  resultSet.getInt("ludoid");
            int posti =  resultSet.getInt("posti");
            String descrizione =  resultSet.getString("descrizione");

            entity.setId(id);
            entity.setLudoid(ludoid);
            entity.setPosti(posti);
            entity.setDescrizione(descrizione);

            res.add(entity);
        }
        return res;
    }
}
