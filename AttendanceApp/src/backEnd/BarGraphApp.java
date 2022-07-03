package backEnd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import styles.Theme;

/**
 *
 * @author Nate
 */
public class BarGraphApp extends JPanel {

    JSlider slider;
    JComboBox<String> names;

    private BarGraph graph;
    private BarGraphModel model;
    
    public BarGraphApp(Theme theme) {
        setBackground(theme.getMainColor());
        this.graph = new BarGraph(theme);
//        this.model = graph.getModel();
//        slider = new JSlider();
//        slider.setMaximum(100);
//        slider.setMajorTickSpacing(10);
//        slider.setSnapToTicks(false);
//        slider.setPaintTicks(true);
//        
//        
//        slider.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                int index = names.getSelectedIndex();+
//                model.itemAt(index).percentage = slider.getValue();
//                repaint();
//            }
//        });
//        
//        names = new JComboBox<String>(new String[]{"Lisa", "John", "Linda", "David", "Guido"});
//        names.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int index = names.getSelectedIndex();
//                slider.setValue(model.itemAt(index).percentage);
//            }
//        });
//        
//        names.setSelectedIndex(0);
//        
//        add(slider);
//        add(names);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph.draw(g);
    }

//    public static void main(String[] args) {
//        // TODO code application logic here
//        JFrame frame = new JFrame("Bar Graph");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600,600);
//        frame.setLocationRelativeTo(null);
//        frame.add(new BarGraphApp());
//        frame.setVisible(true);
//    }

}
