import java.awt.*;
import javax.swing.*;

public class GA3 {
    public static void main(String[] args) {
        double[] values = new double[args.length];
        for (int i = 0; i < args.length; i++) {
            values[i] = Double.parseDouble(args[i]);
        }

        JFrame frame = new JFrame();
        frame.setTitle("Pie Chart Drawing");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PieChartDrawing(values));
        frame.setVisible(true);
    }
}

class PieChartDrawing extends JPanel {

    private double[] values;
    private Color[] colors;
    private double total;

    public PieChartDrawing(double[] values) {
        this.values = values;
        colors = new Color[values.length];

        // Calculate total value of all slices
        for (int i = 0; i < values.length; i++) {
            total += values[i];
        }

        // Generate random colors for each slice
        for (int i = 0; i < colors.length; i++) {
            colors[i] = new Color((int) (Math.random() * 0x1000000));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        int r = (int) (Math.min(x, y) * 0.8);

        // Draw each slice of the pie chart
        int currentAngle = 0;
        for (int i = 0; i < values.length; i++) {
            int arcAngle = (int) (values[i] / total * 360);
            g.setColor(colors[i]);
            g.fillArc(x - r, y - r, 2 * r, 2 * r, currentAngle, arcAngle);
            currentAngle += arcAngle;
        }
    }
}