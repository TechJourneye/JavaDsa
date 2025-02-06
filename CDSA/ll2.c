#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node* next;
};

struct Node* createNode(int data){
    struct Node* newNode=(struct Node*)malloc(sizeof(struct Node));

    newNode->data=data;
    newNode->next=NULL;
    return newNode;
}

void printLL(struct Node* head){
    struct Node* temp=head;

    while(temp!=NULL){
        printf("%d->",temp->data);
        temp=temp->next;
    }
    printf("NULL\n");
}
// delete
void deleteLastnode(struct Node** head){
    if(*head==NULL){
     printf("ll is empty");
     return;
    }
    if((*head)->next==NULL){
        free(*head);
        *head==NULL;
        return;
    }

    struct Node* temp=*head;
    while(temp->next->next!=NULL){
        temp=temp->next;
    }
    free(temp->next);
    temp->next=NULL;
}

void deletebyValue(struct Node** head,int data ){
    if(*head==NULL){
        return;
    }
    if((*head)->data==data){
      struct Node* temp=*head;
      *head=(*head)->next;
      free(temp);
      printf("deleated the node with value %d",data);
      return;
    }

    struct Node* temp=*head;
    while(temp->next!=NULL&&temp->next->data!=data){/////////////////////
        temp=temp->next;
    }
     if (temp->next == NULL) {
        printf("Node with value %d not found.\n", data);
        return;
    }
     struct Node* nodetoDelete=temp->next;
     temp->next=temp->next->next;
     free(nodetoDelete);
     printf("Node with value %d deleated.\n", data);
}

// Function to find the middle node using slow and fast pointer approach
struct Node* getLeftMiddleElement(struct Node* head) {
    if (head == NULL) {
        return NULL;
    }

    struct Node* slow = head;
    struct Node* fast = head;

    // Move fast pointer two steps and slow pointer one step
    while (fast != NULL && fast->next != NULL && fast->next->next != NULL) {
        slow = slow->next;
        fast = fast->next->next;
    }

    return slow; // slow will be at the middle
}

// Function to insert a node at the middle using slow and fast pointer approach
void insertAtMiddle(struct Node** head, int data) {
    struct Node* newNode = createNode(data);

    if (*head == NULL) {
        // If the list is empty, just set the new node as the head
        *head = newNode;
        return;
    }

    // Find the middle node
    struct Node* middle = getLeftMiddleElement(*head);

    // Insert the new node after the middle node
    newNode->next = middle->next;
    middle->next = newNode;
}

int main(){
    struct Node* head=createNode(10);
    head->next=createNode(20);
    head->next->next=createNode(30);
    printf("node before delete\n");
    printLL(head);
     insertAtMiddle(&head,80);
        //  insertAtMiddle(&head,90);
    printLL(head);
           insertAtMiddle(&head,90);
                   //  insertAtMiddle(&head,90);
    printLL(head);
}