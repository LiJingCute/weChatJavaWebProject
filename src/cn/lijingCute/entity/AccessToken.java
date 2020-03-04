package cn.lijingCute.entity;

public class AccessToken {
	//获取token	
	private String accessToken;
	//过期时间
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
		//过期时间=当前时间+接入时的时间
		expireTime = System.currentTimeMillis()+Integer.parseInt(expireIn)*1000;
	}
	
	/**
	 * 判断token是否过期
	 */
	public boolean isExpired() {
		return System.currentTimeMillis()>expireTime;
	}

}
