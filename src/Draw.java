import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.Styler;

public class Draw {
    private final String title;
    private final String series_name;
    private final double[][][] data;
    private final int iter;
    private final int len;

    public Draw(String title, String seriesName, double[][][] data)
    {
        this.title = title;
        this.series_name = seriesName;
        this.data = data;
        iter = this.data.length;
        len = data[0].length;
    }

    public  void draw() throws InterruptedException {

        XYChart chart = new XYChartBuilder()
            .width(500)
            .height(400)
            .theme(Styler.ChartTheme.GGPlot2)
            .title(title)
        .build();

        for (int i = 0; i < iter; i++) {
            chart.addSeries(series_name+i, data[i][0], data[i][1]);
        }

        final SwingWrapper<XYChart> sw = new SwingWrapper<>(chart);
        sw.displayChart();

        for (int j = 1; j<len-1; j++) {
            int i = 0;
            for (; i< iter; i++) {

                Thread.sleep(100);
                int finalJ = j;
                int finalI = i;
                javax.swing.SwingUtilities.invokeLater(() -> {

                    chart.updateXYSeries(series_name+ finalI, data[finalI][finalJ-1], data[finalI][finalJ], null);
                    sw.repaintChart();
                });
            }

        }
    }
}
