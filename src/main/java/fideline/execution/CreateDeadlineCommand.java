package fideline.execution;

import fideline.exception.DataFileInteractionException;
import fideline.save.Storage;
import fideline.task.TaskManager;
import fideline.user.Ui;

/**
 * Command that executes the creation of a deadline task.
 *
 * @author Fun Leon
 */
public class CreateDeadlineCommand extends Command {

    /** Title of the task */
    private String taskDescription;

    /** When the task is due */
    private String deadline;

    /**
     * Constructs a command that can create and add a deadline
     * task to the existing tasks.
     *
     * @param taskDescription Title of the task.
     * @param deadline When the task is due.
     */
    public CreateDeadlineCommand(String taskDescription, String deadline) {
        this.taskDescription = taskDescription;
        this.deadline = deadline;
    }

    /**
     * Creates and adds new deadline task to existing tasks, and saves it locally.
     * The new task is unmarked.
     *
     * @param taskManager Manager for existing tasks and creation of new ones.
     * @param storage     Handler for storage of existing tasks locally.
     * @param ui          Handler for display messages to the user.
     */
    @Override
    public void execute(TaskManager taskManager, Storage storage, Ui ui) throws DataFileInteractionException {
        String taskString = taskManager.addDeadline(taskDescription, deadline);
        storage.addLine("D| |" + taskDescription + "|" + deadline);
        ui.addTaskMsg(taskString, taskManager.getTaskCount());
    }

}
