package com.jfeesoft.kindergarten.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("testBeanView")
@Scope("view")
public class TestBeanView {
	private String testStr;
	private List<String> images;
	private List<Message> messages;

	@PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 8; i++) {
            images.add("nature" + i + ".jpg");
        }
        messages = new ArrayList<Message>();
        messages.add(new Message(1, "Jan Kowalski", "", "2017-07-01", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
        messages.add(new Message(2, "Jan Kowalski2", "", "2017-07-02", "Lorem ipsum dolor sit amet, consectetur adipiscing elit2."));
        messages.add(new Message(3, "Jan Kowalski3", "", "2017-07-03", "Lorem ipsum dolor sit amet, consectetur adipiscing elit3."));
        messages.add(new Message(4, "Jan Kowalski4", "", "2017-07-04", "Lorem ipsum dolor sit amet, consectetur adipiscing elit4."));
        messages.add(new Message(5, "Jan Kowalski5", "", "2017-07-04", "Lorem ipsum dolor sit amet, consectetur adipiscing elit4."));
        messages.add(new Message(6, "Jan Kowalski6", "", "2017-07-04", "Lorem ipsum dolor sit amet, consectetur adipiscing elit4."));
        messages.add(new Message(7, "Jan Kowalski7", "", "2017-07-04", "Lorem ipsum dolor sit amet, consectetur adipiscing elit4."));
        
    }
 
    public List<String> getImages() {
        return images;
    }
    
	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
}
