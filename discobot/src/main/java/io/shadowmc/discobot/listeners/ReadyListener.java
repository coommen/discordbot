package io.shadowmc.discobot.listeners;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {

	@Override
	public void onReady(ReadyEvent event) {
		System.out.println("I'm Ready");
		// Main.log("status", "Logged in as: " + event.getJDA().getSelfUser().getName());
	}
	
}
