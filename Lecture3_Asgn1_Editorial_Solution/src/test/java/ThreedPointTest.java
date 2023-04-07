import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.*;

public class ThreedPointTest {

    @Test
    public void testPointHasX() {
        try {
            Field field = Point.class.getDeclaredField("x");
            assertTrue(Modifier.isProtected(field.getModifiers()));
            assertEquals("int", field.getType().getSimpleName());
        } catch (NoSuchFieldException e) {
            fail("Field x does not exist");
        }
    }


    @Test
    public void testPointHasY() {
        try {
            Field field = Point.class.getDeclaredField("y");
            assertTrue(Modifier.isProtected(field.getModifiers()));
            assertEquals("int", field.getType().getSimpleName());
        } catch (NoSuchFieldException e) {
            fail("Field y does not exist");
        }
    }


    @Test
    public void testPointHasDisplay() {
        try {
            Method method = Point.class.getDeclaredMethod("display");
            assertTrue(Modifier.isPublic(method.getModifiers()));
            assertEquals(void.class, method.getReturnType());
            assertEquals(0, method.getParameterCount());
        } catch (NoSuchMethodException e) {
            fail("Method display does not exist");
        }
    }


    @Test
    public void testPointDisplay() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Point p = new Point();
        p.x = 1;
        p.y = 2;
        p.display();
        assertEquals("[1, 2]\n", outContent.toString());
    }


    @Test
    public void testThreedPointDisplayOverride() {
        ThreedPoint tp = new ThreedPoint();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        tp.display();
        String expectedOutput = "[0, 0, 0]\n";
        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void testThreedPointDisplay() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ThreedPoint tp = new ThreedPoint();
        tp.x = 1;
        tp.y = 2;
        tp.display();
        assertEquals("[1, 2, 0]\n", outContent.toString());
    }

    @Test
    public void testPointDataMembers() {
        try {
            Field fieldX = Point.class.getDeclaredField("x");
            Field fieldY = Point.class.getDeclaredField("y");
            assertTrue(Modifier.isProtected(fieldX.getModifiers()));
            assertTrue(Modifier.isProtected(fieldY.getModifiers()));
            assertEquals("int", fieldX.getType().getSimpleName());
            assertEquals("int", fieldY.getType().getSimpleName());
        } catch (NoSuchFieldException e) {
            fail("x and y data members not found in Point class");
        }
    }


    @Test
    public void testPointDisplayMethod() {
        try {
            Method method = Point.class.getDeclaredMethod("display");
            assertTrue(Modifier.isPublic(method.getModifiers()));
            assertEquals(Void.TYPE, method.getReturnType());
        } catch (NoSuchMethodException e) {
            fail("display method not found in Point class");
        }
    }

    @Test
    public void testPointDisplayMethodOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Point point = new Point();
        point.x = 2;
        point.y = 3;
        point.display();
        assertEquals("[2, 3]\n", outContent.toString());
    }
    @Test
    public void testThreedPointDisplayMethodOverride() {
        ThreedPoint threedPoint = new ThreedPoint();
        assertTrue(Point.class.isAssignableFrom(ThreedPoint.class));
        assertEquals("display", ThreedPoint.class.getDeclaredMethods()[0].getName());
        assertEquals("public void Point.display()", Point.class.getDeclaredMethods()[0].toString());
    }
    
    @Test
    public void testThreedPointDisplayMethodOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ThreedPoint threedPoint = new ThreedPoint();
        threedPoint.x = 2;
        threedPoint.y = 3;
        threedPoint.z = 4;
        threedPoint.display();
        assertEquals("[2, 3, 4]\n", outContent.toString());
    }



}
