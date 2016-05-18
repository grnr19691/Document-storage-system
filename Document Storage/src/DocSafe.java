import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by grnr1 on 4/10/2016.
 */
public class DocSafe
{


    public static void main(String args[])
    {
        EncryptorDecryptor enc[]=new EncryptorDecryptor[1];
        enc[0] = new EncryptorDecryptor(0);
        DocStore store[] = new DocStore[1];

        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setTitle("DocSafe: A secure document storage system\n");
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        OneTimeSetEncryptor mainPage = new OneTimeSetEncryptor();

        RetrieveDocPanel getDocument=new RetrieveDocPanel();


        SaveDocPanel setDocument = new SaveDocPanel();

        HomePanel home=new HomePanel();


        mainPage.submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!mainPage.encyptorTextField.getText().equals(""))
                {


                        try
                        {
                            enc[0] = new EncryptorDecryptor(Integer.parseInt(mainPage.encyptorTextField.getText()));

                        }
                        catch (Exception E)
                        {
                            JOptionPane.showMessageDialog(null, "Enter a positive and correct value");
                            return;
                        }

                    store[0]=new DocStore(enc[0]);
                }
                frame.remove(mainPage);
                frame.add(home);
                frame.pack();
            }
        });


        store[0] = new DocStore (enc[0]);

        home.submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.remove(home);
                if(home.saveButton.isSelected())
                {
                    setDocument.setgetDocText.setText("");
                    setDocument.setgetStringDocText.setText("");
                    frame.add(setDocument);
                }
                else if(home.retrieveButton.isSelected())
                {
                    getDocument.getDocText.setText("");
                    getDocument.getEncryptorDocText.setText("");
                    frame.add(getDocument);
                }
                else
                {
                    home.saveButton.setSelected(false);
                    home.retrieveButton.setSelected(false);
                    frame.add(home);
                }
                frame.pack();
            }
        });

        getDocument.cancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                getDocument.getDoc.setText("");
                frame.remove(getDocument);
                frame.add(home);
                frame.pack();
            }
        });

        setDocument.setcancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.remove(setDocument);
                frame.add(home);
                frame.pack();
            }
        });


        getDocument.getSubmit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String docText;
                    if (getDocument.getEncryptorDocText.getText().equals(""))
                    {
                        docText = store[0].getDoc(getDocument.getDocText.getText()).getContent();

                    } else
                    {
                        docText = store[0].getDoc(getDocument.getDocText.getText(), Integer.parseInt(getDocument.getEncryptorDocText.getText())).getContent();
                    }
                    getDocument.getDoc.setText(docText);
                    frame.add(getDocument);

                }
                catch (Exception E)
                {

                }
            }
        });

        setDocument.setgetSubmit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Document doc = new Document(setDocument.setgetDocText.getText(),setDocument.setgetStringDocText.getText());
                store[0].saveDoc(doc);

                frame.remove(setDocument);
                frame.add(home);
                frame.pack();
            }
        });

        frame.add(mainPage);
        //frame.add(getDocument);
        frame.pack();

        frame.setVisible(true);

    }
}
