package io.shadowmc.discobot.commands;

import java.util.Date;

import io.shadowmc.discobot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class TimeCommand implements Command {

	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Time Command Action is called on channel: " + event.getTextChannel().toString() );
		try{
			Date dt = new Date();
			event.getAuthor().
			event.getTextChannel().sendMessage("It is: "+ dt.toString()).queue();;
			
		}
		catch(Exception  e)
		{
			System.out.println("Time Command Action Error: " + e.toString() );
			
		}
		
	}

	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return;
	}

}
