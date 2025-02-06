#include <stdio.h>
#include<stdlib.h>
#define size 5

struct circularQueue{
 int items[size];
 int front;int rear;
};
void initilizes(struct circularQueue* q){
    q->front=-1;
    q->rear=-1;
}
int isEmpty(struct circularQueue* q){
 return q->front==-1&&q->rear==-1;
}
int isFull(struct circularQueue* q){
    return (q->rear+1)%size==q->front;
}
void enQueue(struct circularQueue* q,int data){
      if(isFull(q)){
        printf("queue is full");
        return;
      }
      if(isEmpty(q)){
        q->front=0;
      }
      q->rear=(q->rear+1)%size;
      q->items[q->rear]=data;
}
int deQueue(struct circularQueue* q){
    if(isEmpty(q)){
        printf("q is empty");
        return -1;
    }
    int result=q->items[q->front];
    if(q->front==q->rear){
        q->front=-1;
        q->rear=-1;
    }else{
     q->front=(q->front+1)%size;
    }
    return result;
}
int peek(struct circularQueue* q){
    return q->items[q->front];
}
// Function to display the elements of the circular queue
void displayQueue(struct circularQueue* q) {
    if (isEmpty(q)) {
        printf("Queue is empty!\n");
        return;
    }
    printf("Queue elements: ");
    int i = q->front;
    while (1) {
        printf("%d ", q->items[i]);
        if (i == q->rear) {
            break;
        }
        i = (i + 1) % size;
    }
    printf("\n");
}
int main(){
    struct circularQueue q;
    initilizes(&q);
    enQueue(&q,10);
     enQueue(&q,20);
      enQueue(&q,30);
      displayQueue(&q);
      while(!isEmpty(&q)){
        printf("%d\n",peek(&q));
        deQueue(&q);
      }
}