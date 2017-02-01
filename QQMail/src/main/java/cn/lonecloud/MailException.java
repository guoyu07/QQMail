package cn.lonecloud;

public class MailException extends RuntimeException {

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 7837092238053697685L;
	/**
	 * 消息
	 */
	private String msg;

	public MailException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MailException(String msg) {
		super(msg);
		this.setMsg(msg);
	}
	MailException(Throwable e){
		super(e);
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
