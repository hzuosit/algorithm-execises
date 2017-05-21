// define the node class for entry of hashmap.
class Entry<K, V> {
	 final K key;
	  V value;
	  Entry<K, V> next;
	 // constructor 
	  Entry(K key, V value) {
	     this.key = key;
	     this.value = value;
	  }
	  // get key
	  public K getKey() {
	    return key;
	  }
	  //getvalue
	  public V getValue() {
	    return value;
	  }
	  //set value
	  public void set(V value) {
	    this.value = value;
	  }

}
