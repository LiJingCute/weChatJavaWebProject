package cn.lijingCute.util;

import cn.lijingCute.entity.Button;
import cn.lijingCute.entity.ClickButton;
import cn.lijingCute.entity.PhotoOrAlbumButton;
import cn.lijingCute.entity.SubButton;
import cn.lijingCute.entity.ViewButton;
import net.sf.json.JSONObject;
import cn.lijingCute.service.WxService;

public class CreateMenu {

	public static void main(String[] args) {
		//菜单对象
		Button btn = new Button();
		//第一个一级菜单
		btn.getButton().add(new ClickButton("点击菜单", "1"));
		//第二个一级菜单
		btn.getButton().add(new ViewButton("点击跳转", "http://www.baidu.com"));
		//创建第三个一级菜单
		SubButton sb = new SubButton("点击出现子菜单");
		//为第三个一级菜单增加子菜单
		sb.getSub_button().add(new PhotoOrAlbumButton("传图", "31"));
		sb.getSub_button().add(new ClickButton("点击", "32"));
		sb.getSub_button().add(new ViewButton("网易新闻", "http://news.163.com"));
		//加入第三个一级菜单
		btn.getButton().add(sb);
		//转为json
		JSONObject jsonObject = JSONObject.fromObject(btn);
		//准备url
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", WxService.getAccessToken());
		//发送请求
		String result = Util.post(url, jsonObject.toString());
		System.out.println(result);
		
	}
	
}
