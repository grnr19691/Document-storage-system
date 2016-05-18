/**
 * Created by grnr1 on 4/10/2016.
 */
public class Document
{
    private String documentId;
    private String content;
    public Document(String documentId,String content)
    {
        this.documentId = documentId;
        this.content = content;
    }
    public String getContent()
    {
        return  content;
    }
    public String getDocumentId()
    {
        return documentId;
    }
}
