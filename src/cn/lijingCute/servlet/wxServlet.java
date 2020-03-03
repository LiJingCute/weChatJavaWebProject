package cn.lijingCute.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.regexp.internal.REUtil;

import cn.lijingCute.service.WxService;

@WebServlet("/wxServlet")
public class wxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public wxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  signature 	΢�ż���ǩ����signature����˿�������д��token�����������е�timestamp������nonce������
			timestamp 	ʱ���
			nonce 		�����
			echostr 	����ַ���
		 */
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
//		System.out.println(signature);
//		System.out.println(timestamp);
//		System.out.println(nonce);
//		System.out.println(echostr);
		//У��ǩ��		
		if(WxService.check(timestamp,nonce,signature)){
			PrintWriter pw = response.getWriter();
			//ԭ������echostr����	
			pw.print(echostr);
			pw.flush();
			pw.close();
			System.out.println("����ɹ�");
		}else {
			System.out.println("����ʧ��");
		}

	}

	//������Ϣ���¼�����	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		//������Ϣ���¼�����
		Map<String, String> requestMap = WxService.parseRequest(request.getInputStream());
		System.out.println(requestMap);
		//׼���ظ������ݰ�
		String respXml = WxService.getRespose(requestMap);
		System.out.println(respXml);
		PrintWriter out = response.getWriter();
		out.print(respXml);
		out.flush();
		out.close();
	}

}



