package org.psnbtech;

public class LabelTestCases {

    /*
     * TEST 1: Labeled Continue
     * Scenario: Processing a matrix. If we find a specific bad value, 
     * we skip the rest of the current row and immediately jump to the next row.
     */
    public void testLabeledContinue() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        rowLoop: // The label
        for (int i = 0; i < matrix.length; i++) {
            
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 5) {
                    System.out.println("Found 5, skipping rest of row " + i);
                    // CFG should draw an edge from here to the 'i++' update block
                    continue rowLoop; 
                }
                System.out.println("Processing: " + matrix[i][j]);
            }
        }
        System.out.println("Matrix processed.");
    }

    /*
     * TEST 2: Labeled Break (Loops)
     * Scenario: A deep search algorithm. Once the target is found, 
     * we bail out of all nested loops immediately to save computation.
     */
    public void testLabeledBreakLoop() {
        boolean found = false;
        
        searchLoop: // The label
        for (int i = 0; i < 10; i++) {
            
            for (int j = 0; j < 10; j++) {
                if (i == 5 && j == 5) {
                    found = true;
                    // CFG should draw an edge from here straight to the final print statement
                    break searchLoop; 
                }
            }
        }
        // Fall-through from the loop AND the labeled break land here
        System.out.println("Search finished. Found: " + found);
    }

    /*
     * TEST 3: Labeled Break (Standalone Block)
     * Scenario: A validation pipeline. If a check fails, we escape the 
     * validation block without running any further checks.
     */
    public void testLabeledBreakBlock() {
        int status = 404;
        
        validationBlock: { // A label attached to a plain code block
            System.out.println("Starting validation...");
            
            if (status != 200) {
                System.out.println("Error encountered, bailing out of validation!");
                // CFG should draw an edge from here straight to the final print statement
                break validationBlock; 
            }
            
            // This is dead code if status != 200
            System.out.println("Validation successful.");
        }
        
        // Fall-through from the block AND the labeled break land here
        System.out.println("Continuing with rest of method.");
    }
}