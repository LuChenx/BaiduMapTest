
package com.lcx.baidumap.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author luchenxi
 *
 */
public class HttpClientHolder
{
	public static JSONObject Get(String url)
	{
		try
		{
			String content = "";
			CloseableHttpClient httpClient = HttpClients.createDefault();
			CloseableHttpResponse response = null;
			InputStream is = null;
			JSONObject json = new JSONObject();
			//创建Get请求  
			HttpGet httpGet = new HttpGet(url);
			//执行Get请求，  
			response = httpClient.execute(httpGet);
			//得到响应体  
			HttpEntity entity = response.getEntity();
			if(entity != null)
			{
				is = entity.getContent();
				//转换为字节输入流  
				BufferedReader br = new BufferedReader(new InputStreamReader(is, Consts.UTF_8));
				String body = null;
				while((body = br.readLine()) != null)
				{
					content = content + body;
				}
			}
			return JSONObject.parseObject(content);
		}
		catch (Exception e)
		{
			System.err.println("GET请求失败");
			e.printStackTrace();
			return null;
		}
	}
}
