package UI;

public class FindAllUsersUIAction implements UIAction{

    private final FindAllUsersService findAllUsersService;

    public FindAllUsersUIAction(FindAllUsersService findAllUsersService) {
        this.findAllUsersService = findAllUsersService;
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public String getActionName() {
        return "Find all users";
    }
}
