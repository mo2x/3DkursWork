package MainPack;

import javax.swing.*;
import java.awt.*;

public class PaintPanel extends JComponent {

    private int sideSize;

    public PaintPanel() {
        super();
        setBackground(Color.WHITE);
        setIgnoreRepaint(true);
    }

    private void drawClip(Graphics2D g){
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setClip(getParent().getWidth() / 2 - sideSize / 2,
                getParent().getHeight() / 2 - sideSize / 2,
                sideSize, sideSize);
        g.fillRect(g.getClip().getBounds().x, g.getClip().getBounds().y,
                g.getClip().getBounds().width, g.getClip().getBounds().height);
    }

    private void resetSideSize(){
        sideSize = Math.min(getParent().getHeight(), getParent().getWidth());
    }

    public int getSideSize() {
        return sideSize;
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        setDoubleBuffered(true);
    }

    @Override
    public void paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1.create();
        g.setColor(Color.WHITE);
        if (getParent() != null) {
            resetSideSize();
            drawClip(g);
            Painter.draw(g);
        }
    }
}
