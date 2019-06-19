package Utilities;

public class RandomStringGeneratorUtil {
	
	
	public static String RandomString()
	{
		String stringValue="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
		StringBuffer stringbuffer = null;
		try {
			
			stringbuffer=new StringBuffer(10);
			
			for(int i=0;i<10;i++)
			{
				int index=(int)(stringValue.length()*Math.random());
				stringbuffer.append(stringValue.charAt(index));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringbuffer.toString()+"@gmail.com";
	}
	
	public static String RandomFnameString()
	{
		String stringValue="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
		StringBuffer stringbuffer = null;
		try {
			
			stringbuffer=new StringBuffer(5);
			
			for(int i=0;i<5;i++)
			{
				int index=(int)(stringValue.length()*Math.random());
				stringbuffer.append(stringValue.charAt(index));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringbuffer.toString();
	}
	
	public static String RandomLnameString()
	{
		String stringValue="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
		StringBuffer stringbuffer = null;
		try {
			
			stringbuffer=new StringBuffer(5);
			
			for(int i=0;i<5;i++)
			{
				int index=(int)(stringValue.length()*Math.random());
				stringbuffer.append(stringValue.charAt(index));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringbuffer.toString();
	}
	
	public static String RandomMnameString()
	{
		String stringValue="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
		StringBuffer stringbuffer = null;
		try {
			
			stringbuffer=new StringBuffer(5);
			
			for(int i=0;i<5;i++)
			{
				int index=(int)(stringValue.length()*Math.random());
				stringbuffer.append(stringValue.charAt(index));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringbuffer.toString();
	}

}
