package zoo.dinos;

import java.time.*;
import java.util.*;
import java.util.logging.*;

import sun.misc.Unsafe;

public class Animatronic {

    private static final Logger LOGGER = Logger.getLogger("Animatronic");

    private List<String> names;
    private LocalDate visitDate;

    public Animatronic(List<String> names, LocalDate visitDate) {
        this.names = names;
        this.visitDate = visitDate;
    }

    public void unsafeMethod() {
        LOGGER.warning("Don't call this!");
        Unsafe unsafe = Unsafe.getUnsafe();
    }
}
