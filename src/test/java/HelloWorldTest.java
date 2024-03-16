import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    HelloWorld helloWorld = new HelloWorld();

    @BeforeEach
    public void HelloWorld(){
        helloWorld  = new HelloWorld();
    }

    @Test
    public void testSayHello(){
        assertEquals("Hello,World!", helloWorld.sayHello());
    }

    @Test
    public void testGoodbye(){
       // assertEquals("Goodbye!", helloWorld.sayHello());
    }
}