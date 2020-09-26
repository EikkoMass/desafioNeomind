package javaFiles.data;

public class Fornecedor {

	private int id;
	private String name;
	private String email;
	private String comment;
	private String cnpj;
	
	public String toString() {
		return "{ id="+id+", name="+name+",email="+email+", comment="+comment+", cnpj="+cnpj+"}";
	}
	
	public boolean equals(Object obj) {
		
		if(this==obj) return true;
		if(obj==null) return false;
		if(getClass()!=obj.getClass()) return false;
		final Fornecedor other = (Fornecedor) obj;
		if(this.id!= other.id) return false;
		return true;
	}
	
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash  + (int) (this.id ^ (this.id >>> 32));
		return hash;
	}
	
	public long getId() {return this.id;};
	public String getName() {return this.name;};
	public String getEmail() {return this.email;};
	public String getComment() {return this.comment;};
	public String getCnpj() {return this.cnpj;};
	
	public void setId(int id) {this.id = id;};
	public void setName(String name) {this.name = name;};
	public void setEmail(String email) {this.email = email;};
	public void setComment(String comment) {this.comment = comment;};
	public void setCnpj(String cnpj) {this.cnpj = cnpj;};
	
}
