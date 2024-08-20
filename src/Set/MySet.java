package Set;

import java.util.HashSet;
import java.util.Iterator;

public class MySet extends HashSet<String> {
    private static final long serialVersionUID = 1L;

    public MySet() {
        super();
    }

    /**
     * Unions this set with the given other set.
     *
     * @return the union of the elements of this and that
     */
    public MySet union(MySet that) {
        MySet result = new MySet();
        for (String string : this) {
            result.add(string);
        }
        if (that != null) {
            for (String s : that) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * Intersects this set with the given other set.
     *
     * @return the intersection of the elements of this and that
     */
    public MySet intersection(MySet that) {
        MySet result = new MySet();
        if (that == null) {
            return result;
        }
        for (String item : this) {
            if (that.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Gets the difference between this set and the given other set.
     *
     * @return the difference of the elements of this and that
     */
    public MySet difference(MySet that) {
        MySet result = new MySet();
        if (that == null) {
            return this.union(null);
        }
        for (String item : this) {
            if (!that.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Gets the exclusive or between this set and the given other set.
     *
     * @return the exclusive or (XOR) of the elements of this and that
     */
    public MySet exclusiveOr(MySet that) {
        MySet result = new MySet();
        result = this.union(that).difference(this.intersection(that));

        return result;
    }

    /**
     * Converts this set to a string representation.
     *
     * @return a String representation of a MySet object
     */
    public String toString() {
        String result = "<MySet{";
        Iterator<String> thisSet = iterator();
        while (thisSet.hasNext()) {
            result += thisSet.next();
            if (thisSet.hasNext()) {
                result += ",";
            }
        }

        result += "}>";
        return result;
    }
}
