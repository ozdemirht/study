package test;

import org.junit.jupiter.api.Test;
import solution.IQueue;

import solution.QueueByTwoStack;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class testQueueByTwoStack extends TestBase {
    @Test
    public void testConstructor(){
        IQueue<Integer> myQue = new QueueByTwoStack<>();
        assertEquals(true,myQue!=null);
    }
    @Test
    public void testEnqueue(){
        testEnqueue(new QueueByTwoStack<Integer>());
    }
    @Test
    public void testPeek(){
        testPeek(new QueueByTwoStack<Integer>());
    }
    @Test
    public void testDequeue(){
        testDequeue(new QueueByTwoStack<Integer>());
    }
    @Test
    public void testInputFile() throws IOException {
        long testBegin, testEnd;
        testInputFile(new QueueByTwoStack<Integer>(),"./test-input/testdata01.txt",2);
        testInputFile(new QueueByTwoStack<Integer>(),"./test-input/testdata02.txt",5);
        testBegin=System.nanoTime();
        testInputFile(new QueueByTwoStack<Integer>(),"./test-input/input06.txt",50229);
        testEnd=System.nanoTime();
        System.out.println("\nTook "+(testEnd-testBegin)/1000+"msec!");
    }

}
