package seedu.address.model.common;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;


public abstract class Validator {

    public final String internalString;

    /**
     * Constructs a {@code Wrapper}.
     *
     * @param str A valid string.
     */
    public Validator(String str) {
        String temp = "";
        try {
            requireNonNull(str);
            checkArgument(
                    (boolean) this.getClass().getMethod("isValid", String.class).invoke(this, str),
                    (String) this.getClass().getField("MESSAGE_CONSTRAINTS").get(this)
            );
            temp = str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.internalString = temp;
    }

    /**
     * Returns true if a given string matches the child class VALIDATION.
     */
    public boolean isValid(String test) {
        try {
            return test.matches((String) this.getClass().getField("VALIDATION_REGEX").get(this));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns the internalString type casted into Object
     */
    public abstract Object getValue();

    @Override
    public String toString() {
        return this.internalString;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Validator // instanceof handles nulls
                && this.internalString.equals(((Validator) other).internalString)); // state check
    }

    @Override
    public int hashCode() {
        return this.internalString.hashCode();
    }

}
