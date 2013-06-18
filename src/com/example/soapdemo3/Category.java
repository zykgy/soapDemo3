package com.example.soapdemo3;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable{

	private int id;
	private String name;
	private String description;
	private int parentcat;
	private String image;
	private String fullimage;
	private int numberofproducts;
	private String category_publish;
	private String category_browsepage;
	private String category_flypage;
	private int products_per_row;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getParentcat() {
		return parentcat;
	}
	public void setParentcat(int parentcat) {
		this.parentcat = parentcat;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFullimage() {
		return fullimage;
	}
	public void setFullimage(String fullimage) {
		this.fullimage = fullimage;
	}
	public int getNumberofproducts() {
		return numberofproducts;
	}
	public void setNumberofproducts(int numberofproducts) {
		this.numberofproducts = numberofproducts;
	}
	public String getCategory_publish() {
		return category_publish;
	}
	public void setCategory_publish(String category_publish) {
		this.category_publish = category_publish;
	}
	public String getCategory_browsepage() {
		return category_browsepage;
	}
	public void setCategory_browsepage(String category_browsepage) {
		this.category_browsepage = category_browsepage;
	}
	public String getCategory_flypage() {
		return category_flypage;
	}
	public void setCategory_flypage(String category_flypage) {
		this.category_flypage = category_flypage;
	}
	public int getProducts_per_row() {
		return products_per_row;
	}
	public void setProducts_per_row(int products_per_row) {
		this.products_per_row = products_per_row;
	}
	
	     
	     // 1.必须实现Parcelable.Creator接口,否则在获取Person数据的时候，会报错，如下：
	     // android.os.BadParcelableException:
	     // Parcelable protocol requires a Parcelable.Creator object called  CREATOR on class com.um.demo.Person
	     // 2.这个接口实现了从Percel容器读取Person数据，并返回Person对象给逻辑层使用
	     // 3.实现Parcelable.Creator接口对象名必须为CREATOR，不如同样会报错上面所提到的错；
	     // 4.在读取Parcel容器里的数据事，必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
	     // 5.反序列化对象
	
	 
		public static final Parcelable.Creator<Category> CREATOR = new Creator<Category>(){
 
	         @Override
	         public Category createFromParcel(Parcel source) {
	            // TODO Auto-generated method stub
	             // 必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
	        	 Category category = new Category();
	        	 category.setId(source.readInt());
	        	 category.setName(source.readString());
	        	 category.setDescription(source.readString());
	        	 category.setParentcat(source.readInt());
	        	 category.setImage(source.readString());
	        	 category.setFullimage(source.readString());
	        	 category.setNumberofproducts(source.readInt());
	        	 category.setCategory_publish(source.readString());
	        	 category.setCategory_browsepage(source.readString());
	        	 category.setCategory_flypage(source.readString());
	        	 category.setProducts_per_row(source.readInt());
	             return category;
	         }
	 
	         @Override
	         public Category[] newArray(int size) {
	             // TODO Auto-generated method stub
	             return new Category[size];
	         }
	     };
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+this.id+"\nname:"+this.name+"\ndescription:"+this.description+ "\nimage:"+this.image+"\nfullimage:"+this.fullimage +"\nnumberofproducts:"+this.numberofproducts
				+"\ncategory_publish:"+this.category_publish +"\ncategory_browsepage:"+this.category_browsepage+"\ncategory_flypage:"+this.category_flypage+"\nproducts_per_row:"+this.products_per_row;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(id);
		dest.writeString(name);
		dest.writeString(description);
		dest.writeInt(parentcat);
		dest.writeString(image);
		dest.writeString(fullimage);
		dest.writeInt(numberofproducts);
		dest.writeString(category_publish);
		dest.writeString(category_browsepage);
		dest.writeString(category_flypage);
		dest.writeInt(products_per_row);
		
	}
	

}
