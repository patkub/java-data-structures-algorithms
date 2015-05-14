===================================================
           WELCOME TO THE LINKEDBST TEST           
ALL TREES ARE PRINTED USING IN-ORDER TRAVERSAL
UNLESS OTHERWISE STATED
===================================================

==================================================
               TESTING PRINT METHODS               
==================================================
Tree is printed inorder (left, root, right): 1 3 4 6 9 
Tree is printed preorder (root, left, right): 3 1 4 6 9 
Tree is printed postorder (left, right, root): 1 4 6 9 3 
Size of tree: 5
Root: 3
Element left of root: 1
Element right of root: 4
Parent element of last element: 6

Tree after setting root to 0: 1 0 4 6 9 

==================================================
               TESTING REMOVE METHOD               
==================================================

Trying to remove root node: 
ERROR: We cannot remove a node that has two children.
java.lang.IllegalArgumentException: p has two children

Tree after removing element left of root: 0 4 6 9 
Tree after removing last element added (9): 0 4 6 

==================================================
               TESTING ATTACH METHOD               
==================================================

Left Subtree: 1 2 4 
Right Subtree: 3 8 12 
Attached to a tree with root node of 5: 1 2 4 5 3 8 12 

==================================================
              TESTING INSERTION METHOD             
==================================================

After inserting 7: 7 
After inserting 8: 7 8 
After inserting 9: 7 8 9 
After inserting 1: 1 7 8 9 
After inserting 43: 1 7 8 9 43 
After inserting 5: 1 5 7 8 9 43 
Attempting to insert 5 again...
ERROR: We cannot added an element that already exists in the tree!

==================================================
              TESTING DELETION METHOD              
==================================================

Tree: 3 6 7 8 9 10 13 65 
Tree after deleting 7: 3 6 8 9 10 13 65 
Tree after deleting 13: 3 6 8 9 10 65 
Tree after deleting 8: 3 6 9 10 65 
Tree after deleting 3: 6 9 10 65 
Tree after deleting 65: 6 9 10 
Tree after deleting 10: 6 9 
Tree after deleting 9: 6 

Tree: 1 5 7 9 11 
Tree after deleting 9: 1 5 7 11 
Tree after deleting 5: 1 7 11 

==================================================
               TESTING SEARCH METHOD               
==================================================

Searching for 7 in the following BST: 
1 5 7 8 9 43 
7 was found.
Searching for 19 in the following BST: 
1 5 7 8 9 43 
19 was not found.
Searching for 5 in the following BST: 
1 5 7 8 9 43 
5 was found.
Searching for 9 in the following BST: 
1 5 7 8 9 43 
9 was found.

==================================================
               TESTING DEPTH METHOD                
==================================================
1 5 7 8 9 43 
Depth of root is: 0
Depth of 9 is: 2

==================================================
               TESTING HEIGHT METHOD               
==================================================
1 5 7 8 9 43 
Height of root is: 3
Height of 9 is: 1

==================================================
               TESTING SEARCH METHODS              
==================================================
1 5 7 8 9 43 
Biggest value in tree is: 43
Smallest value in tree is: 1
