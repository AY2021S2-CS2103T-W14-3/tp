package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.model.Model;

/**
 * Lists all persons in the address book to the user.
 */
public class ViewMembersCommand extends Command {

    public static final String COMMAND_WORD = "viewMembers";

    public static final String MESSAGE_SUCCESS = "Listed all members in this CCA!";

    public static final String MESSAGE_NO_MEMBERS = "There are currently no Members in the list!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        if (model.getFilteredPersonList().isEmpty()) {
            return new CommandResult(MESSAGE_NO_MEMBERS);
        }
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
