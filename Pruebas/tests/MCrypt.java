import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
//import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/** Encrypt / Decrypt Between Android, PC-JAVA and PHP and vice-versa
 * https://github.com/serpro/Android-PHP-Encrypt-Decrypt
 * https://github.com/MiichaelD/Android-PHP-Encrypt-Decrypt*/
public class MCrypt {        

	private boolean pEncrypt = true;
    private int keyIndex = 0;

    //prefix indicating the algorithm used
    public static String AES_PREF = "AES ";
    public static int MAIN_IND = 0, FIN_GAM_IND = 1, WON_GAM_IND = 2, APP_OPEN_IND = 3, BEST_STREAK_IND = 4;
    
    private String SecretKeys[] = {"COLORIZEDAES0814","COLORIZEDAES0148","COLORIZEDAES1408","COLORIZEDAES1084","COLORIZEDAES0184"};
    //private String iv = "AES0814DEZIROLOC";

    //private IvParameterSpec ivspec;
    private SecretKeySpec keyspec[];
    private Cipher cipher;
    
    private String charset = "UTF8";

    private static MCrypt pInstance	= null;
    
    public static MCrypt getIns(){
    	if(pInstance == null)
    		pInstance = new MCrypt();
    	return pInstance;
    }
    
    public static void delIns(){
    	//let garbage collector do it's job
    	pInstance = null;
    }
    
    public MCrypt(){
        try {
        	keyIndex = MAIN_IND;
        	//ivspec = new IvParameterSpec(iv.getBytes("charset"));
        	keyspec = new SecretKeySpec[SecretKeys.length];
        	for(int i=0;i<SecretKeys.length;i++){
                keyspec[i] = new SecretKeySpec(SecretKeys[i].getBytes(charset), "AES");
        	}
        	cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
    		pEncrypt = false;
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
        	pEncrypt = false;
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
        	//ivspec = new IvParameterSpec(iv.getBytes());
        	for(int i=0;i<SecretKeys.length;i++){
                keyspec[i] = new SecretKeySpec(SecretKeys[i].getBytes(), "AES");
        	}
			e.printStackTrace();
		}
    }
    
    /** Choose what index to use*/
    public void setSecretKeyIndex(int index){
    	if (index < 0 || index >= SecretKeys.length)
    		keyIndex = MAIN_IND;
    	else
    		keyIndex = index;
    }
    
    public void resetSecretKeyIndex(){
    	keyIndex = MAIN_IND;
    }

    public byte[] encrypt(byte[] text){
        if(!pEncrypt)
        	return text;
        
        byte[] encrypted = null;
        try {
        	if(text == null || text.length == 0)
                throw new Exception("Empty string");

            cipher.init(Cipher.ENCRYPT_MODE, keyspec[keyIndex]/*, ivspec*/);
            encrypted = cipher.doFinal(text);
        } catch (Exception e){
        	//TODO remove for release
            e.printStackTrace();
        }
        return encrypted;
    }

    public byte[] decrypt(byte[] code){
    	if(!pEncrypt)
        	return code;
    	
        byte[] decrypted = null;
        try {
            if(code == null || code.length == 0)
            	throw new Exception("Empty string");

            cipher.init(Cipher.DECRYPT_MODE, keyspec[keyIndex]/*, ivspec*/);

            decrypted = cipher.doFinal(code);
        } catch (Exception e){
        	//TODO remove for release
            e.printStackTrace();
        }
        return decrypted;
    }
    
    public byte[] encrypt(String text){
    	try{
    		return encrypt(text.getBytes(charset));
    	}catch(UnsupportedEncodingException e){
    		return encrypt(text.getBytes());
    	}
    }
    
    public byte[] decrypt(String code){
    	try{
    		return decrypt(code.getBytes(charset));
    	}catch(UnsupportedEncodingException e){
    		return decrypt(code.getBytes());
    	}
    }
    
    public static void main(String[] args){
    	test();
    }

    
    public static void test(){
		try {
			MCrypt mc= new MCrypt();
			
			byte[] arr=mc.SecretKeys[0].getBytes();
    		System.out.println("bits:"+8*arr.length);
    	
			
			// String toEncode = "AES:21 12 3 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 5 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 5 2 1 1 1 1 1 1 1 4 1 1 0 2";
            String toEncode = "key_last_new_board";
			System.out.println("toEncode: "+toEncode);
			System.out.println("toEncode: "+byteArrayToHexString(toEncode.getBytes()));
			
			byte[] encrypted = mc.encrypt(toEncode);
			System.out.println("encrypted: "+byteArrayToHexString(encrypted));
			
			byte[] decrypted = mc.decrypt(encrypted);
			System.out.println("decrypted: "+byteArrayToHexString(decrypted));
			System.out.println("decrypted: "+new String(decrypted));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }



    //////////////////

    /** For HEXStrings <-> ByteArrays conversions*/
    private final static char[] hexChars={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    /** Return a HEX String generated from the byte array*/
    public static String byteArrayToHexString(byte[] toHex) {       
        StringBuilder hexString = new StringBuilder();
        for (byte b:toHex) {
            hexString.append(byteToHexString(b));
        }
        return hexString.toString();
    }

    /** Append string representation of a byte*/
    private static String byteToHexString(byte b) {
        int unsigned_byte = b < 0 ? b + 256 : b;
        int hi = unsigned_byte / 16;
        int lo = unsigned_byte % 16;
        return String.format("%c%c", hexChars[hi],hexChars[lo]);
    }
    
    /** Return a new String from the byte array*/
    public static byte[] HexStringToByte(String in) {
        int len = in.length();
        if(len < 2) 
            return null;
        
        byte[] ret = new byte[len/2];
        
        for(int i =0;i<len;i+=2){
            ret[i/2] = (byte)(charToByte(in.charAt(i))<<4 | charToByte(in.charAt(i+1)));
        }
        
        return ret;
    }
    
    /** Return half byte (4bits) value from a HEXADECIMAL char*/
    private static byte charToByte(char c){
        switch(c){
        case '0':       case '1':       case '2':
        case '3':       case '4':       case '5':
        case '6':       case '7':       case '8':
        case '9':
            return (byte)(c-'0');
        case 'A':
            return 10;
        case 'B':
            return 11;
        case 'C':
            return 12;
        case 'D':
            return 13;
        case 'E':
            return 14;
        case 'F':
            return 15;
        default:
            return 0;
        }
    }
}
