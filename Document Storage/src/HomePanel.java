import javax.swing.*;
import java.awt.*;

/**
 * Created by grnr1 on 5/18/2016.
 */
public class HomePanel extends JPanel
{
    JLabel selectOptionHome;
    JLabel retrieveLabel;
    JRadioButton retrieveButton;
    JLabel saveLabel;
    JRadioButton saveButton;
    Container c1;
    Container c2;
    Container c3;
    JButton submit;
    ButtonGroup bg;
    public HomePanel()
    {
        selectOptionHome = new JLabel();
        selectOptionHome.setText("Select whether you want to save or retrieve document");

        retrieveButton=new JRadioButton();
        retrieveLabel=new JLabel("Retrieve");

        c1=new Container();
        c1.setLayout(new FlowLayout());
        c1.add(retrieveButton);
        c1.add(retrieveLabel);



        saveButton=new JRadioButton();
        saveLabel=new JLabel("Save");

        c2=new Container();
        c2.setLayout(new FlowLayout());
        c2.add(saveButton);
        c2.add(saveLabel);

        submit = new JButton("Submit");

        c3=new Container();
        c3.setLayout(new FlowLayout());
        c3.add(submit);

        bg = new ButtonGroup();
        bg.add(saveButton);
        bg.add(retrieveButton);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(selectOptionHome);
        add(c1);
        add(c2);
        add(c3);
    }
}
