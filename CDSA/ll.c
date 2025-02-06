#include <stdio.h>
#include <stdlib.h>

// Define the structure for a linked list node
struct Node {
    int data;
    struct Node* next;
};

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if (!newNode) {
        printf("Memory allocation failed\n");
        exit(1);
    }
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Function to insert a node at the beginning of the linked list
void insertAtBeginning(struct Node** head, int data) {
    struct Node* newnode=createNode(data);
    newnode->next=*head;
    *head=newnode;
}

// Function to insert a node at the end of the linked list
void insertAtEnd(struct Node** head, int data) {
       
    struct Node* newNode = createNode(data);
    if (*head == NULL) {  // If the list is empty
        *head = newNode;
        return;
    }
    struct Node* temp = *head;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = newNode;
}

// Function to delete a node at the beginning of the linked list
void deleteAtBeginning(struct Node** head) {
    if (*head == NULL) {
        printf("The list is empty. Nothing to delete.\n");
        return;
    }
    struct Node* temp = *head;
    *head = (*head)->next; // Move the head pointer to the next node
    free(temp);            // Free the old head node
    printf("Deleted the first node.\n");
}

// Function to delete a node at the end of the linked list
void deleteAtEnd(struct Node** head) {
    if (*head == NULL) {
        printf("The list is empty. Nothing to delete.\n");
        return;
    }
    if ((*head)->next == NULL) { // Only one node in the list
        free(*head);
        *head = NULL;
        printf("Deleted the last node.\n");
        return;
    }
    struct Node* temp = *head;
    while (temp->next->next != NULL) { // Find the second-last node
        temp = temp->next;
    }
    free(temp->next); // Free the last node
    temp->next = NULL;
    printf("Deleted the last node.\n");
}

// Function to delete a node by value
void deleteByValue(struct Node** head, int value) {
    if (*head == NULL) {
        printf("The list is empty. Nothing to delete.\n");
        return;
    }
    // If the head node itself holds the value
    if ((*head)->data == value) {
        struct Node* temp = *head;
        *head = (*head)->next;
        free(temp);
        printf("Deleted the node with value %d.\n", value);
        return;
    }
    // Search for the node to be deleted
    struct Node* temp = *head;
    while (temp->next != NULL && temp->next->data != value) {
        temp = temp->next;
    }
    // If the value is not found
    if (temp->next == NULL) {
        printf("Node with value %d not found.\n", value);
        return;
    }
    // Unlink the node and free memory
    struct Node* nodeToDelete = temp->next;
    temp->next = temp->next->next;
    free(nodeToDelete);
    printf("Deleted the node with value %d.\n", value);
}

// Function to print the linked list
void printList(struct Node* head) {
    while (head != NULL) {
        printf("%d -> ", head->data);
        head = head->next;
    }
    printf("NULL\n");
}

// Main function to demonstrate the functionality
int main() {
    struct Node* head = NULL;

    // Insert elements at the beginning
    insertAtBeginning(&head, 10);
    insertAtBeginning(&head, 20);
    insertAtBeginning(&head, 30);

    printf("Linked list after inserting at the beginning: ");
    printList(head);

    // Insert elements at the end
    insertAtEnd(&head, 40);
    insertAtEnd(&head, 50);

    printf("Linked list after inserting at the end: ");
    printList(head);

    // Delete the first node
    deleteAtBeginning(&head);
    printf("Linked list after deleting the first node: ");
    printList(head);

    // Delete the last node
    deleteAtEnd(&head);
    printf("Linked list after deleting the last node: ");
    printList(head);

    // Delete a node by value
    deleteByValue(&head, 20);
    printf("Linked list after deleting the node with value 20: ");
    printList(head);

    // Attempt to delete a non-existent value
    deleteByValue(&head, 100);
    printf("Linked list after attempting to delete a non-existent value: ");
    printList(head);

    return 0;
}







































// // #include<stdio.h>
// // #include<stdlib.h>

// // // Definition of Node structure
// // struct Node {
// //     int data;
// //     struct Node *next;
// // };

// // // Function to traverse and print the linked list
// // void LLtraversal(struct Node *ptr) {
// //     while (ptr != NULL) {
// //         printf("%d ", ptr->data);
// //         ptr = ptr->next;
// //     }
// // }

// // // Function to insert a new node at the beginning of the linked list
// // struct Node *insertatBeginning(struct Node *head, int data) {
// //     struct Node *ptr = (struct Node *)malloc(sizeof(struct Node));
// //     ptr->next = head;
// //     ptr->data = data;
// //     return ptr;
// // }
// // // function insert at index
// // struct Node *insertatIndx(struct Node *head, int data,int index){
// //     if(index==0){
// //         head=insertatBeginning(head,data);
// //         return head;
// //     }
// //     struct Node *ptr = (struct Node *)malloc(sizeof(struct Node));
// //     struct Node *p=head;
// //     for(int i=0;i<index-1;i++){
// //         p=p->next;
// //     }
// //     ptr->data=data;
// //     ptr->next=p->next;
// //     p->next=ptr;
// //     return head;
// // }
// // int main() {
// //     struct Node *head = NULL; // Initialize head to NULL

// //     // Inserting nodes at the beginning of the linked list
// //     head = insertatBeginning(head, 4);
// //     head = insertatBeginning(head, 3);
// //     head = insertatBeginning(head, 2);
// //     head = insertatBeginning(head, 1);

// //     // Traversing and printing the linked list
// //     LLtraversal(head);
// //      head=insertatIndx(head,90,0);
// //       LLtraversal(head);
// //     return 0;
// // }

// #include <stdio.h>
// #include <stdlib.h>

// // Define the structure for a linked list node
// struct Node {
//     int data;
//     struct Node* next;
// };

// // Function to create a new node
// struct Node* createNode(int data) {
//     struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
//     if (!newNode) {
//         printf("Memory allocation failed\n");
//         exit(1);
//     }
//     newNode->data = data;
//     newNode->next = NULL;
//     return newNode;
// }

// // Function to insert a node at the beginning of the linked list
// struct Node* insertAtBeginning(struct Node* head, int data) {
//     struct Node* newNode = createNode(data);
//     newNode->next = head;
//     return newNode;
// }

// // Function to insert a node at the end of the linked list
// struct Node* insertAtEnd(struct Node* head, int data) {
//     struct Node* newNode = createNode(data);
//     if (head == NULL) {
//         return newNode;
//     }
//     struct Node* temp = head;
//     while (temp->next != NULL) {
//         temp = temp->next;
//     }
//     temp->next = newNode;
//     return head;
// }

// // Function to delete the first node (beginning of the linked list)
// struct Node* deleteAtBeginning(struct Node* head) {
//     if (head == NULL) {
//         printf("The list is empty.\n");
//         return head;
//     }
//     struct Node* temp = head;
//     head = head->next;  // Move head to the next node
//     free(temp);         // Free the old head node
//     return head;
// }

// // Function to delete the last node (end of the linked list)
// struct Node* deleteAtEnd(struct Node* head) {
//     if (head == NULL) {
//         printf("The list is empty.\n");
//         return head;
//     }
//     if (head->next == NULL) {  // Only one node in the list
//         free(head);
//         return NULL;
//     }
//     struct Node* temp = head;
//     while (temp->next != NULL && temp->next->next != NULL) {
//         temp = temp->next;
//     }
//     free(temp->next);  // Free the last node
//     temp->next = NULL; // Set the second last node's next to NULL
//     return head;
// }

// // Function to delete a node at a specific position
// struct Node* deleteAtPosition(struct Node* head, int position) {
//     if (head == NULL) {
//         printf("The list is empty.\n");
//         return head;
//     }

//     struct Node* temp = head;

//     // If the head node is to be deleted
//     if (position == 0) {
//         head = head->next;
//         free(temp);
//         return head;
//     }

//     // Find the node just before the node to be deleted
//     for (int i = 0; temp != NULL && i < position - 1; i++) {
//         temp = temp->next;
//     }

//     // If the position is more than the number of nodes
//     if (temp == NULL || temp->next == NULL) {
//         printf("Position out of bounds.\n");
//         return head;
//     }

//     struct Node* nodeToDelete = temp->next;
//     temp->next = temp->next->next; // Unlink the node from the list
//     free(nodeToDelete);            // Free memory of the deleted node
//     return head;
// }

// // Function to delete a node by value
// struct Node* deleteByValue(struct Node* head, int value) {
//     if (head == NULL) {
//         printf("The list is empty.\n");
//         return head;
//     }

//     // If the head node itself holds the value to be deleted
//     if (head->data == value) {
//         struct Node* temp = head;
//         head = head->next;
//         free(temp);
//         return head;
//     }

//     struct Node* temp = head;
//     while (temp->next != NULL && temp->next->data != value) {
//         temp = temp->next;
//     }

//     // If the value is not found
//     if (temp->next == NULL) {
//         printf("Value not found.\n");
//         return head;
//     }

//     // Node to be deleted is found
//     struct Node* nodeToDelete = temp->next;
//     temp->next = temp->next->next; // Unlink the node from the list
//     free(nodeToDelete);            // Free the memory
//     return head;
// }

// // Function to print the linked list
// void printList(struct Node* head) {
//     while (head != NULL) {
//         printf("%d -> ", head->data);
//         head = head->next;
//     }
//     printf("NULL\n");
// }

// // Main function to demonstrate the functionality
// int main() {
//     struct Node* head = NULL;

//     // Insert elements at the beginning
//     head = insertAtBeginning(head, 10);
//     head = insertAtBeginning(head, 20);
//     head = insertAtBeginning(head, 30);

//     printf("Linked list after inserting at the beginning: ");
//     printList(head);

//     // Insert elements at the end
//     head = insertAtEnd(head, 40);
//     head = insertAtEnd(head, 50);

//     printf("Linked list after inserting at the end: ");
//     printList(head);

//     // Delete the first node
//     head = deleteAtBeginning(head);
//     printf("Linked list after deleting the beginning node: ");
//     printList(head);

//     // Delete the last node
//     head = deleteAtEnd(head);
//     printf("Linked list after deleting the last node: ");
//     printList(head);

//     // Delete the node at position 1
//     head = deleteAtPosition(head, 1);
//     printf("Linked list after deleting the node at position 1: ");
//     printList(head);

//     // Delete the node with value 40
//     head = deleteByValue(head, 40);
//     printf("Linked list after deleting the node with value 40: ");
//     printList(head);

//     return 0;
// }


