import selab.threetier.Server;
import selab.threetier.presentation.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8001);

        server.addView("/", new FilePresentation("C:\\Users\\abahram77\\Downloads\\Telegram Desktop\\src\\ThreeTier\\ThreeTier\\static\\index.html", "text/html"));
        server.addView("/tasks/list", new TasksListPresentation());
        server.addView("/tasks/add", new AddTaskPresentation());
        server.addView("/tasks/remove", new RemoveTaskPresentation());

        server.start();
    }
}
