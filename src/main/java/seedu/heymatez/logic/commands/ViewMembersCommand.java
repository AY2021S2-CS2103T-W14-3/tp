package seedu.heymatez.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.heymatez.commons.core.Messages.MESSAGE_NO_MEMBERS_FOUND;
import static seedu.heymatez.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.heymatez.model.Model;

/**
 * Lists all persons in HeyMatez to the user.
 */
public class ViewMembersCommand extends Command {

    public static final String COMMAND_WORD = "viewMembers";

    public static final String MESSAGE_SUCCESS = "Listed all members in this CCA!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        if(model.getFilteredPersonList().size() == 0) {
            return new CommandResult(MESSAGE_NO_MEMBERS_FOUND);
        } else {
            return new CommandResult(MESSAGE_SUCCESS);
        }
    }
}
