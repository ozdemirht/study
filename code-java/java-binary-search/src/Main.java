import java.util.Arrays;

public class Main {

    /*
    Time complexity of search is O(log n) where the n=length(sortedData)
    */
    public static int binarySearch(int[] sortedData, int left, int right, int query) {
        //System.out.println(" left:"+left+" right:"+right+" q:"+query);
        if (left > right) return -1;
        int mid = (left + right) / 2;
        //System.out.println(" mid:"+mid+" data:"+sortedData[mid]+" q:"+query);
        if (query == sortedData[mid]) return mid;
        return (query < sortedData[mid] ?
                binarySearch(sortedData, left, mid-1, query) :
                binarySearch(sortedData, mid+1, right, query));
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int i;
        int[] testData = new int[10];
        for(i=0;i<testData.length;i++) testData[i]=(int) (111*Math.random());
        Arrays.sort(testData);
        int[] data = testData;
        //Arrays.stream(data).sorted().forEach(x->System.out.print(x+" "));
        Arrays.stream(data).forEach(x->System.out.print(x+" "));

        int[] query = { data[3], data[4], 45};
        for(i=0; i< query.length;i++) {
            System.out.println("\n query=[" + query[i] + "] index=" + binarySearch(data, 0, data.length - 1, query[i]));
            System.out.println(" query=[" + query[i] + "] index=" + Arrays.binarySearch(data, query[i]));
        }
    }
}