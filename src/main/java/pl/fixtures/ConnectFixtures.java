package pl.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.entity.Connect;
import pl.repository.ConnectRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConnectFixtures {
    @Autowired
    ConnectRepository connectRepository;

    public void createAndInsertIntoDb(){
        List<Connect> connects = createConns();
        connects.forEach(conn->{
            connectRepository.save(conn);
        });
    }

    public List<Connect> createConns(){
        List<Connect> connects = new ArrayList<>();
        Connect conn1=new Connect();
        conn1.setDrug1("ibuprofen");
        conn1.setDrug2("paracetamol");
        conn1.setResult("nie łącz");

        Connect conn2 = new Connect();
        conn2.setDrug1("ibuprofen");
        conn2.setDrug2("ketonal");
        conn2.setResult("nie łącz");

        connects.add(conn1);
        connects.add(conn2);

        return connects;

    }
}
