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
		//�˵�����
		Button btn = new Button();
		//��һ��һ���˵�
		btn.getButton().add(new ClickButton("һ�����", "1"));
		//�ڶ���һ���˵�
		btn.getButton().add(new ViewButton("һ����ת", "http://www.baidu.com"));
		//����������һ���˵�
		SubButton sb = new SubButton("���Ӳ˵�");
		//Ϊ������һ���˵������Ӳ˵�
		sb.getSub_button().add(new PhotoOrAlbumButton("��ͼ", "31"));
		sb.getSub_button().add(new ClickButton("���", "32"));
		sb.getSub_button().add(new ViewButton("��������", "http://news.163.com"));
		//���������һ���˵�
		btn.getButton().add(sb);
		//תΪjson
		JSONObject jsonObject = JSONObject.fromObject(btn);
		//׼��url
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", WxService.getAccessToken());
		//��������
		String result = Util.post(url, jsonObject.toString());
		System.out.println(result);
		
	}
	
}
