package org.joshua.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.joshua.javabrains.messenger.database.DatabaseClass;
import org.joshua.javabrains.messenger.model.Message;
import org.joshua.javabrains.messenger.exception.*;


public class MessageService {
	
	/*  METODO QUE TRAE TODOS LOS MENSAJES ANTES DE USAR MAP<>
	public List<Message> getAllMessages(){
		
		Message m1 = new Message(1L, "Hello World!", "Joshua");
		Message m2 = new Message(2L, "Hello Jersey!", "Joshua");
		
		List<Message> listOfMessages = new ArrayList<>();
		
		listOfMessages.add(m1);
		listOfMessages.add(m2);
		
		return listOfMessages;

	}*/
	
	
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		Message m1 = new Message(1, "Hello World!!", "Joshua");
		Message m2 = new Message(2, "Hello Jersey!!", "Joshua");
		
		messages.put(1L, m1);
		messages.put(2L, m2);
		
		/*
		DatabaseClass dbClass = new DatabaseClass();
		dbClass.conexionCloudant();
		*/
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()){
			cal.setTime(message.getCreate());
			if(cal.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start + size > list.size())
			return new ArrayList<Message>();
		System.out.println(start+size);
		System.out.println(list.size());
		return list.subList(start, start + size);
		
	}
	
	public Message getMessage(long id){
		Message message = messages.get(id);
		if(message == null){
			throw new DataNotFoundException("Message with id " + id + " not found");
		}
		return message;
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
		
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	
	

}
