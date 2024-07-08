package bitcamp.myapp;

import bitcamp.myapp.command.Command;

public class HelpCommand implements Command {
    
    public void execute() {
        System.out.println("도움말 입니다.");
    }
}
