package net.ewide.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.ewide.util.JsonUtil;

import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 * ClassName: PostUtil <br/>
 * Function: post请求公用类. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2014-3-27 下午4:52:37 <br/>
 *
 * @author Alex
 * @version
 * @since JDK 1.6
 */
public class PostUtil {

	/**
	 * invoker:(这里用一句话描述这个方法的作用). <br/>
	 * 
	 * @author Alex
	 * @param url
	 * @param param
	 * @return
	 * @throws Exception
	 * @since JDK 1.6
	 */
	public static String invoker(String url, String body)
			throws Exception {
		String returnStr = null;
		HttpPost post = new HttpPost(url);
		StringEntity entity = new StringEntity(body,"UTF-8");
		post.setEntity(entity);
		CloseableHttpClient httpclient = null;
		httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		//执行
		response = httpclient.execute(post);
		
		if (response.getStatusLine().getStatusCode() == 404
				|| response.getStatusLine().getStatusCode() == 500) {
			if (response != null) {
				response.close();
			}
			returnStr = "";
			
		} else {
			StringBuffer sb = new StringBuffer();
			List<String> repondStrings = IOUtils.readLines(response.getEntity().getContent(), "UTF-8");
			for (Iterator iterator = repondStrings.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				sb.append(string);
			}
			returnStr = sb.toString();
		}
		if (response != null) {
			response.close();
		}
		return returnStr;
	}
	
	public static String invoker(String url, Map<String, String> param)
			throws Exception {
		String returnStr = null;
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for (Iterator<String> iterator = param.keySet().iterator(); iterator
				.hasNext();) {
			String key = iterator.next();
			String value = param.get(key);
			params.add(new BasicNameValuePair(key, value));
		}
		HttpPost post = new HttpPost(url);
		post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		
		CloseableHttpClient httpclient = null;
		httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		//执行
		response = httpclient.execute(post);
		
		if (response.getStatusLine().getStatusCode() == 404
				|| response.getStatusLine().getStatusCode() == 500) {
			if (response != null) {
				response.close();
			}
			returnStr = "";
			
		} else {
			StringBuffer sb = new StringBuffer();
			List<String> repondStrings = IOUtils.readLines(response.getEntity().getContent(), "UTF-8");
			for (Iterator iterator = repondStrings.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				sb.append(string);
			}
			returnStr = sb.toString();
		}
		if (response != null) {
			response.close();
		}
		return returnStr;
	}

	public static void main(String[] args) throws Exception {
//		String url = "http://192.168.1.223:8888/SyncTimeService";
			String url = "http://192.168.1.223:10010/cs/login.do";
		Map param = new HashMap();
		param.put("collAddr", "4403000124");
//		param.put("target", "SITE");
//		param.put("username", "test");
//		param.put("desc", "test");
		System.out.println(PostUtil.invoker(url, JsonUtil.writeObject(param)));
	}

}
