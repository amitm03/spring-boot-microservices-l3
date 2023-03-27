package io.javabrains.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting : default Value}")
    private String greetingMessage;

    @Value("some static message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Value("#{${dbValues}}")
    private Map<String,String> dbValues;

    @Autowired
    private DbSettings dbSettings;

    @GetMapping("/greeting")
    public String greeting(){
        return greetingMessage+" "+staticMessage+", "+listValues+", "+dbValues;
    }

    @GetMapping("/dbsettings")
    public String dbsettingValues(){
        return dbSettings.getConnection()+" "+dbSettings.getHost();
    }
}
