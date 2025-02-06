#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node* next;
};

struct queue{
 struct Node *front,*rear;
};

struct Node* createNode(int data){
     struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
      newNode->data = data;
      newNode->next = NULL;
      return newNode;
}

struct queue* createQueue (){
      struct queue* q = (struct queue*)malloc(sizeof(struct queue));
    q->front = q->rear = NULL;
    return q;
}

void enqueue(struct queue* q,int data){
     struct Node* newnode=createNode(data);
     if(q->rear==NULL){
        q->front=q->rear=newnode;
        return;
     }
     q->rear->next=newnode;
     q->rear=newnode;
}

int dequeue(struct queue* q){
    if(q->front==NULL){
        return -1;
    }

    struct Node* temp=q->front;
    int data=temp->data;
    q->front=q->front->next;

    if(q->front==NULL){
        q->rear=NULL;
    }

    free(temp);
    return data;
}

int peek(struct queue* q){
    if(q->front==NULL){
       return -1;
    }
    return q->front->data;
}

int main(){
    struct queue* q=createQueue();
    enqueue(q, 10);
    enqueue(q, 20);
    enqueue(q, 30);
    enqueue(q, 40);
  printf("Front element is %d\n", peek(q));

    // Dequeue operations
    dequeue(q);
    dequeue(q);
      printf("Front element is %d\n", peek(q));

}


// #include <stdio.h>
// #include <stdlib.h>

// // Node structure for linked list
// struct Node {
//     int data;
//     struct Node* next;
// };

// // Queue structure with pointers to front and rear nodes
// struct Queue {
//     struct Node *front, *rear;
// };

// // Function to create a new node
// struct Node* createNode(int data) {
//     struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
//     newNode->data = data;
//     newNode->next = NULL;
//     return newNode;
// }

// // Function to create an empty queue
// struct Queue* createQueue() {
//     struct Queue* q = (struct Queue*)malloc(sizeof(struct Queue));
//     q->front = q->rear = NULL;
//     return q;
// }

// // Enqueue operation (add element to the rear)
// void enqueue(struct Queue* q, int data) {
//     struct Node* newNode = createNode(data);

//     // If queue is empty, front and rear will both point to the new node
//     if (q->rear == NULL) {
//         q->front = q->rear = newNode;
//         printf("%d enqueued to the queue\n", data);
//         return;     
//     }

//     // Add the new node at the rear of the queue and update the rear
//     q->rear->next = newNode;
//     q->rear = newNode;
//     printf("%d enqueued to the queue\n", data);
// }

// // Dequeue operation (remove element from the front)
// int dequeue(struct Queue* q) {
//     if (q->front == NULL) {
//         printf("Queue underflow! Cannot dequeue from an empty queue.\n");
//         return -1;
//     }

//     // Store the front node and move the front pointer to the next node
//     struct Node* temp = q->front;
//     int data = temp->data;
//     q->front = q->front->next;

//     // If front becomes NULL, set rear to NULL (empty queue)
//     if (q->front == NULL)
//         q->rear = NULL;

//     // Free the memory of the dequeued node
//     free(temp);

//     printf("%d dequeued from the queue\n", data);
//     return data;
// }

// // Peek operation (get the front element)
// int peek(struct Queue* q) {
//     if (q->front == NULL) {
//         printf("Queue is empty!\n");
//         return -1;
//     }
//     return q->front->data;
// }

// // Check if the queue is empty
// int isEmpty(struct Queue* q) {
//     return q->front == NULL;
// }

// // Display the queue
// void display(struct Queue* q) {
//     if (isEmpty(q)) {
//         printf("Queue is empty!\n");
//         return;
//     }
//     struct Node* temp = q->front;
//     printf("Queue: ");
//     while (temp != NULL) {
//         printf("%d ", temp->data);
//         temp = temp->next;
//     }
//     printf("\n");
// }

// int main() {
//     struct Queue* q = createQueue();

//     // Enqueue operations
//     enqueue(q, 10);
//     enqueue(q, 20);
//     enqueue(q, 30);
//     enqueue(q, 40);

//     // Display the queue
//     display(q);

//     // Peek at the front element
//     printf("Front element is %d\n", peek(q));

//     // Dequeue operations
//     dequeue(q);
//     dequeue(q);

//     // Display the queue after dequeuing
//     display(q);

//     // Peek at the front element
//     printf("Front element is %d\n", peek(q));

//     return 0;
// }
