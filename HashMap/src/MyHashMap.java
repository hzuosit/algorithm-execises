import java.util.*;
/* support operation : size(), isEmpty(), put(K key, V value), get(K key),
 *   									 remove(K key), containsKey(K key), containsValue(V value), 
 *   										clear().
 */
public class MyHashMap<K, V> {
	// some field of hashmap
  public static final float LOADFACTOR = 0.75f;
  public static final int DEFAULT_CAPACITY = 16;
  private Entry<K, V>[] bucket;
  private int size;
  private float loadFactor;
	//constructors
	public MyHashMap() {
		this(DEFAULT_CAPACITY, LOADFACTOR);
	}
  public MyHashMap(int cap, float loadFactor) {
		if (cap <= 0) {
		  throw new IllegalArgumentException("cap should be larger than zero.");	
		}
		this.bucket = (Entry<K, V>[]) (new Entry[cap]);  // need to read the generic tutorial to figure out why
		this.size = 0;
		this.loadFactor = loadFactor;
	}
  
  //hash
  private int hash(K key) {
  	 // the hashmap could have one null key only, maps to bucket[0]
   if (key == null) {
  	   return 0;
   }
   // post processing for make all hashvalue positive.
   return key.hashCode() & 0x7FFFFFFF;
  }
  //getIndex
  private int getIndex(K key) {
  	  return hash(key) % bucket.length;
  }
  //equal key
  private boolean equalKey(K k1, K k2) {
  	  return k1 == k2 || k1 != null && k1.equals(k2);
  }
  // equal value
  private boolean equalValue(V v1, V v2) {
  	  return v1 == v2 || v1 != null && v1.equals(v2);
  }
  public boolean containsKey(K key) {
		int index = getIndex(key);
		Entry<K,V> entry = bucket[index];
		while (entry != null) {
			if (equalKey(entry.getKey(), key)) {
				return true;
			}
			entry  = entry.next;
		}
		return false;
	}
	public boolean containsValue(V value) {
		//corner case
		if (isEmpty()) {
			return false;
		}
	  	// go through all entry to find whether the value 
		// is inside
		for (Entry<K, V> e : bucket) {
			while (e != null) {
				if (equalValue(value, e.getValue())) {
					return true;
				}
				e = e.next;
			}
		}
		return false;
	}
  //rehashing
	
	public V put(K key, V value) {
		Entry<K, V> head = bucket[getIndex(key)];
		Entry<K, V> node = head;
		while (node != null) {
			// if this key is already associated with a value, replace the value and return 
			// the old value
			if (equalKey(key, node.getKey())) {
				V result = node.getValue();
				node.set(value);
				return result;
			}
		}
		// if the key is new.append the key value entry to the head of the linekd list.
		Entry<K, V> newHead = new Entry<K, V>(key, value);
		newHead.next = head;
		//update the head of entry for bucket. and update size
		bucket[getIndex(key)] = newHead;
		size++;
		// the put action also could trigger rehashing.
		if (needRehashing()) {
			rehashing();
		}
		return null;
	}
	
	//need Rehasing
	private boolean needRehashing() {
		float loadRatio = (size + 0.0f) / bucket.length;
		return loadRatio >= loadFactor;
	}
	
	// rehasing
	private void rehashing() {
		//double the size of bucket array.
		Entry<K,V>[] newArray = (Entry<K,V>[])(new Entry[2 * bucket.length]);
		Entry<K, V>[] oldTable = bucket;
		bucket = newArray;
		for (Entry<K, V> e : oldTable) {
			while (e != null) {
				put(e.getKey(), e.getValue());
				e = e.next;
				size--; // cause put method size++, but when rehashing size not changed.
			}
		}
	}
	// if key is not in HashMap return null
	public V get(K key) {
		Entry<K, V> head = bucket[getIndex(key)];
		while (head != null) {
			if (equalKey(key, head.getKey())) {
				return head.getValue();
			}
			head = head.next;
		}
		return null;
	}
	// remove key value pair based on key
	public V remove(K key) {	
		Entry<K, V> e = removeEntryByKey(key);
		return e == null ? null : e.getValue();
	}
	// delete entry by key
	private Entry<K, V> removeEntryByKey(K key) {
		Entry<K, V> pre = bucket[getIndex(key)];
		Entry<K, V> e = pre;
		while (e != null) {
			Entry<K, V> next = e.next;
			if (equalKey(key, e.getKey())) {
				//if only one element in this bucket.
				if (pre == e) {
				  bucket[getIndex(key)] = next;
				}
				else {
					pre.next = next;
				}
				size--;
				return e;
			}
			pre = e;
			e = next;
		}
		return null;
	}
	
	public int size() {
		return size;
	}
	// getCap function just for test usage.
	public int getCap()  {
		return bucket.length;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	public void clear() {
		Arrays.fill(bucket, null);
	}
}
