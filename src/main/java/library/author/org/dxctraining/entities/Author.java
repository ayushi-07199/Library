package library.author.org.dxctraining.entities;


public class Author {
 private String id;
 private String name;
public Author(String name) {
	this.name=name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public int hashCode() {
	int a=id.hashCode();
	return a;
}
	@Override
	public boolean equals(Object arg) {
		if(this==arg) {
			return true;
		}
		
	   if(arg==null || !(arg instanceof Author) ) {
			return false;
	   }
		
	    Author that=(Author)arg;	
		boolean isequal=this.id.equals(that.id);
		return isequal;
	}

 
}
