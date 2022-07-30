package test;

import org.junit.jupiter.api.Test;
import solution.IQueue;

import solution.QueueBySinglyList;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class testQueueBySinglyList extends TestBase {
    @Test
    public void testConstructor(){
        IQueue<Integer> myQue = new QueueBySinglyList<>();
        assertEquals(true,myQue!=null);
    }
    @Test
    public void testEnqueue(){
        testEnqueue(new QueueBySinglyList<Integer>());
    }
    @Test
    public void testDequeue(){
        testDequeue(new QueueBySinglyList<Integer>());
    }
    @Test
    public void testInputFile() throws IOException {
        testInputFile(new QueueBySinglyList<Integer>(),"./test-input/testdata01.txt",2);
    }
}
