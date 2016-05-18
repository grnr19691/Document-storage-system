import javax.swing.*;
import java.awt.*;

/**
 * Created by grnr1 on 5/18/2016.
 */
public class OneTimeSetEncryptor extends JPanel
{
    JLabel encryptorLabel;
    JTextField encyptorTextField;
    Container c7;
    JButton submit;
    Container c8;
    public OneTimeSetEncryptor()
    {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        encryptorLabel=new JLabel("Enter encrptor value");
        encyptorTextField=new JTextField();
        encyptorTextField.setColumns(20);
        c7=new Container();
        c7.setLayout(new FlowLayout());
        c7.add(encryptorLabel);
        c7.add(encyptorTextField);
        add(c7);

        submit = new JButton("Submit");
        c8 = new Container();
        c8.setLayout(new FlowLayout());
        c8.add(submit);
        add(c8);

    }
}
