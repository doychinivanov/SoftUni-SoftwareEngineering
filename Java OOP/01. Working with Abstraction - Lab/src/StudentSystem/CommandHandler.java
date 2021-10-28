package StudentSystem;

public class CommandHandler {
    private StudentRepo repo;

    public CommandHandler(){
        this.repo = new StudentRepo();
    }

    public String handleCommand(String[] tokens){
        if(tokens[0].equals("Create")){
            String name = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            double grade = Double.parseDouble(tokens[3]);

            Student student = new Student(name, age ,grade);

            this.repo.add(student);

            return null;
        } else if (tokens[0].equals("Show")){
            String name = tokens[1];

            Student student = repo.get(name);

            if(student != null){
                return repo.get(name).getInfo();
            }
            return null;
        }

        return tokens[0];
    }
}
