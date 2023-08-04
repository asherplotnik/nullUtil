package com.util.nullUtil;


import java.util.Optional;
import java.util.function.Supplier;

public class NullUtil {

    public static <T> T getObjectOrNull(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException | IndexOutOfBoundsException e ) {
            return null;
        }
    }

    public static <T> Optional<T> getOptional(Supplier<T> supplier) {
        try {
            return Optional.ofNullable(supplier.get());
        } catch (NullPointerException | IndexOutOfBoundsException e ) {
            return Optional.empty();
        }
    }

}
