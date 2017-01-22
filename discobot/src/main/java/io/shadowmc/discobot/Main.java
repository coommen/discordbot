package io.shadowmc.discobot;

import java.util.HashMap;

import javax.security.auth.login.LoginException;

import io.shadowmc.discobot.commands.PingCommand;
import io.shadowmc.discobot.commands.TimeCommand;
import io.shadowmc.discobot.listeners.BotListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

/**
 * Hello world!
 *
 */




public class Main 
{
	public static HashMap<String, Command> commands = new HashMap<String, Command>();
	
	public static final CommandParser parser = new CommandParser();
	
    public static void main( String[] args )
    {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        
        builder.setToken(BOT_ACCOUNT.BOT_TOKEN);
        
        builder.setAudioEnabled(false); //so it loads faster
        //builder.setAutoReconnect(true);
        
       // builder.addListener(new ReadyListener());
       builder.addListener(new BotListener());
        
        
        
        try {
			JDA jda = builder.buildBlocking();
			jda.setAutoReconnect(true);
			//jda.addEventListener(new BotListener());
		} catch (LoginException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (RateLimitedException e) {
			e.printStackTrace();
		}
        
        commands.put("ping", new PingCommand());
        commands.put("time", new TimeCommand());
    }
    
    public static void handleCommand(CommandParser.CommandContainer cmd){
    	if(commands.containsKey(cmd.invoke)){
    		boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);
    		System.out.println("Handle Command... Command is " + safe);
    		if (safe){
    			System.out.println("Calling Action...");
    			commands.get(cmd.invoke).action(cmd.args, cmd.event);
    			commands.get(cmd.invoke).executed(safe, cmd.event);
    		} else {
    			commands.get(cmd.invoke).executed(safe, cmd.event);
    		}
    		
    		
    		
    	}
    	
    	
    }
    
    
    
    
    
    
    
}
