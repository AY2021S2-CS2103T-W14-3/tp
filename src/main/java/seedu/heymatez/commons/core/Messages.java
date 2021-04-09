package seedu.heymatez.commons.core;

import seedu.heymatez.logic.commands.CommandResult;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command. Use 'help' for more information";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_NAME = "The member name provided is invalid! \n";
    public static final String MESSAGE_INVALID_PERSON_PHONE = "The member phone number provided is invalid! \n";
    public static final String MESSAGE_INVALID_PERSON_EMAIL = "The member email provided is invalid! \n";
    public static final String MESSAGE_INVALID_PERSON_ROLE = "The member role provided is invalid! \n";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d members listed!";
    public static final String MESSAGE_INVALID_TASK_DISPLAYED_INDEX = "The task index provided is invalid! \n";
    public static final String MESSAGE_INVALID_TASK_DESCRIPTION = "The task description provided is invalid! \n";
    public static final String MESSAGE_INVALID_TASK_TITLE = "The task title provided is invalid! \n";
    public static final String MESSAGE_INVALID_TASK_STATUS = "The task status provided is invalid! \n";
    public static final String MESSAGE_INVALID_TASK_PRIORITY = "The task priority provided is invalid! \n";
    public static final String MESSAGE_INVALID_TASK_ASSIGNEE = "The task assignee provided is invalid! \n";
    public static final String MESSAGE_INVALID_TASK_DEADLINE = "The task deadline value provided is invalid! \n";
    public static final String MESSAGE_INVALID_TASK_DEADLINE_FORMAT = "The task deadline format provided is "
            + "incorrect! \n";
    public static final String MESSAGE_TASKS_LISTED_OVERVIEW = "%1$d tasks listed!";
    public static final String MESSAGE_NO_NAME_FOUND = "No members found with given name";
    public static final String MESSAGE_NO_UNASSIGNED_FOUND = "No unassigned tasks found";
    public static final String MESSAGE_NO_UNCOMPLETED_FOUND = "All tasks have been marked as completed!";
    public static final String MESSAGE_NO_KEYWORD_FOUND = "No tasks found with given keyword";
    public static final String MESSAGE_NO_TASKS_FOUND = "No tasks found! Add a new task to begin.";
    public static final String MESSAGE_NO_DEADLINE_FOUND = "No tasks due before given deadline";
    public static final String MESSAGE_NO_PRIORITY_FOUND = "No tasks found with given priority";
    public static final String MESSAGE_NO_TASKS_FOR_MEMBER_FOUND = "No tasks assigned to given member";
    public static final String MESSAGE_NO_MEMBERS_FOUND = "No members found! Add a new member to begin.";

}
