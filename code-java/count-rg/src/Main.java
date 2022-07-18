import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static class Point {
        long distance;
        char  color;
        Point(long distance,char color){
            this.distance = distance;
            this.color = color;
        }
    }
    static class Sortbydistance implements Comparator<Point> {
        // Used for sorting in ascending order of
        // roll number
        public int compare(Point a, Point b)
        {
            if(a.distance < b.distance) return -1;
            if(a.distance > b.distance) return 1;
            return 0;
        }
    }
    public static int solution(int[] X, int[] Y, String colors) {
        // write your code in Java SE 8
        // SC: O(n)
        Point[] points = new Main.Point[X.length];
        int i;
        // TC: O(n)
        for(i=0;i<X.length;i++)
            points[i] = new Main.Point(X[i]*X[i]+Y[i]*Y[i],colors.charAt(i));
        // TC : O(n log n)
        Arrays.sort(points, new Sortbydistance());
        //for(i=0;i<points.length;i++)
        //    System.err.print(" p.d="+points[i].distance+" c:"+points[i].color) ;
        int max_r=0;
        int countR=0;
        int countG=0;
        if(points[0].color=='R') countR++;
        else countG++;
        // TC: O(n)
        for(i=1;i<points.length;i++) {
            if(points[i].color=='R') countR++;
            else countG++;
            if(countR==countG) max_r=i+1;
        }
        // TC : O(n log n)
        // SC : O(n)
        return max_r;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] X = new int[]{4,0,2,-2};
        int[] Y = new int[]{4,1,2,-3};
        String colors = "RGRR";
        int expected = 2;
        int answer = solution(X,Y,colors);
        System.out.println("expected:"+expected+" answer: "+answer);

        X = new int[]{1,1,-1,-1};
        Y = new int[]{1,-1,1,-1};
        colors = "RGRG";
        expected = 4;
        answer = solution(X,Y,colors);
        System.out.println("expected:"+expected+" answer: "+answer);

        X = new int[]{1,0,0};
        Y = new int[]{0,1,-1};
        colors = "GGR";
        expected = 0;
        answer = solution(X,Y,colors);
        System.out.println("expected:"+expected+" answer: "+answer);

        X = new int[]{5,-5,5};
        Y = new int[]{1,-1,-3};
        colors = "GRG";
        expected = 2;
        answer = solution(X,Y,colors);
        System.out.println("expected:"+expected+" answer: "+answer);

        X = new int[]{3000,-3000,4100,-4100,-3000};
        Y = new int[]{5000,-5000,4100, -4100, 5000};
        colors = "RRGRG";
        expected = 2;
        answer = solution(X,Y,colors);
        System.out.println("expected:"+expected+" answer: "+answer);

    }
}