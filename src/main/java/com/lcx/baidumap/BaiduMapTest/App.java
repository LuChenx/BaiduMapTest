
package com.lcx.baidumap.BaiduMapTest;

import java.util.Scanner;

import com.alibaba.fastjson.JSONObject;
import com.lcx.baidumap.util.HttpClientHolder;

/**
 * Hello world!
 *
 */
public class App
{
	static String url = "http://api.map.baidu.com/place/v2/search?output=json&ak=4jD7IBQyd0XreejHAFLSD4Z8fUzf3hZS";

	public static void main(String[] args)
	{
		System.out.print("请输入城市：");
		try
		{
			Scanner scanner = new Scanner(System.in);
			String city = scanner.nextLine();
			url = url + "&region=" + city;
			System.out.print("请输入详细地址：");
			String address = scanner.nextLine();
			url = url + "&query=" + address;
			System.out.println("url:" + url);
			//发送http请求获取JSON格式返回值
			JSONObject jsonObject = HttpClientHolder.Get(url);
			System.out.println(jsonObject.toJSONString());
		}
		catch (Exception e)
		{
			System.err.println("经纬度获取失败");
			e.printStackTrace();
		}
	}
}
