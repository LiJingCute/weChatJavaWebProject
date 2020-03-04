package cn.lijingCute.manager;


import org.junit.Test;

import cn.lijingCute.service.WxService;
import cn.lijingCute.util.Util;

public class TemplateMessageManager {
	
	/**
	 * 设置行业
	 */
	@Test
	public void set() {
		String at = WxService.getAccessToken();
		String url="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token="+at;
		String data="{\n" + 
				"          \"industry_id1\":\"1\",\n" + 
				"          \"industry_id2\":\"4\"\n" + 
				"       }";
		String result = Util.post(url, data);
		System.out.println(result);
	}
	
	/**
	 * 获取行业
	 */
	@Test
	public void get() {
		String at = WxService.getAccessToken();
		String url="https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token="+at;
		String result = Util.get(url);
		System.out.println(result);
	}
	
	/**
	 * 发送模板消息
	 */
	@Test
	public void sendTemplateMessage() {
		String at = WxService.getAccessToken();
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+at;
		String data="{\n" + 
				"           \"touser\":\"oEmP3vm8jWeg875M2p-eknt5HPj8\",\n" + 
				"           \"template_id\":\"P5uLRraltasI25g8rRXu7qPOWVc90CziX4Ub513OQeg\",         \n" + 
				"           \"data\":{\n" + 
				"                   \"first\": {\n" + 
				"                       \"value\":\"您有新的反馈信息啦！\",\n" + 
				"                       \"color\":\"#abcdef\"\n" + 
				"                   },\n" + 
				"                   \"company\":{\n" + 
				"                       \"value\":\"Lijing未来的公司\",\n" + 
				"                       \"color\":\"#fff000\"\n" + 
				"                   },\n" + 
				"                   \"time\": {\n" + 
				"                       \"value\":\"2020年3月4日\",\n" + 
				"                       \"color\":\"#1f1f1f\"\n" + 
				"                   },\n" + 
				"                   \"result\": {\n" + 
				"                       \"value\":\"一切顺顺利利\",\n" + 
				"                       \"color\":\"#173177\"\n" + 
				"                   },\n" + 
				"                   \"remark\":{\n" + 
				"                       \"value\":\"请和Lijing联系哦\",\n" + 
				"                       \"color\":\"#173177\"\n" + 
				"                   }\n" + 
				"           }\n" + 
				"       }";
		String result = Util.post(url, data);
		System.out.println(result);
	}

}
