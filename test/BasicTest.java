import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void anotherVeryImportantThingToTest() {
        assertEquals(3, 1 + 2);
        assertEquals(3, 1 + 2);
    }

}
