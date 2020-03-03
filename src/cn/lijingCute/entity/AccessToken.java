package cn.lijingCute.entity;

public class AccessToken {
	//��ȡtoken	
	private String accessToken;
	//����ʱ��	
	private long expireTime;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(long expireTime) {
		this.expireTime = expireTime;
	}

	public AccessToken(String accessToken, String expireIn) {
		super();
		this.accessToken = accessToken;
		expireTime = System.currentTimeMillis()+Integer.parseInt(expireIn)*1000;
	}
	
	/**
	 * �ж�token�Ƿ����
	 */
	public boolean isExpired() {
		return System.currentTimeMillis()>expireTime;
	}

}
