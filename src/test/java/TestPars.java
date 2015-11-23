import MyPaser.Pars;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 10.11.2015.
 */
public class TestPars {
    @Test
    public void testCalc() {
        Pars instance = new Pars("2+2");
        double expected = 2 + 2;
        assertEquals("2+2=", expected, instance.calc(0), 0.000001);

        instance.setString("(10+3)*2^3");
        expected = (10 + 3) * Math.pow(2, 3);
        assertEquals("(10+3)*2^3=", expected, instance.calc(0), 0.000001);

        instance.setString("(10+2)/5+((12-2)*2^3)");
        expected = (10 + 2) / 5.0 + ((12 - 2) * Math.pow(2, 3));
        assertEquals("(10+2)/5+((12-2)*2^3)=", expected, instance.calc(0), 0.000001);

        instance.setString("(12/6+3)^2");
        expected = Math.pow((12 / 6 + 3), 2);
        assertEquals("(12/6+3)^2=", expected, instance.calc(0), 0.000001);
    }
}
