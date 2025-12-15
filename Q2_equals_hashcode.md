# Question 2 – equals() and hashCode()

In Java, `equals()` and `hashCode()` must be overridden together when objects are stored
in hash-based collections such as `HashMap` or `HashSet`.

If two objects are equal according to `equals()`, they must return the same hash code.
Fields involved in equality should be immutable to avoid unexpected behavior.
