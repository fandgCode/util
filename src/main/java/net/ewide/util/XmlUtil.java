/**
 * Project Name:util
 * File Name:XmlUtil.java
 * Package Name:com.ctp.util
 * Date:2014-5-9下午1:57:32
 *
*/

package net.ewide.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

/**
 * ClassName:XmlUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016-5-9 下午1:57:32 <br/>
 * @author   Alex(yaohao@gmail.com)
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class XmlUtil {

	private static Map<String, Document> xmls = new HashMap<String,Document>();
	/**
	 * document:xml文档跟.
	 * @since JDK 1.6
	 */
	private Document document;

	/**
	 * Creates a new instance of ConfigUtil.
	 * 
	 * @param fileName
	 */
	private XmlUtil(String fileName) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();   
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			if(is==null){
				is=this.getClass().getResourceAsStream(fileName);
			}
			document = db.parse(is);
		} catch (Exception e) {
			System.out.println(fileName + "文件加载失败!");
		}
	}

	public static Document getDocuments(String fileName) {
		if (xmls.get(fileName) == null) {
			XmlUtil util = new XmlUtil(fileName);
			xmls.put(fileName, util.getDocument());
		}
		return xmls.get(fileName);
	}

	/**
	 * document.
	 *
	 * @return  the document
	 * @since   JDK 1.6
	 */
	public Document getDocument() {
		return document;
	}

	/**
	 * document.
	 *
	 * @param   document    the document to set
	 * @since   JDK 1.6
	 */
	public void setDocument(Document document) {
		this.document = document;
	}
	
	


}

