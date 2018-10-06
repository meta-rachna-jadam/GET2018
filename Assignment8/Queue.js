function Node(data) {
    this.data = data;
    this.next = null;
}
 
function Queue() {
    this.front = null;
    this.rear = null;
}
 
Queue.prototype.enqueue = function(value) {
    var node = new Node(value);
 
    // add node in empty list
    if (this.rear == null) {
        this.front = node;
        this.rear = node;
        return node;
    } else {
    // add node in a non-empty list
        this.rear.next = node;
        this.rear = node;
        return node;
    }
};
 
Queue.prototype.dequeue = function() {
    var message = {failure: 'Failure: Underflow exception.'},
        deletedNode;
    
    // Underflow condition
    if (this.front == null) {
        throw new Error(message.failure);
    } else {
    // remove node from queue
        // if one node in queue
        if (this.front == this.rear) {
            this.rear = null;
        }
        deletedNode = this.front;
        this.front = this.front.next;
    }
    return deletedNode;   
};

// to print complete queue
Queue.prototype.print = function() {
    var currentNode = this.front;
    
   while(currentNode) {
       console.log(currentNode.data);
       currentNode = currentNode.next;
   }
}