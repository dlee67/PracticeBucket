/*
	Failed LinkedList
*/
#include <iostream>
#include <cstdio>

using namespace std;

class Node {
	public:		 
		int val;
		Node *next;
		void setVal(int x = 0){
			val = x;
		}
		int getVal(){
			return val;
		}
};

class LinkedList {
	Node* headNode;
	public:
		LinkedList(int val){
			headNode = new Node;
			headNode->setVal(val);
		}
		void newNode(int val){
			Node* temp = new Node;
			temp->setVal(val);
			temp->next = headNode;
			headNode = temp;
		}
		//Should do this recursivly at one point.
		void iterNode(){

			Node *temp = headNode;			

			while(1){
				cout << temp->val << endl;
				if(temp->next == NULL){
					break;	
				}
				temp = temp->next;
			}
		}
};

int main(int argc, char** argv){
	LinkedList list(0);
	list.newNode(1);
	list.newNode(2);
	list.newNode(3);
	list.newNode(4);
	list.iterNode();	

	return 0;
}