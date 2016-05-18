import javax.swing.*;
import java.io.IOError;
import java.io.IOException;

/**
 * Created by grnr1 on 4/10/2016.
 */
public class DocStore
{
    private Document store[];
    private int capacity=50;
    private Encryptor encryptor;
    public DocStore(Encryptor enc)
    {
        store=new Document[capacity];
        encryptor = enc;
    }
    public void saveDoc(Document doc)
    {
        for(int i=0;i<store.length;i++)
        {
            if(doc.getDocumentId().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Filename cannot be empty");
                return;
            }
            if(store[i]==null)
            {
                store[i]=doc;
                return;
            }
            if(doc.getDocumentId().equals(store[i].getDocumentId()))
            {
                JOptionPane.showMessageDialog(null, "Sorry, Filename already exists.Cannot overwrite");
                return;
            }

        }
        JOptionPane.showMessageDialog(null, "Sorry, the capacity of DocStore is already full. Cannot store this document.");

    }
    public Document getDoc(String id)
    {
        for(int i=0;i<store.length;i++)
        {
            if(store[i]==null)
            {
                continue;
            }
            if(store[i].getDocumentId().equals(id))
            {
                return new Document(id, encryptor.encrypt(store[i].getContent()));
            }
        }
        JOptionPane.showMessageDialog(null, "The requested id is not found in this DocStore");
        return null;
    }
    public Document getDoc(String id,int key)
    {
        Document returnDoc = getDoc(id);
        if(returnDoc==null)
        {
            return returnDoc;
        }
        Encryptor tempEncryptor= new EncryptorDecryptor(key);
        if(tempEncryptor.decrypt(returnDoc.getContent()).equals(encryptor.decrypt(returnDoc.getContent())))
        {
            return new Document(id, encryptor.decrypt(returnDoc.getContent()));
        }
        return returnDoc;
    }

}
