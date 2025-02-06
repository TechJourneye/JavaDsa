#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node* next;
    struct Node* prev;
};
  struct Node* createNode(int data){
    struct Node* newNode=(struct Node*)malloc(sizeof(struct Node));
    newNode->data=data;
    newNode->next=NULL;
    newNode->prev=NULL;
    return newNode;
  }

  void insertfirst(struct Node** head,int data){
    struct Node*  newNode =createNode(data);
    if(*head==NULL){
        *head=newNode;
        return;
    }
     newNode->next=*head;
     (*head)->prev=newNode;
     *head=newNode;
  }
  void deletefirst(struct Node** head){
    if((*head)==NULL){
        return;
    }
     struct Node* temp=*head;
     *head=(*head)->next;
     if((*head)!=NULL){
        (*head)->prev=NULL;
     }
     free(temp);
  }

  void printdll(struct Node* head){
    struct Node* temp=head;
    while(temp!=NULL){
        printf("%d<->",temp->data);
           if (temp->next == NULL) break; 
        temp=temp->next;
    }
    printf("NULL\n");
    printf("previous traversal");
    while(temp!=NULL){
        printf("%d<-",temp->data);
        temp=temp->prev;
    }
        printf("NULL\n");
  }

int main(){
    struct Node* head=NULL;
    insertfirst(&head,10);
    insertfirst(&head,20);
    insertfirst(&head,30);
    printf("after insertion\n");
    printdll(head);
    deletefirst(&head);
    printf("after deletion");
    printdll(head);
    return 0;
}