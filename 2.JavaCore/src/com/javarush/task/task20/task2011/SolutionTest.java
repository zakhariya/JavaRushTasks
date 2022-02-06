package com.javarush.task.task20.task2011;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.NotSerializableException;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    public static Solution.Apartment apartment;

    @Before
    public void initMock() {
        apartment = Mockito.mock(Solution.Apartment.class);
    }

    @Test
    public void mockToStringTest() {
        String expected = "I`m mock";

        Mockito.when(apartment.toString()).thenReturn("I`m mock");

        String actual = apartment.toString();

        assertEquals(expected, actual);
    }

    @Test(expected = NotSerializableException.class)
    public void mockExceptionTest() throws IOException {
        Mockito.when(apartment.toString()).thenThrow(NotSerializableException.class);

        apartment.toString();
    }
}
