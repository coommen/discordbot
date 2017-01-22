package io.shadowmc.discobot.listeners;

import io.shadowmc.discobot.Main;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BotListener extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if(event.getMessage().getContent().startsWith("~!") && event.getMessage().getId() != event.getJDA().getSelfUser().getId()) Main.handleCommand(Main.parser.parse(event.getMessage().getContent().toLowerCase(), event));
	}
	
	@Override
	public void onReady(ReadyEvent event) {
		System.out.println(event.getJDA().getSelfUser().getName() + " is ready!"  );
		super.onReady(event);
	}
}
