function Node(data) {
    this.data = data;
    this.linkPointer = null;
}
 
function Stack() {
    this.top = null;
}
 
Stack.prototype.push = function(value) {
    var node = new Node(value);
 
    // add node in empty stack
    if (this.isEmpty()) {
        this.top = node;
        return node;
    } else {
    // add node in a non-empty list
        
        node.linkPointer = this.top;
        this.top = node;
        return node;
    }
};
 
Stack.prototype.peek = function() {
    var message = {failure: 'Failure: Stack is Empty.'};
    if (this.isEmpty()) {
        throw new Error(message.failure);
    } else {
        return this.top.data;
    }
    
};

Stack.prototype.isEmpty = function() {
    return (this.top == null);
};
 
Stack.prototype.pop = function() {
    var message = {failure: 'Failure: Underflow exception.'},
        deletedNode;
    
    // Underflow condition
    if (this.isEmpty()) {
        throw new Error(message.failure);
    } else {
    // remove node from stack
        deletedNode = this.top;
        this.top = this.top.linkPointer;
    }
    return deletedNode;   
};

// to print complete stack
Stack.prototype.print = function() {
    var currentNode = this.top;
    while(currentNode) {
        console.log(currentNode.data);
        currentNode = currentNode.linkPointer;
    }
}