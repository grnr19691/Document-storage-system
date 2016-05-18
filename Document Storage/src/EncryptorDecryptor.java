/**
 * Created by grnr1 on 4/10/2016.
 */
public class EncryptorDecryptor implements Encryptor
{
    private int offset;
    private String allowableChars;

    public EncryptorDecryptor(int offset)
    {
        allowableChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-.!,";
        if (offset < 0)
        {
            throw new IllegalArgumentException("key must be positive");
        }
        if (offset >= 60)
        {
            throw new IllegalArgumentException("key must be less than " + allowableChars.length());
        }
        this.offset = offset;
    }

    @Override
    public String encrypt(String plainText)
    {
        String encryptedText = "";
        for(int i=0;i<plainText.length();i++)
        {
            for(int j=0;j<allowableChars.length();j++)
            {
                if(plainText.charAt(i)==allowableChars.charAt(j))
                {
                    encryptedText = encryptedText + allowableChars.charAt((j+offset)%allowableChars.length());
                    break;
                }
                if(j==allowableChars.length()-1)
                {
                    encryptedText = encryptedText + plainText.charAt(i);
                }
            }

        }
        return  encryptedText;
    }

    @Override
    public String decrypt(String encryptedText)
    {
        String plainText = "";
        for(int i=0;i<encryptedText.length();i++)
        {
            for(int j=0;j<allowableChars.length();j++)
            {
                if(encryptedText.charAt(i)==allowableChars.charAt(j))
                {
                    plainText = plainText + allowableChars.charAt((j+(allowableChars.length() - offset))%allowableChars.length());
                    break;
                }
                if(j==allowableChars.length()-1)
                {
                    plainText = plainText + encryptedText.charAt(i);
                }
            }
        }

        return plainText;
    }

    public int getOffset()
    {
        return offset;
    }
}
