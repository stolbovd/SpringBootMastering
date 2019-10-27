package ru.inkontext.persons.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "person")
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Getter
@Slf4j
public class Person extends AbstractAggregateRoot {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "per_seq")
	@SequenceGenerator(name = "per_seq", sequenceName = "per_seq", allocationSize = 1)
	@Column(name = "per_id")
	@Access(AccessType.PROPERTY)
	@Setter
	private Long personId;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "family", column = @Column(name = "per_family")),
			@AttributeOverride(name = "name", column = @Column(name = "per_name")),
			@AttributeOverride(name = "secname", column = @Column(name = "per_secname"))
	})
	private FullName fullName;

	@Column(name = "per_birthday")
	private LocalDate birthday;
}