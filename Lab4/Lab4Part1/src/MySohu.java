/*
 * Name: Sheharyar Alam Khan
 * Lab 4 Part 1
 * Professor Gao
 * 05/08/19
 * CS-170-02
 * Description:
 * This class contains a sorted map that maps a String to a FriendInfo object.
 */
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class MySohu {
	//member variables
	SortedMap<String, FriendInfo> COLLECTION = new TreeMap<String, FriendInfo>();
	/*
	 * public void sort() {
		COLLECTION is already sorted because it is a sorted map.
	}
	 */
	//Empty default constructor
	MySohu(){}
	//sets the COLLECTION equal to the passed COLLECTION
	MySohu(SortedMap<String, FriendInfo> COLLECTION){
		this.COLLECTION = COLLECTION;
	}
	/*
	 * This function adds a friend to the COLLECTION.
	 */
	public boolean add(FriendInfo f) {
		/*converts the string to lower case so that the input for the key is not case sensitive and
		 * so that the list is in order regardless of which letters are in lower case.
		 * for Example: without converting the key to lower case the upper case Z would be above the lowercase a on the list.
		 * 
		 * Zelda	---------------		-----------
		 * alpha	---------------		-----------
		 * beta		---------------		-----------
		 * 
		 * but when converting the key to lowercase all the cases are the same so we will get:
		 * 
		 * alpha	---------------		-----------
		 * beta		---------------		-----------
		 * Zelda	---------------		-----------
		 * 
		 * as only the key is in lower case and not the name member in FriendInfo the name will still have the upper case characters.
		 */
		if(COLLECTION.put(f.name.toLowerCase(), f) == null)
			return (false);
		else
			return (true);
		
	}
	/*
	 * This function deletes a friend from the COLLECTION.
	 */
	public boolean delete(String k)	{
		if(COLLECTION.remove(k.toLowerCase()) == null) //converted to lower case because key is in lower case
			return (false);
		else
			return (true);
	}
	/*
	 * This function returns a well formatted table in string format that contains all the info from the COLLECTION. 
	 */
	public String print() {
		Format format = new Format();
		String str = "";
		str += format.setW("Name", 25, " ");
		str += format.setW("Email", 30, " ");
		str += format.setW("Address", 35, " ");
		str += "\n";
		str += format.setW("", 90, "-");
		str += "\n";
		for(Entry<String, FriendInfo> entry : COLLECTION.entrySet()) {
			str += entry.getValue().toString();
			str += "\n";
		}
		return (str);
	}
	/*
	 * The search function searches the COLLECTION and adds all entries that contain the key in their data to a new SortedMap called results
	 *  and returns results. The results are not case sensitive. so if the collection contains Sherry and the user searches for sherry.  Sherry will
	 *  show up in the results and vice versa.
	 */
	public SortedMap<String, FriendInfo> search(String key){
		SortedMap<String, FriendInfo> results = new TreeMap<String, FriendInfo>();
		for(Entry<String,FriendInfo> entry: COLLECTION.entrySet())
		{//converting everything to lower case allows searching for data in a non case sensitive way.
			if(entry.getValue().toString().toLowerCase().contains(key.toLowerCase())) {
				results.put(entry.getKey(), entry.getValue());
			}
		}
		return results;
		
	}
}

