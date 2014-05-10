import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class Test {
	public static void main(String[] args) throws Exception {

		String uri = "http://localhost:8080";
		HttpClient client = new HttpClient();
		HttpMethod method = new PostMethod(uri);

		int code = client.executeMethod(method);
		String body = new String(method.getResponseBody());
		System.out.println(code);
		System.out.println(body);
	}
}
