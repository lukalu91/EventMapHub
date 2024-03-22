package it.emh.lambda.event.searcher.services;

import com.google.gson.Gson;
import it.emh.lambda.event.common.beans.LudoPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    //TODO: Testare le proprietà: quando va in errore -> gestire caso in cui il connector non funziona
    @Test
    public void testFindAllEvent() throws Exception {
        List<LudoPoint> points =  EventService.findEvents();

        Gson gson = new Gson();

        System.out.println(gson.toJson(points));
    }
}
