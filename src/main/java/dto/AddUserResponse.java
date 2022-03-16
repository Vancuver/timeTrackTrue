package dto;

import Core.Validation.CoreError;

import java.util.List;
import java.util.Objects;

public class AddUserResponse {

    private Integer createdID;
    private List<CoreError> errors;

    public Integer getCreatedID() {
        return createdID;
    }

    public void setCreatedID(Integer createdID) {
        this.createdID = createdID;
    }

    public List<CoreError> getErrors() {
        return errors;
    }

    public void setErrors(List<CoreError> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddUserResponse that = (AddUserResponse) o;
        return Objects.equals(createdID, that.createdID) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdID, errors);
    }

    @Override
    public String toString() {
        return "AddUserResponse{" +
                "createdID=" + createdID +
                ", errors=" + errors +
                '}';
    }
}
