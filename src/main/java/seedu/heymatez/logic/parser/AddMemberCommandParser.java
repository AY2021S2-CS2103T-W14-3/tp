package seedu.heymatez.logic.parser;

import static seedu.heymatez.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.heymatez.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.heymatez.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.heymatez.logic.parser.CliSyntax.PREFIX_ROLE;

import java.util.stream.Stream;

import seedu.heymatez.logic.commands.AddMemberCommand;
import seedu.heymatez.logic.parser.exceptions.ParseException;
import seedu.heymatez.model.person.Email;
import seedu.heymatez.model.person.Name;
import seedu.heymatez.model.person.Person;
import seedu.heymatez.model.person.Phone;
import seedu.heymatez.model.person.Role;

/**
 * Parses input arguments and creates a new AddMemberCommand object
 */
public class AddMemberCommandParser implements Parser<AddMemberCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddMemberCommand
     * and returns an AddMemberCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddMemberCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ROLE);

        if (!arePrefixesPresent(argMultimap, PREFIX_PHONE, PREFIX_EMAIL)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddMemberCommand.MESSAGE_USAGE));
        }

        Name name = ParserUtil.parseName(argMultimap.getPreamble());
        Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        Email email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get());

        Person person = new Person(name, phone, email);

        Role role;
        if (arePrefixesPresent(argMultimap, PREFIX_ROLE)) {
            role = ParserUtil.parseRole(argMultimap.getValue(PREFIX_ROLE).get());
            person = new Person(name, phone, email, role);
        }
        return new AddMemberCommand(person);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
