import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class GA4 {

    public static void main(String[] args) {
        int[] values = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
        JFrame frame = new JFrame("Bar Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new BarChart(values));
        frame.pack();
        frame.setVisible(true);
    }
}

class BarChart extends JPanel {

    private int[] values;
    private Color[] colors;

    public BarChart(int[] values) {
        this.values = values;
        colors = new Color[values.length];

        for (int i = 0; i < colors.length; i++) {
            colors[i] = new Color((int) (Math.random() * 0x1000000));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth() / values.length;
        int maxValue = Arrays.stream(values).max().getAsInt();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            int height = (int) (getHeight() * ((double) value / maxValue));
            int x = i * width;
            int y = getHeight() - height;
            g.setColor(colors[i]);
            g.fillRect(x, y, width, height);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }
}