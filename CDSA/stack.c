#include <stdio.h>
#include <stdlib.h>

// Define a node for the linked list
struct Node {
    int data;
    struct Node* next;
};

// // Function to create a new node
// struct Node* createNode(int data) {
//     struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
//     newNode->data = data;
//     newNode->next = NULL;
//     return newNode;
// }

// // Function to push an element onto the stack
// void push(struct Node** top, int data) {
//     struct Node* newNode = createNode(data);
//     newNode->next = *top;
//     *top = newNode; // Update the top pointer
//     printf("Pushed %d onto the stack\n", data);
// }

// // Function to check if the stack is empty
// int isEmpty(struct Node* top) {
//     return top == NULL;
// }

// // Function to pop an element from the stack
// int pop(struct Node** top) {
//     if (isEmpty(*top)) {
//         printf("Stack Underflow! Cannot pop from an empty stack.\n");
//         return -1; // Return an error value
//     }
//     struct Node* temp = *top;
//     int poppedData = temp->data;
//     *top = temp->next; // Move the top pointer to the next node
//     free(temp); // Free the memory of the popped node
//     printf("Popped %d from the stack\n", poppedData);
//     return poppedData;
// }

// // Function to peek at the top element of the stack
// int peek(struct Node* top) {
//     if (isEmpty(top)) {
//         printf("Stack is empty. No top element.\n");
//         return -1; // Return an error value
//     }
//     return top->data;
// }

// // Function to display the stack
int isEmpty(struct Node* top){
    return top==NULL;
}
void displayStack(struct Node* top) {
    if (isEmpty(top)) {
        printf("Stack is empty.\n");
        return;
    }
    printf("Stack: ");
    while (top != NULL) {
        printf("%d -> ", top->data);
        top = top->next;
    }
    printf("NULL\n");
}

// // Main function to demonstrate stack operations
// int main() {
//     struct Node* stack = NULL; // Initialize stack as empty

//     // Push elements onto the stack
//     push(&stack, 10);
//     push(&stack, 20);
//     push(&stack, 30);

//     // Display the stack
//     displayStack(stack);

//     // Peek at the top element
//     printf("Top element is %d\n", peek(stack));

//     // Pop elements from the stack
//     pop(&stack);
//     pop(&stack);

//     // Display the stack again
//     displayStack(stack);

//     // Pop the last element
//     pop(&stack);

//     // Try popping from an empty stack
//     pop(&stack);

//     return 0;
// }
void push(struct Node** top,int data){
    struct Node* newNode=(struct Node*)malloc(sizeof(struct Node));
    newNode->data=data;
    newNode->next=*top;
    *top=newNode;
    // printf("Element %d pushed into the stack",data);
}
int pop(struct Node** top){
    struct Node* temp=*top;
    int poppedData=temp->data;
    *top=temp->next;
    free(temp);
    return poppedData;
}
int main (){
struct Node* stack=NULL;
push(&stack,9);
push(&stack,4);
push(&stack,7);
displayStack(stack);
printf("%d->popped from stack",pop(&stack));
printf("\n");
displayStack(stack);

}