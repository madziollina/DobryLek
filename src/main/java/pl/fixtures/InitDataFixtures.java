package pl.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.entity.Connect;

import javax.annotation.PostConstruct;

@Component
public class InitDataFixtures {

    @Autowired
    ConnectFixtures connectFixtures;

    @PostConstruct
    public void initData(){
        connectFixtures.createAndInsertIntoDb();
    }
}
