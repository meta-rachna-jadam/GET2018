function Node(value) {
    this.data = value;
    this.previous = null;
    this.next = null;
}
 
function DoublyList() {
    this._length = 0;
    this.head = null;
    this.tail = null;
}
 
DoublyList.prototype.add = function(value) {
    var node = new Node(value);
 
    // add node in non-empty list
    if (this._length) {
        this.tail.next = node;
        node.previous = this.tail;
        this.tail = node;
    } else {
        // add node in empty list
        this.head = node;
        this.tail = node;
    }
 
    this._length++;
    return node;
};
 
DoublyList.prototype.searchNodeAt = function(position) {
    var currentNode = this.head,
        length = this._length,
        count = 0,
        message = {failure: 'Failure: non-existent node in this list.'};
 
    // search node at invalid position
    if (length === 0 || position < 0 || position > length-1) {
        throw new Error(message.failure);
    }
 
    // search node at valid position
    while (count < position) {
        currentNode = currentNode.next;
        count++;
    }
 
    return currentNode;
};
 
DoublyList.prototype.remove = function(position) {
    var currentNode = this.head,
        length = this._length,
        count = 0,
        message = {failure: 'Failure: non-existent node in this list.'},
        message = {success: 'Success: node remove successfully.'},
        beforeNodeToDelete = null,
        nodeToDelete = null,
        deletedNode = null;
 
    // remove node at invalid position
    if (length === 0 || position < 0 || position > length-1) {
        throw new Error(message.failure);
    }
 
    // remove node at the first position
    if (position === 0) {
        this.head = currentNode.next;
 
        // there is a second node
        if (this.head != null) {
            this.head.previous = null;
        // there is no second node
        } else {
            this.head = null;
            this.tail = null;
        }
 
    // the last node is removed
    } else if (position === this._length-1) {
        this.tail = this.tail.previous;
        this.tail.next = null;
    // a middle node is removed
    } else {
        while (count < position) {
            currentNode = currentNode.next;
            count++;
        }
 
        beforeNodeToDelete = currentNode.previous;
        nodeToDelete = currentNode;
        afterNodeToDelete = currentNode.next;
 
        beforeNodeToDelete.next = afterNodeToDelete;
        afterNodeToDelete.previous = beforeNodeToDelete;
        deletedNode = nodeToDelete;
        nodeToDelete = null;
    }
 
    this._length--;
    return message.success;
};

// to print complete list
DoublyList.prototype.print = function() {
    var currentNode = this.head;
    for (var index = 0; index < this._length; index++) {
        console.log(currentNode.data);
        currentNode = currentNode.next;
    }
}

var linkedList = new DoublyList();
linkedList.add(10);
console.log(linkedList.searchNodeAt(0).head);
linkedList.remove(0);
linkedList.add(10);
//console.log(linkedList.searchNodeAt(4).data);
console.log("Length = "+linkedList._length);
console.log("\n\nResult:-\n");
linkedList.print();