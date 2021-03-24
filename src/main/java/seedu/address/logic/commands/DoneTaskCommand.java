package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TASKS;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Description;
import seedu.address.model.task.Task;
import seedu.address.model.task.TaskStatus;
import seedu.address.model.task.Title;

/**
 * Represents a DoneTaskCommand
 * Changes the status of existing task in HEY MATEz to completed
 */
public class DoneTaskCommand extends Command {
    public static final String COMMAND_WORD = "done";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Changes the status of the task to be completed"
            + "by the index number used in the displayed task board. \n"
            + "Parameters: INDEX (must be a positive integer) "
            + "Example: " + COMMAND_WORD + " 1 ";

    public static final String MESSAGE_DONE_TASK_SUCCESS = "Task is marked as done!";
    public static final String MESSAGE_TASK_ALREADY_MARKED_DONE = "Task is already marked done!";

    private final Index index;

    /**
     * @param index of the task in the filtered task list to mark as completed
     */
    public DoneTaskCommand(Index index) {
        requireNonNull(index);

        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Task> lastShownList = model.getFilteredTaskList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        Task taskToMarkDone = lastShownList.get(index.getZeroBased());
        Task doneTask = createDoneTask(taskToMarkDone);

        assert doneTask != null;

        model.setTask(taskToMarkDone, doneTask);
        model.updateFilteredTaskList(PREDICATE_SHOW_ALL_TASKS);
        return new CommandResult(MESSAGE_DONE_TASK_SUCCESS);
    }

    /**
     * Creates and returns a {@code Task} with the details of {@code taskToUndo}
     *
     * @params taskToUndo task to be marked as completed
     * @return A Task with the updated completed status
     */
    public static Task createDoneTask(Task taskToDone) throws CommandException {
        assert taskToDone != null;

        Title updatedTitle = taskToDone.getTitle();
        Description updatedDescription = taskToDone.getDescription();
        Deadline updatedDeadline = taskToDone.getDeadline();

        TaskStatus current = taskToDone.getTaskStatus();

        if (current == TaskStatus.COMPLETED) {
            throw new CommandException(MESSAGE_TASK_ALREADY_MARKED_DONE);
        }

        TaskStatus updatedStatus = TaskStatus.COMPLETED;

        return new Task(updatedTitle, updatedDescription, updatedDeadline, updatedStatus);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DoneTaskCommand)) {
            return false;
        }

        // state check
        DoneTaskCommand e = (DoneTaskCommand) other;
        System.out.println(index);
        System.out.println(e.index);
        return index.equals(e.index);

    }
}
