package com.SCM.Smart_Contact_Manager.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
// import lombok.Getter;
import lombok.NoArgsConstructor;
// import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String content;
    @Builder.Default
    private MessageType type = MessageType.blue;
	
    public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
    
    
}
