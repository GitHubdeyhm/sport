package com.sport.util.file;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Scanner;

/**
 * IO工具类
 * @Date 2016-10-23下午2:44:45
 */
public class IOUtil {

	private static final Logger log = Logger.getLogger(IOUtil.class);

	/**
	 * 从一个输入流中读取字符内容，常用于从httpclient中获取响应内容文本。
	 * @param in 输入流
	 * @return 字符内容
	 */
	public static String getStreamContent(InputStream in) {
		if (in == null) return null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		try {
			String content = "";
			while ((content = br.readLine()) != null) {
				sb.append(content);
			}
		} catch (IOException e) {
			log.error(e);
		} finally {
			safeClose(br);
		}
		return sb.toString();
	}
	
	/**
	 * 安全关闭流的简便方法。
	 * @Date 2017-08-20 14:06
	 */
	public static void safeClose(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 实现重定向输出流到一个文件，默认输出是屏幕，输入是键盘
	 * @Date 2016-10-23下午2:58:22
	 * @throws IOException
	 */
	public static void redirectOut() {
		try (FileOutputStream fos = new FileOutputStream("out.txt");
				PrintStream ps = new PrintStream(fos)
		) {
			System.setOut(ps);//重定向输出流到一个文件
			System.out.println("重定向流到文件");
			System.out.println(new IOUtil());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 实现重定向输入流为一个文件，默认输出是屏幕，输入是键盘
	 * @Date 2016-10-23下午3:02:53
	 * @throws IOException
	 */
	public static void redirectIn() throws IOException {
		try (
				FileInputStream fis = new FileInputStream("test.txt"))
		{
			System.setIn(fis);//重定向输入流为一个文件
			Scanner sc = new Scanner(System.in);
			sc.useDelimiter("\n");
			while (sc.hasNext()) {
				System.out.println(sc.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		//redirectOut();
//		redirectIn();

//		System.out.println("".equals(new StringBuilder().toString()));
	}

}
