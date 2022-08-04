import solution.SimpleTextEditor;

import java.io.*;
import java.util.stream.IntStream;

public class Main {

    public static void testInputFromFile(String fileName) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        SimpleTextEditor editor = new SimpleTextEditor();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);
                if(n>0&&n<5) {
                    switch(n){
                        case 1:
                            editor.append(firstMultipleInput[1]);
                            break;
                        case 2:
                            editor.delete(Integer.parseInt(firstMultipleInput[1]));
                            break;
                        case 3:
                            editor.print(Integer.parseInt(firstMultipleInput[1]),bufferedWriter);
                            bufferedWriter.newLine();
                            break;
                        case 4:
                            editor.undo();
                            break;
                        default:
                            break;
                    }
                }

                //bufferedWriter.write(String.valueOf(result));
                //bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //bufferedWriter.close();
    }

    public static void testAPI() throws IOException {
        SimpleTextEditor editor = new SimpleTextEditor();

        editor.append("abc");
        editor.print(3, new BufferedWriter(new OutputStreamWriter(System.out)));
        editor.delete(3);
        editor.append("xy");
        editor.print(2, new BufferedWriter(new OutputStreamWriter(System.out)));
        editor.undo();
        editor.undo();
        editor.print(1, new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    public static void main(String[] args) throws IOException {
        long testBegin, testEnd;
        String fileName;
        testAPI();

        fileName="./test-input/input01.txt";
        testBegin = System.nanoTime();
        testInputFromFile(fileName);
        testEnd = System.nanoTime();
        System.out.println("File["+fileName+"] took "+(testEnd-testBegin)/1000+" msec!");

        fileName="./test-input/input10.txt";
        testBegin = System.nanoTime();
        testInputFromFile(fileName);
        testEnd = System.nanoTime();
        System.out.println("File["+fileName+"] took "+(testEnd-testBegin)/1000+" msec!");

    }
}