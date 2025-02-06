#include <stdio.h>
#include <stdlib.h>

// Define the structure for the tree node
struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

// Function to create a new node
struct Node* newNode(int data) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = data;
    node->left = NULL;
    node->right = NULL;
    return node;
}

void preorder(struct Node* node) {
    if (node == NULL) {
        return;  // Base case: If the node is null, return
    }

    // 1. Visit the root node
    printf("%d ", node->data);

    // 2. Traverse the left subtree
    preorder(node->left);

    // 3. Traverse the right subtree
    preorder(node->right);
}

int main() {
    // Manually creating a tree for demonstration
    struct Node* root = newNode(1);         // Create root node with data 1
    root->left = newNode(2);                // Left child of root
    root->right = newNode(3);               // Right child of root
    root->left->left = newNode(4);          // Left child of node 2
    root->left->right = newNode(5);         // Right child of node 2

    // Preorder traversal of the binary tree
    printf("Pre-order traversal: ");
    preorder(root);

    return 0;
}
