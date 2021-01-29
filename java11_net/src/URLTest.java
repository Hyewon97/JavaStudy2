import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	public URLTest() {
		try {
			//
			URL url = new URL("https://www.nate.com/");
			System.out.println("getProtocol = " + url.getProtocol());
			System.out.println("getHost = "+ url.getHost());
			System.out.println("getPort = " + url.getPort());
			System.out.println("getFile = "+url.getFile());
			System.out.println("getPath = " + url.getPath());
			//URLConnection 객체를 구해 Header의 contentType을 구하면 한글 코드를 알아낼수 있다.
			URLConnection con = url.openConnection();
			con.connect(); //header 정보를 얻기전에 통신채널을 확보하다.
			
			//Header의 contentType 가져오기
			String contentType = con.getContentType();
			System.out.println("ContentType = "+ contentType);
			
			String encode = contentType.substring(contentType.indexOf("=")+1);
			System.out.println("substring = " + encode);
//			String encode2[] = contentType.split("=");
//			System.out.println("split = " + encode2[1]);
			
			//url 객체를 통해 리소스 가져오기
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while(true) {
				String inData = br.readLine();
				if(inData ==null)break;
				System.out.println(inData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new URLTest();
	}
}
