package com.kf5.support.internet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.kf5.support.model.MessageStatus;
import com.kf5.support.model.StatusCode;
import com.kf5.support.model.builder.KF5EntityBuilder;

public class HttpRequest {

	/**
	 * GET请求
	 * @param url 请求地址
	 * @param baseToken basic验证码
	 * @return
	 */
	public static MessageStatus sendGetRequest(String url,String baseToken){

		MessageStatus messageStatus = new MessageStatus();
		HttpURLConnection connection = null;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			connection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestMethod("GET");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("Content-Type","application/json");
			connection.setDoOutput(true );
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setConnectTimeout(10*1000);
			connection.setRequestProperty("Authorization", "Basic "+baseToken);

			// 建立实际的连接
			connection.connect();
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				messageStatus.setStatus(StatusCode.OK);
				messageStatus.setJsonObject(KF5EntityBuilder.safeObject(getInputStream(connection.getInputStream())));
			} else {
				messageStatus.setStatus(connection.getResponseCode());
				messageStatus.setJsonObject(KF5EntityBuilder.safeObject(getInputStream(connection.getErrorStream())));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if (connection != null) {
				connection.disconnect();
			}
		}
		
//		System.out.println(messageStatus.getJsonObject().toString());
		
		return messageStatus;
	}


	/**
	 * DELETE请求方式
	 * @param url 请求地址
	 * @param baseToken basic验证码
	 * @return
	 */
	public static MessageStatus sendDeleteRequest(String url,String baseToken){

		MessageStatus messageStatus = new MessageStatus();
		HttpURLConnection connection = null;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			connection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestMethod("DELETE");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("Content-Type","application/json");
			connection.setDoOutput(true );
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setConnectTimeout(10*1000);
			connection.setRequestProperty("Authorization", "Basic "+baseToken);
			// 建立实际的连接
			connection.connect();
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				messageStatus.setStatus(StatusCode.OK);
				messageStatus.setJsonObject(KF5EntityBuilder.safeObject(getInputStream(connection.getInputStream())));
			} else {
				messageStatus.setStatus(connection.getResponseCode());
				messageStatus.setJsonObject(KF5EntityBuilder.safeObject(getInputStream(connection.getErrorStream())));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if (connection != null) {
				connection.disconnect();
			}
		}
		return messageStatus;
	}



	/**
	 * POST请求方式
	 * @param url 请求地址
	 * @param baseToken basic验证码
	 * @param param 提交参数，参数格式为json格式
	 * @return
	 */
	public static MessageStatus sendPostRequest(String url,String baseToken,String param) {

		MessageStatus messageStatus = new MessageStatus();
		DataOutputStream out = null;
		HttpURLConnection connection = null;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			connection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestMethod("POST");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("Content-Type","application/json");
			connection.setDoOutput(true );
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setConnectTimeout(10*1000);
			connection.setRequestProperty("Authorization", "Basic "+baseToken);
			// 建立实际的连接
			connection.connect();
			out = new DataOutputStream(connection.getOutputStream());
			out.write(param.getBytes("utf-8"));
			out.flush();
			out.close();
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK ||connection.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
				messageStatus.setStatus(StatusCode.OK);
				messageStatus.setJsonObject(KF5EntityBuilder.safeObject(getInputStream(connection.getInputStream())));
			} else {
				messageStatus.setStatus(connection.getResponseCode());
				messageStatus.setJsonObject(KF5EntityBuilder.safeObject(getInputStream(connection.getErrorStream())));
			}
			System.out.println(messageStatus.getJsonObject().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (connection != null) {
					connection.disconnect();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return messageStatus;
	}



	/**
	 * PUT请求当时
	 * @param url 请求地址
	 * @param baseToken basic验证码
	 * @param param 提交参数，参数格式为json格式
	 * @return
	 */
	public static MessageStatus sendPutRequest(String url,String baseToken,String param) {

		MessageStatus messageStatus = new MessageStatus();
		DataOutputStream out = null;
		HttpURLConnection connection = null;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			connection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("Content-Type","application/json");
			connection.setDoOutput(true );
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setConnectTimeout(10*1000);
			connection.setRequestProperty("Authorization", "Basic "+baseToken);
			// 建立实际的连接
			connection.connect();
			out = new DataOutputStream(connection.getOutputStream());
			out.write(param.getBytes("utf-8"));
			out.flush();
			out.close();
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				messageStatus.setStatus(StatusCode.OK);
				messageStatus.setJsonObject(KF5EntityBuilder.safeObject(getInputStream(connection.getInputStream())));
			} else {
				messageStatus.setStatus(connection.getResponseCode());
				messageStatus.setJsonObject(KF5EntityBuilder.safeObject(getInputStream(connection.getErrorStream())));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (connection != null) {
					connection.disconnect();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return messageStatus;
	}

	private static String getInputStream(InputStream stream) {
		if (stream == null) {
			return null;
		}

		StringBuffer sb = new StringBuffer();
		String line;
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(stream,
					"utf-8"));
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}
			bufferedReader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 附件上传
	 * @param url 上传附件地址
	 * @param file 需要上传的文件
	 * @param baseToken basic验证码
	 * @return
	 * @throws IOException 异常处理
	 */
	public static String uploadAttachment(String url, File file,String baseToken) throws IOException {

		String BOUNDARY = java.util.UUID.randomUUID().toString();
		String PREFIX = "--", LINEND = "\r\n";

		URL uri = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
		conn.setReadTimeout(10 * 1000); // 缓存的最长时间
		conn.setDoInput(true);// 允许输入
		conn.setDoOutput(true);// 允许输出
		conn.setUseCaches(false); // 不允许使用缓存
		conn.setRequestMethod("POST");
		conn.setRequestProperty("connection", "keep-alive");
		conn.setRequestProperty("Charsert", "UTF-8");
		conn.setRequestProperty("Content-Type", "application/binary");
		conn.setRequestProperty("Authorization", "Basic "+baseToken);
		DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
		/**
		 * 写入附件数据
		 */
		if (file != null){
			InputStream is = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				outStream.write(buffer, 0, len);
			}
			is.close();
			outStream.write(LINEND.getBytes());
		}

		// 请求结束标志
		byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINEND).getBytes();
		outStream.write(end_data);
		outStream.flush();
		// 得到响应码
		int res = conn.getResponseCode();
		String result = "";
		if (res == HttpURLConnection.HTTP_OK || res == HttpURLConnection.HTTP_CREATED) {
			result = getInputStream(conn.getInputStream());
		}else {
			result = getInputStream(conn.getErrorStream());
		}
		outStream.close();
		conn.disconnect();
		return result;
	}



}
