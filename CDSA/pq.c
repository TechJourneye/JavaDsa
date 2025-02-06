#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 100  // Maximum size of the heap //

// Structure for the priority queue (binary max heap)
struct PriorityQueue {
    int data[MAX_SIZE];
    int size;
};

// Function to initialize the priority queue
void initialize(struct PriorityQueue* pq) {
    pq->size = 0;
}

// Function to check if the queue is empty
int isEmpty(struct PriorityQueue* pq) {
    return pq->size == 0;
}

// Function to get the index of the parent of a node
int parent(int i) {
    return (i - 1) / 2;
}

// Function to get the index of the left child of a node
int leftChild(int i) {
    return 2 * i + 1;
}

// Function to get the index of the right child of a node
int rightChild(int i) {
    return 2 * i + 2;
}

// Function to swap two elements in the heap
void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Function to insert an element into the priority queue (enqueue)
 void enqueue(struct PriorityQueue* pq,int data ){
  if(pq->size==MAX_SIZE){
    printf("pq is full\n");
    return;
  }
  //insert the new element at the end of the heap
  pq->data[pq->size]=data;
  int i=pq->size;
  pq->size++;
  //restore the max heap property by bubbling up
  while(i!=0&&pq->data[parent(i)]<pq->data[i]){
    swap(&pq->data[parent(i)],&pq->data[i]);
    i=parent(i);
  }
 }

// Function to remove and return the highest priority element (dequeue)

int dequeue(struct PriorityQueue* pq){
    if(isEmpty(pq)){
        printf("pq is empty");
        return -1;
    }
    //root is the heighest priority
    int root=pq->data[0];
    //put last element in the root
    pq->data[0]=pq->data[pq->size-1];
    pq->size--;
    int i=0;
    //restore the max heap propertu by bubbling down
    while(1){
        int left=leftChild(i);
        int right=rightChild(i);
        int largest=i;
        if(left<pq->size&&pq->data[left]>pq->data[largest]){
            largest=left;
        }
        if(right<pq->size&&pq->data[right]>pq->data[largest]){
            largest=right;
        }
        if(largest==i){
            break;
        }
        swap(&pq->data[largest],&pq->data[i]);
        i=largest;
    }
    return root;
}
// Function to peek at the highest priority element
int peek(struct PriorityQueue* pq) {
    if (isEmpty(pq)) {
        printf("Priority Queue is empty.\n");
        return -1;
    }
    return pq->data[0];
}

// Function to display the priority queue
void display(struct PriorityQueue* pq) {
    if (isEmpty(pq)) {
        printf("Priority Queue is empty.\n");
        return;
    }
    printf("Priority Queue: ");
    for (int i = 0; i < pq->size; i++) {
        printf("%d ", pq->data[i]);
    }
    printf("\n");
}

// Main function to test the priority queue
int main() {
    // struct PriorityQueue pq;
    // initialize(&pq);

    // printf("Is the queue empty? %s\n", isEmpty(&pq) ? "Yes" : "No");

    // enqueue(&pq, 10); 
    // enqueue(&pq, 20);
    // enqueue(&pq, 5);
    // enqueue(&pq, 30);

    // printf("Priority Queue after enqueues:\n");
    // display(&pq);

    // printf("Is the queue empty? %s\n", isEmpty(&pq) ? "Yes" : "No");

    // printf("Peek: %d\n", peek(&pq));

    // printf("Dequeue: %d\n", dequeue(&pq));
    // printf("Priority Queue after dequeue:\n");
    // display(&pq);

    // printf("Dequeue: %d\n", dequeue(&pq));
    // printf("Priority Queue after another dequeue:\n");
    // display(&pq);

    // printf("Is the queue empty? %s\n", isEmpty(&pq) ? "Yes" : "No");

    // return 0;
    printf("%d",(15%8));
}







// #include <stdio.h>
// #include <stdlib.h>

// // Node structure for the priority queue
// struct Node {
//     int data;
//     struct Node* next;
// };

// // Function to create a new node
// struct Node* createNode(int data) {
//     struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
//     newNode->data = data;
//     newNode->next = NULL;
//     return newNode;
// }

// // Function to insert an element into the priority queue
// // Higher values are treated as higher priority
// void enqueue(struct Node** head, int data) {
//     struct Node* newNode = createNode(data);

//     // If the queue is empty or the new node has the highest priority
//     if (*head == NULL || (*head)->data < data) {
//         newNode->next = *head;
//         *head = newNode;
//         return;
//     }

//     // Find the correct position to insert the new node
//     struct Node* current = *head;
//     while (current->next != NULL && current->next->data >= data) {
//         current = current->next;
//     }
//     newNode->next = current->next;
//     current->next = newNode;
// }

// // Function to remove and return the element with the highest priority
// int dequeue(struct Node** head) {
//     if (*head == NULL) {
//         printf("Priority Queue is empty.\n");
//         return -1;
//     }

//     struct Node* temp = *head;
//     int data = temp->data;
//     *head = (*head)->next;
//     free(temp);
//     return data;
// }

// // Function to peek at the highest priority element
// int peek(struct Node* head) {
//     if (head == NULL) {
//         printf("Priority Queue is empty.\n");
//         return -1;
//     }
//     return head->data;
// }

// // Function to check if the queue is empty
// int isEmpty(struct Node* head) {
//     return head == NULL;
// }
// // Function to display the priority queue
// void display(struct Node* head) {
//     if (head == NULL) {
//         printf("Priority Queue is empty.\n");
//         return;
//     }
//     printf("Priority Queue: ");
//     while (head != NULL) {
//         printf("%d -> ", head->data);
//         head = head->next;
//     }
//     printf("NULL\n");
// }

// // Main function to test the priority queue
// int main() {
//     struct Node* pq = NULL;

//     enqueue(&pq, 10);
//     enqueue(&pq, 20);
//     enqueue(&pq, 5);
//     enqueue(&pq, 30);

//     printf("Priority Queue after enqueues:\n");
//     display(pq);

//     printf("Peek: %d\n", peek(pq));

//     printf("Dequeue: %d\n", dequeue(&pq));
//     printf("Priority Queue after dequeue:\n");
//     display(pq);

//     printf("Dequeue: %d\n", dequeue(&pq));
//     printf("Priority Queue after another dequeue:\n");
//     display(pq);

//     return 0;
// }

