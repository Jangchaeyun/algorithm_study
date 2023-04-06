#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct _element {
	char name[21];
}element;

typedef struct _Node* NodePointer;
typedef struct _Node {
	char name[21];
	unsigned int key;
	int height;
	NodePointer leftChild;
	NodePointer rightChild;
	NodePointer link;
}Node;

int getMax(int a, int b) {
	return a > b ? a : b;
}

int getHeight(NodePointer node) {
	if (!node) return 0;
	return node->height;
}

void setHeight(NodePointer node) {
	node->height = getMax(getHeight(node->leftChild), getHeight(node->rightChild)) + 1;
}

NodePointer rotateLL(NodePointer node) {
	NodePointer cNode = node->leftChild;
	node->leftChild = cNode->rightChild;
	cNode->rightChild = node;

	setHeight(node);
	return cNode;
}

NodePointer rotateRR(NodePointer node) {
	NodePointer cNode = node->rightChild;
	node->rightChild = cNode->leftChild;
	cNode->leftChild = node;

	setHeight(node);
	return cNode;
}

NodePointer rotateLR(NodePointer node) {
	node->leftChild = rotateRR(node->leftChild);
	return rotateLL(node);
}

NodePointer rotateRL(NodePointer node) {
	node->rightChild = rotateLL(node->rightChild);
	return rotateRR(node);
}

int getDifference(NodePointer node) {
	if (!node)
		return 0;
	return getHeight(node->leftChild) - getHeight(node->rightChild);
}

NodePointer balance(NodePointer node) {
	int diff = getDifference(node);

	//L OR R judge
	if (diff >= 2) {
		//LL OR LR
		if (getDifference(node->leftChild) >= 1)
			node = rotateLL(node);
		else
			node = rotateLR(node);
	}
	else if (diff <= -2) {
		//RR or RL 
		if (getDifference(node->rightChild) <= -1)
			node = rotateRR(node);
		else
			node = rotateRL(node);
	}
	setHeight(node);

	return node;
}

NodePointer insertNode(NodePointer node, char name[], unsigned int key) {
	if (node == NULL) {
		node = malloc(sizeof(Node));
		strcpy(node->name, name);
		node->key = key;
		node->height = 1;
		node->leftChild = node->rightChild = node->link = NULL;
	}
	else {
		if (node->key > key) {
			node->leftChild = insertNode(node->leftChild, name, key);
			node = balance(node);
		}
		else if (node->key < key) {
			node->rightChild = insertNode(node->rightChild, name, key);
			node = balance(node);
		}
		else {
			NodePointer newNode = malloc(sizeof(Node));
			strcpy(newNode->name, name);
			newNode->key = key;
			newNode->leftChild = newNode->rightChild = NULL;

			newNode->link = node->link;
			node->link = newNode;
		}
	}

	return node;
}

unsigned int StringToInt(char* string) {
	int sum = 0;
	while (*string) {
		sum = sum * 65599 + *string;
		string++;
	}

	return sum;
}

int compare(const void* a, const void* b) {
	return strcmp(((element*)a)->name, ((element*)b)->name);
}

int main(void) {
	int N, M; scanf("%d %d", &N, &M);

	NodePointer root = NULL;
	for (int i = 0; i < N; i++) {
		char name[21]; scanf("%s", name);
		root = insertNode(root, name, StringToInt(name));
	}

	int count = 0; int size = (N > M ? N : M);
	element* storage = malloc(sizeof(element) * size);
	for (int i = 0; i < M; i++) {
		char find[21]; scanf("%s", find);
		unsigned int key = StringToInt(find);

		NodePointer cur = root;
		while (cur) {
			if (cur->key == key) {
				while (cur) {
					if (strcmp(cur->name, find) == 0) {
						strcpy(storage[count++].name, find);
						break;
					}
					cur = cur->link;
				}
				break;
			}

			if (key <= cur->key)
				cur = cur->leftChild;
			else
				cur = cur->rightChild;
		}
	}
	qsort(storage, count, sizeof(element), compare);


	printf("%d\n", count);
	for (int i = 0; i < count; i++) {
		printf("%s\n", storage[i].name);
	}

	return 0;
}