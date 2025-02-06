#include <stdio.h>
#include <stdlib.h>

#define MAX 5

struct stack{
    int arr[MAX];
    int top;
};

void init(struct stack* st){
    st->top=-1;
}
int isEmpty(struct stack* st){
    return st->top==-1;
}

int isFull(struct stack* st){
    return st->top==MAX-1;
}

void push(struct stack* st,int data){
    if(isFull(st)){
        printf("overflow\n");
        return;
    }
st->arr[++(st->top)]=data;

}

int pop(struct stack* st){
    if(isEmpty(st)){
        printf("underflow\n");
        return -1;
    }
    return st->arr[(st->top)--];
}

// Display all elements of the stack
void display(struct stack* st) {
    if (isEmpty(st)) {
        printf("Stack is empty!\n");
        return;
    }
    printf("Stack elements: ");
    for (int i = 0; i <= st->top; i++) {
        printf("%d ", st->arr[i]);
    }
    printf("\n");
}

int main() {
    struct stack stack;
    init(&stack);  // Initialize the stack

    // Push elements onto the stack
    push(&stack, 10);
    push(&stack, 20);
    push(&stack, 30);
    push(&stack, 40);
    push(&stack, 50);
    push(&stack, 60);  // This will trigger stack overflow

    // Display the stack
    // display(&stack);

    // Peek at the top element
    // printf("Top element is %d\n", peek(&stack));

    // Pop elements from the stack
    printf("Popped element: %d\n", pop(&stack));
    printf("Popped element: %d\n", pop(&stack));

    // Display the stack after popping
    display(&stack);

    return 0;
}




































// #include <stdio.h>
// #include <stdlib.h>

// struct Node {
//     int data;
//     struct Node* next;
// };
// struct Node* createNode(int data){
//    struct Node* newNode=(struct Node*)malloc(sizeof(struct Node));
//    newNode->data=data;
//    newNode->next=NULL;
//    return newNode;
// }
// int isEmpty(struct Node* top){
//     return top==NULL;
// }

// void push(struct Node** top,int data){
//      struct Node* newNode=createNode(data);
//      if(*top==NULL){
//         *top=newNode;
//         return;
//      }
//      newNode->next=*top;
//      *top=newNode;
  
// }
// int pop(struct Node** top){

//      if(*top==NULL){
//        printf("stack underflow");
//         return -1;
//      }
//     struct Node* poppedData=*top;
//     int data =poppedData->data;
//     *top=(*top)->next;
//     free(poppedData);
//     return data;
  
// }

//  int peek(struct Node** top){
//     return (*top)->data;
//  }
// int main(){
//    struct Node* st=NULL;
//    push(&st,4);
//     push(&st,2);
//     push(&st,5);  

//     printf("%d",pop(&st));
//         printf("%d",pop(&st));
//             printf("%d",pop(&st));

// }