/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

/**
 *
 * @author Usuario
 */
public class Grafico extends javax.swing.JPanel {

    /**
     * Creates new form Grafico
     */
    public Grafico() {
        initComponents();
        createChart(createDataset());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 883, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private static JFreeChart createChart(PieDataset dataset) {

        JFreeChart chart = ChartFactory.createPieChart(
                "TUTOR DE PROGRAMACION", dataset, false, false, false);

        chart.setBackgroundPaint(new GradientPaint(new Point(0, 0),
                new Color(20, 20, 20), new Point(400, 200), Color.DARK_GRAY));

        TextTitle t = chart.getTitle();
        t.setHorizontalAlignment(HorizontalAlignment.CENTER);
        t.setPaint(new Color(240, 240, 240));
        t.setFont(new Font("Arial", Font.BOLD, 26));

        PiePlot plot = (PiePlot) chart.getPlot();

        plot.setBackgroundPaint(null);
        plot.setInteriorGap(0.04);
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);
        plot.setLabelShadowPaint(null);
        plot.setBaseSectionOutlinePaint(Color.WHITE);
        plot.setSectionOutlinesVisible(true);
        plot.setBaseSectionOutlineStroke(new BasicStroke(2.0f));
        plot.setLabelFont(new Font("Courier New", Font.BOLD, 20));
        plot.setLabelLinkPaint(Color.WHITE);
        plot.setLabelLinkStroke(new BasicStroke(2.0f));
        plot.setLabelOutlineStroke(null);
        plot.setLabelPaint(Color.WHITE);
        plot.setLabelBackgroundPaint(null);

        TextTitle url = new TextTitle(
                "Blog Oficial: http://acodigo.blospot.com",
                new Font("Courier New", Font.PLAIN, 12));
        url.setPaint(Color.WHITE);
        url.setPosition(RectangleEdge.BOTTOM);
        url.setHorizontalAlignment(HorizontalAlignment.RIGHT);

        TextTitle description = new TextTitle(
                "Los tutoriales mas frecuentes en nuestro blog",
                new Font("Arial", Font.PLAIN, 18));
        description.setPaint(Color.LIGHT_GRAY);
        description.setPosition(RectangleEdge.TOP);
        description.setHorizontalAlignment(HorizontalAlignment.LEFT);

        chart.addSubtitle(description);
        chart.addSubtitle(url);

        return chart;
    }
    
    private static PieDataset createDataset() {
    DefaultPieDataset dataset = new DefaultPieDataset();
    dataset.setValue("OpenCV 3.x", new Double(40.0));
    dataset.setValue("Java", new Double(20.0));
    dataset.setValue("Python 3.x", new Double(20.0));
    dataset.setValue("OpengGL", new Double(10.5));
    dataset.setValue("Win32", new Double(5.25));
    dataset.setValue(".NET", new Double(5.25));
    return dataset;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}