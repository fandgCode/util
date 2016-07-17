/**
 * 
 */
package net.ewide.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex yaohao@gmail.com
 * @date 2011-11-3 下午12:00:01
 * @TODO TODO
 * @version 2.3
 */
public class GenericTokenParser {

	private final String openToken;
	private final String closeToken;
	private final TokenHandler handler;

	public GenericTokenParser(String openToken, String closeToken,
			TokenHandler handler) {
		this.openToken = openToken;
		this.closeToken = closeToken;
		this.handler = handler;
	}

	public String parse(String text) throws Exception {
		StringBuilder builder = new StringBuilder();
		if (text != null) {
			String after = text;
			int start = after.indexOf(openToken);
			int end = after.indexOf(closeToken);
			while (start > -1) {
				if (end > start) {
					String before = after.substring(0, start);
					String content = after.substring(
							start + openToken.length(), end);
					String substitution = handler.handleToken(content);
					builder.append(before);
					builder.append(substitution);
					after = after.substring(end + closeToken.length());
				} else if (end > -1) {
					String before = after.substring(0, end);
					builder.append(before);
					builder.append(closeToken);
					after = after.substring(end + closeToken.length());
				} else {
					break;
				}
				start = after.indexOf(openToken);
				end = after.indexOf(closeToken);
			}
			builder.append(after);
		}
		return builder.toString();
	}

	public int count(String text) throws Exception {
		int count = 0;
		if (text != null) {
			String after = text;
			int start = after.indexOf(openToken);
			int end = after.indexOf(closeToken);
			while (start > -1) {
				if (end > start) {
					String before = after.substring(0, start);
					String content = after.substring(
							start + openToken.length(), end);
					String substitution = handler.handleToken(content);
					after = after.substring(end + closeToken.length());
					count++;
				} else if (end > -1) {
					String before = after.substring(0, end);
					after = after.substring(end + closeToken.length());
				} else {
					break;
				}
				start = after.indexOf(openToken);
				end = after.indexOf(closeToken);
			}
		}
		return count;
	}

	/**
	 * 获取参数名
	 * @param string
	 * @return
	 * @throws Exception 
	 */
	public Object[] getParams(String text) throws Exception {
		List<String> param = new ArrayList<String>();
		if (text != null) {
			String after = text;
			int start = after.indexOf(openToken);
			int end = after.indexOf(closeToken);
			while (start > -1) {
				if (end > start) {
					String before = after.substring(0, start);
					String content = after.substring(
							start + openToken.length(), end);
					String substitution = handler.handleToken(content);
					after = after.substring(end + closeToken.length());
					param.add(content);
				} else if (end > -1) {
					String before = after.substring(0, end);
					after = after.substring(end + closeToken.length());
				} else {
					break;
				}
				start = after.indexOf(openToken);
				end = after.indexOf(closeToken);
			}
		}
		return param.toArray();
	}

}
