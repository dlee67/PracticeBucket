
/*

   There is no rotation and stuff.
   
   But this source code is not.

   testing change

*/
class BinTree_and_Recursion{

   Node root;
   
   public void add(int number){
   
      if(root == null){
      
         root = new Node(number);
      
         return; //<- If I don't have that my output will be 3,4,5,5 for in order traverse.
         
      }
   
      add(root, number);
   
   }
   
   public Node add(Node recurNode, int number){
   
      if(recurNode == null){
      
         return new Node(number);//Without making the newNode, I see only that's the possibility.
//Along with the fact that return is the only thing that will actually off the operation manually.      
      
      }else{//This part is the hardest part.

      /*
      
         The point is so that I can come back to the place where I cam from.
      
         Placements of the nodes needs to be determined by the key values
         
         and such.
      
      */ 
      
         if(number < recurNode.key){
         
            //recurNode.left = add(recurNode.left);//I need to be able to retain the information I've passed.   
            //recurNode.left seems to be a correct thing to do.
         
            //You know why recurNode = add(recurNode.left); Doesn't make any sense?
            //Because when recurNode.left = null, the previous recurNode.left will be = null.
            //Doesn't achieve anything.
         /*
            if(recurNode == null){
            
               recureNode = newNode;
            
               return null;
            
            }
         */
            recurNode.left = add(recurNode.left, number);//Whatever I've passed in, its left
//will be itself's left.
         
         }else{
         
            recurNode.right = add(recurNode.right, number);
         
         
         
         }
         
/*

   There is thing about rotation,
   
*/
         /*   
         int leftDepth = depth(recurNode.left);
         
         int rightDepth = depth(recurNode.right);
         
         int depthDiff = leftDepth - rightDepth;
         
         if(depthDiff > 2){
         
            Node b = recurNode;
            
            Node a = recurNode.left;
            
            Node y = a.right;
            
            b.left = y;
            
            a.right = b;
            
            return a;
            
            
         }else if(depthDiff < 2){
         
            Node a = recurNode;
            
            Node b = recurNode.right;
            
            Node y = b.left;
            
            
            b.left = a;
            
            a.right = y;
            
            return b;   
         
         }
         
         Even if I have seen how the thing worked, and understands it abstractly,
         
         I still don't know how to apply.
         
         */
         return recurNode;//<- That's going to return what I've passed?
        
      }
   
   }
   
   public void inOrderTraverse(Node recurNode){
   
      if(recurNode != null){
   
         inOrderTraverse(recurNode.left);
         
         recurNode.display();
         
         inOrderTraverse(recurNode.right);
      
      }
   
   }
   
   public int depth(Node parent){   
   
      if(parent == null){return 0;}
   
      int leftDepth = depth(parent.left);
      int rightDepth = depth(parent.right);
   
      /*
         
         The reason why below statement for me to find the depth is...
         
         rather complicated explanation, but pictorally so simple.
         
         Further the recursion occur for my nodes, +1 is returned, so it kinda stack up and such.
         
         And it is in evitable that I will find the branches along the way
            
      */
      int depthNum = Math.max(leftDepth, rightDepth); 
   
      return depthNum + 1;
   
   }

   public static void main(String args[]){
   
      BinTree_and_Recursion weed = new BinTree_and_Recursion();
      
      weed.add(5);
   
      weed.add(4);
      
      weed.add(2);
      
      weed.add(10);     
      
      weed.add(3);
      
      weed.add(7);
      
      weed.add(6);
      
      weed.add(8);
      
      weed.inOrderTraverse(weed.root);
   
   }

}

/*

   This object will take in integer values and pass it to
   
   key values.
   
*/
class Node{

   int key;
   
   Node right;
   
   Node left;
   
   public Node(int key){
   
      this.key = key;
   
   }
   
   public void display(){
   
      System.out.println("This Node has a value: " + key);
   
   }

}