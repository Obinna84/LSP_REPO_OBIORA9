package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Assignment 6: JUnit 5 tests for IntegerSet.
 *
 * Complete every TODO. Do not remove, rename, or disable test methods.
 * Each test must contain meaningful 
 assertions and run independently.
 */
public class IntegerSetTest {
    // ===== clear() =====

    /**
      * Create a populated set; call clear(); assert that it is empty and its length is zero.
      * Assignment 5 equivalent: 2 point(s).
      */
    
    @Test
    public void testClearClearsPopulatedSet() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);

        // Act
        set.clear();

        // Assert
        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }

    @Test
    public void testClearClearsEmptySet() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act
        set.clear();

        // Assert
        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }

    @Test
    public void testLengthCountsUniqueElements() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(3);

        // Act
        int length = set.length();

        // Assert
        assertEquals(3, length);
    }

    /**
     * Verify a new empty set has length zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthEmptySetLength() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act
        int length = set.length();

        // Assert
        assertEquals(0, length);
    }

   // ===== equals() =====

   /**
     * Construct sets with identical elements in different insertion orders; assert equality.
     * Assignment 5 equivalent: 2 point(s).
     */
   
  @Test
  public void testEqualsIgnoresInsertionOrder() {
      // Arrange
      IntegerSet set1 = new IntegerSet();
      set1.add(1);
      set1.add(2);
      set1.add(3);

      IntegerSet set2 = new IntegerSet();
      set2.add(3);
      set2.add(1);
      set2.add(2);

      // Act
      boolean result = set1.equals(set2);

      // Assert
      assertTrue(result);
      assertTrue(set2.equals(set1));
  }

  @Test
  public void testEqualsDetectsDifferentContents() {
      // Arrange
      IntegerSet set1 = new IntegerSet();
      set1.add(1);
      set1.add(2);

      IntegerSet set2 = new IntegerSet();
      set2.add(1);
      set2.add(3);

      // Act
      boolean result = set1.equals(set2);

      // Assert
      assertFalse(result);
      assertFalse(set2.equals(set1));
  }

   /**
     * Verify two separately constructed empty sets compare equal.
     * Assignment 5 equivalent: 2 point(s).
     */
  @Test
  public void testEqualsEmptySetsEqual() {
      // Arrange
      IntegerSet set1 = new IntegerSet();
      IntegerSet set2 = new IntegerSet();

      // Act
      boolean result = set1.equals(set2);

      // Assert
      assertTrue(result);
      assertTrue(set2.equals(set1));
  }


   /**
     * Verify a set equals itself and differs from a set of another size.
     * Assignment 5 equivalent: 2 point(s).
     */
  @Test
  public void testEqualsSameObjectAndDifferentSizes() {
      // Arrange
      IntegerSet set1 = new IntegerSet();
      set1.add(1);
      set1.add(2);
      set1.add(3);

      IntegerSet set2 = new IntegerSet();
      set2.add(1);
      set2.add(2);

      // Act
      boolean sameObject = set1.equals(set1);
      boolean differentSizes = set1.equals(set2);

      // Assert
      assertTrue(sameObject);
      assertFalse(differentSizes);
  }

   // ===== contains() =====

   /**
     * Verify contains() is true for a present element and false for an absent one.
     * Assignment 5 equivalent: 2 point(s).
     */
  @Test
  public void testContainsPresentAndAbsent() {
      // Arrange
      IntegerSet set = new IntegerSet();
      set.add(10);
      set.add(20);
      set.add(30);

      // Act
      boolean present = set.contains(20);
      boolean absent = set.contains(40);

      // Assert
      assertTrue(present);
      assertFalse(absent);
  }

   /**
    * Verify an empty set does not contain an arbitrary integer.
    * Assignment 5 equivalent: 2 point(s).
    */  
  @Test
  public void testContainsEmptySetContainsNothing() {
      // Arrange
      IntegerSet set = new IntegerSet();

      // Act
      boolean result = set.contains(10);

      // Assert
      assertFalse(result);
  }

   // ===== largest() =====

   /**
     * Verify largest() returns the maximum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestNegativeAndPositiveValues() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(-10);
        set.add(0);
        set.add(5);
        set.add(20);
        set.add(-30);

        // Act
        int largest = set.largest();

        // Assert
        assertEquals(20, largest);
    }


   /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestEmptySetThrowsException() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            set.largest();
        });
    }

   // ===== smallest() =====

   /**
     * Verify smallest() returns the minimum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestNegativeAndPositiveValues() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(-20);
        set.add(0);
        set.add(30);
        set.add(-5);

        // Act
        int smallest = set.smallest();

        // Assert
        assertEquals(-20, smallest);
    }

   /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestEmptySetThrowsException() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            set.smallest();
        });
    }

   // ===== add() =====

   /**
     * Add the same integer repeatedly; verify only one copy exists.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddIgnoresDuplicates() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act
        set.add(5);
        set.add(5);
        set.add(5);

        // Assert
        assertEquals(1, set.length());
        assertTrue(set.contains(5));
    }

   /**
    * Add Integer.MIN_VALUE, Integer.MAX_VALUE, and zero; verify all are represented.
    * Assignment 5 equivalent: 2 point(s).
    */
    @Test
    public void testAddHandlesIntegerBoundaries() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act
        set.add(Integer.MIN_VALUE);
        set.add(Integer.MAX_VALUE);
        set.add(0);

        // Assert
        assertTrue(set.contains(Integer.MIN_VALUE));
        assertTrue(set.contains(Integer.MAX_VALUE));
        assertTrue(set.contains(0));
        assertEquals(3, set.length());
    }

    // ===== remove() =====

    /**
      * Remove a present element; verify it is absent and others remain.
      * Assignment 5 equivalent: 2 point(s).
      */ 
    @Test
    public void testRemoveRemovesExistingElement() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(20);
        set.add(30);

        // Act
        set.remove(20);

        // Assert
        assertFalse(set.contains(20));
        assertTrue(set.contains(10));
        assertTrue(set.contains(30));
        assertEquals(2, set.length());
    }

    /**
      * Remove an absent element; verify the set is unchanged.
      * Assignment 5 equivalent: 2 point(s).
      */ 
    @Test
    public void testRemoveIgnoresAbsentElement() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(20);
        set.add(30);

        // Act
        set.remove(40);

        // Assert
        assertEquals(3, set.length());
        assertTrue(set.contains(10));
        assertTrue(set.contains(20));
        assertTrue(set.contains(30));
        assertFalse(set.contains(40));
    }

    // ===== union() =====

    /**
      * Verify union() contains all distinct elements from two overlapping sets.
      * Assignment 5 equivalent: 2 point(s).
      */
    @Test
    public void testUnionOverlappingSets() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Act
        IntegerSet result = set1.union(set2);

        // Assert
        assertEquals(5, result.length());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
        assertTrue(result.contains(5));
    }

    /**
      * Verify union with an empty set and with the same object.
      * Assignment 5 equivalent: 2 point(s).
      */
    @Test
    public void testUnionEmptyAndSameOperand() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);

        IntegerSet emptySet = new IntegerSet();

        // Act
        IntegerSet unionEmpty = set.union(emptySet);
        IntegerSet unionSelf = set.union(set);

        // Assert
        assertTrue(unionEmpty.equals(set));
        assertTrue(unionSelf.equals(set));

        assertEquals(3, unionEmpty.length());
        assertEquals(3, unionSelf.length());

        assertTrue(emptySet.isEmpty());
    }

    /**
      * Verify both inputs remain unchanged; modify the result and verify the inputs are still
unchanged.
      * Assignment 5 equivalent: 3 point(s).
      */
    @Test
    public void testUnionDoesNotMutateInputs() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);

        // Act
        IntegerSet result = set1.union(set2);

        // Assert - verify original inputs are unchanged
        assertEquals(2, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));

        assertEquals(2, set2.length());
        assertTrue(set2.contains(3));
        assertTrue(set2.contains(4));

        // Act - modify the result
        result.add(5);
        result.remove(1);

        // Assert - verify inputs remain unchanged
        assertEquals(2, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertFalse(set1.contains(5));

        assertEquals(2, set2.length());
        assertTrue(set2.contains(3));
        assertTrue(set2.contains(4));
        assertFalse(set2.contains(5));

        // Verify the result was modified
        assertFalse(result.contains(1));
        assertTrue(result.contains(5));

        // Verify the result is a separate object
        assertNotSame(set1, result);
        assertNotSame(set2, result);
    }

    // ===== intersect() =====
   /**
     * Verify intersection contains exactly the shared elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectOverlappingSets() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);

        // Act
        IntegerSet result = set1.intersect(set2);

        // Assert
        assertEquals(2, result.length());
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));

        assertFalse(result.contains(1));
        assertFalse(result.contains(2));
        assertFalse(result.contains(5));
        assertFalse(result.contains(6));
    }

   /**
     * Verify disjoint intersection is empty and self-intersection is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */ 
    @Test
    public void testIntersectDisjointAndSameOperand() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);

        // Act
        IntegerSet disjointResult = set1.intersect(set2);
        IntegerSet selfResult = set1.intersect(set1);

        // Assert
        assertTrue(disjointResult.isEmpty());
        assertEquals(0, disjointResult.length());

        assertTrue(selfResult.equals(set1));
        assertEquals(2, selfResult.length());
    }

   /**
     * Modify the intersection result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testIntersectIndependentResult() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Act
        IntegerSet result = set1.intersect(set2);

        // Assert - verify intersection
        assertEquals(2, result.length());
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));

        // Act - modify the result
        result.remove(2);
        result.add(5);

        // Assert - verify inputs remain unchanged
        assertEquals(3, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(5));

        assertEquals(3, set2.length());
        assertTrue(set2.contains(2));
        assertTrue(set2.contains(3));
        assertTrue(set2.contains(4));
        assertFalse(set2.contains(5));

        // Assert - verify result changed independently
        assertFalse(result.contains(2));
        assertTrue(result.contains(5));

        assertNotSame(set1, result);
        assertNotSame(set2, result);
    }

   // ===== diff() =====

   /**
     * Verify A.diff(B) returns elements in A but not B, and distinguish direction.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffDirectionMatters() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Act
        IntegerSet result1 = set1.diff(set2);
        IntegerSet result2 = set2.diff(set1);

        // Assert
        assertEquals("[1, 2]", result1.toString());
        assertEquals("[4, 5]", result2.toString());
        assertFalse(result1.equals(result2));
    }

   /**
     * Verify difference with an empty set and difference with itself.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffEmptyAndSameOperand() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);

        IntegerSet emptySet = new IntegerSet();

        // Act
        IntegerSet diffEmpty = set.diff(emptySet);
        IntegerSet diffSelf = set.diff(set);
        IntegerSet emptyDiff = emptySet.diff(set);

        // Assert
        assertTrue(diffEmpty.equals(set));
        assertEquals(3, diffEmpty.length());

        assertTrue(diffSelf.isEmpty());
        assertEquals(0, diffSelf.length());

        assertTrue(emptyDiff.isEmpty());
        assertEquals(0, emptyDiff.length());
    }

   /**
     * Modify the difference result and verify neither input changes.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testDiffIndependentResult() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);

        // Act
        IntegerSet result = set1.diff(set2);

        // Assert - verify initial difference
        assertEquals("[1, 2]", result.toString());
        assertEquals("[1, 2, 3]", set1.toString());
        assertEquals("[3, 4]", set2.toString());

        // Act - modify result
        result.remove(1);
        result.add(5);

        // Assert - verify result changed independently
        assertEquals("[2, 5]", result.toString());

        // Assert - verify original inputs remain unchanged
        assertEquals("[1, 2, 3]", set1.toString());
        assertEquals("[3, 4]", set2.toString());

        assertNotSame(set1, result);
        assertNotSame(set2, result);
    }

   // ===== complement() =====
   /**
     * Verify A.complement(B) returns elements in B but not A.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementReverseDifference() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Act
        IntegerSet result = set1.complement(set2);

        // Assert
        assertEquals("[4, 5]", result.toString());
        assertEquals(2, result.length());
        assertFalse(result.contains(1));
        assertFalse(result.contains(3));
    }

   /**
     * Verify complement with an empty receiver and with an empty argument.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testComplementEmptyOperands() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);

        IntegerSet emptySet = new IntegerSet();

        // Act
        IntegerSet result1 = emptySet.complement(set);
        IntegerSet result2 = set.complement(emptySet);

        // Assert
        assertEquals("[1, 2]", result1.toString());
        assertTrue(result2.isEmpty());
        assertEquals(0, result2.length());

        assertTrue(emptySet.isEmpty());
        assertEquals("[1, 2]", set.toString());
    }

   /**
     * Modify the complement result and verify neither input changes.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementIndependentResult() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Act
        IntegerSet result = set1.complement(set2);

        // Assert - verify complement
        assertEquals("[3, 4]", result.toString());

        // Act - modify result
        result.remove(3);
        result.add(5);

        // Assert - verify independence
        assertEquals("[4, 5]", result.toString());
        assertEquals("[1, 2]", set1.toString());
        assertEquals("[2, 3, 4]", set2.toString());

        assertNotSame(set1, result);
        assertNotSame(set2, result);
    }

   // ===== isSubsetOf() =====

   /**
     * Verify a proper subset is recognized.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfProperSubset() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(1);
        set2.add(2);
        set2.add(3);

        // Act
        boolean result = set1.isSubsetOf(set2);

        // Assert
        assertTrue(result);
        assertFalse(set2.isSubsetOf(set1));
    }

   /**
     * Verify a set with an element missing from the other set is not a subset.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfNotSubset() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(4);

        IntegerSet set2 = new IntegerSet();
        set2.add(1);
        set2.add(2);
        set2.add(3);

        // Act
        boolean result = set1.isSubsetOf(set2);

        // Assert
        assertFalse(result);
        assertFalse(set2.isSubsetOf(set1));
    }

   /**
     * Verify equal sets are subsets of each other.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsSubsetOfEqualSets() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(1);

        // Act
        boolean result1 = set1.isSubsetOf(set2);
        boolean result2 = set2.isSubsetOf(set1);

        // Assert
        assertTrue(result1);
        assertTrue(result2);
    }
   /**
     * Verify the empty set is a subset of a nonempty set, but not vice versa.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfEmptyCases() {
        // Arrange
        IntegerSet emptySet = new IntegerSet();

        IntegerSet populatedSet = new IntegerSet();
        populatedSet.add(1);
        populatedSet.add(2);

        // Act
        boolean result1 = emptySet.isSubsetOf(populatedSet);
        boolean result2 = populatedSet.isSubsetOf(emptySet);
        boolean result3 = emptySet.isSubsetOf(emptySet);

        // Assert
        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);
    }

   // ===== isDisjoint() =====

   /**
     * Verify disjoint sets return true.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointNoOverlap() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);

        // Act
        boolean result = set1.isDisjoint(set2);

        // Assert
        assertTrue(result);
        assertTrue(set2.isDisjoint(set1));
    }

   /**
     * Verify overlapping sets return false.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointOverlap() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);

        // Act
        boolean result = set1.isDisjoint(set2);

        // Assert
        assertFalse(result);
        assertFalse(set2.isDisjoint(set1));
    }

   /**
     * Verify disjointness with an empty set and with the same nonempty object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointEmptyAndSameOperand() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);

        IntegerSet emptySet = new IntegerSet();

        // Act
        boolean result1 = set.isDisjoint(emptySet);
        boolean result2 = set.isDisjoint(set);
        boolean result3 = emptySet.isDisjoint(emptySet);

        // Assert
        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);
    }

   // ===== symmetricDiff() =====

   /**
     * Verify symmetric difference contains elements appearing in exactly one set.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testSymmetricDiffPartiallyOverlappingSets() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Act
        IntegerSet result = set1.symmetricDiff(set2);

        // Assert
        assertEquals("[1, 2, 4, 5]", result.toString());
        assertEquals(4, result.length());
        assertFalse(result.contains(3));

        assertEquals("[1, 2, 3]", set1.toString());
        assertEquals("[3, 4, 5]", set2.toString());
    }

   /**
     * Verify symmetric difference of identical sets is empty.
     * Assignment 5 equivalent: 2 point(s).
     */  
    @Test
    public void testSymmetricDiffIdenticalSets() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(1);

        // Act
        IntegerSet result1 = set1.symmetricDiff(set2);
        IntegerSet result2 = set1.symmetricDiff(set1);

        // Assert
        assertTrue(result1.isEmpty());
        assertEquals(0, result1.length());

        assertTrue(result2.isEmpty());
        assertEquals(0, result2.length());
    }
   /**
     * Verify behavior with an empty set and with disjoint sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffEmptyAndDisjointSets() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);

        IntegerSet emptySet = new IntegerSet();

        // Act
        IntegerSet result1 = set1.symmetricDiff(emptySet);
        IntegerSet result2 = set1.symmetricDiff(set2);
        IntegerSet result3 = emptySet.symmetricDiff(set1);

        // Assert
        assertEquals("[1, 2]", result1.toString());
        assertEquals("[1, 2, 3, 4]", result2.toString());
        assertEquals("[1, 2]", result3.toString());
    }

   /**
     * Modify the result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIndependentResult() {
        // Arrange
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);

        // Act
        IntegerSet result = set1.symmetricDiff(set2);

        // Assert - verify initial result
        assertEquals("[1, 2, 4]", result.toString());

        // Act - modify result
        result.remove(1);
        result.add(5);

        // Assert - verify independence
        assertEquals("[2, 4, 5]", result.toString());

        assertEquals("[1, 2, 3]", set1.toString());
        assertEquals("[3, 4]", set2.toString());

        assertNotSame(set1, result);
        assertNotSame(set2, result);
    }

   // ===== isEmpty() =====

   /**
     * Verify a newly constructed set is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyNewSet() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act
        boolean result = set.isEmpty();

        // Assert
        assertTrue(result);
        assertEquals(0, set.length());
    }

   /**
     * Verify a set with an element is not empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyPopulatedSet() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(10);

        // Act
        boolean result = set.isEmpty();

        // Assert
        assertFalse(result);
        assertEquals(1, set.length());
    }

   /**
     * Clear a populated set and verify it is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyAfterClear() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(20);

        // Act
        set.clear();

        // Assert
        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }

   // ===== toString() =====

   /**
     * Verify elements appear in ascending numeric order regardless of insertion order.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringAscendingOrder() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(1);
        set.add(3);
        set.add(-2);
        set.add(0);

        // Act
        String result = set.toString();

        // Assert
        assertEquals("[-2, 0, 1, 3, 5]", result);
    }

    /**
      * Verify an empty set formats as [].
      * Assignment 5 equivalent: 1 point(s).
      */
    @Test
    public void testToStringEmptyFormatting() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act
        String result = set.toString();

        // Assert
        assertEquals("[]", result);
    }

    /**
      * Verify comma-space formatting, brackets, and duplicate suppression.
      * Assignment 5 equivalent: 2 point(s).
      */
    @Test
    public void testToStringExactSpacingAndDuplicates() {
        // Arrange
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);

        // Act
        String result = set.toString();

        // Assert
        assertEquals("[1, 2, 3]", result);
        assertEquals(3, set.length());
    }
}
