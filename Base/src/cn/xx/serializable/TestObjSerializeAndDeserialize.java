package cn.xx.serializable;

/*
把对象转换为字节序列的过程称为对象的序列化。
把字节序列恢复为对象的过程称为对象的反序列化。
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjSerializeAndDeserialize {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		serializePerson();
		
		Person p = deserializePerson();//反序列Perons对象
		System.out.println("name is " + p.getName() + "\n" + "age is " + p.getAge());
	}

	private static void serializePerson() throws FileNotFoundException, IOException {
		Person p = new Person();
		p.setName("beelin");
		p.setAge(25);
		
		ObjectOutputStream s = new ObjectOutputStream(new FileOutputStream(new File("/Users/luzhirong/Desktop/person.txt")));
		s.writeObject(p);
		System.out.println("Person对象序列化成功！");
		s.close();
	}
	
	private static Person deserializePerson() throws Exception, IOException {
		ObjectInputStream s = new ObjectInputStream(new FileInputStream(new File("/Users/luzhirong/Desktop/person.txt")));
		Person p = (Person) s.readObject();
		System.out.println("Person对象反序列化成功！");
		s.close();
		return p;
	}
}
