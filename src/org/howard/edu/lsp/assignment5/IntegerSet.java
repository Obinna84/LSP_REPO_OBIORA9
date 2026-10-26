package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;

/**
 * A mathematical set of integers. Duplicate values are not stored, and
 * internal representation remains encapsulated.
 */
public class IntegerSet {
    private ArrayList  <Integer> elements;

    /**
     * Constructs an empty integer set.
     */
    public IntegerSet() {
        this.elements = new ArrayList<Integer>();
    }

    /**
     * Constructs a set that owns the provided element collection.
     *
     * @param elements the elements for the new set
     */
    private IntegerSet(ArrayList<Integer> elements) {
        this.elements = new ArrayList<Integer>();

        for (int element : elements) {
            add(element);
        }
    }

    /**
     * Removes all values from this set.
     */
    public void clear() {
        elements.clear();
    }

    /**
     * Returns the number of unique values in this set.
     *
     * @return the set size
     */
    public int length() {
        return elements.size();
    }

    /**
     * Returns whether this set and {@code b} contain exactly the same values,
     * regardless of insertion order.
     *
     * @param b the set to compare
     * @return true if both sets contain the same elements
     */
    public boolean equals(IntegerSet b) {
        if (b == this) {
            return true;
        }

        if (b == null) {
            return false;
        }

        return elements.size() == b.elements.size()
            && elements.containsAll(b.elements);
    }

    /**
     * Returns whether {@code value} is present in this set.
     *
     * @param value the integer to search for
     * @return true if the value is in the set
     */
    public boolean contains(int value) {
        return elements.contains(value);
    }

    /**
     * Returns the largest integer in this set.
     *
     * @return the largest value
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (elements.isEmpty()) {
        throw new IllegalStateException("Set is empty");
        }
        return java.util.Collections.max(elements);
    }

    public int smallest() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return java.util.Collections.min(elements);
    }

    public void add(int item) {
        if (!elements.contains(item)) {
            elements.add(item);
            elements.sort(null);
        }
    }

    /**
     * Removes {@code item} from this set. Has no effect if the item is absent.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        elements.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set containing values that appear in this set or in {@code b}.
     * Neither input set is modified.
     *
     * @param b the other set
     * @return the union of the two sets
     */
    public IntegerSet union(IntegerSet b) {
        ArrayList<Integer> result = new ArrayList<Integer>(elements);
        result.addAll(b.elements);
        return new IntegerSet(result);
    }

    /**
     * Returns a new set containing values shared by this set and {@code b}.
     * Neither input set is modified.
     *
     * @param b the other set
     * @return the intersection of the two sets
     */
    public IntegerSet intersect(IntegerSet b) {
        ArrayList<Integer> result = new ArrayList<Integer>(elements);
        result.retainAll(b.elements);
        return new IntegerSet(result);
    }

    /**
     * Returns a new set containing values in this set that are not in {@code b}.
     * Neither input set is modified.
     *
     * @param b the other set
     * @return the difference of this set minus {@code b}
     */
    public IntegerSet diff(IntegerSet b) {
        ArrayList<Integer> result = new ArrayList<Integer>(elements);
        result.removeAll(b.elements);
        return new IntegerSet(result);
    }

    /**
     * Returns a new set containing values in {@code b} that are not in this set.
     * This assignment-specific complement is the reverse of {@link #diff(IntegerSet)}.
     * Neither input set is modified.
     *
     * @param b the other set
     * @return the complement of this set relative to {@code b}
     */
    public IntegerSet complement(IntegerSet b) {
        ArrayList<Integer> result = new ArrayList<Integer>(b.elements);
        result.removeAll(elements);
        return new IntegerSet(result);
    }

    /**
     * Returns whether every value in this set is also present in {@code b}.
     * An empty set is a subset of every set.
     *
     * @param b the candidate superset
     * @return true if this set is a subset of {@code b}
     */
    public boolean isSubsetOf(IntegerSet b) {
        return b.elements.containsAll(elements);
    }

    /**
     * Returns whether this set and {@code b} share no values. Empty sets are
     * disjoint from all sets.
     *
     * @param b the other set
     * @return true if the two sets have no elements in common
     */
    public boolean isDisjoint(IntegerSet b) {
        ArrayList<Integer> overlap = new ArrayList<Integer>(elements);
        overlap.retainAll(b.elements);
        return overlap.isEmpty();
    }

    /**
     * Returns a new set containing values that occur in exactly one of the two sets.
     * Neither input set is modified.
     *
     * @param b the other set
     * @return the symmetric difference of the two sets
     */
    public IntegerSet symmetricDiff(IntegerSet b) {
        ArrayList<Integer> result = new ArrayList<Integer>(elements);
        result.addAll(b.elements);
        ArrayList<Integer> shared = new ArrayList<Integer>(elements);
        shared.retainAll(b.elements);
        result.removeAll(shared);
        return new IntegerSet(result);
    }

    /**
     * Returns whether this set contains no values.
     *
     * @return true if the set is empty
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Returns the set elements in ascending numerical order, separated by a
     * comma and one space, inside square brackets. An empty set is {@code []}.
     *
     * @return the formatted set string
     */
    @Override
    public String toString() {
        return elements.toString();
    }
}
