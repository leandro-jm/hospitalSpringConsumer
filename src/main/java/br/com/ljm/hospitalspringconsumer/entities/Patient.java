package br.com.ljm.hospitalspringconsumer.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "patients")
@NoArgsConstructor
@Getter
@Setter
public class Patient implements Serializable {

	@Id
	private Long id;

	private String name;

	private String document;

	private Integer heartRate;

	public Patient(String name, String document, Integer heartRate) {
		this.name = name;
		this.document = document;
		this.heartRate = heartRate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Patient patient = (Patient) o;
		return Objects.equals(id, patient.id) && Objects.equals(name, patient.name) && Objects.equals(document, patient.document) && Objects.equals(heartRate, patient.heartRate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, document, heartRate);
	}

	@Override
	public String toString() {
		return "Patient{" +
				"id=" + id +
				", name='" + name + '\'' +
				", document='" + document + '\'' +
				", heartRate=" + heartRate +
				'}';
	}
}
