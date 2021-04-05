package spring;

import java.io.Serializable;

public class UserDTO implements Serializable{
	private int uid;
	private String uname;
	private String upass;
	private int flag;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "LoginDTO [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", flag=" + flag + "]";
	}
	
	
	public final int getUid() {
		return uid;
	}
	public final void setUid(int uid) {
		this.uid = uid;
	}
	public final String getUname() {
		return uname;
	}
	public final void setUname(String uname) {
		this.uname = uname;
	}
	public final String getUpass() {
		return upass;
	}
	public final void setUpass(String upass) {
		this.upass = upass;
	}
	public final int getFlag() {
		return flag;
	}
	public final void setFlag(int flag) {
		this.flag = flag;
	}
}
