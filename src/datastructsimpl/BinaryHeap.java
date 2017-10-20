package datastructsimpl;


class BinaryHeap{
  
  Node []nodeArray;
  int currHeapSize;
  int maxHeapZise;
  
  
  
  public BinaryHeap(){
  }
  
  public BinaryHeap(int heapSize){
    nodeArray = new Node[heapSize];
    currHeapSize = 0;
    maxHeapZise = heapSize;
  }
  
  
  
  
 
  
    
  public void add(Node node){
      if(currHeapSize<maxHeapZise){
          
          nodeArray[currHeapSize]=node;
          trickleUp(currHeapSize);
          currHeapSize++;
          
      }
      
     
      
  } 
    
    
  public Node remove(){
      
      
      Node root = nodeArray[0];
      nodeArray[0]=nodeArray[currHeapSize-1];
      trickleDown(0);
      return root;
      
  }
  
  private void trickleDown(int index){ // swap with child with higher key
      
  }
    
    
  public void printHeap(){
      
      
      for(int i = 0;i<currHeapSize;i++){
          System.out.println(nodeArray[i].getKey());
      }
      
      
  }
    
    private void trickleUp(int i){
        
        if(i==0){
            return;
        }
        else{
            int parent = (i-1)/2;
            while(nodeArray[parent].getKey()>nodeArray[i].getKey()){
                Node temp = nodeArray[parent];
                nodeArray[parent]=nodeArray[i];
                nodeArray[i] = temp;
                i = parent;
                parent = (i-1)/2;
            }
                
        }
    }
    
    
   public static void main(String []args){
      
        System.out.println("Hello There!");
       
       
       BinaryHeap h = new BinaryHeap(10);
       h.add(new Node(4));
        h.add(new Node(3));
        h.add(new Node(2));
        h.add(new Node(1));
       
       
      h.printHeap();
  }
    
    
}


class Node{
    
    int key;
    
    public Node(int key){
        this.key = key;
    }
    
    public void setKey(int key){
        this.key = key;
    }
    public int getKey(){
        return this.key;
    }
    
}
