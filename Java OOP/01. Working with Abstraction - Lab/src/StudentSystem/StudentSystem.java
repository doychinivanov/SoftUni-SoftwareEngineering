package StudentSystem;

public class StudentSystem {
    private CommandHandler handler;
    private boolean isWorking;

    public StudentSystem(){
        this.handler = new CommandHandler();
    }

    public void start(){
        this.isWorking = true;

        while(isWorking){
            String result = handler.handleCommand(Reader.readStringArr("\\s+"));

            if(result != null && !result.equals("Exit")){
                System.out.println(result);
            }

            isWorking = !"Exit".equals(result);
        }
    }
}
