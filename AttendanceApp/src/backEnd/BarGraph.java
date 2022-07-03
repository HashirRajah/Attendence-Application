package backEnd;




import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import styles.Theme;

/**
 *
 * @author Nate
 */
public class BarGraph {

    protected BarGraphModel model;
    
    protected static final Font BAR_TITLE_FONT = new Font("Calibri", Font.PLAIN, 10);
    
    public BarGraph(Theme theme) {
        this.model = new BarGraphModel();
        
        //TODO: Remove this code below. Only test code
        model.setLocation(5, 5);
        model.setSize(475, 100);
        
        BarGraphModel.BarItem item = new BarGraphModel.BarItem("JAN");
        item.percentage = 60;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("FEB");
        item.percentage = 90;
        model.addItem(item);
        
        
        item = new BarGraphModel.BarItem("MAR");
        item.percentage = 50;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("APR");
        item.percentage = 65;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("MAY");
        item.percentage = 70;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("JUN");
        item.percentage = 100;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("JUL");
        item.percentage = 50;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("AUG");
        item.percentage = 30;
        model.addItem(item);
     
        item = new BarGraphModel.BarItem("SEP");
        item.percentage = 80;
        model.addItem(item);
     
        item = new BarGraphModel.BarItem("OCT");
        item.percentage = 60;
        model.addItem(item);
     
        item = new BarGraphModel.BarItem("NOV");
        item.percentage = 10;
        model.addItem(item);
     
        item = new BarGraphModel.BarItem("DEC");
        item.percentage = 40;
        model.addItem(item);

     
     
    }
    
    public BarGraphModel getModel() {
        return model;
    }

    public void setModel(BarGraphModel model) {
        this.model = model;
    }
    
    public void draw(Graphics g){
        drawItems(g);
        drawBoarder(g);
    }
    
    private void drawItems(Graphics g ){
        int i = 0;
        g.setFont(BAR_TITLE_FONT);
        FontMetrics fm = g.getFontMetrics(BAR_TITLE_FONT);
        
        for (BarGraphModel.BarItem item : model.items){
            
            int percentHeight = ((int)((double)item.percentage/100 * model.getSize().height));
            
            int x = model.getX() + i * model.getHorizontalGap();
            int y = model.getY() + model.getSize().height - percentHeight;
            int w = item.width;
            int h = percentHeight;
            g.setColor(item.background==null ? new Color(51, 106, 161) : item.background);
            g.fillRect(x, y, w, h);
            i++;
            //Draw the title
            int sw = fm.stringWidth(item.title);
            if (sw < item.width){
                x = x + ((item.width - sw)/2);
            } else {
                x = x - ((sw - item.width)/2);
            }
            
            y = model.getY() + model.getSize().height + BAR_TITLE_FONT.getSize();
            g.drawString(item.title, x, y);
        }
    }
    
   private void drawBoarder(Graphics g){
       g.setColor(new Color(56, 171, 171));
       g.drawRoundRect(model.getX(), model.getY(), model.getSize().width, model.getSize().height, 5, 5);
   }
}
