import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TestUI {
    UI ui;

@BeforeEach
void setup (){
    Club club = new Club();
    UI ui = new UI(club);
}
@Test
void testUI (){

}


}
