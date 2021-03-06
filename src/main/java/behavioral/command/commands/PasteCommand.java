package behavioral.command.commands;

import behavioral.command.Document;

/**
 * ConcreteCommand
 */
public class PasteCommand implements Command {
    private Document document;

    public PasteCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.paste();
    }
}