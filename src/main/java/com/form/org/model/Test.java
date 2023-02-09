package com.form.org.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="Test")
public class Test extends Utilisateur{
	
	private static final long serialVersionUID = 1L;

	
	
	@Column(name="description1")
	private String description1;
	
	

}
