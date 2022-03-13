package UI;

public class AddUserUIAction implements UIAction {

    private final AddUserService addUserService;

    public AddUserUIAction(AddUserService addUserService) {
        this.addUserService = addUserService;
    }


    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public String getActionName() {
        return "Add User";
    }


}
