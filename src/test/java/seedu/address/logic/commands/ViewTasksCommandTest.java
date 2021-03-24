package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.testutil.TypicalTasks;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ViewTasksCommand.
 */
public class ViewTasksCommandTest {
    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(TypicalTasks.getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getHeyMatez(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ViewTasksCommand(), model, ViewTasksCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
