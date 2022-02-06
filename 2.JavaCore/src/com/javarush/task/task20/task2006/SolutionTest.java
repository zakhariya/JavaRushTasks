package com.javarush.task.task20.task2006;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;

import static org.junit.Assert.fail;

public class SolutionTest {

    @Test
    public void checkHumanSerializable() {
        try {
            Solution.Human human = new Solution.Human();

            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(arrayOutputStream);
            outputStream.writeObject(human);
        } catch (NotSerializableException e) {
            fail("Human is not Serializable");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
