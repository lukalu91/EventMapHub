package it.emh.lambda.event.searcher.services;

import it.emh.lambda.event.common.beans.Evento;
import it.emh.lambda.event.common.beans.LudoPoint;
import it.emh.lambda.event.common.beans.Luogo;
import it.emh.lambda.event.common.beans.Tavolo;
import it.emh.lambda.event.common.enums.EventType;
import it.emh.lambda.event.db.entity.EventoEntity;
import it.emh.lambda.event.db.entity.LudoPointEntity;
import it.emh.lambda.event.db.entity.TavoloEntity;
import it.emh.lambda.event.db.repositories.EventRepository;
import it.emh.lambda.event.db.repositories.LudoPointRepository;
import it.emh.lambda.event.db.repositories.TavoloRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventService {

    public static List<LudoPoint> findEvents() throws Exception {
        List<LudoPoint> res = new ArrayList<>();

        // TROVO TUTTI I LUDOPOINT
        LudoPointRepository ludoPointRepository = new LudoPointRepository();
        List<LudoPointEntity> pointEntitys = ludoPointRepository.findAllLudoPoint();

        for(LudoPointEntity pointEntity: pointEntitys){
            LudoPoint lp = new LudoPoint();
            lp.setNome(pointEntity.getNome());

            Luogo luogo = new Luogo();
            luogo.setLatitudine(new BigDecimal(pointEntity.getLatitudine()));
            luogo.setLongitudine(new BigDecimal(pointEntity.getLogintudine()));

            // TROVO TUTTI GLI EVENTI DEI LUDO POINT
            EventRepository eventRepository = new EventRepository();
            List<EventoEntity> eventiEntitys = eventRepository.findAllEventFromLudoPoint(pointEntity);

            List<Evento> eventi = new ArrayList<>();
            for(EventoEntity eventoEntity : eventiEntitys){
                Evento evento = new Evento();
                evento.setNome(eventoEntity.getId()+"° Evento");
                evento.setData(new Date());
                evento.setTipo(EventType.TORNEO);
                evento.setDescrizione("bla bla bla");

                eventi.add(evento);
            }

            // TROVO TUTTI i tavoli del ludopoint
            TavoloRepository tavoloRepsitory = new TavoloRepository();
            List<TavoloEntity> tavoliEntitys = tavoloRepsitory.findAllEventFromLudoPoint(pointEntity);

            List<Tavolo> tavoli = new ArrayList<>();
            for(TavoloEntity tavoloEntity : tavoliEntitys){
                Tavolo tavolo = new Tavolo();
                tavolo.setPosti(tavoloEntity.getPosti());
                tavolo.setId(tavoloEntity.getId());
                tavolo.setDescrizione(tavoloEntity.getDescrizione());

                tavoli.add(tavolo);
            }

            lp.setEvents(eventi);
            lp.setLuogo(luogo);
            lp.setTavoli(tavoli);
            res.add(lp);
        }


        return res;
    }
}
