package mmf.piskunou.lab1TM;

import java.lang.reflect.Field;
/* Java is sooooo Shitty - not to include custom enum values!! Fuck its old shit...*/
public enum State {
    WORK(0),
    STOP(-1),
    ERROR(-2);


    State(){
        setEnumOrdinalDefault(this);
    }

    State(int myOrdinal) {
        this.setEnumOrdinal(this, myOrdinal);
    }

    private static int order = 0;

    private void setEnumOrdinal(Enum object, int ordinal) {

        Field field;
        try {
            field = object.getClass().getSuperclass().getDeclaredField("ordinal");
            field.setAccessible(true);
            field.set(object, ordinal);
            order = ordinal;
        } catch (Exception ex) {
            throw new RuntimeException("Can't update enum ordinal: " + ex);
        }
    }

    private void setEnumOrdinalDefault(Enum object) {

        Field field;
        try {
            field = object.getClass().getSuperclass().getDeclaredField("ordinal");
            field.setAccessible(true);
            field.set(object, ++order);
        } catch (Exception ex) {
            throw new RuntimeException("Can't update enum ordinal: " + ex);
        }
    }
}
