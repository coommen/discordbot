package io.shadowmc.discobot.commands;

import io.shadowmc.discobot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PingCommand implements Command {

	private final String HELP = "USAGE: ~!ping";
	
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	public void action(String[] args, MessageReceivedEvent event) {
		System.out.println("Ping Command Action is called on channel: " + event.getTextChannel().toString() );
		try{
			event.getTextChannel().sendMessage("Hello "+ event.getAuthor().getAsMention()  +  ", I'm Shadow DiscordApp Bot. I'm listening!").queue();;
			
		}
		catch(Exception  e)
		{
			System.out.println("Ping Command Action Error: " + e.toString() );
			
		}
		
		

	}

	public String help() {
		return HELP;
	}

	public void executed(boolean success, MessageReceivedEvent event) {
		return;
	}

}
