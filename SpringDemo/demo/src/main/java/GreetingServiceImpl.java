// src/main/java/com/example/springdiexample/service/GreetingServiceImpl.java

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet() {
        return "Hello, World!";
    }
}
