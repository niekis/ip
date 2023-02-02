package fideline.execution;

import fideline.exception.DataFileInteractionException;
import fideline.save.Storage;
import fideline.task.TaskManager;
import fideline.user.Ui;

/**
 * Command that executes the creation of a todo task.
 *
 * @author Fun Leon
 */
public class CreateTodoCommand extends Command {

    /** Title of the task */
    private String taskDescription;

    /**
     * Constructs a command that can create and add a todo
     * task to the existing tasks.
     *
     * @param taskDescription Title of the task.
     */
    public CreateTodoCommand(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /**
     * Creates and adds new todo task to existing tasks, and saves it locally.
     * The new task is unmarked.
     *
     * @param taskManager Manager for existing tasks and creation of new ones.
     * @param storage     Handler for storage of existing tasks locally.
     * @param ui          Handler for display messages to the user.
     */
    @Override
    public void execute(TaskManager taskManager, Storage storage, Ui ui) throws DataFileInteractionException {
        String taskString = taskManager.addTodo(taskDescription);
        storage.addLine("T| |" + taskDescription);
        ui.addTaskMsg(taskString, taskManager.getTaskCount());
    }

}
