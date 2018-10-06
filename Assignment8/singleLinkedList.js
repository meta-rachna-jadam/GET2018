function Node(data) {
    this.data = data;
    this.next = null;
}
 
function SinglyList() {
    this._length = 0;
    this.head = null;
}
 
SinglyList.prototype.add = function(value) {
    var node = new Node(value),
        currentNode = this.head;
 
    // add node in empty list
    if (currentNode == null) {
        this.head = node;
        this._length++;
        return node;
    }
 
    // add node in a non-empty list
    while (currentNode.next) {
        currentNode = currentNode.next;
    }
    currentNode.next = node;
    this._length++;
    return node;
};
 
SinglyList.prototype.searchNodeAt = function(position) {
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
 
SinglyList.prototype.remove = function(position) {
    var currentNode = this.head,
        length = this._length,
        count = 0,
        message = {failure: 'Failure: non-existent node in this list.'},
        beforeNodeToDelete = null,
        nodeToDelete = null,
        deletedNode = null;
 
    // remove node at invalid position
    if (position < 0 || position > length-1) {
        throw new Error(message.failure);
    }
 
    // remove node at the first position
    if (position === 0) {
        this.head = currentNode.next;
        deletedNode = currentNode;
        currentNode = null;
        this._length--;
        return deletedNode;
    }
 
    // any other node is removed
    while (count < position) {
        beforeNodeToDelete = currentNode;
        nodeToDelete = currentNode.next;
        currentNode = currentNode.next;
        count++;
    }
 
    beforeNodeToDelete.next = nodeToDelete.next;
    deletedNode = nodeToDelete;
    nodeToDelete = null;
    this._length--;
    return deletedNode;
};

// to print complete list
SinglyList.prototype.print = function() {
    var currentNode = this.head;
    for (var index = 0; index < this._length; index++) {
        console.log(currentNode.data);
        currentNode = currentNode.next;
    }
}

var linkedList = new SinglyList();
linkedList.add(10);
linkedList.add(20);
linkedList.add(30);
linkedList.add(40);
linkedList.add(50);
linkedList.add(60);
linkedList.remove(0);
console.log(linkedList.searchNodeAt(0).data);
console.log("Length = "+linkedList._length);
console.log("\n\nResult:-\n");
linkedList.print();
/*console.log(linkedList)*/