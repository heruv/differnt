import java.util.Arrays;

public  class Main
{
    public static void main(String[] args) throws Exception
    {
        double[][][] data = { {{0,5,0,0}, {0,0,5,0}, {0,1,2,3}, {0,1,2,3}, {1,2,3,4}, {4,3,2,1}}, {{0,5,0,0}, {0,0,5,0}, {0,1,2,3}, {0,1,2,3}, {1,2,3,4}, {4,3,2,1}},{{0,5,0,0}, {0,0,5,0}, {0,1,2,3}, {0,1,2,3}, {1,2,3,4}, {4,3,2,1}},};


            var plot = new Draw("beatle plot", "beatle", data);
            System.out.println(Arrays.deepToString(data));
            plot.draw();
  }
}


