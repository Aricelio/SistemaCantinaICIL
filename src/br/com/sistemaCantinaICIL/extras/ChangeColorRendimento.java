package br.com.sistemaCantinaICIL.extras;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Aricelio - 16/01/2016
 */
public class ChangeColorRendimento implements TableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        // Cria um objeto do tipo Component
        Component component = DEFAULT_RENDERER.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
        
        if (column == 0) {            
            component.setBackground(Color.decode("#58ACFA")); // Azul
            component.setForeground(Color.BLACK);           
        }       

        return component;
    }

}
