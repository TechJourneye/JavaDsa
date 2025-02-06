#include<stdio.h>
#include<stdlib.h>


struct Node {
    int data;
    struct Node* next;
};

static struct Node* tail=NULL;
void printLL(struct Node* head){
    while(head!=NULL){
        printf("%d->",head->data);
        head=head->next;
    }
    printf("NULL");
}
struct Node* createNode(int data){
    struct Node* newNode=(struct Node*)malloc(sizeof(struct Node));
    newNode->data=data;
    newNode->next=NULL;
    return newNode;
}
void insertatBeginning(struct Node** head,int data){
    struct Node* newNode=createNode(data);
    if(*head==NULL){
         newNode->next=*head; 
        *head=newNode;
         tail=newNode;
         return;
    }
    newNode->next=*head;
    *head=newNode;
}
void insertatEnd(struct Node** head,int data){
     struct Node* newNode=createNode(data);
         if (*head == NULL) {
        *head =tail= newNode;
        // tail = newNode; // Update tail when the first node is added
    } else {
        tail->next = newNode;
        tail = newNode; // Update the tail pointer
    }

}
int main(){
    struct Node*head=NULL;

   for(int i=0;i<4;i++){
    insertatBeginning(&head,i);
   }
   insertatEnd(&head,90);
   insertatEnd(&head,50);
    printLL(head);

    return 0;
}