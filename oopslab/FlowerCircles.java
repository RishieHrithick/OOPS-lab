import java.awt.*;
import javax.swing.*;

public class FlowerCircles extends JPanel {

    // basic settings
    private static final int NUM_RINGS = 16;
    private static final int STEP = 10;
    private static final double ROT_OFFSET = Math.toRadians(45); // tilt 45°
    private static final double EPS = 8.0;
    private static final double ANG_STEP = Math.toRadians(0.057); // ~0.001 rad
    private static final int LAYERS = 5;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D pen = (Graphics2D) g;

        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth(), h = getHeight();
        int midX = w / 2, midY = h / 2;

        int maxRadius = NUM_RINGS * STEP;

        // outer rings
        pen.setStroke(new BasicStroke(1.1f));
        pen.setColor(new Color(120, 120, 120));
        drawAllCircles(pen, midX, midY);

        // outer petals
        shadePetalLayers(pen, midX, midY, maxRadius);

        // inner petals
        int innerAmp = (int) Math.round(maxRadius * 0.38);
        shadePetalLayers(pen, midX, midY, innerAmp);
    }

    private void drawAllCircles(Graphics2D pen, int cx, int cy) {
        int r = STEP;
        for (int k = 1; k <= NUM_RINGS; k++) {
            pen.drawOval(cx - r, cy - r, 2 * r, 2 * r);
            r += STEP;
        }
    }

    private void shadePetalLayers(Graphics2D g2, int cx, int cy, int amp) {
        int layer = 1;
        while (layer <= LAYERS) {
            float w = 0.4f + layer * 0.3f;
            float a = 0.04f + layer * 0.05f;

            g2.setStroke(new BasicStroke(w, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.setColor(new Color(0f, 0f, 0f, a));

            renderPetals(g2, cx, cy, amp);

            layer++;
        }
    }

    // main petal tracing
    private void renderPetals(Graphics2D g2, int cx, int cy, int amp) {
        double twoPi = Math.toRadians(360);

        for (int ring = 1; ring <= NUM_RINGS; ring++) {
            int r = ring * STEP;

            boolean active = false;
            double segStart = 0.0;

            for (double th = 0.0; th <= twoPi + ANG_STEP; th += ANG_STEP) {
                double rose = Math.abs(amp * Math.sin(2 * (th + ROT_OFFSET)));
                boolean onRing = Math.abs(rose - r) <= EPS;

                if (onRing && !active) {
                    active = true;
                    segStart = th;
                } else if (!onRing && active) {
                    arcBetween(g2, cx, cy, r, segStart, th);
                    active = false;
                }
            }
            if (active) arcBetween(g2, cx, cy, r, segStart, twoPi);
        }
    }

    // arc drawing helper
    private void arcBetween(Graphics2D g2, int cx, int cy, int r, double t1, double t2) {
        if (t2 <= t1) return;
        int d = r << 1;

        double startDeg = Math.toDegrees(-t1);
        double extentDeg = Math.toDegrees(-(t2 - t1));

        g2.drawArc(cx - r, cy - r, d, d,
                (int) Math.round(startDeg),
                (int) Math.round(extentDeg));
    }


    public static void main(String[] args) {
        int maxR = NUM_RINGS * STEP;
        int margin = STEP;
        int sz = 2 * (maxR + margin) + 40;

        JFrame f = new JFrame("Flower illusion Circles ");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowerCircles canvas = new FlowerCircles();
        canvas.setPreferredSize(new Dimension(sz, sz));
        f.setContentPane(canvas);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}


