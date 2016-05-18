import javax.swing.*;
import java.awt.*;

/**
 * Created by grnr1 on 5/18/2016.
 */
public class RetrieveDocPanel extends JPanel
{
    JLabel enterNameLabel;
    JTextField getDocText;
    JLabel enterEncryptorLabel;
    JTextField getEncryptorDocText;
    Container c4;
    Container c5;
    Container c6;
    JButton getSubmit;
    JButton cancel;
    JTextArea getDoc;
    public RetrieveDocPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        enterNameLabel=new JLabel("Enter file name");
        getDocText=new JTextField();
        getDocText.setColumns(20);
        c4=new Container();
        c4.setLayout(new FlowLayout());
        c4.add(enterNameLabel);
        c4.add(getDocText);
        add(c4);

        enterEncryptorLabel=new JLabel("Enter encryptor value");
        getEncryptorDocText=new JTextField();
        getEncryptorDocText.setColumns(20);
        c5=new Container();
        c5.setLayout(new FlowLayout());
        c5.add(enterEncryptorLabel);
        c5.add(getEncryptorDocText);
        add(c5);

        getSubmit=new JButton("Submit");
        cancel=new JButton("Cancel");
        Container c6=new Container();
        c6.setLayout(new FlowLayout());

        c6.add(getSubmit);
        c6.add(cancel);
        add(c6);

        getDoc=new JTextArea(3,20);
        getDoc.setEditable(false);
        Container c7=new Container();
        c7.setLayout(new FlowLayout());

        c7.add(getDoc);
        add(c7);
    }
}
