/*
 * (#)ParameterParser.java 1.0 2011-11-15 2011-11-15 
 */
package net.ewide.util;

import java.util.Map;
import java.util.Properties;

/**
 * @author Alex  yaohao@gmail.com
 * @version $2.3, 2011-11-15 下午4:13:38
 * @since JDK1.6
 * sql关于#{}字符的转换工作
 */
public class ParameterParser {
	
	/**
	 * parse:符号解析. <br/>
	 * @author Alex(yaohao@gmail.com)
	 * @param string 需要解析的字符串
	 * @param variables 解析字符串中的参数
	 * @param startSymbol 开始符号
	 * @param endSymbol 结束符号
	 * @return
	 * @throws Exception
	 * @since JDK 1.6
	 */
	public static String parse(String string, Properties variables,String startSymbol,String endSymbol) throws Exception {
		VariableTokenHandler handler = new VariableTokenHandler(variables);
		GenericTokenParser parser = new GenericTokenParser(startSymbol, endSymbol, handler);
		return parser.parse(string);
	}

	private static class VariableTokenHandler implements TokenHandler {
		private Properties variables;

		public VariableTokenHandler(Properties variables) {
			this.variables = variables;
		}

		public String handleToken(String content) {
			if (variables != null && variables.containsKey(content)) {
				return variables == null ? content : variables
						.getProperty(content);
			} else {
				return "${" + content + "}";
			}
		}
	}
	
	
	/**
	 * parse:符号解析. <br/>
	 * @author Alex(yaohao@gmail.com)
	 * @param string 需要解析的字符串
	 * @param variables 解析字符串中的参数
	 * @param startSymbol 开始符号
	 * @param endSymbol 结束符号
	 * @return
	 * @throws Exception
	 * @since JDK 1.6
	 */
	public static String parse(String string, Map variables,String startSymbol,String endSymbol) throws Exception {
		VariableTokenHandlerMap handler = new VariableTokenHandlerMap(variables);
		GenericTokenParser parser = new GenericTokenParser(startSymbol, endSymbol, handler);
		return parser.parse(string);
	}

	private static class VariableTokenHandlerMap implements TokenHandler {
		private Map variables;

		public VariableTokenHandlerMap(Map variables) {
			this.variables = variables;
		}

		public String handleToken(String content) {
			if (variables != null && variables.containsKey(content)) {
				return (String) (variables == null ? content : variables.get(content));
//						.getProperty(content);
			} else {
				return "${" + content + "}";
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		p.put("code", "a");
		p.put("name", "b");
		p.put("b1", "c");
		p.put("b2", "d");
		System.out.println(ParameterParser.parse("(#{code},#{name},#{b1},#{b2},#{b3},#{b4},#{b5},#{b6},#{b7},#{b8},#{b9},#{b10},#{createDate},#{createEmp},#{lastUpdateDate},#{updateEmp},#{cs},#{cv},#{sortIndex})", p,"#{","}"));
		
	}
	
}
