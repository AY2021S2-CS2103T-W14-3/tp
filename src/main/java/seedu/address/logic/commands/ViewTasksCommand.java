package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TASKS;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class ViewTasksCommand extends Command {

    public static final String COMMAND_WORD = "viewTasks";

    public static final String MESSAGE_SUCCESS = "Listed all Tasks";

    public static final String MESSAGE_NO_TASKS = "There are currently no Tasks in the list";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.updateFilteredTaskList(PREDICATE_SHOW_ALL_TASKS);
        if (model.getFilteredTaskList().isEmpty()) {
            return new CommandResult(MESSAGE_NO_TASKS);
        }
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
