import javax.swing.*;
import java.awt.*;

/**
 * Created by grnr1 on 5/18/2016.
 */
public class SaveDocPanel extends JPanel
{
    JLabel setenterNameLabel;
    JTextField setgetDocText;
    Container c7;
    Container c8;
    Container c9;
    Container c10;
    JLabel setenterStringLabel;
    JTextArea setgetStringDocText;
    JButton setgetSubmit;
    JButton setcancel;
    public SaveDocPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setenterNameLabel=new JLabel("Enter file name");
        setgetDocText=new JTextField();
        setgetDocText.setColumns(20);
        c7=new Container();
        c7.setLayout(new FlowLayout());
        c7.add(setenterNameLabel);
        c7.add(setgetDocText);
        add(c7);

        setenterStringLabel=new JLabel("Enter string you want to save");
        setgetStringDocText=new JTextArea(3,20);

        c10=new Container();
        c10.setLayout(new FlowLayout());
        c10.add(setenterStringLabel);
        c10.add(setgetStringDocText);
        add(c10);

        setgetSubmit=new JButton("Submit");
        setcancel=new JButton("Cancel");
        c9=new Container();
        c9.setLayout(new FlowLayout());
        c9.add(setgetSubmit);
        c9.add(setcancel);
        add(c9);
    }
}
