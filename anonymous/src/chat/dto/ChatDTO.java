package chat.dto;

import java.util.Date;

public class ChatDTO {
	
	String chatName;
	String chatContent;
	Date chatTime;
	
	public String getChatName() {
		return chatName;
	}
	public void setChatName(String chatName) {
		this.chatName = chatName;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public Date getChatTime() {
		return chatTime;
	}
	public void setChatTime(Date chatTime) {
		this.chatTime = chatTime;
	}
	
	@Override
	public String toString() {
		return "Chat [chatName=" + chatName + ", chatContent=" + chatContent + ", chatTime=" + chatTime + "]";
	}
}
