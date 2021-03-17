package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.task.Task;

/**
 * Adds a person to the address book.
 */
public class AddTaskCommand extends Command {

    public static final String COMMAND_WORD = "addTask";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a new task to dashboard.\n"
            + "Parameters: "
            + "TITLE "
            + PREFIX_DESCRIPTION + " DESCRIPTION "
            + "Example: " + COMMAND_WORD + " "
            + "Plan board meeting "
            + PREFIX_DESCRIPTION + " Draft meeting agenda and proposal for board meeting";

    public static final String MESSAGE_SUCCESS = "New Task added: %1$s";

    private final Task toAddTask;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddTaskCommand(Task task) {
        requireNonNull(task);
        toAddTask = task;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.addTask(toAddTask);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAddTask));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddTaskCommand // instanceof handles nulls
                && toAddTask.equals(((AddTaskCommand) other).toAddTask));
    }
}
