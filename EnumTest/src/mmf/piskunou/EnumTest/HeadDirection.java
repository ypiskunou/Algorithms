package mmf.piskunou.EnumTest;

import java.lang.reflect.Field;

public enum HeadDirection {
    Left(-1),
    NoMove,
    Right;

    static int order;

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

    HeadDirection(){
        setEnumOrdinalDefault(this);
    }

    HeadDirection(int myOrdinal) {
        this.setEnumOrdinal(this, myOrdinal);
    }
}