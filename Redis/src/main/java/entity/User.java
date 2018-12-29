package entity;

import java.io.Serializable;

// 一定要实现Serializable，否则报错
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private int age;


    public User() {
        super();
    }


    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public User(Long id, String username, int age) {
        super();
        this.id = id;
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", age=" + age + "]";
    }

}

