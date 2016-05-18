/**
 * Created by grnr1 on 4/10/2016.
 */
public class DocSafeTester
{
    public static void test()
    {
        // Create an instance of an Encryptor with an offset
        Encryptor enc = new EncryptorDecryptor(5);
        // Create an instance of a DocStore
        DocStore  store = new DocStore (enc);
        // Create instances of a Document
        Document doc1 = new Document("D10","This is a test");
        Document doc2 = new Document("DA9","London Eye");
        // Store them in DocStore instance
        store.saveDoc (doc1);
        store.saveDoc (doc2);
        // Retrieve the document with id and display the
        // contents. The contents should be in the encrypted form
        System.out.println(store.getDoc("D10").getContent());
        // Retrieve the document with id and the correct offset and
        // display the contents.
        // The contents should be in the decrypted form
        System.out.println(store.getDoc("D10",5).getContent());
        // Retrieve the document with id and an incorrect offset and
        // display the contents.
        // The contents should be in the encrypted form
        System.out.println(store.getDoc("D10",2).getContent());
        // Try to retrieve the document with an id that does
        // not exist in the store. Should display an error message
        System.out.println(store.getDoc("B67"));
    }
}
